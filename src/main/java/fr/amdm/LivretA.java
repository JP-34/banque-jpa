package fr.amdm;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="livreta")
public class LivretA extends Compte {
	
	private Double taux;
	
	public LivretA() {
		
	}

	
	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	

	@Override
	public String toString() {
		return "LivretA [ taux=" + taux + "]";
	}

		
}
