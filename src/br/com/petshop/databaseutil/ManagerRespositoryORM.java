package br.com.petshop.databaseutil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

/**
 * The Class ManagerRespositoryORM.
 * 
 * @author LuisHenrique
 * @param <T>
 *            the generic type
 */

public class ManagerRespositoryORM<T> {

	/** The manager respository orm. */

	private static ManagerRespositoryORM managerRespositoryORM;

	/** The factory. */
	private EntityManagerFactory factory;

	/** The manager. */
	private EntityManager manager;

	/**
	 * Instantiates a new manager respository orm.
	 */
	private ManagerRespositoryORM() {
		setFactory(Persistence.createEntityManagerFactory("petshop"));
		setManager(getFactory().createEntityManager());
	}

	/**
	 * Gets the single instance of ManagerRespositoryORM.
	 *
	 * @return single instance of ManagerRespositoryORM
	 */

	public static ManagerRespositoryORM getInstance() {
		if (managerRespositoryORM == null) {
			managerRespositoryORM = new ManagerRespositoryORM();
		}
		return managerRespositoryORM;
	}

	/**
	 * Persist object.
	 *
	 * @param object
	 *            the object
	 * @param classArgument
	 *            the class argument
	 * @return the boolean
	 */
	public Boolean persistObject(Object object, Class<T> classArgument) {
		boolean returned = false;
		try {
			getManager().getTransaction().begin();
			getManager().persist(object);
			getManager().getTransaction().commit();
			returned = true;
		} catch (RollbackException e) {
			getManager().close();

		}
		return returned;

	}

	/**
	 * Gets the list.
	 *
	 * @param query
	 *            the query
	 * @param classArgument
	 *            the class argument
	 * @return the list
	 */
	public List<T> getList(String query, Class<T> classArgument) {
		return getManager().createNamedQuery(query, classArgument)
				.getResultList();
	}

	/**
	 * Removes the object.
	 *
	 * @param object
	 *            the object
	 * @return the boolean
	 */
	public Boolean removeObject(Object object) {
		boolean returned = false;
		try {
			getManager().getTransaction().begin();
			getManager().remove(object);
			getManager().getTransaction().commit();
		} catch (Exception e) {
			getManager().close();
		}
		return returned;
	}

	public Boolean update(Object object) {
		boolean returned = false;
		try {
			getManager().getTransaction().begin();
			getManager().merge(object);
			getManager().getTransaction().commit();
			returned = true;
		} catch (Exception e) {
			getManager().close();
		}
		return returned;

	}
	/**
	 * Gets the factory.
	 *
	 * @return the factory
	 */
	private EntityManagerFactory getFactory() {
		return factory;
	}

	/**
	 * Sets the factory.
	 *
	 * @param factory
	 *            the new factory
	 */
	private void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}

	/**
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	public EntityManager getManager() {
		return manager;
	}

	/**
	 * Sets the manager.
	 *
	 * @param manager
	 *            the new manager
	 */
	private void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
