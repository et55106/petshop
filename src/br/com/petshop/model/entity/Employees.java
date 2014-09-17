package br.com.petshop.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tab_employees")
public class Employees implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4940842268244584410L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_employees")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	
	private Number cpf;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_start")
	private Date dateStart;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_end")
	private Date dateEnd;

	@OneToOne
	@JoinColumn(name="fk_users")
	private Users user;
	
	public Employees(){
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Number getCpf() {
		return cpf;
	}

	public void setCpf(Number cpf) {
		this.cpf = cpf;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employees other = (Employees) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", cpf=" + cpf
				+ ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + "]";
	}

}
