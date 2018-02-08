package com.example.usuario.inventoryprovider.ui.product.interactor;

import com.example.usuario.inventoryprovider.data.db.model.Product;
import com.example.usuario.inventoryprovider.data.db.repository.ProductRepository;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductInteractorImp implements ProductInteractor {
    private OnLoadFinish onLoadFinish;

    public ProductInteractorImp(OnLoadFinish onLoadFinish) {
        this.onLoadFinish = onLoadFinish;
    }

    @Override
    public void loadProducts() {
        onLoadFinish.onSuccess(ProductRepository.getInstance().getProducts());
    }

    @Override
    public void loadProduct(Product product) {
        onLoadFinish.onSuccess(ProductRepository.getInstance().loadProduct(product));
    }
}
