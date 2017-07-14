package br.com.caelum.fj27.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.caelum.fj27.model.User;


@Repository
public interface LoginRepository extends CrudRepository<User, Long>, UserDetailsService {


    @Override
    @Query("select u from User u where u.username = :username")
    UserDetails loadUserByUsername(@Param("username") String username) throws UsernameNotFoundException;

}
