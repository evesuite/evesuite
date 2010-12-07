package eu.evesuite.eve.ui.preferences;

import java.io.File;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import eu.evesuite.eve.ui.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {

		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		store.setDefault(PreferenceConstants.P_DATABASE_TYPE, PreferenceConstants.P_DATABASE_TYPE_DEFAULT);		
		store.setDefault(PreferenceConstants.P_DATABASE_HOST, PreferenceConstants.P_DATABASE_HOST_DEFAULT);		
		store.setDefault(PreferenceConstants.P_DATABASE_USER, PreferenceConstants.P_DATABASE_USER_DEFAULT);		
		store.setDefault(PreferenceConstants.P_DATABASE_PASS, PreferenceConstants.P_DATABASE_PASS_DEFAULT);		
		store.setDefault(PreferenceConstants.P_DATABASE_NAME, PreferenceConstants.P_DATABASE_NAME_DEFAULT);		
		store.setDefault(PreferenceConstants.P_DATABASE_PORT, PreferenceConstants.P_DATABASE_PORT_DEFAULT);
		
		String basePath = System.getProperty("user.home") + File.separatorChar;
		
		if (File.separatorChar == '/') {
			basePath += ".evesuite";
		} else {
			basePath += "EVE Suite";
		}
		
		basePath += File.separatorChar;
		
		store.setDefault(PreferenceConstants.P_DATABASE_FILE, basePath + PreferenceConstants.P_DATABASE_FILE_DEFAULT);
	}

}
