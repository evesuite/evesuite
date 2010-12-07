package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dgmEffects database table.
 * 
 */
@Entity
@Table(name="dgmEffects")
public class DgmEffect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short effectID;

	private String description;

	private byte disallowAutoRepeat;

	private short dischargeAttributeID;

	private String displayName;

	private byte distribution;

	private short durationAttributeID;

	private short effectCategory;

	private String effectName;

	private byte electronicChance;

	private short falloffAttributeID;

	private short fittingUsageChanceAttributeID;

	private short graphicID;

	private String guid;

	private byte isAssistance;

	private byte isOffensive;

	private byte isWarpSafe;

	private short npcActivationChanceAttributeID;

	private short npcUsageChanceAttributeID;

	private int postExpression;

	private int preExpression;

	private byte propulsionChance;

	private byte published;

	private short rangeAttributeID;

	private byte rangeChance;

	private String sfxName;

	private short trackingSpeedAttributeID;

    public DgmEffect() {
    }

	public short getEffectID() {
		return this.effectID;
	}

	public void setEffectID(short effectID) {
		this.effectID = effectID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getDisallowAutoRepeat() {
		return this.disallowAutoRepeat;
	}

	public void setDisallowAutoRepeat(byte disallowAutoRepeat) {
		this.disallowAutoRepeat = disallowAutoRepeat;
	}

	public short getDischargeAttributeID() {
		return this.dischargeAttributeID;
	}

	public void setDischargeAttributeID(short dischargeAttributeID) {
		this.dischargeAttributeID = dischargeAttributeID;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public byte getDistribution() {
		return this.distribution;
	}

	public void setDistribution(byte distribution) {
		this.distribution = distribution;
	}

	public short getDurationAttributeID() {
		return this.durationAttributeID;
	}

	public void setDurationAttributeID(short durationAttributeID) {
		this.durationAttributeID = durationAttributeID;
	}

	public short getEffectCategory() {
		return this.effectCategory;
	}

	public void setEffectCategory(short effectCategory) {
		this.effectCategory = effectCategory;
	}

	public String getEffectName() {
		return this.effectName;
	}

	public void setEffectName(String effectName) {
		this.effectName = effectName;
	}

	public byte getElectronicChance() {
		return this.electronicChance;
	}

	public void setElectronicChance(byte electronicChance) {
		this.electronicChance = electronicChance;
	}

	public short getFalloffAttributeID() {
		return this.falloffAttributeID;
	}

	public void setFalloffAttributeID(short falloffAttributeID) {
		this.falloffAttributeID = falloffAttributeID;
	}

	public short getFittingUsageChanceAttributeID() {
		return this.fittingUsageChanceAttributeID;
	}

	public void setFittingUsageChanceAttributeID(short fittingUsageChanceAttributeID) {
		this.fittingUsageChanceAttributeID = fittingUsageChanceAttributeID;
	}

	public short getGraphicID() {
		return this.graphicID;
	}

	public void setGraphicID(short graphicID) {
		this.graphicID = graphicID;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public byte getIsAssistance() {
		return this.isAssistance;
	}

	public void setIsAssistance(byte isAssistance) {
		this.isAssistance = isAssistance;
	}

	public byte getIsOffensive() {
		return this.isOffensive;
	}

	public void setIsOffensive(byte isOffensive) {
		this.isOffensive = isOffensive;
	}

	public byte getIsWarpSafe() {
		return this.isWarpSafe;
	}

	public void setIsWarpSafe(byte isWarpSafe) {
		this.isWarpSafe = isWarpSafe;
	}

	public short getNpcActivationChanceAttributeID() {
		return this.npcActivationChanceAttributeID;
	}

	public void setNpcActivationChanceAttributeID(short npcActivationChanceAttributeID) {
		this.npcActivationChanceAttributeID = npcActivationChanceAttributeID;
	}

	public short getNpcUsageChanceAttributeID() {
		return this.npcUsageChanceAttributeID;
	}

	public void setNpcUsageChanceAttributeID(short npcUsageChanceAttributeID) {
		this.npcUsageChanceAttributeID = npcUsageChanceAttributeID;
	}

	public int getPostExpression() {
		return this.postExpression;
	}

	public void setPostExpression(int postExpression) {
		this.postExpression = postExpression;
	}

	public int getPreExpression() {
		return this.preExpression;
	}

	public void setPreExpression(int preExpression) {
		this.preExpression = preExpression;
	}

	public byte getPropulsionChance() {
		return this.propulsionChance;
	}

	public void setPropulsionChance(byte propulsionChance) {
		this.propulsionChance = propulsionChance;
	}

	public byte getPublished() {
		return this.published;
	}

	public void setPublished(byte published) {
		this.published = published;
	}

	public short getRangeAttributeID() {
		return this.rangeAttributeID;
	}

	public void setRangeAttributeID(short rangeAttributeID) {
		this.rangeAttributeID = rangeAttributeID;
	}

	public byte getRangeChance() {
		return this.rangeChance;
	}

	public void setRangeChance(byte rangeChance) {
		this.rangeChance = rangeChance;
	}

	public String getSfxName() {
		return this.sfxName;
	}

	public void setSfxName(String sfxName) {
		this.sfxName = sfxName;
	}

	public short getTrackingSpeedAttributeID() {
		return this.trackingSpeedAttributeID;
	}

	public void setTrackingSpeedAttributeID(short trackingSpeedAttributeID) {
		this.trackingSpeedAttributeID = trackingSpeedAttributeID;
	}

}