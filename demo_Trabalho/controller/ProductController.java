package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Product;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/products")
public class ProductController {


    private final List<Product> products = new ArrayList<>();

    private Integer nexId =1;

    @GetMapping
    public List<Product> getALLProducts(){
        return products;
    }

    @PostMapping
    public Product addProduct (@RequestBody Product product) {
        product.setId((int) nexId++);
        products.add(product);
        return product;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product updateProduct) {
        for (Product product : products){
            if (product.getId().equals(id)){
                product.setName(updateProduct.getName());
                return product;

            }
        }
        return null;
    } 
    
    
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        for (Product product : products) { 
            if (product.getId().equals(id)) { 
                products.remove(product); 
                return "Produto removido com sucesso"; 
            }
        }
        return "Produto não encontrado"; 
    }
}
