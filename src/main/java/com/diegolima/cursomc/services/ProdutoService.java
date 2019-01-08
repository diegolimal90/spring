package com.diegolima.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.diegolima.cursomc.domain.Categoria;
import com.diegolima.cursomc.domain.Pedido;
import com.diegolima.cursomc.domain.Produto;
import com.diegolima.cursomc.repositories.CategoriaRepository;
import com.diegolima.cursomc.repositories.ProdutoRepository;
import com.diegolima.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	public Produto find(Integer id) {
		Produto obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
					+ ", Tipo: " + Pedido.class.getName());
		}
		return obj;
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepo.findAll(ids);
		
		return repo.search(nome, categorias, pageRequest);		
	}
}