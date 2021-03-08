package br.com.orange.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.orange.casadocodigo.validacao.UniqueValue;


public class CriaAutorRequest {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class,fieldName = "email")
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public CriaAutorRequest(@NotBlank String nome,
			@NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome,this.email,this.descricao);
	}

	public String getEmail() {
		return this.email;
	}

}