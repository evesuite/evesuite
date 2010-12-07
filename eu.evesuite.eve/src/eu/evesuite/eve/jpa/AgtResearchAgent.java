package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the agtResearchAgents database table.
 * 
 */
@Entity
@Table(name="agtResearchAgents")
public class AgtResearchAgent implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AgtResearchAgentPK id;

    public AgtResearchAgent() {
    }

	public AgtResearchAgentPK getId() {
		return this.id;
	}

	public void setId(AgtResearchAgentPK id) {
		this.id = id;
	}
	
}