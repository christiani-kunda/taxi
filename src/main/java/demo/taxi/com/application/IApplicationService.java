package demo.taxi.com.application;

import demo.taxi.com.util.ResponseObjectDto;

import java.util.UUID;

/**
 * The Interface of IApplicationService.
 *
 * @author Christian Iradukunda
 */
public interface IApplicationService {

	ResponseObjectDto getClosestDriversByRider(int number);

	ResponseObjectDto createTrip(UUID riderId, UUID driverId);

	ResponseObjectDto completeTrip(int tripNumber);
}