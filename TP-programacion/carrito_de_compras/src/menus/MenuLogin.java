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
			int contador = 2;
			boolean stateLogin = true;
			while(stateLogin)
			{
				usuarioService.ManualUso();				
				int stadoUsuario = IngresoDeDatosLogin();
				System.out.println("ver rol usuario " + stadoUsuario);
				if(stadoUsuario == -1) {
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
							if(stadoUsuario != -1)
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
				else if(stadoUsuario == 0){
					//Ingreso como cliente
					System.out.println("Ingreso exitoso!!! ingresaste a la aplicación.");
					stateLogin = false;
					//Retornamos el rol del usuario
					return stadoUsuario;
				}
				else
				{
					//ingreso como empleado
					System.out.println("Ingreso exitoso!!! ingresaste a la aplicación.");
					stateLogin = false;
					//Retornamos el rol del usuario
					return stadoUsuario;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error en el menu login... revisar desarrollador");
		}
		return 0;
		
	}
	
	
	public int IngresoDeDatosLogin()
	{
		System.out.println("Ingrese el correo:");
		String username = sc.next();
		System.out.println("Ingrese la contraseña:");
		String password = sc.next();		
		
		return usuarioService.Login(this._listadoUsuario, username, password);
	}


	
}
