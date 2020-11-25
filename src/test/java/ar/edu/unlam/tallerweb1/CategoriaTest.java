package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorCategoria;
import ar.edu.unlam.tallerweb1.controladores.ControladorPublicacion;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;

public class CategoriaTest {
	private ControladorCategoria controladorCategoria = new ControladorCategoria();
	private ServicioCategoria servicioCategoriaMock;
	private Categoria categoriaMock; 
	private RepositorioCategoria repositorioCategoriaMock;
	private HttpServletRequest requestMock;
	private HttpSession sessionMock;
	
	@Before
	public void init() {
		servicioCategoriaMock = mock(ServicioCategoria.class);
		categoriaMock = mock(Categoria.class);
		repositorioCategoriaMock = mock(RepositorioCategoria.class);
		requestMock = mock(HttpServletRequest.class);
		sessionMock = mock(HttpSession.class);
		when(requestMock.getSession()).thenReturn(sessionMock);
	}
	
	@Test
	public void testDeCrearCategoria() {	
		
		when(categoriaMock.getNombre()).thenReturn("WoW");
		when(categoriaMock.getTipoCategoriaNum()).thenReturn(0);
		
		/*ModelAndView modelAndView = controladorCategoria.agregarCategoria(categoriaMock, requestMock);*/
		ModelAndView modelAndView = controladorCategoria.agregarCategoria(categoriaMock, requestMock);
		
		
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/biblioteca");
	}
	
	@Test
	public void testDeQueSiUnaCategoriaNoTieneNombreTiraError() {	
		
		when(categoriaMock.getNombre()).thenReturn("");
		when(categoriaMock.getTipoCategoriaNum()).thenReturn(0);
		
		
		ModelAndView modelAndView = controladorCategoria.agregarCategoria(categoriaMock, requestMock);
		
		
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home?errorNombre=Falta elegir nombre&errorTipo=null");
	}
	
	@Test
	public void testDeQueSiUnaCategoriaNoTieneTipoTiraError() {	
		
		when(categoriaMock.getNombre()).thenReturn("No vacio");
		when(categoriaMock.getTipoCategoriaNum()).thenReturn(null);
		
		
		ModelAndView modelAndView = controladorCategoria.agregarCategoria(categoriaMock, requestMock);
		
		
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home?errorNombre=null&errorTipo=Falta elegir tipo");
	}
}
