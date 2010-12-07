package eu.evesuite.eve.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.eclipse.persistence.annotations.Customizer;

import eu.evesuite.eve.jpa.customizer.InvTypeCustomizer;


@Entity
@Table(name="invTypes")
@Customizer(InvTypeCustomizer.class)
public class InvType implements Serializable {

	private static final long serialVersionUID = -5325005044172096301L;

	@Id
	private int typeID;

	private double basePrice;

	private double capacity;

	private double chanceOfDuplicating;

	private String description;

	private int graphicID;

	private int groupID;

	private int marketGroupID;

	private double mass;

	private int portionSize;

	private boolean published;

	private int raceID;

	private double radius;

	private String typeName;

	private double volume;

	@ManyToOne
	@JoinColumn(name = "iconID", insertable=false, updatable=false)	
	private EveIcon eveIcon;	
	
	@ManyToOne
	@JoinColumn(name = "marketGroupID", insertable=false, updatable=false)
	private InvMarketGroup invMarketGroup;
	
	@ManyToOne
	@JoinColumn(name = "groupID", insertable=false, updatable=false)
	private InvGroup invGroup;

	@OneToOne
	@JoinColumn(name = "typeID", referencedColumnName="productTypeID", insertable=false, updatable=false)
	private InvBlueprintType invBlueprintType;

	@OneToMany(mappedBy = "invType", fetch = FetchType.LAZY)	
	private Collection<DgmTypeAttribute> dgmTypeAttributes;
		
	@OneToMany(mappedBy = "invType", fetch = FetchType.LAZY)
	private List<InvTypeMaterial> invTypeMaterials;
	
	@OneToMany(mappedBy = "materialInvType", fetch = FetchType.LAZY)
	private Collection<InvTypeMaterial> materialInvTypes;
	
	@OneToMany(mappedBy = "invType", fetch = FetchType.LAZY)
	private Collection<RamTypeRequirement> ramTypeRequirements;

	@OneToMany(mappedBy = "requiredInvType", fetch = FetchType.LAZY)
	private Collection<RamTypeRequirement> requiredRamTypeRequirements;
	
	@OneToMany(mappedBy = "invType", fetch = FetchType.LAZY)
	private Collection<InvMetaType> invMetaTypes;
	
	@OneToMany(mappedBy = "parentInvType", fetch = FetchType.LAZY)
	private Collection<InvMetaType> parentInvMetaTypes;
	
	@OneToMany(mappedBy = "invType", fetch = FetchType.LAZY)	
	private Collection<PlanetSchematicsTypeMap> planetSchematicsTypeMaps;
			
	@OneToOne(mappedBy = "invType")
	@JoinColumn(name = "typeID", referencedColumnName="typeID", insertable=false, updatable=false)
	private PlanetSchematicsTypeMap planetSchematicsTypeMap;
	
	@OneToOne(mappedBy = "invType")
	@JoinColumn(name = "typeID", referencedColumnName="typeID", insertable=false, updatable=false)
	private InvTypeReaction invTypeReaction;
	
	public List<InvTypeMaterial> getInvTypeMaterials() {
		return invTypeMaterials;
	}

	public void setInvTypeMaterials(List<InvTypeMaterial> invTypeMaterials) {
		this.invTypeMaterials = invTypeMaterials;
	}

	public Collection<InvTypeMaterial> getMaterialInvTypes() {
		return materialInvTypes;
	}

	public void setMaterialInvTypes(Collection<InvTypeMaterial> materialInvTypes) {
		this.materialInvTypes = materialInvTypes;
	}

	public Collection<DgmTypeAttribute> getDgmTypeAttributes() {
		return dgmTypeAttributes;
	}

	public void setDgmTypeAttributes(Collection<DgmTypeAttribute> dgmTypeAttributes) {
		this.dgmTypeAttributes = dgmTypeAttributes;
	}

	public InvType() {
    }

	public InvMarketGroup getInvMarketGroup() {
		return invMarketGroup;
	}

	public void setInvMarketGroup(InvMarketGroup invMarketGroup) {
		this.invMarketGroup = invMarketGroup;
	}

