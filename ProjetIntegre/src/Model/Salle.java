package Model;

public class Salle {

	private int id;
	private String nom;
	private int capacite;

	public Salle(int id, String nom, int capacite) {
		super();
		this.id = id;
		this.nom = nom;
		this.capacite = capacite;
	}
	public Salle() {
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
