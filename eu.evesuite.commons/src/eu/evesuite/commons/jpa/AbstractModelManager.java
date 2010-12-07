package eu.evesuite.commons.jpa;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

abstract public class AbstractModelManager implements IModelService {

	protected EntityManagerFactory entityManagerFactory;

	protected EntityManager entityManager;

	protected String persistenceUnit;

	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(propertyName,
				listener);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setPersistenceUnit(String persistenceUnit)
			throws RuntimeException {

		if (this.entityManager instanceof EntityManager) {
			throw new RuntimeException("EntityManagerFactory initialized");
		}

		this.persistenceUnit = persistenceUnit;
	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1) {
		return entityManager.find(arg0, arg1);
	}
	
	public Query createQuery(String arg0) {
		return entityManager.createQuery(arg0);
	}

	public Query createNamedQuery(String arg0) {
		return entityManager.createNamedQuery(arg0);
	}

	public Query createNativeQuery(String arg0) {
		return entityManager.createNativeQuery(arg0);
	}

	@Override
	public void persist(Object arg0) throws Exception {

		try {
			
			boolean bNew = entityManager.contains(arg0);
			
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			
			if (bNew) {
				arg0 = entityManager.merge(arg0);
			}

			entityManager.persist(arg0);
			entityManager.getTransaction().commit();
			
			if (!bNew) {
				if (arg0 instanceof IPropertyChangeSupport) {
					((IPropertyChangeSupport)arg0).firePropertyChange(arg0.getClass().getName(), null, arg0);
				}
				propertyChangeSupport.firePropertyChange(arg0.getClass().getName(), null, arg0);
			} else {
				if (arg0 instanceof IPropertyChangeSupport) {
					((IPropertyChangeSupport)arg0).firePropertyChange(arg0.getClass().getName(), arg0, arg0);
				}
				propertyChangeSupport.firePropertyChange(arg0.getClass().getName(), arg0, arg0);
			}
			
			
		} catch (Exception e) {
			if (entityManager instanceof EntityManager && entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			throw e;
		}
	}

	@Override
	public void remove(Object arg0) throws Exception {
		
		try {

			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			
			arg0 = entityManager.merge(arg0);
			entityManager.remove(arg0);
			entityManager.getTransaction().commit();
			
			if (arg0 instanceof IPropertyChangeSupport) {
				IPropertyChangeSupport t = (IPropertyChangeSupport)arg0;
				t.firePropertyChange(arg0.getClass().getName(), arg0, null);
			}
			
			propertyChangeSupport.firePropertyChange(arg0.getClass().getName(), arg0, null);
			
		} catch (Exception e) {
			
			if (entityManager instanceof EntityManager && entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			
			throw e;
		}
	}

	@Override
	public void open() throws Exception {

		if (entityManagerFactory != null) {
			throw new RuntimeException(
					"EntityManagerFactory already initialized");
		}

		if (entityManager != null) {
			throw new RuntimeException("EntityManager already initialized");
		}

		try {

			entityManagerFactory = Persistence
					.createEntityManagerFactory(persistenceUnit);

			propertyChangeSupport.firePropertyChange(PROPERTY_CHANGE_CONNECT,
					entityManager,
					entityManager = entityManagerFactory.createEntityManager());
			
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void open(Map map) throws Exception {

		if (entityManagerFactory != null) {
			throw new RuntimeException(
					"EntityManagerFactory already initialized");
		}

		if (entityManager != null) {
			throw new RuntimeException("EntityManager already initialized");
		}

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory(
					persistenceUnit, map);

			propertyChangeSupport.firePropertyChange(PROPERTY_CHANGE_CONNECT,
					entityManager,
					entityManager = entityManagerFactory.createEntityManager());
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void close() throws Exception {

		try {
			
			if (entityManager instanceof EntityManager) {
				entityManager.close();
				entityManager = null;
			}

			if (entityManagerFactory instanceof EntityManagerFactory) {
				entityManagerFactory.close();
				entityManagerFactory = null;
				propertyChangeSupport.firePropertyChange(
						PROPERTY_CHANGE_DISCONNECT, entityManager,
						entityManager = null);
			}
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean isOpened() {
		return (entityManager instanceof EntityManager);
	}

	
}
