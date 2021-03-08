package br.com.orange.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class LivroController {

	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/livros")
	@Transactional
	public String criaLivro(@RequestBody @Valid CriaLivroRequest request) {
		
		Livro novoLivro = request.toModel(manager);
		manager.persist(novoLivro);
		return novoLivro.toString();
	}
}
