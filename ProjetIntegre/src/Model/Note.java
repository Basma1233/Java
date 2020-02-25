package Model;

public class Note {

	private int id;
	private int matiere;
	private int classe;
	private int eleve;
	private int note;
	private String observation;

	public Note(int id, int matiere, int classe, int eleve, int note, String observation) {
		super();
		this.id = id;
		this.matiere = matiere;
		this.classe = classe;
		this.eleve = eleve;
		this.note = note;
		this.observation = observation;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMatiere() {
		return matiere;
	}
	public void setMatiere(int matiere) {
		this.matiere = matiere;
	}
	public int getClasse() {
		return classe;
	}
	public void setClasse(int classe) {
		this.classe = classe;
	}
	public int getEleve() {
		return eleve;
	}
	public void setEleve(int eleve) {
		this.eleve = eleve;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}

}
