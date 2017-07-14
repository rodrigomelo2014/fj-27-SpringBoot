package br.com.caelum.fj27.controller;

import br.com.caelum.fj27.dao.AuthorRepository;
import br.com.caelum.fj27.dao.ProductRepository;
import br.com.caelum.fj27.model.BookType;
import br.com.caelum.fj27.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/products")
public class ProductController {

    private static Integer PAGE_SIZE = 10;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @GetMapping
    @Cacheable("allProducts")
    public ModelAndView list(@RequestParam("page") Optional<Integer> currentPage){

        ModelAndView view = new ModelAndView("products/list");

        PageRequest pageRequest = new PageRequest(currentPage.orElse(0), PAGE_SIZE);

        view.addObject("pageable", productRepository.findAll(pageRequest));

        return view;

    }
    @GetMapping("form")
    public ModelAndView form(Product product){
        ModelAndView view = new ModelAndView("products/form");

        view.addObject("bookTypes", BookType.values());
        view.addObject("authors", authorRepository.findAll());

        return view;
    }

    @PostMapping
    @CacheEvict(value = "allProducts", allEntries = true)
    public ModelAndView save(MultipartFile summary, @Valid Product product, BindingResult result){

        if (result.hasErrors()) return form(product);

        String filename = summary.getOriginalFilename();

        product.setSummaryPath(filename);

        productRepository.save(product);

        return new ModelAndView("redirect:/products");
    }
}
