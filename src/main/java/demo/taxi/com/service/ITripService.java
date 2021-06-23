package demo.taxi.com.service;

import demo.taxi.com.util.ResponseObjectDto;

/**
 * The interface ITripService.
 *
 * @author Christian Iradukunda
 */
public interface ITripService {

	ResponseObjectDto getListOfActiveTrips();

}