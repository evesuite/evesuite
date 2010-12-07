package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the agtAgentTypes database table.
 * 
 */
@Entity
@Table(name="agtAgentTypes")
public class AgtAgentType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int agentTypeID;
	private String agentType;

    public AgtAgentType() {
    }


	@Id
	public int getAgentTypeID() {
		return this.agentTypeID;
	}

	public void setAgentTypeID(int agentTypeID) {
		this.agentTypeID = agentTypeID;
	}


	public String getAgentType() {
		return this.agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

}