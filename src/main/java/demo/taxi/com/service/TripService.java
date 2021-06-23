package demo.taxi.com.service;

import demo.taxi.com.model.Trip;
import demo.taxi.com.repository.ITripRepository;
import demo.taxi.com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Class TripService.
 *
 * @author Christian Iradukunda
 */
@Service
public class TripService implements ITripService {

	@Autowired
	private ITripRepository tripRepository;

	@Override
	public Response<List<Trip>> getListOfActiveTrips() {
		return new Response<>(tripRepository.findAll());
	}
}