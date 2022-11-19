package contenedores;
import java.util.ArrayList;
import models.Usuario;

public class ListadoUsuarios implements Contenedor<Usuario> {
	
	protected ArrayList<Usuario> _listUsuarios;
	
	public ListadoUsuarios() {
		this._listUsuarios = new ArrayList<Usuario>();
	}
	
	public ArrayList<Usuario> GetListaUsuarios(){	
		return this._listUsuarios;
	}

	
	public void MostrarListadoUsuario() {
		System.out.println("Id  |  Nombre  |  Password  |   Rol ");
		for (Usuario usuario : this._listUsuarios) {
			System.out.println(usuario.getIdUsuario() + "  " + usuario.getNombreUsuario() + "  " 
					+ usuario.getContraseniaUsuario() + " " +  usuario.getRolUsuarioLogueado());
		}
	}
	
	@Override
	public boolean agregar(Usuario usuario) {
		// TODO Auto-generated method stub
		try {
			boolean state = this._listUsuarios.add(usuario);
			return state;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Usuario buscar(int clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(Usuario clave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Usuario clave) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
