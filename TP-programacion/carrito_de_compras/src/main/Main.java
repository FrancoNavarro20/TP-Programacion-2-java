package main;

import java.util.Scanner;

import Interfaces.UsuariosService;
import contenedores.ListadoArticulos;
import contenedores.ListadoUsuarios;
import menus.MenuArticulo;
import menus.MenuLogin;
import models.Articulo;
import models.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListadoArticulos la = new ListadoArticulos();
		ListadoUsuarios lu = new ListadoUsuarios();
		Usuario usuarioService = new Usuario();
		Scanner sc = new Scanner(System.in);
		MenuArticulo ma = new MenuArticulo(la);
		MenuLogin ml = new MenuLogin(lu, usuarioService, sc);
		
		
		
		ml.InicialMenuLogin();
		
		//Iniciamos el menu de articulos;
		ma.Iniciar();
		System.out.println("Se termino el programa");
		

	}

}
