package com.LuisaLocacao.repository;

import org.springframework.data.repository.CrudRepository;

import com.LuisaLocacao.models.Carro;
/**
 * Interface utilizada para fazer uma sobrescrita de m�todo do CrudRepository para a classe Carro.
 * 
 * @author Widson.
 * @version 1.0.
 */
public interface CarroRepository extends CrudRepository<Carro, String>{
	Carro findByCodigo(long codigo);

}