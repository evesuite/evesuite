package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the staOperationServices database table.
 * 
 */
@Embeddable
public class StaOperationServicePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private byte operationID;

	private int serviceID;

    public StaOperationServicePK() {
    }
	public byte getOperationID() {
		return this.operationID;
	}
	public void setOperationID(byte operationID) {
		this.operationID = operationID;
	}
	public int getServiceID() {
		return this.serviceID;
	}
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StaOperationServicePK)) {
			return false;
		}
		StaOperationServicePK castOther = (StaOperationServicePK)other;
		return 
			(this.operationID == castOther.operationID)
			&& (this.serviceID == castOther.serviceID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.operationID);
		hash = hash * prime + this.serviceID;
		
		return hash;
    }
}