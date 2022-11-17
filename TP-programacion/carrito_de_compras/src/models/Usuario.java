package models;

import java.util.Scanner;

import Interfaces.UsuariosService;

public class Usuario implements UsuariosService{

	private int idUsuario;
	private String nombreUsuario;
	private String contraseniaUsuario;
	private int rolUsuario;
	private Scanner sc;
	
	//Constructor con parametros
	public Usuario(int idUsuario, String nombreUsuario, String contraseniaUsuario, int rolUsuario) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contraseniaUsuario = contraseniaUsuario;
		this.rolUsuario = rolUsuario;
		this.sc = new Scanner(System.in);
	}
	
	//Constructor sin parametros
	public Usuario() {
		this.sc = new Scanner(System.in);
	}
	
	
	//Setter and getters 
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseniaUsuario() {
		return contraseniaUsuario;
	}
	public void setContraseniaUsuario(String contraseniaUsuario) {
		this.contraseniaUsuario = contraseniaUsuario;
	}
	
	public int getRolUsuario() {
		return rolUsuario;
	}
	public void setRolUsuario(int rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	@Override
	public void Registrarse() {
		System.out.println("Ingrese el correo electronico como nombre de usuario:");
		String nUsuario = sc.next();
	}

	@Override
	public void Login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ManualUso() {
		System.out.println("Bienvenido... Ingrese un correo electronico como nombre de usuario y una contraseña");
		System.out.println("para poder registrar su usuario dentro del sistema");
		
	}

	@Override
	public void getRolUsuarioLogueado() {
		// TODO Auto-generated method stub
		
	}
	
}
