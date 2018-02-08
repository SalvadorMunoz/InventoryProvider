package com.example.usuario.inventoryprovider.data.db.repository.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.usuario.inventoryprovider.data.db.InventoryContract;
import com.example.usuario.inventoryprovider.data.db.model.InventoryOpenHelper;
import com.example.usuario.inventoryprovider.data.db.model.Product;
import com.example.usuario.inventoryprovider.data.db.model.ProductView;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDao {
    public ArrayList<Product> loadProducts(){
        ArrayList<Product> tmp = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();

        Cursor cursor = sqLiteDatabase.query(InventoryContract.ProductEntry.TABLE_NAME,InventoryContract.ProductEntry.ALL_COLUMNS,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                tmp.add(new Product(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                        cursor.getString(4),cursor.getInt(5),cursor.getInt(6),cursor.getInt(7),cursor.getInt(8),cursor.getInt(9),
                        cursor.getDouble(10),cursor.getString(11),cursor.getString(12),cursor.getString(13),cursor.getString(14),cursor.getString(15),cursor.getString(16)));

            }while(cursor.moveToNext());
        }

        InventoryOpenHelper.getInstance().closeDatabase();
        return tmp;
    }

    public ProductView loadProduct(int id){
        ProductView product = null;
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();

        sqLiteQueryBuilder.setTables(InventoryContract.ProductInnerEntry.PRODUCT_INNER);
        sqLiteQueryBuilder.setProjectionMap(InventoryContract.ProductInnerEntry.sProductInnerProjectMap);
        //sqLiteQueryBuilder.appendWhere();
        //1 mostramos si es correcta la consulta
        String sql = sqLiteQueryBuilder.buildQuery(InventoryContract.ProductInnerEntry.ALL_COLUMNS, null,null,null,null,null);
        Log.e("consulta huevona",sql);
        String selection = InventoryContract.ProductInnerEntry.TABLE_NAME+"."+ BaseColumns._ID+"=?";
        String []args ={String.valueOf(id)};

        Cursor cursor = sqLiteQueryBuilder.query(sqLiteDatabase,InventoryContract.ProductInnerEntry.ALL_COLUMNS,selection,args,null,null,null);

        if(cursor.moveToFirst()){
            do{
                product = new ProductView(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),
                        cursor.getInt(5),cursor.getString(6),cursor.getInt(7),cursor.getString(8),cursor.getInt(9),cursor.getString(10),
                        cursor.getInt(11),cursor.getString(12),cursor.getInt(13),
                        cursor.getDouble(14), cursor.getString(15), cursor.getString(16),
                        cursor.getString(17), cursor.getString(18), cursor.getString(19),
                        cursor.getString(20));
            }while (cursor.moveToNext());
        }
        InventoryOpenHelper.getInstance().closeDatabase();
        return product;
    }
}
