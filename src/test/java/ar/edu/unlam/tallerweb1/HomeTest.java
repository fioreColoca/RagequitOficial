package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.controladores.ControladorPublicacion;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;

public class HomeTest {
	private ControladorPublicacion controladorPublicacion = new ControladorPublicacion();
	private Publicacion publicacionMock;
	private ServicioCategoria servicioCategoriaMock;
	private ServicioPublicacion servicioPublicacionMock;
	private Categoria categoriaMock; 
	private RepositorioCategoria repositorioCategoriaMock;
	private HttpServletRequest requestMock;
	private HttpSession sessionMock;
	
	@Before
	public void init() {
		publicacionMock = mock(Publicacion.class);
		servicioCategoriaMock = mock(ServicioCategoria.class);
		categoriaMock = mock(Categoria.class);
		repositorioCategoriaMock = mock(RepositorioCategoria.class);
		servicioPublicacionMock = mock(ServicioPublicacion.class);
		requestMock = mock(HttpServletRequest.class);
		sessionMock = mock(HttpSession.class);
		when(requestMock.getSession()).thenReturn(sessionMock);
	}
	
	@Test
	public void testDeQueSiUnaPublicacionNoTieneCategoriaTiraError() {	
		
		when(publicacionMock.getCategoriaId()).thenReturn(-1L);
		when(publicacionMock.getMensaje()).thenReturn("No vacio");
		
		ModelAndView modelAndView = controladorPublicacion.guardarPublicacion(publicacionMock, requestMock);
		
		
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home?errorMensaje=null&errorCategoria=Falta elegir categoria");
	}
	
	@Test
	public void testDeQueSiUnaPublicacionNoTieneMensajeTiraError() {
	
		when(publicacionMock.getCategoriaId()).thenReturn(1L);
		when(servicioCategoriaMock.mostrarCategoriaPorId(1L)).thenReturn(categoriaMock);
		when(repositorioCategoriaMock.mostrarCategoriaPorId(1L)).thenReturn(categoriaMock);
		when(publicacionMock.getMensaje()).thenReturn("");
		
		controladorPublicacion.setServicioCategoria(servicioCategoriaMock);
		ModelAndView modelAndView = controladorPublicacion.guardarPublicacion(publicacionMock, requestMock);
		
		
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home?errorMensaje=La publicacion no puede tener un mensaje vacio&errorCategoria=null");
	}
	
	@Test
	public void testDeQueSiUnaPublicacionTieneMensajeYCategoriaNoTireError() {
		
		when(publicacionMock.getCategoriaId()).thenReturn(1L);
		when(servicioCategoriaMock.mostrarCategoriaPorId(1L)).thenReturn(categoriaMock);
		when(publicacionMock.getMensaje()).thenReturn("Mensaje");
		
		controladorPublicacion.setServicioCategoria(servicioCategoriaMock);
		controladorPublicacion.setServicioPublicacion(servicioPublicacionMock);
		ModelAndView modelAndView = controladorPublicacion.guardarPublicacion(publicacionMock, requestMock);
		
		
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home?errorMensaje=null&errorCategoria=null");
	}
}
