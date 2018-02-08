package com.example.usuario.inventoryprovider.ui.product.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.jaime.inventorydb.R;
import com.example.usuario.inventoryprovider.adapters.ProductAdapter;
import com.example.usuario.inventoryprovider.data.db.model.Product;
import com.example.usuario.inventoryprovider.ui.product.contract.ProductContract;
import com.example.usuario.inventoryprovider.ui.product.presenter.ProductPresenterImp;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListProductFragment extends ListFragment implements ProductContract.ViewListProduct{
    public static final String TAG ="listProduct";
    private static  ListProductFragment instance;
    private ProductAdapter adapter;
    private ProductPresenterImp presenter;
    private ListProductListener callback;

    public interface ListProductListener{
        void goProduct (Bundle bundle);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callback = (ListProductListener) activity;
    }

    public static ListProductFragment newInstance(Bundle bundle){
        instance = new ListProductFragment();

        if(bundle != null)
            instance.setArguments(bundle);

        return instance;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_product, container, false);

        adapter = new ProductAdapter(getContext());
        presenter = new ProductPresenterImp(this);


        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setAdapter(adapter);

        presenter.LoadProducts();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) parent.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable("product",product);
                callback.goProduct(bundle);
            }
        });

    }

    @Override
    public void fillProducts(ArrayList<Product> products) {
        adapter.clear();
        adapter.addAll(products);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDestroy();
    }
}
