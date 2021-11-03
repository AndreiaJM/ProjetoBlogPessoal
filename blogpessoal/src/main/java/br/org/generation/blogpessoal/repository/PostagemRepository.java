package br.org.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Postagem;

@Repository 
public interface PostagemRepository extends JpaRepository <Postagem, Long>{
	//@repository Indica ao spring que sera a nossa Interface repository ou seja, fara  acomunicação com o banco de dados atraves dos métodos padrão
	//ou consultas de metodos personalizados que representam as instruções passadas no SQL, ex: select, insert (metodos query)
	
	public List <Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	//List por que nos retornará uma lista com os objetos do tipo postagem(classe postagem(model)), 
	// equivalente a select * from tb_postagem where titulo like %titulo%
}