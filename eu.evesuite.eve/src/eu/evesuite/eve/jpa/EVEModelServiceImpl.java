package eu.evesuite.eve.jpa;

import java.util.Collection;

import eu.evesuite.commons.jpa.AbstractModelManager;
import eu.evesuite.commons.jpa.EVEModelService;
import eu.evesuite.eve.bean.TechTree;
import eu.evesuite.eve.bean.TechTreeNode;

public class EVEModelServiceImpl extends AbstractModelManager implements
		EVEModelService {

	public EVEModelServiceImpl() {
		persistenceUnit = "eu.evesuite.eve.jpa";
	}	

	public boolean isBluePrint(InvType entity) {
		
		InvBlueprintType blueprint = this.entityManager.find(InvBlueprintType.class, entity.getTypeID());
		
		if (blueprint instanceof InvBlueprintType) {
			return true;
		}
		
		return false;
	}
	
	public InvBlueprintType getBluePrint(InvType entity) {
		
		if (!this.isBluePrint(entity)) {
			return entity.getInvBlueprintType();
		}

		InvBlueprintType blueprint = this.entityManager.find(InvBlueprintType.class, entity.getTypeID());
		
		if (blueprint instanceof InvBlueprintType) {
			return blueprint;
		}
		
		return null;
	}
	
	public void printPITree(PlanetSchematic schematic, String indent) {
		
		Collection<PlanetSchematicsTypeMap> collection = schematic.getPlanetSchematicsTypeMaps();
		
		for (PlanetSchematicsTypeMap planetSchematicsTypeMap : collection) {
			
			if (!planetSchematicsTypeMap.getIsInput()) {
				System.out.println(indent + schematic.getSchematicName() +  " - " + planetSchematicsTypeMap.getQuantity());				
			}
		}

		for (PlanetSchematicsTypeMap planetSchematicsTypeMap : collection) {
			
			if (planetSchematicsTypeMap.getIsInput()) {
				
				PlanetSchematicsTypeMap map = planetSchematicsTypeMap.getInvType().getPlanetSchematicsTypeMap();
				
				if (map instanceof PlanetSchematicsTypeMap) {				
					this.printPITree(map.getPlanetSchematic(), indent + "\t");
				} else {
					System.out.println(indent + "\t" + planetSchematicsTypeMap.getInvType().getTypeName() + " - " + planetSchematicsTypeMap.getQuantity());
				}
			}
		}
	}
	
	public void printMoonTree(InvTypeReaction reaction, String indent) {

		Collection<InvTypeReaction> collection = reaction.getInvTypeReactions();
		
		System.out.println(indent + reaction.getInvType().getTypeName() +  " - " + reaction.getQuantity());

		for (InvTypeReaction invTypeReaction : collection) {
			
			InvTypeReaction itemReaction = invTypeReaction.getInvType().getInvTypeReaction();
			
			if (itemReaction instanceof InvTypeReaction) {
				this.printMoonTree(itemReaction, indent + "\t");
			} else {
				System.out.println(indent + "\t" + invTypeReaction.getInvType().getTypeName() + " - " + invTypeReaction.getQuantity());
			}
		}
		
	}
	
	
	public Collection<TechTreeNode> getTechTree(InvBlueprintType entity, String indent, double me) {
		
		TechTree techTree = new TechTree();
		
		return techTree.getTree(entity, -4.0);
		
		/*
		Collection<InvTypeMaterial> materials = entity.getInvType().getMaterialInvTypes();
		
		this.printMaterials(materials, indent, me);
		
		Collection<RamTypeRequirement> ramTypeRequirements = entity.getRequiredRamTypeRequirements();
		
		for (RamTypeRequirement ramTypeRequirement : ramTypeRequirements) {
			
			if (ramTypeRequirement.getActivityID() == 1 && ramTypeRequirement.getRequiredInvType().getInvGroup().getInvCategory().getCategoryID() != 16) {
				
				System.out.println(indent  + ramTypeRequirement.getRamActivity().getActivityName()
						+ " - "
						+ ramTypeRequirement.getRequiredInvType()
								.getTypeName() + " - "
						+ ramTypeRequirement.getQuantity() + " - "
						+ ramTypeRequirement.getDamagePerJob() + " - "
						+ ramTypeRequirement.getRecycle());
				
				materials = ramTypeRequirement.getRequiredInvType().getMaterialInvTypes();
				
				this.printMaterials(materials,  indent + "\t", 0.0);
				
				PlanetSchematicsTypeMap planetSchematicsTypeMap = ramTypeRequirement.getRequiredInvType().getPlanetSchematicsTypeMap();
				
				if (planetSchematicsTypeMap instanceof PlanetSchematicsTypeMap) {
					this.printPITree(planetSchematicsTypeMap.getPlanetSchematic(), indent + "\t");
				}
				
			}
		}		*/					
	}
	
	
}
