package demo.taxi.com.controller;

import demo.taxi.com.application.IApplicationService;
import demo.taxi.com.model.Driver;
import demo.taxi.com.model.Trip;
import demo.taxi.com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * The Class IApplicationController.
 *
 * @author Christian Iradukunda
 */
@RestController
@RequestMapping("request")
public class ApplicationController {

	@Autowired
	private IApplicationService applicationService;

	@GetMapping("/get-closed-drivers")
	public Response<List<Driver>> getClosestDriversByRider(@RequestHeader UUID riderId){
		return applicationService.getClosestDriversByRider(riderId);
	}

	@PostMapping("/create-trip")
	public Response<Trip> createTrip(@RequestHeader UUID riderId, @RequestHeader UUID driverId, @RequestHeader String destinationLocation){
		return applicationService.createTrip(riderId, driverId, destinationLocation);
	}

	@PutMapping("/complete-trip")
	public Response<Trip> completeTrip(@RequestHeader UUID tripId){
		return applicationService.completeTrip(tripId);
	}
}