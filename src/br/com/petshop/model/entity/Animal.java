package br.com.petshop.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Animal.
 */
@Entity
@Table(name = "tab_animal")
public class Animal implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_animal")
	private Long id;

	/** The name. */
	@Column(nullable = false)
	private String name;

	/** The color. */
	@Column
	private String color;

	/** The weight. */
	@Column
	private Double weight;

	/** The height. */
	@Column
	private Double height;

	/** The length. */
	@Column
	private Double length;

	/** The physical size. */
	@Column
	private String physicalSize;

	/** The type animal. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tipo_animal")
	private TypeAnimal typeAnimal;

	
	
	/** The appointment. */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_client", nullable = false)
	private Client client;

	
	/**
	 * Instantiates a new animal.
	 */
	public Animal() {
	
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(Double height) {
		this.height = height;
	}

	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public Double getLength() {
		return length;
	}

	/**
	 * Sets the length.
	 *
	 * @param length the new length
	 */
	public void setLength(Double length) {
		this.length = length;
	}

	/**
	 * Gets the physical size.
	 *
	 * @return the physical size
	 */
	public String getPhysicalSize() {
		return physicalSize;
	}

	/**
	 * Sets the physical size.
	 *
	 * @param physicalSize the new physical size
	 */
	public void setPhysicalSize(String physicalSize) {
		this.physicalSize = physicalSize;
	}

	/**
	 * Gets the type animal.
	 *
	 * @return the type animal
	 */
	public TypeAnimal getTypeAnimal() {
		return typeAnimal;
	}

	/**
	 * Sets the type animal.
	 *
	 * @param typeAnimal the new type animal
	 */
	public void setTypeAnimal(TypeAnimal typeAnimal) {
		this.typeAnimal = typeAnimal;
	}

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Sets the client.
	 *
	 * @param client the new client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", color=" + color
				+ ", weight=" + weight + ", height=" + height + ", length="
				+ length + ", physicalSize=" + physicalSize + ", typeAnimal="
				+ typeAnimal + ", client=" + client + "]";
	}

	
	
	
}
