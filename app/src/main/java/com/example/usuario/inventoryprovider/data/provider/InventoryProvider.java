package com.example.usuario.inventoryprovider.data.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.usuario.inventoryprovider.data.db.InventoryContract;
import com.example.usuario.inventoryprovider.data.db.model.InventoryOpenHelper;

/**
 * Created by usuario on 5/02/18.
 */

public class InventoryProvider extends ContentProvider {
    private static  final  int PRODUCT=1;
    private static  final  int PRODUCT_ID=2;
    private static  final  int DEPENDECY=3;
    private static  final  int DEPENDENCY_ID=4;
    private static  final  int SECTOR=5;
    private static  final  int SECTOR_ID=6;
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private SQLiteDatabase sqLiteDatabase;
    static {
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY,InventoryProviderContract.Product.CONTENT_PATH,PRODUCT);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY,InventoryProviderContract.Product.CONTENT_PATH+"/#",PRODUCT_ID);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY,InventoryProviderContract.Dependency.CONTENT_PATH,DEPENDECY);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY,InventoryProviderContract.Dependency.CONTENT_PATH+"/#",DEPENDENCY_ID);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY,InventoryProviderContract.Sector.CONTENT_PATH,SECTOR);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY,InventoryProviderContract.Sector.CONTENT_PATH+"/#",SECTOR_ID);


    }

    @Override
    public boolean onCreate() {
        sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor = null;

        switch (uriMatcher.match(uri)){
            case PRODUCT:
                break;
            case PRODUCT_ID:
                break;
            case DEPENDECY:
                cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);

                break;
            case DEPENDENCY_ID:
                break;
            case SECTOR:
                break;
            case SECTOR_ID:
                break;
            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid uri "+uri);
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long r=-1;


        switch (uriMatcher.match(uri)){
            case PRODUCT:
                break;

            case DEPENDECY:
                r  = sqLiteDatabase.insert(InventoryContract.DependencyEntry.TABLE_NAME,null,values);

                break;

            case SECTOR:
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid uri "+uri);
        }
        return Uri.parse(InventoryProviderContract.AUTHORITY+InventoryProviderContract.Dependency.CONTENR_URI+"/"+r);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int r = -1;
        switch (uriMatcher.match(uri)){
            case PRODUCT:
                break;

            case DEPENDECY:
                r = sqLiteDatabase.delete(InventoryContract.DependencyEntry.TABLE_NAME,selection,selectionArgs);

                break;

            case SECTOR:
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid uri "+uri);
        }

        return r;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int r = -1;
        switch (uriMatcher.match(uri)){
            case PRODUCT:
                break;

            case DEPENDECY:
                r = sqLiteDatabase.update(InventoryContract.DependencyEntry.TABLE_NAME,values,selection,selectionArgs);

                break;

            case SECTOR:
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid uri "+uri);
        }

        return r;    }
}
