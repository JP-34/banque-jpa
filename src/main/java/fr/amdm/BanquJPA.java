package fr.amdm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class BanquJPA {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banq");
		EntityManager em = entityManagerFactory. createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		//ajout de banque
		Banque ba1 = new Banque();
		ba1.setNom("LCL");
		em.persist(ba1);
		
		Banque ba2 = new Banque();
		ba2.setNom("Credit Agricole");
		em.persist(ba2);
		
		//ajout de client avec une banque avec adresse
		Client cli = new Client();
		cli.setNom("Dupont");
		cli.setPrenom("Daniel");
		LocalDate dateNaiss = LocalDate.of(1967, 3, 15);
		cli.setDateNaissance(dateNaiss);
		Adresse ad = new Adresse(12, "rue des Pinsons", 34380, "Montpellier");
		cli.setAdresse(ad);
		cli.setBanque(ba2);
		//Ajout de compte 1
		Set<Compte> listCpt1 = new HashSet<Compte>();
		Compte cpt1 = new Compte();
		cpt1.setNumero("302");
		cpt1.setSolde(200.10);
		listCpt1.add(cpt1);
		cli.setComptes(listCpt1);
		em.persist(cpt1);
		em.persist(cli);
		
		//Ajout du compte 2		
		Compte cpt2 = new Compte();
		cpt2.setNumero("340-FF");
		cpt2.setSolde(400.50);
		listCpt1.add(cpt2);
		cli.setComptes(listCpt1);
		em.persist(cpt2);
		
		//Ajout Operation au compte 2
				List<Operation> listOp1 = new ArrayList<Operation>();
				Operation op1 = new Operation();
				LocalDateTime dateJ = LocalDateTime.now() ;
				op1.setDate(dateJ);
				op1.setMontant(600.00);
				op1.setMotif("Prime");
				listOp1.add(op1);
				cpt2.setOperations(listOp1);
				em.persist(op1);
				em.persist(cpt2);
				
							
		et.commit();
		
		em.close();
		entityManagerFactory.close();
		
	}

}
