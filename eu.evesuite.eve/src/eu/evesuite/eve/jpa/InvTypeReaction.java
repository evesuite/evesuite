package eu.evesuite.eve.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.eclipse.persistence.annotations.Customizer;

import eu.evesuite.eve.jpa.customizer.InvTypeReactionCustomizer;

@Entity
@Table(name="invTypeReactions")
@IdClass(InvTypeReactionPK.class)
@Customizer(InvTypeReactionCustomizer.class)
public class InvTypeReaction implements Serializable {

	private static final long serialVersionUID = -2084236295538254679L;

	@Id
	private int reactionTypeID;

	@Id
	private boolean input;

	@Id
	private int typeID;
		
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "reactionTypeID", referencedColumnName="reactionTypeID", insertable=false, updatable=false),
			@JoinColumn(name = "typeID", referencedColumnName="typeID", insertable=false, updatable=false),
			@JoinColumn(name = "input", referencedColumnName="input", insertable=false, updatable=false)
	})
	private InvTypeReaction invTypeReaction;	

	@OneToMany(mappedBy = "invTypeReaction", fetch = FetchType.LAZY)	
	private Collection<InvTypeReaction> invTypeReactions;
						
	@ManyToOne
	@JoinColumn(name = "typeID", insertable=false, updatable=false)	
	private InvType invType;	
				
	private int quantity;

    public InvTypeReaction() {
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
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setInvType(InvType invType) {
		this.invType = invType;
	}

	public InvType getInvType() {
		return invType;
	}
	
	public void setInvTypeReactions(Collection<InvTypeReaction> invTypeReactions) {
		this.invTypeReactions = invTypeReactions;
	}

	public Collection<InvTypeReaction> getInvTypeReactions() {
		return invTypeReactions;
	}

	public void setInvTypeReaction(InvTypeReaction invTypeReaction) {
		this.invTypeReaction = invTypeReaction;
	}

	public InvTypeReaction getInvTypeReaction() {
		return this.invTypeReaction;
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
		return "InvTypeReaction [reactionTypeID=" + reactionTypeID
				+ ", typeID=" + typeID + ", input=" + input + ", quantity="
				+ quantity + "]";
	}


		
}