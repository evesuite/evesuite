package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invFlags database table.
 * 
 */
@Entity
@Table(name="invFlags")
public class InvFlag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte flagID;

	private String flagName;

	private String flagText;

	private String flagType;

	private short orderID;

    public InvFlag() {
    }

	public byte getFlagID() {
		return this.flagID;
	}

	public void setFlagID(byte flagID) {
		this.flagID = flagID;
	}

	public String getFlagName() {
		return this.flagName;
	}

	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}

	public String getFlagText() {
		return this.flagText;
	}

	public void setFlagText(String flagText) {
		this.flagText = flagText;
	}

	public String getFlagType() {
		return this.flagType;
	}

	public void setFlagType(String flagType) {
		this.flagType = flagType;
	}

	public short getOrderID() {
		return this.orderID;
	}

	public void setOrderID(short orderID) {
		this.orderID = orderID;
	}

}