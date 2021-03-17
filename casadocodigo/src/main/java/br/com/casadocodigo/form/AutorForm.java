package br.com.casadocodigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.casadocodigo.model.Autor;

public class AutorForm {
	
	@NotBlank
	private String nome;
	@NotBlank @Email 
	private String email;
	@NotBlank @Size(max = 400)
	private String descricao;
	
	public AutorForm(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}	
	
	public Autor toModel() {
		return new Autor(nome, email, descricao);
	}
	
	public String getEmail() {
		return this.email;
	}

}
