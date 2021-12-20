package com.LuisaLocacao.repository;

import org.springframework.data.repository.CrudRepository;

import com.LuisaLocacao.models.Funcionario;

/**
 * Interface utilizada para fazer uma sobrescrita de m�todo do CrudRepository para a classe Funcionario.
 * 
 * @author Widson.
 * @version 1.0.
 */
public interface FuncionarioRepository extends CrudRepository<Funcionario, String>{
	Funcionario findByCodigo(long codigo);

}
