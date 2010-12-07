package eu.evesuite.commons.utils;

import java.beans.PropertyChangeListener;

import org.jdom.Document;

public interface EVEAPIService {

	public static final String BASE_URL = "http://api.eve-online.com";
	
	public static final String ACCOUNT_URL = "/account/Characters.xml.aspx";
	
	public void addPropertyChangeListener(PropertyChangeListener listener);

	public void removePropertyChangeListener(PropertyChangeListener listener);
	
	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener);

	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener);
	
	public void setBaseURL(String baseURL);
	
	public void setAccountURL(String accountURL);
	
	public Document getAccounts(String userID, String limitedApiKey);
}
