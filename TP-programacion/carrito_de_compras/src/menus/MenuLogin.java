package menus;

import java.util.Scanner;

import contenedores.ListadoUsuarios;
import models.Usuario;

public class MenuLogin {
	
	ListadoUsuarios _listadoUsuario = new ListadoUsuarios();
	Usuario usuarioService = new Usuario();
	Scanner sc = new Scanner(System.in);
	
	//Constructor
	public MenuLogin(ListadoUsuarios _listadoUsurio, Usuario usuarioService, Scanner sc) {
		super();
		this._listadoUsuario = _listadoUsurio;
		this.usuarioService = usuarioService;
		this.sc = sc;
	}

	public void InicialMenuLogin()
	{
		try {
			
			boolean stateLogin = true;
			while(stateLogin)
			{
				usuarioService.ManualUso();				
				boolean stadoUsuario = IngresoDeDatosLogin();
				
				if(stadoUsuario == false) {
					System.out.println("ingreso mal los datos o no esta registrado como usuario.");
					System.out.println("Desea registrarse en el sistema? S/N");
					String request = sc.next().toUpperCase();
					if(request.equals("S")) 
					{
						Usuario newUsuario = usuarioService.Registrarse(1);
						if(newUsuario != null)
						{
							_listadoUsuario.agregar(newUsuario);
							_listadoUsuario.MostrarListadoUsuario();
						}
					}
					else {
						System.out.println("Ha ocurrido un error al registrarse");
					}
				}
				
				stadoUsuario = IngresoDeDatosLogin();
				if(stadoUsuario)
				{
					System.out.println("Ingreso exitoso!!! ingresaste a la aplicación.");
					stateLogin = false;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error en el menu login... revisar desarrollador");
		}
		
	}
	
	
	public boolean IngresoDeDatosLogin()
	{
		System.out.println("Ingrese el correo:");
		String username = sc.next();
		System.out.println("Ingrese la contraseña:");
		String password = sc.next();
		return usuarioService.Login(_listadoUsuario, username, password);
	}


	
}
