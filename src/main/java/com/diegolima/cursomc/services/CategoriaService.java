package com.diegolima.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolima.cursomc.domain.Categoria;
import com.diegolima.cursomc.repositories.CategoriaRepository;
<<<<<<< HEAD
import com.diegolima.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
					+ ", Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
=======

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		return obj;
	}

>>>>>>> branch 'master' of https://github.com/diegolimal90/spring.git
}
