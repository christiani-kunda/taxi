package demo.taxi.com.repository;

import demo.taxi.com.model.ETripState;
import demo.taxi.com.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * The Interface of ITripRepository.
 *
 * @author Christian Iradukunda
 */
@Repository
public interface ITripRepository extends JpaRepository<Trip, UUID> {
	List<Trip> findTripsByState(ETripState state);
}