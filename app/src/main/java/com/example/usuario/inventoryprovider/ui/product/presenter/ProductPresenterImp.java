package com.example.usuario.inventoryprovider.ui.product.presenter;

import com.example.usuario.inventoryprovider.data.db.model.Product;
import com.example.usuario.inventoryprovider.data.db.model.ProductView;
import com.example.usuario.inventoryprovider.ui.product.contract.ProductContract;
import com.example.usuario.inventoryprovider.ui.product.interactor.ProductInteractor;
import com.example.usuario.inventoryprovider.ui.product.interactor.ProductInteractorImp;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductPresenterImp implements ProductContract.ProductPresenter,ProductInteractor.OnLoadFinish {
    private  ProductContract.ViewListProduct view;
    private ProductContract.ViewProduct productview;
    private ProductInteractorImp interactor;

    public ProductPresenterImp(ProductContract.ViewListProduct view) {
        this.view = view;
        this.interactor = new ProductInteractorImp(this);
    }

    public ProductPresenterImp(ProductContract.ViewProduct productview){
        this.productview = productview;
        this.interactor = new ProductInteractorImp(this);

    }

    @Override
    public void LoadProducts() {
        interactor.loadProducts();
    }

    @Override
    public void loadProduct(Product product) {
        interactor.loadProduct(product);

    }

    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }

    @Override
    public void onSuccess(ArrayList<Product> products) {
        view.fillProducts(products);
    }

    @Override
    public void onSuccess(ProductView productView) {
        productview.showProduct(productView);
    }
}
