package com.pelada.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pelada.br.model.Pelada;

@Repository
public interface PeladaRepository extends JpaRepository<Pelada, Integer>{
	

}
