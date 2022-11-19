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

	public int InicialMenuLogin()
	{
		try {
			int contador = 0;
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
						Usuario newUsuario = usuarioService.Registrarse(contador+1);
						if(newUsuario != null)
						{
							_listadoUsuario.agregar(newUsuario);
							_listadoUsuario.MostrarListadoUsuario();
							contador++;
							stadoUsuario = IngresoDeDatosLogin();
							if(stadoUsuario == true)
							{
								System.out.println("Ingreso exitoso!!! ingresaste a la aplicación.");
								stateLogin = false;
								
								//Retornamos el rol del usuario
								return newUsuario.getRolUsuario();
							}
						}
					}
					else {
						System.out.println("Ha ocurrido un error al registrarse");
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error en el menu login... revisar desarrollador");
		}
		return 0;
		
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
