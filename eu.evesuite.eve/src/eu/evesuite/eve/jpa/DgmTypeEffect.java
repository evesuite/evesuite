package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dgmTypeEffects database table.
 * 
 */
@Entity
@Table(name="dgmTypeEffects")
public class DgmTypeEffect implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DgmTypeEffectPK id;

	private byte isDefault;

    public DgmTypeEffect() {
    }

	public DgmTypeEffectPK getId() {
		return this.id;
	}

	public void setId(DgmTypeEffectPK id) {
		this.id = id;
	}
	
	public byte getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(byte isDefault) {
		this.isDefault = isDefault;
	}

}