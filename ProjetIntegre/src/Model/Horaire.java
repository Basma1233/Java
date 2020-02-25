package Model;

public class Horaire {

	int id;
	String nom;

	public Horaire(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Horaire() {
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nom;
	}

}
