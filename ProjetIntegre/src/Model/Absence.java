package Model;

public class Absence {

	private int id;
	private String classe;
	private int eleve;
	private String seance;

	public Absence(int id, String classe, int eleve, String seance) {
		super();
		this.id = id;
		this.classe = classe;
		this.eleve = eleve;
		this.seance = seance;
	}
	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getEleve() {
		return eleve;
	}
	public void setEleve(int eleve) {
		this.eleve = eleve;
	}
	public String getSeance() {
		return seance;
	}
	public void setSeance(String seance) {
		this.seance = seance;
	}

}
