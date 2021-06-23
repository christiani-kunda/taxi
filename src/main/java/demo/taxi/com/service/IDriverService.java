package demo.taxi.com.service;

import demo.taxi.com.model.Driver;
import demo.taxi.com.util.Response;

import java.util.List;
import java.util.UUID;

/**
 * The Interface of IDriverService.
 *
 * @author Christian Iradukunda
 */
public interface IDriverService {

	Response<Driver> findDriverById(UUID driverId);

	Response<List<Driver>> findAllDrivers();

	Response<List<Driver>> findAllAvailableDrivers();

	Response<List<Driver>> findAllAvailableDriversByDistance(double distance, String location);

}