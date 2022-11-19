package models;

public class Articulo {
	
	private int idArticulo;
	private double precio;
	private String nombre;
	private String descripcion;
	
	
	public Articulo(int idArticulo,double precio, String nombre, String descripcion) {
		this.precio = precio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.idArticulo = idArticulo;
	}
	
	
	public int getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
