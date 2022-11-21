package Interfaces;
import contenedores.ListadoUsuarios;
import models.Usuario;

public interface UsuariosService {
	
	public void ManualUso();
	public Usuario Registrarse(int idUsuario);
	public int Login(ListadoUsuarios lu, String username, String password);
	public int getRolUsuarioLogueado();
	//public void MostrarListadoUsuario(ArrayList<Usuario> lu);
	
}
