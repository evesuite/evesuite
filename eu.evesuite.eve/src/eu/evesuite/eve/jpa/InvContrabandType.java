package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invContrabandTypes database table.
 * 
 */
@Entity
@Table(name="invContrabandTypes")
public class InvContrabandType implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InvContrabandTypePK id;

	private double attackMinSec;

	private double confiscateMinSec;

	private double fineByValue;

	private double standingLoss;

    public InvContrabandType() {
    }

	public InvContrabandTypePK getId() {
		return this.id;
	}

	public void setId(InvContrabandTypePK id) {
		this.id = id;
	}
	
	public double getAttackMinSec() {
		return this.attackMinSec;
	}

	public void setAttackMinSec(double attackMinSec) {
		this.attackMinSec = attackMinSec;
	}

	public double getConfiscateMinSec() {
		return this.confiscateMinSec;
	}

	public void setConfiscateMinSec(double confiscateMinSec) {
		this.confiscateMinSec = confiscateMinSec;
	}

	public double getFineByValue() {
		return this.fineByValue;
	}

	public void setFineByValue(double fineByValue) {
		this.fineByValue = fineByValue;
	}

	public double getStandingLoss() {
		return this.standingLoss;
	}

	public void setStandingLoss(double standingLoss) {
		this.standingLoss = standingLoss;
	}

}