package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ramTypeRequirements database table.
 * 
 */
@Entity
@Table(name="ramTypeRequirements")
@IdClass(RamTypeRequirementPK.class)
public class RamTypeRequirement implements Serializable {

	private static final long serialVersionUID = -6219337944927794679L;

	@Id
	private int typeID;

	@Id
	private int activityID;

	@Id
	private int requiredTypeID;

	private double damagePerJob;

	private int quantity;

	private boolean recycle;
	
	@ManyToOne
	@JoinColumn(name = "activityID", insertable=false, updatable=false)
	private RamActivity ramActivity;

	@ManyToOne
	@JoinColumn(name = "typeID", insertable=false, updatable=false)
	private InvType invType;
	
	@ManyToOne
	@JoinColumn(name = "requiredTypeID", insertable=false, updatable=false)
	private InvType requiredInvType;
	
	@ManyToOne
	@JoinColumn(name = "typeID", referencedColumnName="blueprintTypeID", insertable=false, updatable=false)
	private InvBlueprintType invBlueprintType;
	
    public RamTypeRequirement() {
    }
	
	public int getTypeID() {
		return typeID;
	}


	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}


	public int getActivityID() {
		return activityID;
	}


	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}


	public int getRequiredTypeID() {
		return requiredTypeID;
	}


	public void setRequiredTypeID(int requiredTypeID) {
		this.requiredTypeID = requiredTypeID;
	}


	public double getDamagePerJob() {
		return this.damagePerJob;
	}

	public void setDamagePerJob(double damagePerJob) {
		this.damagePerJob = damagePerJob;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean getRecycle() {
		return this.recycle;
	}

	public boolean isRecycle() {
		return getRecycle();
	}

	public void setRecycle(boolean recycle) {
		this.recycle = recycle;
	}

	public void setRamActivity(RamActivity ramActivity) {
		this.ramActivity = ramActivity;
	}

	public RamActivity getRamActivity() {
		return ramActivity;
	}

	public void setInvType(InvType invType) {
		this.invType = invType;
	}

	public InvType getInvType() {
		return invType;
	}

	public void setRequiredInvType(InvType requiredInvType) {
		this.requiredInvType = requiredInvType;
	}

	public InvType getRequiredInvType() {
		return requiredInvType;
	}

	public void setInvBlueprintType(InvBlueprintType invBlueprintType) {
		this.invBlueprintType = invBlueprintType;
	}

	public InvBlueprintType getInvBlueprintType() {
		return invBlueprintType;
	}

}