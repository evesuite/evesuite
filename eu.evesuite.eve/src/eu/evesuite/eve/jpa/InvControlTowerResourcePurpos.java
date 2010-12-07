package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invControlTowerResourcePurposes database table.
 * 
 */
@Entity
@Table(name="invControlTowerResourcePurposes")
public class InvControlTowerResourcePurpos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte purpose;

	private String purposeText;

    public InvControlTowerResourcePurpos() {
    }

	public byte getPurpose() {
		return this.purpose;
	}

	public void setPurpose(byte purpose) {
		this.purpose = purpose;
	}

	public String getPurposeText() {
		return this.purposeText;
	}

	public void setPurposeText(String purposeText) {
		this.purposeText = purposeText;
	}

}