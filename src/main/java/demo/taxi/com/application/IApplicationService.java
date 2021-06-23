package demo.taxi.com.application;

import demo.taxi.com.model.Driver;
import demo.taxi.com.model.Trip;
import demo.taxi.com.util.Response;

import java.util.List;
import java.util.UUID;

/**
 * The Interface of IApplicationService.
 *
 * @author Christian Iradukunda
 */
public interface IApplicationService {

	Response<List<Driver>> getClosestDriversByRider(UUID riderId);

	Response<Trip> createTrip(UUID riderId, UUID driverId, String destinationLocation);

	Response<Trip> completeTrip(UUID tripId);
}