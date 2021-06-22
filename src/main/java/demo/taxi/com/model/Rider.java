package demo.taxi.com.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

/**
 * The Class Client.
 *
 * @author Christian Iradukunda
 */
@Entity
@Table(name = "rider")
public class Rider {

	@Id
	@GeneratedValue
	private UUID id;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	private String fullName;

	private String location;
}