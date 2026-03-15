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

    //Consultation de tous les produits
    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    // Mise à jour de la quantité en stock
    public void updateQuantity(Integer id, int quantity){
        Product p = productRepository.findById(id).orElse(null);
        if(p != null){
            p.setQuantity(quantity);
            productRepository.save(p);
        } else {
            System.out.println("Ce produit n'existe pas");
        }
    }

    // Calcul du nombre de produits ayant une quantité faible (ex : quantité ≤ 5)
    public int countLowStockProducts(){
        List<Product> products = productRepository.findAll();
        int nb = 0;
        for (Product product : products){
            if(product.getQuantity() <= 5){
                nb++;
            }
        }
        return nb;
    }




}
