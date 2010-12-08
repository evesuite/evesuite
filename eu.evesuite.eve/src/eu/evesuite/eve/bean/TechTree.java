package eu.evesuite.eve.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import eu.evesuite.eve.jpa.InvBlueprintType;
import eu.evesuite.eve.jpa.InvType;
import eu.evesuite.eve.jpa.InvTypeMaterial;
import eu.evesuite.eve.jpa.InvTypeReaction;
import eu.evesuite.eve.jpa.PlanetSchematic;
import eu.evesuite.eve.jpa.PlanetSchematicsTypeMap;
import eu.evesuite.eve.jpa.RamTypeRequirement;

public class TechTree {

	public Collection<TechTreeNode> getTree(InvBlueprintType entity, double me) {

		if (!(entity instanceof InvBlueprintType)) {
			return new ArrayList<TechTreeNode>();
		}
		
		Collection<TechTreeNode> collection = getTreeNodes(entity, null);

		Collections.sort((List<TechTreeNode>) collection,
				new Comparator<TechTreeNode>() {

					@Override
					public int compare(TechTreeNode o1, TechTreeNode o2) {
						return o1.getInvType().getTypeName()
								.compareTo(o2.getInvType().getTypeName());
					}

				});
		
		for (TechTreeNode techTreeNode : collection) {
			techTreeNode.setApplyME(true);
		}

		if (entity.getTechLevel() == 2) {

			/*
			Collection<InvMetaType> invMetaTypes = entity.getInvType()
					.getInvMetaTypes();

			for (InvMetaType invMetaType : invMetaTypes) {

				Collection<InvTypeMaterial> invTypeMaterials = invMetaType
						.getParentInvType().getMaterialInvTypes();
			}
						*/
		}		
		
		return collection;		
	}

	protected void printTree(Collection<TechTreeNode> collection, String indent, double me) {
		
		for (TechTreeNode techTreeNode : collection) {
			
			if (techTreeNode.isApplyME()) {
				System.out
						.println(indent + techTreeNode.getInvType().getTypeName()
								+ " ME:"
								+ " perfect => "
								+ techTreeNode.getAmount()
								+ " | "
								+ me
								+ " => "
								+ (techTreeNode.isRequirement() ? techTreeNode
										.getAmount() : this.calculateME(
										techTreeNode.getAmount(), -4.0)));
			} else {
				System.out
				.println(indent + techTreeNode.getInvType().getTypeName()
						+ " => "
						+ techTreeNode.getAmount());				
			}
			
			printTree(techTreeNode.getChildren(), indent + "\t", 0.0);
		}
	}
	
	protected void createChildren(Collection<TechTreeNode> collection) {
		
		for (TechTreeNode techTreeNode : collection) {
		
			if (techTreeNode.getInvType().getInvBlueprintType() != null) {
				
				InvBlueprintType blueprint = techTreeNode.getInvType().getInvBlueprintType();
				
				if (blueprint instanceof InvBlueprintType) {
					
					techTreeNode.setBluePrint(true);
					techTreeNode.setApplyME(true);
					
					Collection<TechTreeNode> techTreeNodes = this.getTreeNodes(blueprint, techTreeNode);
					
					techTreeNode.addAll(techTreeNodes);
				}
			}			
		}
	}
	
	public Collection<TechTreeNode> getBySchematic(PlanetSchematic schematic, TechTreeNode parent) {
		
		Collection<TechTreeNode> collection = new ArrayList<TechTreeNode>();
		
		Collection<PlanetSchematicsTypeMap> collection2 = schematic.getPlanetSchematicsTypeMaps();
		
		TechTreeNode node = null;
		
		for (PlanetSchematicsTypeMap planetSchematicsTypeMap : collection2) {
			
			if (planetSchematicsTypeMap.getIsInput()) {
				
				PlanetSchematicsTypeMap map = planetSchematicsTypeMap.getInvType().getPlanetSchematicsTypeMap();
				
				node = new TechTreeNode();
				node.setAmount((double) planetSchematicsTypeMap.getQuantity());
				node.setInvType(planetSchematicsTypeMap.getInvType());
				node.setRequirement(false);
				node.setParent(parent);
				node.setType(TechTreeNode.TYPES.PI);

				collection.add(node);				

				if (map instanceof PlanetSchematicsTypeMap) {		
					node.addAll(this.getBySchematic(map.getPlanetSchematic(), node));
				}					
			}
		}
		
		return collection;
	}
	
