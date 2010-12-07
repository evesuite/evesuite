package eu.evesuite.eve.jpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the crpNPCCorporations database table.
 * 
 */
@Entity
@Table(name = "crpNPCCorporations")
public class CrpNPCCorporation extends EntityAbstract {

	private static final long serialVersionUID = -2653586845631627305L;

	@Id
	private int corporationID;

	private int border;

	private int corridor;

	private String description;

	private int enemyID;

	private String extent;

	private int factionID;

	private int friendID;

	private int fringe;

	private int hub;

	private int initialPrice;

	private int investorID1;

	private int investorID2;

	private int investorID3;

	private int investorID4;

	private int investorShares1;

	private int investorShares2;

	private int investorShares3;

	private int investorShares4;

	private double minSecurity;

	private long publicShares;

	private boolean scattered;

	private String size;

	private double sizeFactor;

	private int solarSystemID;

	private int stationCount;

	private int stationSystemCount;

	@OneToMany(mappedBy = "crpNPCCorporation", fetch = FetchType.LAZY)
	private Collection<AgtAgent> agtAgents;

	@ManyToOne
	@JoinColumn(name = "factionID", insertable=false, updatable=false)
	private ChrFaction chrFaction;

	@ManyToOne
	@JoinColumn(name = "corporationID", insertable=false, updatable=false)
	private EveName eveName;

	public EveName getEveName() {
		return eveName;
	}

	public Collection<AgtAgent> getAgtAgents() {
		return agtAgents;
	}

	public void setAgtAgents(Collection<AgtAgent> agtAgents) {
		this.agtAgents = agtAgents;
	}

	public void setEveName(EveName eveName) {
		this.eveName = eveName;
	}

	public ChrFaction getChrFaction() {
		return chrFaction;
	}

	public void setChrFaction(ChrFaction chrFaction) {
		this.chrFaction = chrFaction;
	}

	public Collection<ChrFaction> getChrFactions() {
		return chrFactions;
	}

	public void setChrFactions(Collection<ChrFaction> chrFactions) {
		this.chrFactions = chrFactions;
	}

	public Collection<ChrFaction> getMilitiaChrFactions() {
		return militiaChrFactions;
	}

	public void setMilitiaChrFactions(Collection<ChrFaction> militiaChrFactions) {
		this.militiaChrFactions = militiaChrFactions;
	}

	@OneToMany(mappedBy = "crpNPCCorporation", fetch = FetchType.LAZY)
	private Collection<ChrFaction> chrFactions;

	@OneToMany(mappedBy = "militiaCrpNPCCorporation", fetch = FetchType.LAZY)
	private Collection<ChrFaction> militiaChrFactions;

	public CrpNPCCorporation() {
	}

	public int getCorporationID() {
		return this.corporationID;
	}

	public void setCorporationID(int corporationID) {
		this.corporationID = corporationID;
	}

	public int getBorder() {
		return this.border;
	}

	public void setBorder(int border) {
		this.border = border;
	}

	public int getCorridor() {
		return this.corridor;
	}

	public void setCorridor(int corridor) {
		this.corridor = corridor;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEnemyID() {
		return this.enemyID;
	}

	public void setEnemyID(int enemyID) {
		this.enemyID = enemyID;
	}

	public String getExtent() {
		return this.extent;
	}

	public void setExtent(String extent) {
		this.extent = extent;
	}

	public int getFactionID() {
		return this.factionID;
	}

	public void setFactionID(int factionID) {
		this.factionID = factionID;
	}

	public int getFriendID() {
		return this.friendID;
	}

	public void setFriendID(int friendID) {
		this.friendID = friendID;
	}

	public int getFringe() {
		return this.fringe;
	}

	public void setFringe(int fringe) {
		this.fringe = fringe;
	}

	public int getHub() {
		return this.hub;
	}

	public void setHub(int hub) {
		this.hub = hub;
	}

	public int getInitialPrice() {
		return this.initialPrice;
	}

	public void setInitialPrice(int initialPrice) {
		this.initialPrice = initialPrice;
	}

	public int getInvestorID1() {
		return this.investorID1;
	}

	public void setInvestorID1(int investorID1) {
		this.investorID1 = investorID1;
	}

	public int getInvestorID2() {
		return this.investorID2;
	}

	public void setInvestorID2(int investorID2) {
		this.investorID2 = investorID2;
	}

	public int getInvestorID3() {
		return this.investorID3;
	}

	public void setInvestorID3(int investorID3) {
		this.investorID3 = investorID3;
	}

	public int getInvestorID4() {
		return this.investorID4;
	}

	public void setInvestorID4(int investorID4) {
		this.investorID4 = investorID4;
	}

	public int getInvestorShares1() {
		return this.investorShares1;
	}

	public void setInvestorShares1(int investorShares1) {
		this.investorShares1 = investorShares1;
	}

	public int getInvestorShares2() {
		return this.investorShares2;
	}

	public void setInvestorShares2(int investorShares2) {
		this.investorShares2 = investorShares2;
	}

	public int getInvestorShares3() {
		return this.investorShares3;
	}

	public void setInvestorShares3(int investorShares3) {
		this.investorShares3 = investorShares3;
	}

	public int getInvestorShares4() {
		return this.investorShares4;
	}

	public void setInvestorShares4(int investorShares4) {
		this.investorShares4 = investorShares4;
	}

	public double getMinSecurity() {
		return this.minSecurity;
	}

	public void setMinSecurity(double minSecurity) {
		this.minSecurity = minSecurity;
	}

	public long getPublicShares() {
		return this.publicShares;
	}

	public void setPublicShares(long publicShares) {
		this.publicShares = publicShares;
	}

	public boolean getScattered() {
		return this.scattered;
	}

	public void setScattered(boolean scattered) {
		this.scattered = scattered;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getSizeFactor() {
		return this.sizeFactor;
	}

	public void setSizeFactor(double sizeFactor) {
		this.sizeFactor = sizeFactor;
	}

	public int getSolarSystemID() {
		return this.solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public int getStationCount() {
		return this.stationCount;
	}

	public void setStationCount(int stationCount) {
		this.stationCount = stationCount;
	}

	public int getStationSystemCount() {
		return this.stationSystemCount;
	}

	public void setStationSystemCount(int stationSystemCount) {
		this.stationSystemCount = stationSystemCount;
	}

}