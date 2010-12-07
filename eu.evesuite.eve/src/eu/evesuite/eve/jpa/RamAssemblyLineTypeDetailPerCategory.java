package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ramAssemblyLineTypeDetailPerCategory database table.
 * 
 */
@Entity
@Table(name="ramAssemblyLineTypeDetailPerCategory")
public class RamAssemblyLineTypeDetailPerCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RamAssemblyLineTypeDetailPerCategoryPK id;

	private double materialMultiplier;

	private double timeMultiplier;

    public RamAssemblyLineTypeDetailPerCategory() {
    }

	public RamAssemblyLineTypeDetailPerCategoryPK getId() {
		return this.id;
	}

	public void setId(RamAssemblyLineTypeDetailPerCategoryPK id) {
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