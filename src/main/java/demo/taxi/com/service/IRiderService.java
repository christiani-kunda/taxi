package demo.taxi.com.service;

import demo.taxi.com.util.ResponseObjectDto;

import java.util.UUID;

/**
 * The Interface of IRiderService.
 *
 * @author Christian Iradukunda
 */
public interface IRiderService {

	ResponseObjectDto findAllRiders();

	ResponseObjectDto findRiderById(UUID riderId);

}