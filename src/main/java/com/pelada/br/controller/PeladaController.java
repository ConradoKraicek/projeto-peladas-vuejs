package com.pelada.br.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pelada.br.model.Pelada;
import com.pelada.br.repository.PeladaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/peladas")
public class PeladaController {
	
	@Autowired
	PeladaRepository peladaRepository;
	
	@GetMapping
	public List<Pelada> listaPeladas(){
		return peladaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Pelada listaPeladaUnico(@PathVariable(value="id") Integer id){
		return peladaRepository.findById(id).get();
	}
	
	@PostMapping
	public Pelada salvaPelada(@RequestBody @Valid Pelada pelada) {
		return peladaRepository.save(pelada);
	}
	
	@PutMapping
	public Pelada atualizaPelada(@RequestBody @Valid Pelada pelada) {
		return peladaRepository.save(pelada);
	}
	
	@DeleteMapping("/{id}")
	public void deletaPelada(@PathVariable(value="id") Integer id) {
		peladaRepository.deleteById(id);
	}

}
