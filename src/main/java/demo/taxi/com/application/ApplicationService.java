package demo.taxi.com.application;

import demo.taxi.com.util.ResponseObjectDto;

import java.util.UUID;

/**
 * The Class ApplicationService.
 *
 * @author Christian Iradukunda
 */
public class ApplicationService implements IApplicationService {

	@Override
	public ResponseObjectDto getClosestDriversByRider(int number) {
		return null;
	}

	@Override
	public ResponseObjectDto createTrip(UUID riderId, UUID driverId) {
		return null;
	}

	@Override
	public ResponseObjectDto completeTrip(int tripNumber) {
		return null;
	}
}