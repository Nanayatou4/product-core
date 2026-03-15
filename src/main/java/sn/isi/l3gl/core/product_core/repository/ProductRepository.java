package sn.isi.l3gl.core.product_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.l3gl.core.product_core.entite.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}