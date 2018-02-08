package com.example.usuario.inventoryprovider.data.provider.dao;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.example.usuario.inventoryprovider.InventoryApplication;
import com.example.usuario.inventoryprovider.data.base.DependencyDao;
import com.example.usuario.inventoryprovider.data.db.InventoryContract;
import com.example.usuario.inventoryprovider.data.db.model.Dependency;
import com.example.usuario.inventoryprovider.data.provider.InventoryProvider;
import com.example.usuario.inventoryprovider.data.provider.InventoryProviderContract;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public class DependencyDaoImp implements DependencyDao{
    private ArrayList<Dependency> dependencies;
    @Override
    public ArrayList<Dependency> loadAll() {
        dependencies = new ArrayList<>();
        String [] projection = InventoryProviderContract.Dependency.PROJECTION;

        //El content provider esta registrado en el sistema
        ContentResolver cr7 =InventoryApplication.getContext().getContentResolver();
        Cursor cursor = cr7.query(InventoryProviderContract.Dependency.CONTENR_URI,projection,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                dependencies.add(new Dependency(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            }while (cursor.moveToNext());
        }

        return dependencies;
    }

    @Override
    public long add(Dependency dependency) {
        ContentResolver cr7 =InventoryApplication.getContext().getContentResolver();
        ContentValues values = new ContentValues();

        values.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        values.put(InventoryContract.DependencyEntry.COLUMN_SORTNAME, dependency.getShortname());
        values.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        values.put(InventoryContract.DependencyEntry.COLUMN_IMAGE, dependency.getImage());

        Uri uri = cr7.insert(InventoryProviderContract.Dependency.CONTENR_URI,values);
        if(uri == null)
            return -1;

        return Long.parseLong(uri.getLastPathSegment());


    }

    @Override
    public int update(Dependency dependency) {
        ContentResolver cr7 =InventoryApplication.getContext().getContentResolver();
        ContentValues values = new ContentValues();

        values.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        String selection=InventoryProviderContract.Dependency._ID+"=?";
        String arguments[] = new String[]{String.valueOf(dependency.get_ID())};
        Uri uri = InventoryProviderContract.Dependency.CONTENR_URI;


        return cr7.update(uri,values,selection,arguments);
    }

    @Override
    public int delete(Dependency dependency) {
        ContentResolver cr7 =InventoryApplication.getContext().getContentResolver();
        String selection=InventoryProviderContract.Dependency._ID+"=?";
        String arguments[] = new String[]{String.valueOf(dependency.get_ID())};
        Uri uri = InventoryProviderContract.Dependency.CONTENR_URI;
        return cr7.delete(uri,selection,arguments);
    }

    @Override
    public boolean exists(String name, String sortname) {
        return false;
    }
}
