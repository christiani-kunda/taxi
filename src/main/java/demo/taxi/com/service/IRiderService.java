package demo.taxi.com.service;

import demo.taxi.com.model.Rider;
import demo.taxi.com.util.Response;

import java.util.List;
import java.util.UUID;

/**
 * The Interface of IRiderService.
 *
 * @author Christian Iradukunda
 */
public interface IRiderService {

	Response<List<Rider>> findAllRiders();

	Response<Rider> findRiderById(UUID riderId);

}