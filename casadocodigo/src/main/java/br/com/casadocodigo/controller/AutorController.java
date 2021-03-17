package br.com.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.form.AutorForm;
import br.com.casadocodigo.model.Autor;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@PersistenceContext
	private EntityManager entityManager;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorForm autorForm) {
		Autor autor = autorForm.toModel();
		entityManager.persist(autor);

		return ResponseEntity.ok().build();
	}

}
