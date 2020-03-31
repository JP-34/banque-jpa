package fr.amdm;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="assurancevie")
public class AssuranceVie extends Compte{
	
	
	@Column(name="DATE_FIN", nullable = false)
	private LocalDate dateFin;
		
	private Double taux;
	
	public  AssuranceVie() {
			 		
	}

	
	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	

	@Override
	public String toString() {
		return "AssuranceVie [dateFin=" + dateFin + ", taux=" + taux + "]";
	}

	
}
