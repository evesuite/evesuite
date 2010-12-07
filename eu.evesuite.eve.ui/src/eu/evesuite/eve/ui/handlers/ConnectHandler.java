package eu.evesuite.eve.ui.handlers;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.spi.PersistenceUnitTransactionType;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.persistence.config.TargetServer;
import org.eclipse.ui.statushandlers.StatusManager;

import eu.evesuite.eve.ui.Activator;
import eu.evesuite.eve.ui.preferences.PreferenceConstants;
import eu.evesuite.commons.jpa.EVEModelService;

import static org.eclipse.persistence.config.PersistenceUnitProperties.*;

public class ConnectHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {

		EVEModelService service = Activator.getDefault().getModelService();

		try {
			
			@SuppressWarnings("rawtypes")
			Map properties = getConnectionProperties();

			service.open(properties);
			
		} catch (Exception e) {
			IStatus status = new Status(Status.WARNING, Activator.PLUGIN_ID, e.getMessage(), e);
			StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.BLOCK);			
		}

		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map getConnectionProperties() {
		
		Map properties = new HashMap();
		
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		properties.put(TRANSACTION_TYPE,
				PersistenceUnitTransactionType.RESOURCE_LOCAL.name());
		
		if (store.getString(PreferenceConstants.P_DATABASE_TYPE).equalsIgnoreCase("mysql")) {
			
			String url = "jdbc:mysql://" + store.getString(PreferenceConstants.P_DATABASE_HOST);
			url += ":" + store.getString(PreferenceConstants.P_DATABASE_PORT) + "/";
			url += store.getString(PreferenceConstants.P_DATABASE_NAME);
			
			properties.put(JDBC_DRIVER, "com.mysql.jdbc.Driver");
			properties.put(JDBC_URL, url);
			properties.put(JDBC_USER, store.getString(PreferenceConstants.P_DATABASE_USER));
			properties.put(JDBC_PASSWORD, store.getString(PreferenceConstants.P_DATABASE_PASS));
		}
		
		if (store.getString(PreferenceConstants.P_DATABASE_TYPE).equalsIgnoreCase("sqlite")) {
			
			String url = "jdbc:sqlite:" + store.getString(PreferenceConstants.P_DATABASE_FILE);
			
			properties.put(JDBC_DRIVER, "org.sqlite.JDBC");
			properties.put(JDBC_URL, url);			
		}
		
		properties.put(TARGET_SERVER, TargetServer.DEFAULT);
		properties.put(DDL_GENERATION, NONE);
		properties.put(LOGGING_LEVEL, "Off");
		
		return properties;
	}
}
