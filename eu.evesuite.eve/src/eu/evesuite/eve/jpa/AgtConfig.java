package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the agtConfig database table.
 * 
 */
@Entity
@Table(name="agtConfig")
public class AgtConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AgtConfigPK id;

	private String v;

    public AgtConfig() {
    }

	public AgtConfigPK getId() {
		return this.id;
	}

	public void setId(AgtConfigPK id) {
		this.id = id;
	}
	
	public String getV() {
		return this.v;
	}

	public void setV(String v) {
		this.v = v;
	}

}