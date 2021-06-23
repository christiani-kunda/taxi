package demo.taxi.com.repository;

import demo.taxi.com.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * The Interface of IRiderRepository.
 *
 * @author Christian Iradukunda
 */
@Repository
public interface IRiderRepository extends JpaRepository<Rider, UUID> {

}