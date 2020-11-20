package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

public class AdministrarRolTest {
	private ServicioUsuario servicioUsuario;
	private RepositorioUsuario repositorioUsuarioMock;
	
	@Before
	public void init() {
		repositorioUsuarioMock = mock(RepositorioUsuario.class);
 	
		
	}
	
	@Test
	public void testDeQueSeLeCambieElRolAUnUsuario() {
		Usuario usuario = new Usuario();
		
		usuario.setRol("usuario");
		usuario.setId(1L);
		
		Long idUsuario = usuario.getId();
	
		String usuarioRol = usuario.getRol();
		
		assertThat(usuarioRol).isEqualTo("usuario");
		
//		servicioUsuario.setRepositorioUsuario(repositorioUsuarioMock);
//		when(repositorioUsuarioMock.obtenerUsuarioPorId(1L)).thenReturn(usuario);
		//persistir usuario
		
		servicioUsuario.cambiarRol(idUsuario, "admin");
		
		String usuarioRolCambiado = usuario.getRol();
		
		assertThat(usuarioRolCambiado).isEqualTo("admin");
	}
}