	public int getTypeID() {
		return this.typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public double getBasePrice() {
		return this.basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getCapacity() {
		return this.capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getChanceOfDuplicating() {
		return this.chanceOfDuplicating;
	}

	public void setChanceOfDuplicating(double chanceOfDuplicating) {
		this.chanceOfDuplicating = chanceOfDuplicating;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGraphicID() {
		return this.graphicID;
	}

	public void setGraphicID(int graphicID) {
		this.graphicID = graphicID;
	}

	public int getGroupID() {
		return this.groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public int getMarketGroupID() {
		return this.marketGroupID;
	}

	public void setMarketGroupID(int marketGroupID) {
		this.marketGroupID = marketGroupID;
	}

	public double getMass() {
		return this.mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public int getPortionSize() {
		return this.portionSize;
	}

	public void setPortionSize(int portionSize) {
		this.portionSize = portionSize;
	}

	public boolean getPublished() {
		return this.published;
	}

	public boolean isPublished() {
		return getPublished();
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public int getRaceID() {
		return this.raceID;
	}

	public void setRaceID(int raceID) {
		this.raceID = raceID;
	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public double getVolume() {
		return this.volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public void setRequiredRamTypeRequirements(
			Collection<RamTypeRequirement> requiredRamTypeRequirements) {
		this.requiredRamTypeRequirements = requiredRamTypeRequirements;
	}

	public Collection<RamTypeRequirement> getRequiredRamTypeRequirements() {
		return requiredRamTypeRequirements;
	}

	public void setRamTypeRequirements(Collection<RamTypeRequirement> ramTypeRequirements) {
		this.ramTypeRequirements = ramTypeRequirements;
	}

	public Collection<RamTypeRequirement> getRamTypeRequirements() {
		return ramTypeRequirements;
	}

	public void setInvMetaTypes(Collection<InvMetaType> invMetaTypes) {
		this.invMetaTypes = invMetaTypes;
	}

	public Collection<InvMetaType> getInvMetaTypes() {
		return invMetaTypes;
	}

	public void setParentInvMetaTypes(Collection<InvMetaType> parentInvMetaTypes) {
		this.parentInvMetaTypes = parentInvMetaTypes;
	}

	public Collection<InvMetaType> getParentInvMetaTypes() {
		return parentInvMetaTypes;
	}

	public void setEveIcon(EveIcon eveIcon) {
		this.eveIcon = eveIcon;
	}

	public EveIcon getEveIcon() {
		return eveIcon;
	}

	public void setInvGroup(InvGroup invGroup) {
		this.invGroup = invGroup;
	}

	public InvGroup getInvGroup() {
		return invGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + typeID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof InvType)) {
			return false;
		}
		InvType other = (InvType) obj;
		if (typeID != other.getTypeID()) {
			return false;
		}
		return true;
	}

	public void setInvBlueprintType(InvBlueprintType invBlueprintType) {
		this.invBlueprintType = invBlueprintType;
	}

	public InvBlueprintType getInvBlueprintType() {
		return invBlueprintType;
	}

	public void setPlanetSchematicsTypeMaps(Collection<PlanetSchematicsTypeMap> planetSchematicsTypeMaps) {
		this.planetSchematicsTypeMaps = planetSchematicsTypeMaps;
	}

	public Collection<PlanetSchematicsTypeMap> getPlanetSchematicsTypeMaps() {
		return planetSchematicsTypeMaps;
	}

	public void setPlanetSchematicsTypeMap(PlanetSchematicsTypeMap planetSchematicsTypeMap) {
		this.planetSchematicsTypeMap = planetSchematicsTypeMap;
	}

	public PlanetSchematicsTypeMap getPlanetSchematicsTypeMap() {
		return planetSchematicsTypeMap;
	}

	public void setInvTypeReaction(InvTypeReaction invTypeReaction) {
		this.invTypeReaction = invTypeReaction;
	}

	public InvTypeReaction getInvTypeReaction() {
		return invTypeReaction;
	}

	
}