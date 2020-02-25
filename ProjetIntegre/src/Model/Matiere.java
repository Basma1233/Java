package Model;

public class Matiere {

	private int id;
	private String nom;
	private int coefficient ;

	public Matiere(int id, String nom, int coefficient) {
		super();
		this.id = id;
		this.nom = nom;
		this.coefficient = coefficient;
	}
	public Matiere() {
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
	public int getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nom;
	}

}
