package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crpNPCCorporationDivisions database table.
 * 
 */
@Entity
@Table(name="crpNPCCorporationDivisions")
public class CrpNPCCorporationDivision implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CrpNPCCorporationDivisionPK id;

	private byte size;

    public CrpNPCCorporationDivision() {
    }

	public CrpNPCCorporationDivisionPK getId() {
		return this.id;
	}

	public void setId(CrpNPCCorporationDivisionPK id) {
		this.id = id;
	}
	
	public byte getSize() {
		return this.size;
	}

	public void setSize(byte size) {
		this.size = size;
	}

}