package menus;
import java.util.Scanner;
import contenedores.ListadoArticulos;
import contenedores.ListadoUsuarios;
import models.Usuario;

public class MenuPrincipal {

	private MenuArticulo ma;
	private MenuLogin ml;
	
	//Constructor
	public MenuPrincipal(ListadoArticulos la, ListadoUsuarios lu, 
			Usuario usuarioService,Scanner sc)
	{
		this.ma = new MenuArticulo(la);
		this.ml = new MenuLogin(lu, usuarioService, sc);
	}
	
	
	public void IniciarMenuPrincipal()
	{
		while(true) {
			int rolUser = ml.InicialMenuLogin();
			System.out.println("El rol que tiene " + rolUser); 
			if(rolUser == 0)
			{
				System.out.println("Usted tiene el perfil de cliente asignado...");
				System.out.println("\n-Menu de artículos-");
				int respuestaCliente = ma.IniciarMenuArticulosCliente();//Iniciamos el menu de articulos;
					
			}
			else
			{
				System.out.println("Usted tiene el perfil de empleado asignado...");
				System.out.println("\n-Menu de artículos-");
				int respuestaEmpleados =  ma.IniciarMenuArticulos();
			}
		}
		
	}
}
