package pz.strona.Bean;

public class UserList {
	
	private String id;
	private String login;
	private String data;
	
	public UserList(String id, String login, String data){
		this.id = id;
		this.login = login;
		this.data = data;
		
	}
	// to musi być żeby wypisał własciwe dane
	public String toString() {
		return id+ " " +login +" "+ data +"\n";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	

}
