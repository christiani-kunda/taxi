package demo.taxi.com.controller;

import demo.taxi.com.model.Driver;
import demo.taxi.com.service.IDriverService;
import demo.taxi.com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * The Class DriverController.
 *
 * @author Christian Iradukunda
 */
@RestController
@RequestMapping("driver")
public class DriverController {

	@Autowired
	private IDriverService driverService;

	@GetMapping("/id")
	public Response<Driver> findDriverById(@RequestHeader UUID driverId){
		return driverService.findDriverById(driverId);
	}

	@GetMapping("/all")
	public Response<List<Driver>> findAllDrivers(){
		return driverService.findAllDrivers();
	}

	@GetMapping("/all-active")
	public Response<List<Driver>> findAllAvailableDrivers(){
		return driverService.findAllAvailableDrivers();
	}

	@GetMapping("/all-active-by-distance")
	public Response<List<Driver>> findAllAvailableDriversByDistance(@RequestHeader Double distance, @RequestHeader String location){
		if(!location.contains(",")){
			return new Response<>(new Exception("Wrong format for location"), "Provide location in the format of x,y");
		}
		return driverService.findAllAvailableDriversByDistance(distance, location);
	}
}