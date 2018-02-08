package com.example.usuario.inventoryprovider.ui.product;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jaime.inventorydb.R;
import com.example.usuario.inventoryprovider.ui.product.fragment.ListProductFragment;
import com.example.usuario.inventoryprovider.ui.product.fragment.ProductFragment;

/**
 * Clase que muestra la activity de Product.
 */
public class ProductActivity extends AppCompatActivity implements ListProductFragment.ListProductListener {
    private ListProductFragment listProductFragment;
    private ProductFragment productFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        listProductFragment = (ListProductFragment) getSupportFragmentManager().findFragmentByTag(ListProductFragment.TAG);
        if(listProductFragment == null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            listProductFragment = ListProductFragment.newInstance(null);
            fragmentTransaction.add(android.R.id.content,listProductFragment,ListProductFragment.TAG).commit();
        }
    }


    @Override
    public void goProduct(Bundle bundle) {
        productFragment = (ProductFragment) getSupportFragmentManager().findFragmentByTag(ProductFragment.TAG);

        if(productFragment == null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            productFragment = ProductFragment.getInstance(bundle);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(android.R.id.content,productFragment,ProductFragment.TAG).commit();
        }
    }
}
