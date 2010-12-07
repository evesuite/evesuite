package eu.evesuite.eve.ui.preferences;

import java.sql.Connection;
import java.sql.DriverManager;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.*;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.statushandlers.StatusManager;

import eu.evesuite.eve.ui.Activator;

public class PreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	private ComboFieldEditor comboFieldEditor;
	
	private StringFieldEditor hostStringFieldEditor;
	
	private StringFieldEditor userStringFieldEditor;
	
	private StringFieldEditor passStringFieldEditor;
	
	private StringFieldEditor nameStringFieldEditor;
	
	private IntegerFieldEditor portIntegerFieldEditor;
	
	private FileFieldEditor fileFieldEditor; 

	public PreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("EVE Suite API");
	}
	
	public void createFieldEditors() {
		
		comboFieldEditor = new ComboFieldEditor(PreferenceConstants.P_DATABASE_TYPE, "Database", PreferenceConstants.P_DATABASE_TYPES, getFieldEditorParent());
		
		hostStringFieldEditor = new StringFieldEditor(PreferenceConstants.P_DATABASE_HOST, "Hostname", getFieldEditorParent());
		userStringFieldEditor = new StringFieldEditor(PreferenceConstants.P_DATABASE_USER, "Username", getFieldEditorParent());
		passStringFieldEditor = new StringFieldEditor(PreferenceConstants.P_DATABASE_PASS, "Password", getFieldEditorParent());
		nameStringFieldEditor = new StringFieldEditor(PreferenceConstants.P_DATABASE_NAME, "Database", getFieldEditorParent());
		portIntegerFieldEditor = new IntegerFieldEditor(PreferenceConstants.P_DATABASE_PORT, "Port", getFieldEditorParent());
		fileFieldEditor = new FileFieldEditor(PreferenceConstants.P_DATABASE_FILE, "File", getFieldEditorParent());
		
		addField(comboFieldEditor);
		addField(hostStringFieldEditor);
		addField(userStringFieldEditor);
		addField(passStringFieldEditor);
		addField(nameStringFieldEditor);
		addField(portIntegerFieldEditor);
		addField(fileFieldEditor);
		
		updateType(getPreferenceStore().getString(PreferenceConstants.P_DATABASE_TYPE));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}	

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		
		super.propertyChange(event);
		
		if (event.getSource() == comboFieldEditor) {
			updateType(event.getNewValue().toString());
		}
	}
	
	@Override
	protected void performApply() {

		super.performApply();
		
		if (getPreferenceStore().getString(PreferenceConstants.P_DATABASE_TYPE).equalsIgnoreCase("mysql")) {
			
			String url = "jdbc:mysql://" + getPreferenceStore().getString(PreferenceConstants.P_DATABASE_HOST);
			url += ":" + getPreferenceStore().getString(PreferenceConstants.P_DATABASE_PORT) + "/";
			url += getPreferenceStore().getString(PreferenceConstants.P_DATABASE_NAME);
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection connection = DriverManager.getConnection(url, getPreferenceStore().getString(PreferenceConstants.P_DATABASE_USER), getPreferenceStore().getString(PreferenceConstants.P_DATABASE_PASS));
				
				if (!connection.isClosed()) {
					connection.close();
					connection = null;
				}
				
			} catch (Exception e) {
				IStatus status = new Status(Status.WARNING, Activator.PLUGIN_ID, e.getMessage(), e);
				StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.BLOCK);
			}
			
		}

		if (getPreferenceStore().getString(PreferenceConstants.P_DATABASE_TYPE).equalsIgnoreCase("sqlite")) {
			
			String url = "jdbc:sqlite:" + getPreferenceStore().getString(PreferenceConstants.P_DATABASE_FILE);
			
			try {
				
				Class.forName("org.sqlite.JDBC").newInstance();
				Connection connection = DriverManager.getConnection(url);
				
				if (!connection.isClosed()) {
					connection.close();
					connection = null;
				}
				
			} catch (Exception e) {
				IStatus status = new Status(Status.WARNING, Activator.PLUGIN_ID, e.getMessage(), e);
				StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.BLOCK);
			}
			
		}
	}

	private void updateType(String type) {
		
		if (type.equalsIgnoreCase("sqlite")) {
			hostStringFieldEditor.setEnabled(false, getFieldEditorParent());
			userStringFieldEditor.setEnabled(false, getFieldEditorParent());
			passStringFieldEditor.setEnabled(false, getFieldEditorParent());
			nameStringFieldEditor.setEnabled(false, getFieldEditorParent());
			portIntegerFieldEditor.setEnabled(false, getFieldEditorParent());
			
			fileFieldEditor.setEnabled(true, getFieldEditorParent());
		}

		if (type.equalsIgnoreCase("mysql")) {
			hostStringFieldEditor.setEnabled(true, getFieldEditorParent());
			userStringFieldEditor.setEnabled(true, getFieldEditorParent());
			passStringFieldEditor.setEnabled(true, getFieldEditorParent());
			nameStringFieldEditor.setEnabled(true, getFieldEditorParent());
			portIntegerFieldEditor.setEnabled(true, getFieldEditorParent());
			
			fileFieldEditor.setEnabled(false, getFieldEditorParent());			
		}
	}
	
}