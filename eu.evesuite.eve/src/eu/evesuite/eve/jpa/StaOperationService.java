package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the staOperationServices database table.
 * 
 */
@Entity
@Table(name="staOperationServices")
public class StaOperationService implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StaOperationServicePK id;

    public StaOperationService() {
    }

	public StaOperationServicePK getId() {
		return this.id;
	}

	public void setId(StaOperationServicePK id) {
		this.id = id;
	}
	
}