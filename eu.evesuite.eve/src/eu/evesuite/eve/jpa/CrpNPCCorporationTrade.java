package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crpNPCCorporationTrades database table.
 * 
 */
@Entity
@Table(name="crpNPCCorporationTrades")
public class CrpNPCCorporationTrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CrpNPCCorporationTradePK id;

    public CrpNPCCorporationTrade() {
    }

	public CrpNPCCorporationTradePK getId() {
		return this.id;
	}

	public void setId(CrpNPCCorporationTradePK id) {
		this.id = id;
	}
	
}