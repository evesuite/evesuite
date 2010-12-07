package eu.evesuite.eve.jpa;

import java.io.Serializable;

public class InvTypeReactionPK implements Serializable {

	private static final long serialVersionUID = -6155833917015778724L;

	private int reactionTypeID;

	private boolean input;

	private int typeID;

    public InvTypeReactionPK() {
    }
    
	public int getReactionTypeID() {
		return this.reactionTypeID;
	}
	
	public void setReactionTypeID(int reactionTypeID) {
		this.reactionTypeID = reactionTypeID;
	}
	
	public boolean getInput() {
		return this.input;
	}
	
	public void setInput(boolean input) {
		this.input = input;
	}
	
	public int getTypeID() {
		return this.typeID;
	}
	
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (input ? 1231 : 1237);
		result = prime * result + reactionTypeID;
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
		if (!(obj instanceof InvTypeReaction)) {
			return false;
		}
		InvTypeReaction other = (InvTypeReaction) obj;
		if (input != other.getInput()) {
			return false;
		}
		if (reactionTypeID != other.getReactionTypeID()) {
			return false;
		}
		if (typeID != other.getTypeID()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "InvTypeReactionPK [reactionTypeID=" + reactionTypeID
				+ ", typeID=" + typeID + ", input=" + input + "]";
	}
	
}