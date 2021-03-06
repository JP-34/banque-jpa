package fr.amdm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	private String numero;
	
	private Double solde;
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations = new ArrayList<Operation>();
	
	@ManyToMany
	@JoinTable(name="CLICOM", 
		joinColumns = @JoinColumn(name="ID_COMPT", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name="ID_CLI", referencedColumnName = "ID"))
	private Set<Client> clients;
	
	public Compte() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	
}
