package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ramAssemblyLineTypes database table.
 * 
 */
@Entity
@Table(name="ramAssemblyLineTypes")
public class RamAssemblyLineType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte assemblyLineTypeID;

	private byte activityID;

	private String assemblyLineTypeName;

	private double baseMaterialMultiplier;

	private double baseTimeMultiplier;

	private String description;

	private double minCostPerHour;

	private double volume;

    public RamAssemblyLineType() {
    }

	public byte getAssemblyLineTypeID() {
		return this.assemblyLineTypeID;
	}

	public void setAssemblyLineTypeID(byte assemblyLineTypeID) {
		this.assemblyLineTypeID = assemblyLineTypeID;
	}

	public byte getActivityID() {
		return this.activityID;
	}

	public void setActivityID(byte activityID) {
		this.activityID = activityID;
	}

	public String getAssemblyLineTypeName() {
		return this.assemblyLineTypeName;
	}

	public void setAssemblyLineTypeName(String assemblyLineTypeName) {
		this.assemblyLineTypeName = assemblyLineTypeName;
	}

	public double getBaseMaterialMultiplier() {
		return this.baseMaterialMultiplier;
	}

	public void setBaseMaterialMultiplier(double baseMaterialMultiplier) {
		this.baseMaterialMultiplier = baseMaterialMultiplier;
	}

	public double getBaseTimeMultiplier() {
		return this.baseTimeMultiplier;
	}

	public void setBaseTimeMultiplier(double baseTimeMultiplier) {
		this.baseTimeMultiplier = baseTimeMultiplier;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMinCostPerHour() {
		return this.minCostPerHour;
	}

	public void setMinCostPerHour(double minCostPerHour) {
		this.minCostPerHour = minCostPerHour;
	}

	public double getVolume() {
		return this.volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

}