package demo.taxi.com.controller;

import demo.taxi.com.model.Trip;
import demo.taxi.com.service.ITripService;
import demo.taxi.com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The Class ITripController.
 *
 * @author Christian Iradukunda
 */
@RestController
@RequestMapping("trip")
public class TripController {

	@Autowired
	private ITripService tripService;

	@GetMapping("/all-active-trips")
	public Response<List<Trip>> getListOfActiveTrips(){
		return tripService.getListOfActiveTrips();
	}
}