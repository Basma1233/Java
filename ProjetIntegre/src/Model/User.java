package Model;

public class User {

	private int id;
	private String login;
	private String password;
	private String type;
	private String email;


	public User(String login, int id, String type, String password, String email) {
		super();
		this.login = login;
		this.id = id;
		this.type = type;
		this.password = password;
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
