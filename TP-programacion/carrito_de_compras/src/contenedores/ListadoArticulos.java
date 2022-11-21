package contenedores;

import java.util.ArrayList;

import models.Articulo;

public class ListadoArticulos implements Contenedor<Articulo>{
	
	private ArrayList<Articulo> _listArticulos; 

	public ListadoArticulos() {
		this._listArticulos = new ArrayList<Articulo>();
	}
	
	public boolean MostrarListadoArticulos()
	{
		boolean retorno = false;
		try {
			
			if(this._listArticulos.size() > 0)
			{
				System.out.println("ID   -  PRECIO  -  NOMBRE  -  DESCRIPCION");
				for (Articulo articulo : _listArticulos) 
				{
					System.out.println(articulo.getIdArticulo()+ "-      "+articulo.getPrecio()+" - "+ articulo.getNombre()+ " - "+ articulo.getDescripcion());
				}
				retorno = true;
			}
			else 
			{
				retorno = false;
			}
			
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error al mostrar la lista de articulos.");
		}
		
		return retorno;
	}

	public ArrayList<Articulo> GetListadoArticulos()
	{
		return this._listArticulos;
	}
	
	@Override
	public boolean agregar(Articulo articulo) {
		boolean state = this._listArticulos.add(articulo);
		return (state == true) ? true : false;
	}

	@Override
	public boolean existe(Articulo clave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Articulo articulo) {
		// TODO Auto-generated method stub
		boolean state = this._listArticulos.remove(articulo);
		return (state == true) ? true : false;
	}

	@Override
	public Articulo buscar(int articuloId) {
		
		return _listArticulos.get(articuloId);
	}

}
