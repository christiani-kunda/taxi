package demo.taxi.com.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
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
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	private String initAdress;

	private String destination;

	private ETripState state;

	private Integer tripNumber;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "driver_id")
	private Driver driverId;

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

	public String getInitAdress() {
		return initAdress;
	}

	public void setInitAdress(String initAdress) {
		this.initAdress = initAdress;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Driver getDriverId() {
		return driverId;
	}

	public void setDriverId(Driver driverId) {
		this.driverId = driverId;
	}

	public ETripState getState() {
		return state;
	}

	public void setState(ETripState state) {
		this.state = state;
	}

	public Integer getTripNumber() {
		return tripNumber;
	}

	public void setTripNumber(Integer tripNumber) {
		this.tripNumber = tripNumber;
	}
}