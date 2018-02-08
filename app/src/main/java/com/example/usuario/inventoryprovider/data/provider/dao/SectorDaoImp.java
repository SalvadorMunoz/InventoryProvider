package com.example.usuario.inventoryprovider.data.provider.dao;

import android.content.ContentResolver;
import android.database.Cursor;

import com.example.usuario.inventoryprovider.InventoryApplication;
import com.example.usuario.inventoryprovider.data.base.SectorDao;
import com.example.usuario.inventoryprovider.data.db.model.Dependency;
import com.example.usuario.inventoryprovider.data.db.model.Sector;
import com.example.usuario.inventoryprovider.data.provider.InventoryProviderContract;

import java.util.ArrayList;

/**
 * Created by usuario on 8/02/18.
 */

public class SectorDaoImp implements SectorDao {
    private ArrayList<Sector> sectors;
    @Override
    public ArrayList<Sector> loadAll() {
        sectors = new ArrayList<>();
        String [] projection = InventoryProviderContract.Sector.PROJECTION;

        //El content provider esta registrado en el sistema
        ContentResolver cr7 = InventoryApplication.getContext().getContentResolver();
        Cursor cursor = cr7.query(InventoryProviderContract.Sector.CONTENR_URI,projection,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                if(cursor.getInt(5) == 0){

                }
                //sectors.add(new Sector(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)));
                /*sectors.add(new Sector(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3)
                , cursor.getString(4), cursor.getInt(5),cursor.getInt(6)));*/
            }while (cursor.moveToNext());
        }

        return sectors;
    }

}
