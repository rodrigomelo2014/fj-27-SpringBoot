package br.com.caelum.fj27;

import br.com.caelum.fj27.dao.AuthorRepository;
import br.com.caelum.fj27.dao.LoginRepository;
import br.com.caelum.fj27.dao.ProductRepository;
import br.com.caelum.fj27.dao.RoleRepository;
import br.com.caelum.fj27.model.*;
import br.com.caelum.fj27.utils.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static br.com.caelum.fj27.model.BookType.*;
import static java.util.Arrays.asList;

@SpringBootApplication
@EnableCaching
public class Boot {

	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}


	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private RoleRepository roleRepository;

	@PostConstruct
	public void postConstruct(){

        createUsersAndRoles();

        for (int i = 0; i < 20; i++) {
            createProducts(withAuthors());
        }



    }

    private void createUsersAndRoles() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleBuyer = new Role("ROLE_BUYER");

        roleRepository.save(asList(roleAdmin, roleBuyer));


        User admin = new User("admin@casadocodigo.com.br", Password.of("123456"), roleAdmin);
        User comprador = new User("comprador@gmail.com", Password.of("123456"), roleBuyer);

        loginRepository.save(asList(admin, comprador));

    }

    private void createProducts(List<Author> authors) {


        Author fernando = authors.get(0);
        Author alberto = authors.get(1);

        Price ebook15 = new Price(EBOOK, new BigDecimal("15"));
        Price printed20 = new Price(PRINTED, new BigDecimal("20"));
        Price combo30 = new Price(COMBO, new BigDecimal("30"));

        List<Price> prices = asList( ebook15, printed20, combo30 );


        Product jpa = new Product("JPA", "JPA in action", 120, LocalDate.now(), "JPA-Summary.pdf", asList(alberto), prices);
        Product spring = new Product("Spring", "Spring in Action", 300, LocalDate.now(), "Spring-Summary.pdf", authors, prices);
        Product springCloud = new Product("Spring Cloud", "Spring Cloud in Action", 300, LocalDate.now(), "Spring-Cloud-Summary.pdf", asList(fernando), prices);

        List<Product> products = asList(jpa, spring, springCloud);

        productRepository.save(products);
    }

    private List<Author> withAuthors() {

        Author fernando = new Author("Fernando");
        Author alberto = new Author("Alberto");

        List<Author> authors = asList(fernando, alberto);

        authorRepository.save(authors);

        return authors;
    }
    
    @Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("/WEB-INF/messages");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1);
		return bundle;
	}

}
