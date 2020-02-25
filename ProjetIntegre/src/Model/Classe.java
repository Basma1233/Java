package Model;

public class Classe {

	private int id;
	private String nom;
	private int niveau;
	private int capacite;

	public Classe(int id, String nom, int niveau, int capacite) {
		super();
		this.id = id;
		this.nom = nom;
		this.niveau = niveau;
		this.capacite = capacite;
	}
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nom;
	}

}
