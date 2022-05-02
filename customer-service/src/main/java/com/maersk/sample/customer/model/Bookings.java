package com.maersk.sample.customer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;
import com.maersk.sample.customer.annotations.ValueOfEnum;


@Table(name = "bookings")
@Entity
public class Bookings {

	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@NotNull(message = "The containerSize field must not be blank.")
	@Column(name = "containersize", nullable = false)
	private int containerSize;

	@NotEmpty
	@Size(min = 5, max = 20, message = "Origin should have minimum 2 and maximum 20 characters")
	@Column(name = "origin", nullable = false)
	private String origin;

	@NotEmpty
	@Size(min = 5, max = 20, message = "Destination should have minimum 2 and maximum 20 characters")
	@Column(name = "destination", nullable = false)
	private String destination;

	@NotNull(message = "The quantity field must not be blank.")
	@Range(min = 1, max = 100, message = "quantity should have minimum 2 and maximum 20 characters")
	@Column(name = "quantity", nullable = false)
	private int quantity;

	@NotNull
	@ValueOfEnum(enumClass = ContainerEnum.class)
	@Column(name = "containertype", nullable = false)
	private String containerType;

	@Column(name = "ctimestamp")
	@CreationTimestamp
	private Date timeStamp;

	
	public Bookings() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getContainerSize() {
		return containerSize;
	}

	public void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}	


}
