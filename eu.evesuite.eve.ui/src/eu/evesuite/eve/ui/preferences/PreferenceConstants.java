package eu.evesuite.eve.ui.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {

public static final String P_DATABASE_TYPE = "dbDatabaseType";
	
	public static final String P_DATABASE_TYPE_DEFAULT = "mysql";
	
	public static final String[][] P_DATABASE_TYPES = {{"SQLite", "sqlite"},{"MySQL", "mysql"}};
	
	public static final String P_DATABASE_HOST = "dbHost";
	
	public static final String P_DATABASE_HOST_DEFAULT = "sql";
	
	public static final String P_DATABASE_USER = "dbUser";
	
	public static final String P_DATABASE_USER_DEFAULT = "eve";
	
	public static final String P_DATABASE_PASS = "dbPass";
	
	public static final String P_DATABASE_PASS_DEFAULT = "eve";
	
	public static final String P_DATABASE_NAME = "dbName";
	
	public static final String P_DATABASE_NAME_DEFAULT = "eve";
	
	public static final String P_DATABASE_PORT = "dbPort";
	
	public static final int P_DATABASE_PORT_DEFAULT = 3306;
	
	public static final String P_DATABASE_FILE = "dbFile";
	
	public static final String P_DATABASE_FILE_DEFAULT = "EVEOnline.db";
	
	
}
