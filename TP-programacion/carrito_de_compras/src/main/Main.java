package main;

import java.util.Scanner;

import Interfaces.UsuariosService;
import contenedores.ListadoArticulos;
import contenedores.ListadoUsuarios;
import menus.MenuArticulo;
import menus.MenuLogin;
import menus.MenuPrincipal;
import models.Articulo;
import models.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListadoArticulos la = new ListadoArticulos();
		ListadoUsuarios lu = new ListadoUsuarios();
		Usuario usuarioService = new Usuario();
		Scanner sc = new Scanner(System.in);
		MenuPrincipal mp = new MenuPrincipal(la,lu,usuarioService,sc);		
		
		/*Agrego un usuario como administrador para cargar los datos
		lu.agregar(new Usuario(1,"franco","franco",1)); //usuario rol empleado
		lu.agregar(new Usuario(2,"mati","mati",0)); //usuario rol cliente
		lu.MostrarListadoUsuario();*/
			
		mp.IniciarMenuPrincipal();
		

		
		System.out.println("Se termino el programa");
		

	}

}
 