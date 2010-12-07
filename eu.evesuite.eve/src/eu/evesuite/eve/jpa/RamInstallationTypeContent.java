package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ramInstallationTypeContents database table.
 * 
 */
@Entity
@Table(name="ramInstallationTypeContents")
public class RamInstallationTypeContent implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RamInstallationTypeContentPK id;

	private byte quantity;

    public RamInstallationTypeContent() {
    }

	public RamInstallationTypeContentPK getId() {
		return this.id;
	}

	public void setId(RamInstallationTypeContentPK id) {
		this.id = id;
	}
	
	public byte getQuantity() {
		return this.quantity;
	}

	public void setQuantity(byte quantity) {
		this.quantity = quantity;
	}

}