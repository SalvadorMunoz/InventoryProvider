package com.example.usuario.inventoryprovider.ui.product.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jaime.inventorydb.R;
import com.example.usuario.inventoryprovider.data.db.model.Product;
import com.example.usuario.inventoryprovider.data.db.model.ProductView;
import com.example.usuario.inventoryprovider.ui.product.contract.ProductContract;
import com.example.usuario.inventoryprovider.ui.product.presenter.ProductPresenterImp;

public class ProductFragment extends Fragment implements ProductContract.ViewProduct {
    public static  final String TAG = "product";
    private TextView type,category,subcategory;
    private ProductContract.ProductPresenter presenter;

    public  static ProductFragment getInstance(Bundle bundle){
        ProductFragment productFragment = new ProductFragment();

        if(bundle != null)
            productFragment.setArguments(bundle);

        return productFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product,container,false);

        category = (TextView) view.findViewById(R.id.txv_product_category_entry);
        type = (TextView) view.findViewById(R.id.txv_product_type);
        subcategory = (TextView) view.findViewById(R.id.txv_product_subcategory);
        presenter = new ProductPresenterImp(this);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Product tmp = null;
        if(getArguments()!=null)
            tmp = getArguments().getParcelable("product");
        presenter.loadProduct(tmp);
    }

    @Override
    public void showProduct(ProductView viewProduct) {
        category.setText(viewProduct.getCategoryName());
        Toast.makeText(getContext(),"Categoria: "+viewProduct.getCategoryName()+"   Subcategoria: "+viewProduct.getSubcategoryName()
                +"  Tipo: "+viewProduct.getProductClassDescription(),Toast.LENGTH_LONG).show();
        subcategory.setText(viewProduct.getSubcategoryName());
        type.setText(viewProduct.getProductClassDescription());
    }
}
