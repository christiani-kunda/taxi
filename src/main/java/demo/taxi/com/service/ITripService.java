package demo.taxi.com.service;

import demo.taxi.com.model.Trip;
import demo.taxi.com.util.Response;

import java.util.List;

/**
 * The interface ITripService.
 *
 * @author Christian Iradukunda
 */
public interface ITripService {

	Response<List<Trip>> getListOfActiveTrips();

}