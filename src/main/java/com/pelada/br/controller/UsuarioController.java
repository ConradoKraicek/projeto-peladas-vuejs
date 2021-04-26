package com.pelada.br.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pelada.br.model.Usuario;
import com.pelada.br.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listaUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario listaUsuarioUnico(@PathVariable(value="id") Integer id){
		return usuarioRepository.findById(id).get();
	}
	
	@PostMapping
	public Usuario salvaUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping
	public Usuario atualizaUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping
	public void deletaUsuario(@RequestBody @Valid Usuario usuario) {
		usuarioRepository.delete(usuario);
	}


}
