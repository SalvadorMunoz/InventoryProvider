package com.example.usuario.inventoryprovider.data.db.repository;

import com.example.usuario.inventoryprovider.data.db.model.Product;
import com.example.usuario.inventoryprovider.data.db.model.ProductView;
import com.example.usuario.inventoryprovider.data.db.repository.dao.ProductDao;

import java.util.ArrayList;

/**
 * Clase repositorio que contiene todos los datos de Product.
 */

public class ProductRepository {
    private ProductDao productDao;
    private static ProductRepository instance;

    private ProductRepository() {
        productDao = new ProductDao();
    }

    public static ProductRepository getInstance(){
        if(instance == null)
            instance = new ProductRepository();
        return instance;
    }
    public ArrayList<Product> getProducts(){
        return productDao.loadProducts();
    }

    public ProductView loadProduct(Product product){
        return productDao.loadProduct(product.get_id());
    }
}
