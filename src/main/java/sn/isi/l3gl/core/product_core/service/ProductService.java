package sn.isi.l3gl.core.product_core.service;

import org.hibernate.Length;
import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.product_core.entite.Product;
import sn.isi.l3gl.core.product_core.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //Ajout d’un produit dans l’inventaire
    public Product createProduct(Product product){
        return productRepository.save(product);
    }





}
