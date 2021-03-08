package br.com.orange.casadocodigo.cidadeEstado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CriaPaisController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/paises")
	@Transactional
	public String criaPais(@RequestBody @Valid CriaPaisRequest request) {
		Pais novoPais = new Pais(request.getNome());
		manager.persist(novoPais);
		return novoPais.toString();
	}

}
