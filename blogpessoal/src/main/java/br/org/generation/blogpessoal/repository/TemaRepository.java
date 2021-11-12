package br.org.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Tema;

/*@Repository Indica ao spring que sera a nossa Interface repository ou seja, 
fara  a comunicação com o banco de dados atraves dos métodos padrão
ou consultas de metodos personalizados que representam as instruções passadas
pelo mysql
*/

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{
	
	/*Método personalizado equivalente a:
	 *select * from tb_tema where tema like %tema% 
	 *
	 * */
	
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	

}
