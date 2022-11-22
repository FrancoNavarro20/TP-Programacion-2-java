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

	
	public int IniciarMenuArticulosCliente()
	{
		ListadoArticulos laCliente = new ListadoArticulos();
		int opcionCliente = -1;
		boolean state = true;
		while(state)
		{
			opcionCliente = OpcionesDeMenuCliente();
			switch (opcionCliente) {
			case 1:
				laCliente = AgregarArticulosAlCarrito(laCliente);
				break;
			case 2:
				if(laCliente.GetListadoArticulos().size() == 0)
				{
					System.out.println("No hay articulos agregados al carrito");
					break;
				}
				
				//Mostrar el listado del carrito de compras
				System.out.println("Mostrando el listado del carrito");
				this.MostrarArticulosDelCarrito(laCliente);
				break;
			case 3:
				//Generando factura de compra!!!
				GenerarFacturaDeCompra(laCliente);
				break;
			case 4:
				System.out.println("Gracias por usar el sistema!!!");
				System.out.println("Cerrando sesión del cliente...");
				state = false;
				return 4; //saliendo del sistema
			default:
				System.out.println("Error,re-ingrese una opcion que sea del menu");
				break;
			}
		}
		
		return opcionCliente;
	}
	
	public void MostrarArticulosDelCarrito(ListadoArticulos la)
	{
		System.out.println("-------------------------------LISTA DEL CARRITO------------------------------------");
		System.out.println("Id  -  Nombre  -  Descripcion  - Precio");
		for (Articulo articulos : la.GetListadoArticulos()) {
			System.out.println(articulos.getIdArticulo() + "    -   " + articulos.getNombre() + " -   " 
					+ articulos.getDescripcion() + "       - " + articulos.getPrecio());
		}
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	public ListadoArticulos AgregarArticulosAlCarrito(ListadoArticulos laCliente)
	{
		//ListadoArticulos laCliente = new ListadoArticulos();
		boolean stateCarrito = true;
		try {
			boolean stadoListaArticulo = la.MostrarListadoArticulos();
			if(stadoListaArticulo)
			{
				stateCarrito = false;
				System.out.println("Ingrese el ¡¡número!! del articulo que desea agregar al carrito:");
				int numeroArticulo = sc.nextInt();
				System.out.println("Producto " + numeroArticulo);
				Articulo getArticulo = la.GetListadoArticulos().get(numeroArticulo-1);
				if(getArticulo != null)
				{	
					laCliente.agregar(getArticulo);
				}
				else {
					System.out.println("No se encontro el articulo, intentelo nuevamente.");
				}				
				/*Segunda parte!!
				System.out.println("Desea agregar mas cosas al carrito de compras? S/N");
				String request = sc.next();
				if(request.toLowerCase().equals("s")) // si esto es igual a true
				{
					System.out.println("Entro al if N");
					stateCarrito = true;
				}
				else {
					stateCarrito = false;
				}*/
			}
			else {
				System.out.println("No hay articulos agregados, intentelo nuevamente mas tarde.");
				stateCarrito = false;
			}
			
		} catch (Exception e) {
			return null;
		}
		
		return laCliente; //Devuelve la cantidad de articulos que agrego al carrito
	}
	
	public void GenerarFacturaDeCompra(ListadoArticulos la)
	{
		System.out.println("---------------------FACTURA---------------------------");
		double total = 0;
		this.MostrarArticulosDelCarrito(la);
		
		//Generando Factura de precio;
		for (Articulo articulo : la.GetListadoArticulos()) {
			total = total + articulo.getPrecio();
		}
		
		System.out.println("-----------------------------------");
		System.out.println("Total: " + total + "\n");
		System.out.println("-----------------FIN DE LA FACTURA---------------------");
		
	}
	
	public int IniciarMenuArticulos()
	{
		boolean state = true;
		int contador = 1;
		int opcion;
		while(state)
		{
			opcion = OpcionesDeMenu();
			state = VerificarOpciones(opcion,contador);
			//contador++;
		}
		return 5; //Devuelve 5 cuando sale del menu de articulos empleados
	}
	
	public int OpcionesDeMenuCliente ()
	{
		System.out.println("1-Mostrar articulos para comprar");
		System.out.println("2-Mostrar los articulos que estan en el carrito");
		System.out.println("3-Generar factura de compra");
		System.out.println("4-Cerrar sesión");
		System.out.println("Ingrese una opcion");
		int opcion = sc.nextInt();
		return opcion;
	}
	
	public int OpcionesDeMenu ()
	{
		System.out.println("1-Mostrar articulos");
		System.out.println("2-Agregar articulo");
		System.out.println("3-modificar articulo");
		System.out.println("4-Eliminar articulo");
		System.out.println("5-Cerrar sesion");
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
				
				int cantidad = la.GetListadoArticulos().size();
				Articulo art = CrearArticulo(cantidad+1);
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
