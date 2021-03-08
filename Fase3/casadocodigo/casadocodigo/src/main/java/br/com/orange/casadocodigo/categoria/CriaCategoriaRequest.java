package br.com.orange.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.orange.casadocodigo.validacao.UniqueValue;

public class CriaCategoriaRequest {
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
