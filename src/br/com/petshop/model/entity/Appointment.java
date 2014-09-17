package br.com.petshop.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tab_appointment")
public class Appointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_appointment")
	private Date date;

	@Column(name = "price", nullable = true)
	private Double price;

	@Column(name = "priority", nullable = true)
	private String priority;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Users user;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Client client;

}
