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
		int rolUser = ml.InicialMenuLogin();
		if(rolUser == 0)
		{
			System.out.println("Usted tiene el perfil de cliente asignado...");
			System.out.println("\n-Menu de artículos-");
			
			ma.IniciarMenuArticulos();//Iniciamos el menu de articulos;
		}
	}
}
