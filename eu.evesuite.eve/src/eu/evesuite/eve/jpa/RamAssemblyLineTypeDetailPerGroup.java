package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ramAssemblyLineTypeDetailPerGroup database table.
 * 
 */
@Entity
@Table(name="ramAssemblyLineTypeDetailPerGroup")
public class RamAssemblyLineTypeDetailPerGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RamAssemblyLineTypeDetailPerGroupPK id;

	private double materialMultiplier;

	private double timeMultiplier;

    public RamAssemblyLineTypeDetailPerGroup() {
    }

	public RamAssemblyLineTypeDetailPerGroupPK getId() {
		return this.id;
	}

	public void setId(RamAssemblyLineTypeDetailPerGroupPK id) {
		this.id = id;
	}
	
	public double getMaterialMultiplier() {
		return this.materialMultiplier;
	}

	public void setMaterialMultiplier(double materialMultiplier) {
		this.materialMultiplier = materialMultiplier;
	}

	public double getTimeMultiplier() {
		return this.timeMultiplier;
	}

	public void setTimeMultiplier(double timeMultiplier) {
		this.timeMultiplier = timeMultiplier;
	}

}