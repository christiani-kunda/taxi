package demo.taxi.com.repository;

import demo.taxi.com.model.Driver;
import demo.taxi.com.model.EDriverState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * The Interface of IDriverRepository.
 *
 * @author Christian Iradukunda
 */
@Repository
public interface IDriverRepository extends JpaRepository<Driver, UUID> {

	List<Driver> findDriversByState(EDriverState state);

}