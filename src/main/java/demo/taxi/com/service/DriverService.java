package demo.taxi.com.service;

import demo.taxi.com.util.ResponseObjectDto;

import java.util.UUID;

/**
 * The Class DriverService.
 *
 * @author Christian Iradukunda
 */
public class DriverService implements IDriverService {

	@Override
	public ResponseObjectDto findDriverById(UUID driverId) {
		return null;
	}

	@Override
	public ResponseObjectDto findAllDrivers() {
		return null;
	}

	@Override
	public ResponseObjectDto findAllAvailableDrivers() {
		return null;
	}

	@Override
	public ResponseObjectDto findAllAvailableDriversByLocation(String location) {
		return null;
	}
}