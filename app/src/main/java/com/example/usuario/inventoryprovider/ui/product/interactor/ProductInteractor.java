package com.example.usuario.inventoryprovider.ui.product.interactor;

import com.example.usuario.inventoryprovider.data.db.model.Product;
import com.example.usuario.inventoryprovider.data.db.model.ProductView;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public interface ProductInteractor {
    void loadProducts();
    void loadProduct(Product product);

    interface OnLoadFinish{
        void onSuccess(ArrayList<Product> products);
        void onSuccess(ProductView productView);
    }
}
