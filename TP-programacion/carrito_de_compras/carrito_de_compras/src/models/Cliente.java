package models;

public class Cliente {
	
	private String usuario;
	private String password;
	private String saldo;
	
	//Constructor
	public Cliente(String usuario, String password, String saldo) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.saldo = saldo;
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
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	
}
