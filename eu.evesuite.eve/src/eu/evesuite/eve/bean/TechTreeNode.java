package eu.evesuite.eve.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import eu.evesuite.eve.jpa.InvType;

public class TechTreeNode {

	protected boolean isRequirement;
	
	protected boolean isBluePrint;
	
	protected boolean applyME;
	
	protected double amount;
	
	protected InvType invType;
	
	protected TechTreeNode parent;

	public TechTreeNode getParent() {
		return parent;
	}

	public void setParent(TechTreeNode parent) {
		this.parent = parent;
	}

	protected Collection<TechTreeNode> children;
	
	public TechTreeNode() {
		this.children = new ArrayList<TechTreeNode>();
		this.amount = 0.0;
		this.isRequirement = false;
		this.isBluePrint = false;
		this.applyME = false;
		this.parent = null;
	}
	
	public boolean isApplyME() {
		return applyME;
	}
	public void setApplyME(boolean applyME) {
		this.applyME = applyME;
	}
	public Collection<TechTreeNode> getChildren() {
		return children;
	}

	public void setChildren(Collection<TechTreeNode> children) {
		this.children = children;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public InvType getInvType() {
		return invType;
	}

	public boolean isBluePrint() {
		return isBluePrint;
	}
	public void setBluePrint(boolean isBluePrint) {
		this.isBluePrint = isBluePrint;
	}
	public void setInvType(InvType invType) {
		this.invType = invType;
	}

	public boolean isRequirement() {
		return isRequirement;
	}

	public void setRequirement(boolean isRequirement) {
		this.isRequirement = isRequirement;
	}

	public int size() {
		return children.size();
	}

	public boolean isEmpty() {
		return children.isEmpty();
	}

	public boolean contains(Object o) {
		return children.contains(o);
	}

	public Iterator<TechTreeNode> iterator() {
		return children.iterator();
	}

	public Object[] toArray() {
		return children.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return children.toArray(a);
	}

	public boolean add(TechTreeNode e) {
		return children.add(e);
	}

	public boolean remove(Object o) {
		return children.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return children.containsAll(c);
	}

	public boolean addAll(Collection<? extends TechTreeNode> c) {
		return children.addAll(c);
	}

	public boolean removeAll(Collection<?> c) {
		return children.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return children.retainAll(c);
	}

	public void clear() {
		children.clear();
	}

	public boolean equals(Object o) {
		return children.equals(o);
	}

	public int hashCode() {
		return children.hashCode();
	}
	
	
}
