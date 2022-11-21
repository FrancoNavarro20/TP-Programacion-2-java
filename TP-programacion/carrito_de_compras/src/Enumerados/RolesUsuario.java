package Enumerados;

public enum RolesUsuario {
	Cliente(1),
	Empleado(2);
	
	private final int rol;
	
	private RolesUsuario(int rol)
	{
		this.rol = rol; 
	}

	public int getRol() {
		return rol;
	}
	
}

