package br.com.orange.casadocodigo.cidadeEstado;

import javax.validation.constraints.NotBlank;

import br.com.orange.casadocodigo.validacao.UniqueValue;

public class CriaPaisRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	
	
	public CriaPaisRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}


	public @NotBlank String getNome() {
		
		return nome;
	}

}
