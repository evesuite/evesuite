package eu.evesuite.eve.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the eveNames database table.
 * 
 */
@Entity
@Table(name = "eveNames")
public class EveName implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int itemID;

	private byte categoryID;

	private short groupID;

	private String itemName;

	private short typeID;

	@OneToMany(mappedBy = "eveName", fetch = FetchType.LAZY)
	private Collection<CrpNPCCorporation> crpNPCCorporations;

	@OneToMany(mappedBy = "eveName", fetch = FetchType.LAZY)
	private Collection<AgtAgent> agtAgents;

	public EveName() {
	}

	public Collection<AgtAgent> getAgtAgents() {
		return agtAgents;
	}

	public void setAgtAgents(Collection<AgtAgent> agtAgents) {
		this.agtAgents = agtAgents;
	}

	public Collection<CrpNPCCorporation> getCrpNPCCorporations() {
		return crpNPCCorporations;
	}

	public void setCrpNPCCorporations(
			Collection<CrpNPCCorporation> crpNPCCorporations) {
		this.crpNPCCorporations = crpNPCCorporations;
	}

	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public byte getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(byte categoryID) {
		this.categoryID = categoryID;
	}

	public short getGroupID() {
		return this.groupID;
	}

	public void setGroupID(short groupID) {
		this.groupID = groupID;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public short getTypeID() {
		return this.typeID;
	}

	public void setTypeID(short typeID) {
		this.typeID = typeID;
	}

}