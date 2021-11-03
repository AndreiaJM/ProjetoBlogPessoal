package br.org.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.model.Postagem;
import br.org.generation.blogpessoal.repository.PostagemRepository;

@RestController //Indica que a classe sera uma controller, reponsavel por responder as requisições http
@RequestMapping("/postagens")// Anotação para definir endereço endpoint da URI que a controller responderá
@CrossOrigin(origins = "*", allowedHeaders = "*")// Anotação que permite requisições de qualquer origem
public class PostagemController {
	
		//@Autowired Injeção de dependência, permite a instanciação de classes, neste caso a Interface Repository
		//ou seja quando necessario é criado um objeto desta classe o que permite o uso dos metodos
		// personalizados ou padrão da classe injetada
	
		@Autowired 
		private PostagemRepository postagemRepository;
	
		//Listar todas as postagens
		//ResponseEntity indica que respondera uma request HTTP, neste caso, 200=ok
		//@getmapping Indica que respondera as requisições do tipo Get cumpridas no endpoint
		//List postagem, indica que retornara uma lista com os objetos do tipo postagem
		//linha 38 return executa o metodo findAll, metodo padrão da Inface injetada (JPA repository que foi extendida na interface)
		
		@GetMapping
		public ResponseEntity<java.util.List<Postagem>> getAll(){ //= select * from tb_postagem;
			return ResponseEntity.ok(postagemRepository.findAll());
	}
		
		//Listar por Id
		//Indica que o metodo repondera as requisições do tipo GET
		//Parametro @pathVariable indica o id a ser inserido na url endpoint
		
		@GetMapping("/{id}")
		public ResponseEntity<Postagem> getById(@PathVariable long id){
			return postagemRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))// resposta caso a request seja encontrada
				.orElse(ResponseEntity.notFound().build());// resposta caso a request não seja encontrada
				// = select * from tb_postagem where id=1
		}
			
		//Listar por titulo
		//Indica que o metodo respondera a request do tipo Get
		//("/titulo{titulo}") subcaminho pois o spring não endende o parametro{}, logo iria dar duplicidade de método
		//RespondeEntity = resposta da request html
		//@PathVariable insere o parametro titulo no endpoint da url
		//metodo findAllByTitulo que foi criado na repository, sera ultilizado e neste caso buscando o paramentro 
		//inserido na url como titulo
		
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
			return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
		}	
			
		//Editar uma postagem
		//Indica que trata-se de um metodo no tipo Post
		
		@PostMapping 
		public ResponseEntity<Postagem> postPostagem(@RequestBody Postagem postagem){
			return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
		}
		
		//Editar uma postagem
		//
		@PutMapping
		public ResponseEntity<Postagem> putPostagem(@RequestBody Postagem postagem){
			return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
		}
		
		@DeleteMapping("/{id}")
		public void deletePostagem(@PathVariable long id)
		{
			postagemRepository.deleteById(id);
		}
		
		
		
}
