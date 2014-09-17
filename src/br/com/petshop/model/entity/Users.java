package br.com.petshop.model.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

/**
 * The Class Users.
 */
@Entity
@Table(name = "tab_users")
public class Users implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_users")
	private Long id;

	/** The code. */
	private String code;

	/** The password. */
	private String password;

	/** The dafe of last. */
	@Column(name="date_of_last")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dafeOfLast;

	/** The date of first. */
	@Column(name="date_of_first")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfFirst;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Employees employees;
	/**
	 * Instantiates a new users.
	 */
	public Users() {

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
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {

		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(password.getBytes(), 0, password.length());
			this.password = new BigInteger(1, m.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the dafe of last.
	 *
	 * @return the dafe of last
	 */
	public Date getDafeOfLast() {
		return dafeOfLast;
	}

	/**
	 * Sets the dafe of last.
	 *
	 * @param dafeOfLast
	 *            the new dafe of last
	 */
	public void setDafeOfLast(Date dafeOfLast) {
		this.dafeOfLast = dafeOfLast;
	}

	/**
	 * Gets the date of first.
	 *
	 * @return the date of first
	 */
	public Date getDateOfFirst() {
		return dateOfFirst;
	}

	/**
	 * Sets the date of first.
	 *
	 * @param dateOfFirst
	 *            the new date of first
	 */
	public void setDateOfFirst(Date dateOfFirst) {
		this.dateOfFirst = dateOfFirst;
	}

}
