package ar.edu.unlam.tallerweb1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import ar.edu.unlam.tallerweb1.controladores.ControladorBiblioteca;
import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioBiblioteca;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;

public class BibliotecaTest extends SpringTest {

	private ControladorBiblioteca controladorBiblioteca = new ControladorBiblioteca();
	private Categoria categoria;
	private Biblioteca biblioteca;
	private ServicioBiblioteca servicioBiblioteca;
	private ServicioCategoria servicioCategoria;
	private HttpServletRequest requestMock;
	private HttpSession sessionMock;

	@Before
	public void init() {
		categoria = mock(Categoria.class);
		biblioteca = mock(Biblioteca.class);
		servicioBiblioteca = mock(ServicioBiblioteca.class);
		servicioCategoria = mock(ServicioCategoria.class);
		requestMock = mock(HttpServletRequest.class);
		sessionMock = mock(HttpSession.class);
		when(requestMock.getSession()).thenReturn(sessionMock);

	}

	@Test
	public void testQueSeGuardeUnaCategoria() {

//		controladorBiblioteca.setServicioBiblioteca(servicioBiblioteca);
//		controladorBiblioteca.setServicioCategoria(servicioCategoria);
//		
//		categoria.setId(1L);
//		categoria.setNombre("asd");
//		categoria.setTipoCategoria(CategoriaTipo.JUEGOS);
//		
//		servicioCategoria.guardarCategoria(categoria);
//		Categoria categoria2 = servicioCategoria.mostrarCategoriaPorId(1L);
//		
//		assertThat(categoria2.getId()).isEqualTo(1L);

	}

}