	public Collection<TechTreeNode> getByReaction(InvTypeReaction reaction, TechTreeNode parent) {
		
		Collection<TechTreeNode> collection = new ArrayList<TechTreeNode>();
		
		Collection<InvTypeReaction> collection2 = reaction.getInvTypeReactions();
		
		TechTreeNode node = null;
		
		for (InvTypeReaction invTypeReaction : collection2) {
			
			InvTypeReaction itemReaction = invTypeReaction.getInvType().getInvTypeReaction();
			
			node = new TechTreeNode();
			node.setAmount((double) invTypeReaction.getQuantity());
			node.setInvType(invTypeReaction.getInvType());
			node.setRequirement(false);
			node.setParent(parent);
			node.setType(TechTreeNode.TYPES.MOON);
			parent.setType(TechTreeNode.TYPES.MOON);

			collection.add(node);				

			if (itemReaction instanceof InvTypeReaction) {	
				node.addAll(this.getByReaction(itemReaction.getInvTypeReaction(), node));
			}					
		}
		
		return collection;
	}
	
	protected Collection<TechTreeNode> getTreeNodes(InvBlueprintType entity, TechTreeNode parent) {

		Collection<TechTreeNode> collection = new ArrayList<TechTreeNode>();

		if (!(entity instanceof InvBlueprintType)) {
			return collection;
		}
		
		TechTreeNode node = null;

		if (entity.getInvType() instanceof InvType) {
			
			Collection<InvTypeMaterial> materials = entity.getInvType()
					.getMaterialInvTypes();
	
			for (InvTypeMaterial invTypeMaterial : materials) {
	
				node = new TechTreeNode();
				node.setAmount((double) invTypeMaterial.getQuantity());
				node.setInvType(invTypeMaterial.getInvType());
				node.setRequirement(false);
				node.setParent(parent);
				node.setType(TechTreeNode.TYPES.INVTYPE);
	
				collection.add(node);	
				
				PlanetSchematicsTypeMap planetSchematicsTypeMap = node.getInvType().getPlanetSchematicsTypeMap();
				
				if (planetSchematicsTypeMap instanceof PlanetSchematicsTypeMap) {
					node.addAll(this.getBySchematic(planetSchematicsTypeMap.getPlanetSchematic(), node));
				}
				
				InvTypeReaction invTypeReaction =  node.getInvType().getInvTypeReaction();
				
				if (invTypeReaction instanceof InvTypeReaction) {
					node.addAll(this.getByReaction(invTypeReaction, node));
				}			
			}
		}
		
		Collection<RamTypeRequirement> ramTypeRequirements = entity
				.getRequiredRamTypeRequirements();

		for (RamTypeRequirement ramTypeRequirement : ramTypeRequirements) {

			if (ramTypeRequirement.getActivityID() == 1
					&& ramTypeRequirement.getRequiredInvType().getInvGroup()
							.getInvCategory().getCategoryID() != 16) {

				node = new TechTreeNode();
				node.setAmount((double) ramTypeRequirement.getQuantity());
				node.setInvType(ramTypeRequirement.getRequiredInvType());
				node.setRequirement(true);
				node.setParent(parent);
				node.setType(TechTreeNode.TYPES.INVTYPE);

				collection.add(node);
			}
		}

		this.createChildren(collection);
		
		return collection;
	}

	protected double calculateME(double amount, double me) {

		if (me < 0) {
			return Math
					.round((amount + (double) (amount * (double) (10.0 / 100.0) * (double) ((double) (1 - (me))))));
		} else {
			return Math
					.round((amount + (double) (amount * (double) (10.0 / 100.0) * (double) ((1.0 / (double) (me + 1))))));
		}

	}
}
