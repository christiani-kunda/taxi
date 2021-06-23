package demo.taxi.com.controller;

import demo.taxi.com.model.Rider;
import demo.taxi.com.service.IRiderService;
import demo.taxi.com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * The Class RiderController.
 *
 * @author Christian Iradukunda
 */
@RestController
@RequestMapping("rider")
public class RiderController {

	@Autowired
	private IRiderService riderService;

	@GetMapping("/all")
	public Response<List<Rider>> findAllRiders(){
		return riderService.findAllRiders();
	}

	@GetMapping("/id")
	public Response<Rider> findRiderById(@RequestHeader UUID riderId){
		System.out.println(riderId);
		return riderService.findRiderById(riderId);
	}

}