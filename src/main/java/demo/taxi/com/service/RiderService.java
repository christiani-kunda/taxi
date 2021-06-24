package demo.taxi.com.service;

import demo.taxi.com.model.Rider;
import demo.taxi.com.repository.IRiderRepository;
import demo.taxi.com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * The Class RiderService.
 *
 * @author Christian Iradukunda
 */
@Service
public class RiderService implements IRiderService {

	@Autowired
	private IRiderRepository riderRepository;

	@Override
	public Response<List<Rider>> findAllRiders() {
		return new Response<>(riderRepository.findAll());
	}

	@Override
	public Response<Rider> findRiderById(UUID riderId) {
		try{
			return new Response<>(riderRepository.findById(riderId).orElseThrow(() -> new Exception("Rider not found")));
		}catch (Exception ex){
			return new Response<>(ex, "Rider not found");
		}
	}

}