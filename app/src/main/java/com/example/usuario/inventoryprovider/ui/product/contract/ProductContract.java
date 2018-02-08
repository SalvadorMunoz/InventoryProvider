package com.example.usuario.inventoryprovider.ui.product.contract;

import com.example.usuario.inventoryprovider.data.db.model.Product;
import com.example.usuario.inventoryprovider.data.db.model.ProductView;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public interface ProductContract {
    interface  ViewProduct{
        void showProduct(ProductView viewProduct);
    }
    interface ViewListProduct{
        void fillProducts(ArrayList<Product> products);
    }

    interface ProductPresenter{
        void LoadProducts();
        void loadProduct(Product product);
        void onDestroy();
    }


}
