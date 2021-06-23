package demo.taxi.com.service;

import demo.taxi.com.model.Driver;
import demo.taxi.com.model.EDriverState;
import demo.taxi.com.repository.IDriverRepository;
import demo.taxi.com.util.DistanceCalculator;
import demo.taxi.com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The Class DriverService.
 *
 * @author Christian Iradukunda
 */
@Service
public class DriverService implements IDriverService {

	@Autowired
	private IDriverRepository driverRepository;

	@Override
	public Response<Driver> findDriverById(UUID driverId) {
		try{
			return new Response<>(driverRepository.findById(driverId).orElseThrow(() -> new Exception("Driver not found")));
		}catch (Exception ex){
			return new Response<>(ex, "Driver not found");
		}
	}

	@Override
	public Response<List<Driver>> findAllDrivers() {
		return new Response<>(driverRepository.findAll());
	}

	@Override
	public Response<List<Driver>> findAllAvailableDrivers() {
		return new Response<>(driverRepository.findDriversByState(EDriverState.AVAILABLE));
	}

	@Override
	public Response<List<Driver>> findAllAvailableDriversByDistance(double distance, String location) {

		List<Driver> driversList  = driverRepository.findDriversByState(EDriverState.AVAILABLE);
		List<Driver> newListOfDrivers = new ArrayList<>();
		for(Driver driver : driversList){
			if(DistanceCalculator.calculateDistance(driver.getLocation(), location) <= distance){
				newListOfDrivers.add(driver);
			}
		}
		return new Response<>(newListOfDrivers);
	}

	@PostConstruct
	public void init(){
		for(int i=1; i<=10; i ++){
			Driver driver = new Driver();
			driver.setState(EDriverState.AVAILABLE);
			driver.setLocation("0,0");
			driver.setFullName("full name " + i);
			driver.setPlateNumber("RAF"+ (123 + i) + "A");
			driverRepository.save(driver);
		}
	}
}