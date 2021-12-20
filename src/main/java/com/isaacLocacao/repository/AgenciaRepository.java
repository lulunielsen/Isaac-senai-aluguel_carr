package com.isaacLocacao.repository;

import org.springframework.data.repository.CrudRepository;

import com.isaacLocacao.models.Agencia;

/**
 * Interface utilizada para fazer uma sobrescrita de método do CrudRepository para a classe Agencia.
 * 
 * @author Widson.
 * @version 1.0.
 */
public interface AgenciaRepository extends CrudRepository<Agencia, String>{
	Agencia findByCodigo(long codigo);

}
