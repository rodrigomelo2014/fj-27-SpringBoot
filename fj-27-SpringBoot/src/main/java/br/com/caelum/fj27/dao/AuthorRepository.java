package br.com.caelum.fj27.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.caelum.fj27.model.Author;


@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{
}
