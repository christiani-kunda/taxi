package demo.taxi.com.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * The Class Trip.
 *
 * @author Christian Iradukunda
 */
@Entity
@Table(name = "trip")
public class Trip implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID id;

	@CreationTimestamp
	private Date createdAt = new Date();

	@UpdateTimestamp
	private Date updatedAt = new Date();

	private String fromLocation;

	private String destinationLocation;

	@Enumerated(EnumType.STRING)
	private ETripState state;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "driver_id")
	private Driver driver;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rider_id")
	private Rider rider;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String initAdress) {
		this.fromLocation = initAdress;
	}

	public String getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(String destination) {
		this.destinationLocation = destination;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driverId) {
		this.driver = driverId;
	}

	public ETripState getState() {
		return state;
	}

	public void setState(ETripState state) {
		this.state = state;
	}

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider riderId) {
		this.rider = riderId;
	}
}