package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.SeguirCategoria;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioSeguirCategoria {

	public void seguirCategoria(Usuario usuario, Categoria categoria);

	public SeguirCategoria buscarSeguirCategoriaPorUsuarioYCategoria(Usuario seguidor, Categoria categoriaSeguida);

	public void dejarSeguirCategoria(Usuario seguidor, Categoria categoriaSeguida);

	public List<SeguirCategoria> devolverListaDeSeguidores(Categoria juegosOVarios);

	List<SeguirCategoria> devolverListaDeSeguirCategoriasPorUsuario(Usuario usuario);

}
