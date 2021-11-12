package br.org.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@Entity anotação informa que se trata de uma classe entidade, ou seja que formará a tabela no banco de dados
//@Table nomeia a tabela

@Entity
@Table(name = "tb_tema")
public class Tema {
	
	//@Id anotação para informar que trata-se de uma primary key
	//GeneratedValue informa que sera valor de auto incremento
	//(strategy = GenerationType.IDENTITY) informa tipo de auto-incremento ex: numeros
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@NotNull informa aos spring que não pode ser um valor nulo
	//@Size informa a quantidade minima e/ou maxima de caracteres.
	
	@NotNull(message = "O atributo descrição é um item obrigatório")
	@Size(min = 3, max = 200)
	private String descricao;
	
	//@OneToMany informa relação de tabelas de um para muitos, ex: uma marca para varios produtos (FK)
	//@JsonIgnoreProperties anotação evita um looping infinito
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;
	
	// Métodos Get e Set

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	

}
