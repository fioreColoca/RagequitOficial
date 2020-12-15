package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.SeguirCategoria;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioSeguirCategoria {

	void seguirCategoria(Usuario usuario, Categoria categoria);

	SeguirCategoria buscarSeguirCategoriaPorUsuarioYCategoria(Usuario usuario, Categoria categoria);

	void dejarDeSeguirCategoria(Usuario usuarioLogeado, Categoria categoriaADejarDeSeguir);

	List<Usuario> devolverListaDeSeguidores(Categoria juegosOVarios);

}
