package br.com.orange.casadocodigo.cidadeEstado;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CriaEstadoController {

	@Autowired
	private EntityManager manager;

	@PostMapping(value = "/estados")
	@Transactional
	public String cria(@RequestBody @Valid CriaEstadoRequest request) {
		Estado novoEstado = request.toModel(manager);
		manager.persist(novoEstado);

		return novoEstado.toString();
	}
}
