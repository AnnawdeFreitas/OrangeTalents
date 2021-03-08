package br.com.orange.casadocodigo.cidadeEstado;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Estado {

	private @NotBlank String nome;
	private @NotNull @Valid Pais pais;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Deprecated
	public Estado() {
	}

	public Estado(@NotBlank String nome, @NotNull @Valid Pais pais) {

		this.nome = nome;
		this.pais = pais;

	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";

	}

	public boolean pertenceAoPais(Pais pais) {
		return this.pais.equals(pais);
	}

}
