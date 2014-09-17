package br.com.petshop.repository;

import java.util.List;

import br.com.petshop.databaseutil.ManagerRespositoryORM;
import br.com.petshop.model.entity.Appointment;
import br.com.petshop.repository.patternaplication.AbstractDB;

// TODO: Auto-generated Javadoc
/**
 * The Class AppointmentDAO.
 */
public class AppointmentDAO extends AbstractDB<Appointment> {

	/** The manager repository. */
	private ManagerRespositoryORM<Appointment> managerRepository;

	/**
	 * Instantiates a new appointment dao.
	 */
	public AppointmentDAO() {
		setManagerRepository(ManagerRespositoryORM.getInstance());
	}

	/**
	 * Persist.
	 *
	 * @param object
	 *            the object
	 * @return the boolean
	 */
	@Override
	public Boolean persist(Appointment object) {
		return getManagerRepository().persistObject(object, Appointment.class);
	}

	/**
	 * Removes the.
	 *
	 * @param object
	 *            the object
	 * @return the boolean
	 */
	@Override
	public Boolean remove(Appointment object) {
		return getManagerRepository().removeObject(object);
	}

	/**
	 * List.
	 *
	 * @return the list
	 */
	@Override
	public List<Appointment> list() {
		return getManagerRepository().getList("SELECT a ", Appointment.class);
	}

	/**
	 * Update.
	 *
	 * @param object the object
	 * @return the boolean
	 */
	@Override
	public Boolean update(Appointment object) {
		return getManagerRepository().update(object);
	}

	/**
	 * Gets the manager repository.
	 *
	 * @return the manager repository
	 */
	private ManagerRespositoryORM<Appointment> getManagerRepository() {
		return managerRepository;
	}

	/**
	 * Sets the manager repository.
	 *
	 * @param managerRepository
	 *            the new manager repository
	 */
	private void setManagerRepository(
			ManagerRespositoryORM<Appointment> managerRepository) {
		this.managerRepository = managerRepository;
	}
}
