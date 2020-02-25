package Model;

public class Seance {

	private int id;
	private int classe;
	private int matiere;
	private int salle;
	private int prof;
	private int horaire;
	private int jour;

	public Seance(int id, int classe, int matiere, int salle, int prof, int horaire, int jour) {
		super();
		this.id = id;
		this.classe = classe;
		this.matiere = matiere;
		this.salle = salle;
		this.prof = prof;
		this.horaire = horaire;
		this.jour = jour;
	}
	public Seance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClasse() {
		return classe;
	}
	public void setClasse(int classe) {
		this.classe = classe;
	}
	public int getMatiere() {
		return matiere;
	}
	public void setMatiere(int matiere) {
		this.matiere = matiere;
	}
	public int getSalle() {
		return salle;
	}
	public void setSalle(int salle) {
		this.salle = salle;
	}
	public int getProf() {
		return prof;
	}
	public void setProf(int prof) {
		this.prof = prof;
	}
	public int getHoraire() {
		return horaire;
	}
	public void setHoraire(int horaire) {
		this.horaire = horaire;
	}
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}

}
