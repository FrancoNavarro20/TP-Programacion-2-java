package main;

import java.util.Scanner;

import contenedores.ListadoArticulos;
import menus.MenuArticulo;
import models.Articulo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListadoArticulos la = new ListadoArticulos();
		Scanner sc = new Scanner(System.in);
		MenuArticulo ma = new MenuArticulo(la);
		
		//Iniciamos el menu de articulos;
		ma.Iniciar();
		System.out.println("Se termino el programa");
		

	}

}
