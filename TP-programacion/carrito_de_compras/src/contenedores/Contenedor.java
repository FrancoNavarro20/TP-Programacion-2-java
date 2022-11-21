package contenedores;

public interface Contenedor<T> {

	public boolean agregar(T v);
	public T buscar(int clave);
	public boolean existe(T clave);
	public boolean eliminar(T clave);
	
}
