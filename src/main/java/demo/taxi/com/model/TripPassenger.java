package demo.taxi.com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * The Class Passenger.
 *
 * @author Christian Iradukunda
 */
@Entity
@Table(name = "trip_passenger")
public class TripPassenger implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trip_id")
	private Trip tripId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rider_id")
	private Rider riderId;

	public Trip getTripId() {
		return tripId;
	}

	public void setTripId(Trip tripId) {
		this.tripId = tripId;
	}

	public Rider getRiderId() {
		return riderId;
	}

	public void setRiderId(Rider riderId) {
		this.riderId = riderId;
	}
}