package demo.taxi.com.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * The Class Driver.
 *
 * @author Christian Iradukunda
 */
@Entity
@Table(name = "driver")
public class Driver implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID id;

	@CreationTimestamp
	private Date createdAt = new Date();

	@UpdateTimestamp
	private Date updatedAt = new Date();

	private String fullName;

	private String plateNumber;

	private String location;

	@Enumerated(EnumType.STRING)
	private EDriverState state;

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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public EDriverState getState() {
		return state;
	}

	public void setState(EDriverState state) {
		this.state = state;
	}
}