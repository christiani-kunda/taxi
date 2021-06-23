package demo.taxi.com.service;

import demo.taxi.com.util.ResponseObjectDto;

import java.util.UUID;

/**
 * The Interface of IDriverService.
 *
 * @author Christian Iradukunda
 */
public interface IDriverService {

	ResponseObjectDto findDriverById(UUID driverId);

	ResponseObjectDto findAllDrivers();

	ResponseObjectDto findAllAvailableDrivers();

	ResponseObjectDto findAllAvailableDriversByLocation(String location);

}