package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the staServices database table.
 * 
 */
@Entity
@Table(name="staServices")
public class StaService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int serviceID;

	private String description;

	private String serviceName;

    public StaService() {
    }

	public int getServiceID() {
		return this.serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}