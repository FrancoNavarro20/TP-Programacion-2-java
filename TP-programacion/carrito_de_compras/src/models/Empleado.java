package models;

public class Empleado {

	private String usuario;
	private String password;
	
	//Constructor
	public Empleado(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}
	
	//Getters and Setters
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
