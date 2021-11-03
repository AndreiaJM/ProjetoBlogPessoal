package br.org.generation.meuprojeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.meuprojeto.model.estudos;

@Repository
public interface estudosRepository extends JpaRepository<estudos, Long>{
	
	public List<estudos> findAllByTituloContainingIgnoreCase(String titulo);

}
