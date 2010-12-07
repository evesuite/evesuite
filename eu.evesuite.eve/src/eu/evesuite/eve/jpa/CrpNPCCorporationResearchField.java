package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crpNPCCorporationResearchFields database table.
 * 
 */
@Entity
@Table(name="crpNPCCorporationResearchFields")
public class CrpNPCCorporationResearchField implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CrpNPCCorporationResearchFieldPK id;

    public CrpNPCCorporationResearchField() {
    }

	public CrpNPCCorporationResearchFieldPK getId() {
		return this.id;
	}

	public void setId(CrpNPCCorporationResearchFieldPK id) {
		this.id = id;
	}
	
}