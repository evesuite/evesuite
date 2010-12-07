package eu.evesuite.eve.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the invBlueprintTypes database table.
 * 
 */
@Entity
@Table(name="invBlueprintTypes")
public class InvBlueprintType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int blueprintTypeID;

	private int materialModifier;

	private int maxProductionLimit;

	private int parentBlueprintTypeID;

	private int productionTime;

	private int productivityModifier;

	private int productTypeID;

	private int researchCopyTime;

	private int researchMaterialTime;

	private int researchProductivityTime;

	private int researchTechTime;

	private int techLevel;

	private int wasteFactor;
	
	@ManyToOne
	@JoinColumn(name = "parentBlueprintTypeID", insertable=false, updatable=false)
	private InvBlueprintType parentBlueprintType;

	@OneToMany(mappedBy = "parentBlueprintType", fetch = FetchType.LAZY)	
	private Collection<InvBlueprintType> blueprintTypes;
	
	@OneToOne(mappedBy = "invBlueprintType")
	private InvType invType;
	
	@OneToMany(mappedBy = "invBlueprintType", fetch = FetchType.LAZY)
	private Collection<RamTypeRequirement> requiredRamTypeRequirements;		

    public InvBlueprintType getParentBlueprintType() {
		return parentBlueprintType;
	}

	public void setParentBlueprintType(InvBlueprintType parentBlueprintType) {
		this.parentBlueprintType = parentBlueprintType;
	}

	public Collection<InvBlueprintType> getBlueprintTypes() {
		return blueprintTypes;
	}

	public void setBlueprintTypes(Collection<InvBlueprintType> blueprintTypes) {
		this.blueprintTypes = blueprintTypes;
	}

	public InvType getInvType() {
		return invType;
	}

	public void setInvType(InvType invType) {
		this.invType = invType;
	}

	public InvBlueprintType() {
    }

	public int getBlueprintTypeID() {
		return this.blueprintTypeID;
	}

	public void setBlueprintTypeID(int blueprintTypeID) {
		this.blueprintTypeID = blueprintTypeID;
	}

	public int getMaterialModifier() {
		return this.materialModifier;
	}

	public void setMaterialModifier(int materialModifier) {
		this.materialModifier = materialModifier;
	}

	public int getMaxProductionLimit() {
		return this.maxProductionLimit;
	}

	public void setMaxProductionLimit(int maxProductionLimit) {
		this.maxProductionLimit = maxProductionLimit;
	}

	public int getParentBlueprintTypeID() {
		return this.parentBlueprintTypeID;
	}

	public void setParentBlueprintTypeID(int parentBlueprintTypeID) {
		this.parentBlueprintTypeID = parentBlueprintTypeID;
	}

	public int getProductionTime() {
		return this.productionTime;
	}

	public void setProductionTime(int productionTime) {
		this.productionTime = productionTime;
	}

	public int getProductivityModifier() {
		return this.productivityModifier;
	}

	public void setProductivityModifier(int productivityModifier) {
		this.productivityModifier = productivityModifier;
	}

	public int getProductTypeID() {
		return this.productTypeID;
	}

	public void setProductTypeID(int productTypeID) {
		this.productTypeID = productTypeID;
	}

	public int getResearchCopyTime() {
		return this.researchCopyTime;
	}

	public void setResearchCopyTime(int researchCopyTime) {
		this.researchCopyTime = researchCopyTime;
	}

	public int getResearchMaterialTime() {
		return this.researchMaterialTime;
	}

	public void setResearchMaterialTime(int researchMaterialTime) {
		this.researchMaterialTime = researchMaterialTime;
	}

	public int getResearchProductivityTime() {
		return this.researchProductivityTime;
	}

	public void setResearchProductivityTime(int researchProductivityTime) {
		this.researchProductivityTime = researchProductivityTime;
	}

	public int getResearchTechTime() {
		return this.researchTechTime;
	}

	public void setResearchTechTime(int researchTechTime) {
		this.researchTechTime = researchTechTime;
	}

	public int getTechLevel() {
		return this.techLevel;
	}

	public void setTechLevel(int techLevel) {
		this.techLevel = techLevel;
	}

	public int getWasteFactor() {
		return this.wasteFactor;
	}

	public void setWasteFactor(int wasteFactor) {
		this.wasteFactor = wasteFactor;
	}

	public void setRequiredRamTypeRequirements(
			Collection<RamTypeRequirement> requiredRamTypeRequirements) {
		this.requiredRamTypeRequirements = requiredRamTypeRequirements;
	}

	public Collection<RamTypeRequirement> getRequiredRamTypeRequirements() {
		return requiredRamTypeRequirements;
	}

	@Override
	public String toString() {
		return "InvBlueprintType [blueprintTypeID="
				+ blueprintTypeID
				+ ", materialModifier="
				+ materialModifier
				+ ", maxProductionLimit="
				+ maxProductionLimit
				+ ", parentBlueprintTypeID="
				+ parentBlueprintTypeID
				+ ", productionTime="
				+ productionTime
				+ ", productivityModifier="
				+ productivityModifier
				+ ", productTypeID="
				+ productTypeID
				+ ", researchCopyTime="
				+ researchCopyTime
				+ ", researchMaterialTime="
				+ researchMaterialTime
				+ ", researchProductivityTime="
				+ researchProductivityTime
				+ ", researchTechTime="
				+ researchTechTime
				+ ", techLevel="
				+ techLevel
				+ ", wasteFactor="
				+ wasteFactor
				+ ", "
				+ (parentBlueprintType != null ? "parentBlueprintType="
						+ parentBlueprintType + ", " : "")
				+ (blueprintTypes != null ? "blueprintTypes=" + blueprintTypes
						+ ", " : "")
				+ (invType != null ? "invType=" + invType + ", " : "")
				+ (requiredRamTypeRequirements != null ? "requiredRamTypeRequirements="
						+ requiredRamTypeRequirements
						: "") + "]";
	}

}