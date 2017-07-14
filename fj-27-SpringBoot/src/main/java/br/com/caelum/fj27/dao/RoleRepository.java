package br.com.caelum.fj27.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.caelum.fj27.model.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, String>{

}
