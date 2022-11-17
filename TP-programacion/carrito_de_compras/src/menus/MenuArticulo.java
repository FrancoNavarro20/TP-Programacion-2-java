package menus;

import java.util.Scanner;

import contenedores.ListadoArticulos;
import models.Articulo;

public class MenuArticulo {
	
	private Scanner sc; 
	private ListadoArticulos la;
	
	public MenuArticulo(ListadoArticulos la) {
		this.sc = new Scanner(System.in);
		this.la = la;
	}

	public void Iniciar()
	{
		boolean state = true;
		int contador = 0;;
		int opcion;
		while(state)
		{
			opcion = OpcionesDeMenu();
			state = VerificarOpciones(opcion,contador);
			contador++;
		}
	}
	
	public int OpcionesDeMenu ()
	{
		System.out.println("1-Mostrar articulos");
		System.out.println("2-Agregar articulo");
		System.out.println("3-modificar articulo");
		System.out.println("4-Eliminar articulo");
		System.out.println("5-Salir");
		System.out.println("Ingrese una opcion");
		int opcion = sc.nextInt();
		return opcion;
	}
	
	public boolean VerificarOpciones(int opcion,int idContador) 
	{
		boolean state = true;
		try {
			switch (opcion) {
			case 1:
				if(la.MostrarListadoArticulos() == false){ System.out.println("La lista no contiene articulos.");}
				break;
			case 2:
				
				Articulo art = CrearArticulo(idContador+1);
				boolean exito = la.agregar(art);
				
				if(exito) {System.out.println("El articulo se agrego correctamente.");/*contador++;*/}
				else {System.out.println("No se pudo crear el articulo, intentelo nuevamente mas tarde.");}	
				
				break;
			case 3:
				//Mostrar el listado de articulos;
				la.MostrarListadoArticulos();
				System.out.println("Ingrese el numero de articulo que desea modificar:");
				int numeroArticulomodif = sc.nextInt();
				
				//buscando el articulo modificable
				Articulo getArticulomodif = la.buscar(numeroArticulomodif-1);
				if(getArticulomodif == null) { System.out.println("No se pudo encontrar el articulo");break;}
				Articulo articuloModificado = ModificarArticulo(getArticulomodif,numeroArticulomodif);
				
				if(articuloModificado == null) {System.out.println("El articulo no se pudo modificar correctamente...");break;}
				System.out.println("El articulo se modifico correctamente");
				break;
			case 4:
				//Mostrar el listado de articulos;
				la.MostrarListadoArticulos();
				System.out.println("Ingrese el numero de articulo que desea eliminar:");
				int numeroArticulo = sc.nextInt();
				
				//buscando el articulo
				Articulo getArticulo = la.buscar(numeroArticulo-1);
				
				//Verificacion y eliminacion
				if(la.eliminar(getArticulo)) {System.out.println("El articulo se elimino correctamente...");}
				else{System.out.println("Ha ocurrido un error al eliminar el articulo...");}
				break;
			case 5:
				System.out.println("Saliendo del menu de articulos...");
				state = false;
				break;
			default:
				System.out.println("Ninguna de las opciones es correcta, intentelo nuevamente mas tarde");
				break;
			}
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error en el menu de articulos, " + e.getMessage());
			state = false;
		}
		
		return state;
	}
	
	
	public Articulo CrearArticulo(int idCreacion)
	{
		System.out.println("Ingrese el nombre del articulo:");
		String nombreArticulo = sc.next();

		System.out.println("Ingrese el precio:");
		double precio = sc.nextDouble();

		System.out.println("Ingrese una descripcion breve:");
		String descripcion = sc.next();
		
		return new Articulo(idCreacion,precio,nombreArticulo,descripcion);
	}
	
	public Articulo ModificarArticulo(Articulo articulo, int idArticulo)
	{
		try {
			//Setear Id
			articulo.setIdArticulo(idArticulo);
			
			//Setear nombre articulo
			System.out.println("Ingrese el nombre del articulo:");
			articulo.setNombre(sc.next()); 

			//Setear precio articulo
			System.out.println("Ingrese el precio:");
			articulo.setPrecio(sc.nextDouble());

			//Setear descripcion articulo
			System.out.println("Ingrese una descripcion breve:");
			articulo.setDescripcion(sc.next());

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
				
		return articulo;
	}
	
	
}
