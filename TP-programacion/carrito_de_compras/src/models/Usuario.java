package models;
import java.util.Scanner;
import Interfaces.UsuariosService;
import contenedores.ListadoUsuarios;

public class Usuario implements UsuariosService{

	private int idUsuario;
	private String nombreUsuario;
	private String contraseniaUsuario;
	private int rolUsuario;
	private Scanner sc;
	
	//Constructor con parametros
	public Usuario(int idUsuario, String nombreUsuario, 
			String contraseniaUsuario, int rolUsuario) 
	{
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contraseniaUsuario = contraseniaUsuario;
		this.rolUsuario = rolUsuario;
		this.sc = new Scanner(System.in);
	}
	
	/*Constructor con parametros
	public Usuario(int idUsuario, String nombreUsuario, 
		String contraseniaUsuario, int rolUsuario) 
	{
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contraseniaUsuario = contraseniaUsuario;
		this.sc = new Scanner(System.in);
	}
	*/
	
	
	//Constructor sin parametros
	public Usuario() {
		this.sc = new Scanner(System.in);
	}
	
	
	//Setter and getters 
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseniaUsuario() {
		return contraseniaUsuario;
	}
	public void setContraseniaUsuario(String contraseniaUsuario) {
		this.contraseniaUsuario = contraseniaUsuario;
	}
	
	public int getRolUsuario() {
		return rolUsuario;
	}
	public void setRolUsuario(int rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	@Override
	public Usuario Registrarse(int idUsuario) {
		
		try {
			System.out.println("Ingrese el correo electronico como nombre de usuario:");
			String nUsuario = sc.next();
			
			System.out.println("Ingrese una contraseña:");
			String nContrasenia = sc.next();
			
			System.out.println("Preste atencion en esta parte!!");
			System.out.println("Ingrese 0 para tener el rol de cliente ");
			System.out.println("Ingrese 1 para tener el rol de empleado ");
			int rol = sc.nextInt();
			while(rol != 0 && rol != 1)
			{
				System.out.println("Error- re-ingrese el rol 0 o 1 : ");
				rol = sc.nextInt();
			}
			
			//Por defecto rol usuario cliente = 0
			//Despues el administrador lo pasara a rol usuario Empleado = 1
			return new Usuario(idUsuario,nUsuario,nContrasenia,rol);
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public int Login(ListadoUsuarios lu, String username, String password) {
		
		int retorno = -1;
		
		try {
			System.out.println(username + " " + password);
			for (Usuario usuario : lu.GetListaUsuarios()) {
				if(usuario.getNombreUsuario().toLowerCase().equals(username) && usuario.getContraseniaUsuario().toLowerCase().equals(password)) {
					System.out.println(usuario.getIdUsuario() + " " + usuario.getContraseniaUsuario());
					retorno = usuario.getRolUsuario();
				}
				else {
					System.out.println("No se encontro !!");
					retorno = -1;
				}
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ha ocurrido una excepcion en el metodo login.");
			retorno = -1;
		}
		
		return retorno;		
	}

	@Override
	public void ManualUso() {
		System.out.println("Bienvenido... Ingrese un correo electronico como nombre de usuario y una contraseña");
		System.out.println("para poder registrar su usuario dentro del sistema");	
	}

	@Override
	public int getRolUsuarioLogueado() {
		// TODO Auto-generated method stub
		return this.getRolUsuario();
		
	}
	
	
}
