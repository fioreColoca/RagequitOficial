package ar.edu.unlam.tallerweb1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorComentario;
import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.ComentarioTipo;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentar;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;

public class ComentarioTest {

	private ControladorComentario comentarioControlador = new ControladorComentario();
	private Comentario comentario;
	private ServicioComentar servicioComentario;
	private HttpServletRequest requestMock;
	private HttpSession sessionMock;
	private String tipoComentario;
	private Publicacion publicacion;
	private ServicioPublicacion servicioPublicacion;
	
	
	@Before
	public void init() {
		comentario = mock(Comentario.class);
		servicioComentario = mock(ServicioComentar.class);
		requestMock = mock(HttpServletRequest.class);
		sessionMock = mock(HttpSession.class);
		when(requestMock.getSession()).thenReturn(sessionMock);
		publicacion = mock(Publicacion.class);
		servicioPublicacion = mock(ServicioPublicacion.class);
	}

	
	@Test
	public void testEnviarComentario() {
		
		when(comentario.getId()).thenReturn(1L);
		when(comentario.getMensaje()).thenReturn("hola");
		
		comentarioControlador.setServicioComentario(servicioComentario);
		comentarioControlador.setServicioPublicacion(servicioPublicacion);
		
		ModelAndView modelAndView = comentarioControlador.enviarComentario(comentario ,requestMock);	
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home"); 

	}
	
	@Test 
	public void testNoEnviarMensajeVacio() {
		when(comentario.getId()).thenReturn(1L);
		when(comentario.getMensaje()).thenReturn(" ");
		
		comentarioControlador.setServicioComentario(servicioComentario);
		comentarioControlador.setServicioPublicacion(servicioPublicacion);
		
		ModelAndView modelAndView = comentarioControlador.enviarComentario(comentario, requestMock);	
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home?errorComentario=mensaje vacio"); 
	}
	
}
