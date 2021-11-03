package br.org.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity //Anotação informa ao spring que classe trata-se de uma entidade/model ou seja, tera os atributos para a nossa tabela
@Table(name = "tb_postagem") //Anotação informa ao spring que classe sera uma table, o parenteses da o nome
public class Postagem {
	
	
	@Id //Anotação informa ao spring que atributo sera a chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Anotação informa que sera uma valor de auto incremento parenteses informa que estrategia sera de sequencia numerica
	private long id;                                    
	
	@NotNull(message = "O atributo título é obrgatorio!") // Anotação informa que não pode ser valor um valor nulo, parenteses informa mensagem caso não seja dados um valor
	@Size(min=5, max=100, message="O atributo titulo deve conter no minimo 5 e no maximo 100 caracteres") //Anotação informa a quantidade minima e maxima de caracteres
	private String titulo;
	
	@NotNull(message = "O atributo título é obrigatório!")// Anotação informa que não pode ser um valor nulo e apresenta a menssagem caso esteja nulo
	@Size(min=10, max=1000, message="O atributo titulo deve conter no minimo 10 e no maximo 1000 caracteres")//Anotação informa a quantidade minima e maxima de caracteres
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP) //Anotação informa que sera do tipo data ou data e hora do sistema (Timestamp)
	private Date data = new java.sql.Date(System.currentTimeMillis());// System.currentTimeMillis()->insere os milissegundos na hora
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	//Metodos Get e Set
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	

}
