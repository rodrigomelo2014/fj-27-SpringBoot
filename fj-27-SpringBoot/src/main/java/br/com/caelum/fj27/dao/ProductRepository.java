package br.com.caelum.fj27.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.caelum.fj27.model.Product;


@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{
}
