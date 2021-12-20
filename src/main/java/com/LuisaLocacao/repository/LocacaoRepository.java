package com.LuisaLocacao.repository;


import org.springframework.data.repository.CrudRepository;

import com.LuisaLocacao.models.Locacao;

/**
 * Interface utilizada para fazer uma sobrescrita de método do CrudRepository para a classe Locacao.
 * 
 * @author Widson.
 * @version 1.0.
 */
public interface LocacaoRepository extends CrudRepository<Locacao, String>{
	Locacao findByCodigo(long codigo);
}
