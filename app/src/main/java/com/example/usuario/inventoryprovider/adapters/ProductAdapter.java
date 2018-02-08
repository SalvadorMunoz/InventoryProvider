package com.example.usuario.inventoryprovider.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jaime.inventorydb.R;
import com.example.usuario.inventoryprovider.data.db.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductAdapter extends ArrayAdapter<Product> {
    public ProductAdapter(@NonNull Context context) {
        super(context, R.layout.item_product,new ArrayList<Product>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ProductHolder holder = new ProductHolder();

        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_product, null);

            holder.txvName = (TextView) view.findViewById(R.id.txv_item_product);

            view.setTag(holder);
        }else{
            holder = (ProductHolder) view.getTag();
        }

        holder.txvName.setText(getItem(position).getSortname());

        return view;
    }

    private class ProductHolder{
        TextView txvName;
    }
}
