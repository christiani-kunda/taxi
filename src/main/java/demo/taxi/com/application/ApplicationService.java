package demo.taxi.com.application;

import demo.taxi.com.model.Driver;
import demo.taxi.com.model.EDriverState;
import demo.taxi.com.model.ETripState;
import demo.taxi.com.model.Rider;
import demo.taxi.com.model.Trip;
import demo.taxi.com.repository.IDriverRepository;
import demo.taxi.com.repository.IRiderRepository;
import demo.taxi.com.repository.ITripRepository;
import demo.taxi.com.service.IDriverService;
import demo.taxi.com.service.IRiderService;
import demo.taxi.com.util.DistanceCalculator;
import demo.taxi.com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * The Class ApplicationService.
 *
 * @author Christian Iradukunda
 */
@Service
public class ApplicationService implements IApplicationService {

	@Autowired
	private ITripRepository tripRepository;

	@Autowired
	private IRiderRepository riderRepository;

	@Autowired
	private IRiderService riderService;

	@Autowired
	private IDriverRepository driverRepository;

	@Autowired
	private IDriverService driverService;

	@Override
	public Response<List<Driver>> getClosestDriversByRider(UUID riderId) {
		try {
			Rider rider = riderService.findRiderById(riderId).getData();
			List<Driver> drivers = driverService.findAllAvailableDrivers().getData();
			Map<Driver, Double> driversDistance = new HashMap<>();
			for (Driver driver : drivers) {
				driversDistance.put(driver, DistanceCalculator.calculateDistance(rider.getLocation(), driver.getLocation()));
			}

			Map<Driver, Double> sortedDriversDistance = new HashMap<>();
			driversDistance.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(3)
					.forEachOrdered(x -> sortedDriversDistance.put(x.getKey(), x.getValue()));

			List<Driver> closestDrivers = new ArrayList<>(sortedDriversDistance.keySet());
			return new Response<>(closestDrivers);
		} catch (Exception ex){
			return new Response<>(ex, "There has been error");
		}
	}

	@Override
	public Response<Trip> createTrip(UUID riderId, UUID driverId, String destinationLocation) {
		try{
			Rider rider = riderService.findRiderById(riderId).getData();
			assert rider != null;
			Driver driver = driverService.findDriverById(driverId).getData();
			assert driver != null;
			Trip trip = new Trip();
			trip.setDriver(driver);
			trip.setRider(rider);
			trip.setFromLocation(rider.getLocation());
			trip.setDestinationLocation(destinationLocation);
			trip.setState(ETripState.ACTIVE);

			trip = tripRepository.save(trip);

			// updating the drivers state to unavailable
			driver.setState(EDriverState.UNAVAILABLE);
			driver.setUpdatedAt(new Date());
			driverRepository.save(driver);
			return new Response<>(trip);
		} catch (Exception ex){
			return new Response<>(ex);
		}
	}

	@Override
	public Response<Trip> completeTrip(UUID tripId) {
		try{
			Trip trip = tripRepository.findById(tripId).orElse(null);
			assert trip != null;
			trip.setState(ETripState.COMPLETED);
			trip.setUpdatedAt(new Date());
			trip = tripRepository.save(trip);

			// updating the location of the driver and the passenger
			Rider rider = trip.getRider();
			Driver driver = trip.getDriver();

			rider.setLocation(trip.getDestinationLocation());
			rider.setUpdatedAt(new Date());
			riderRepository.save(rider);

			driver.setLocation(trip.getDestinationLocation());
			driver.setState(EDriverState.AVAILABLE);
			driver.setUpdatedAt(new Date());
			driverRepository.save(driver);
			return new Response<>(trip);
		} catch (Exception ex){
			return new Response<>(ex);
		}
	}
}