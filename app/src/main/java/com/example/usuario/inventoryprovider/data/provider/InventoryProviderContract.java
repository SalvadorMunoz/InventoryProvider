package com.example.usuario.inventoryprovider.data.provider;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.usuario.inventoryprovider.data.db.InventoryContract;

import java.util.HashMap;

/**
 * Created by usuario on 5/02/18.
 */

public final class InventoryProviderContract {
    public static final String AUTHORITY = "com.example.usuario.inventoryprovider";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    private InventoryProviderContract() {

    }

    public static class Dependency implements BaseColumns {
        public static final String CONTENT_PATH = "dependency";
        public static final Uri CONTENR_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final String NAME = "name";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";
        public static final String IMAGE = "imageName";

        public static final String[] PROJECTION = new String[]{
                _ID, NAME, SORTNAME, DESCRIPTION, IMAGE
        };
    }

    public static class Sector implements BaseColumns {
        public static final String CONTENT_PATH = "sector";
        public static final Uri CONTENR_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final String DEPENDENCY_ID = "dependencyId";
        public static final String NAME = "name";
        public static final String SORTNAME = "sortName";
        public static final String DESCRIPTION = "description";
        public static final String ENABLE = "isEnable";
        public static final String SECTOR_DEFAULT = "isSectorDeafault";

        public static final String[] PROJECTION = new String[]{
                _ID, DEPENDENCY_ID, NAME, SORTNAME, DESCRIPTION,
                ENABLE, SECTOR_DEFAULT
        };
    }

    public static class Product implements BaseColumns {
        public static final String CONTENT_PATH = "product";
        public static final Uri CONTENR_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final String SERIAL = "serial";
        public static final String MODELCODE = "modelCode";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";
        public static final String CATEGORY = "category";
        public static final String CATEGORYNAME = "categoryName";
        public static final String SUBCATEGORY = "subcategory";
        public static final String SUBCATEGORYNAME = "subcategoryName";
        public static final String PRODUCTCLASS = "productClass";
        public static final String PRODUCTCLASSDESCRIPTION = "productClassDescription";
        public static final String SECTOR = "sector";
        public static final String SECTORNAME = "sectorName";
        public static final String QUANTITY = "quantity";
        public static final String VALUE = "value";
        public static final String VENDOR = "vendor";
        public static final String BITMAP = "bitmap";
        public static final String IMAGENAME = "imageName";
        public static final String URL = "url";
        public static final String DATEPURCHASE = "datePurchase";
        public static final String NOTES = "notes";

        public static final String[] PROJECTION = new String[]{
                _ID, SERIAL, MODELCODE, SORTNAME, DESCRIPTION, CATEGORY, CATEGORYNAME,
                SUBCATEGORY, SUBCATEGORYNAME, PRODUCTCLASS, PRODUCTCLASSDESCRIPTION, SECTOR, SECTORNAME, QUANTITY, VALUE, VENDOR,
                BITMAP, IMAGENAME, URL, DATEPURCHASE, NOTES
        };


        public static HashMap<String,String> sProductInnerProjectMap;
        static {
            sProductInnerProjectMap = new HashMap<>();
            sProductInnerProjectMap.put(BaseColumns._ID, InventoryContract.ProductEntry.TABLE_NAME+"."+ InventoryContract.ProductEntry._ID);
            sProductInnerProjectMap.put(SERIAL, InventoryContract.ProductEntry.COLUMN_SERIAL);
            sProductInnerProjectMap.put(MODELCODE, InventoryContract.ProductEntry.COLUMN_MODELCODE);
            sProductInnerProjectMap.put(SORTNAME, InventoryContract.ProductInnerEntry.TABLE_NAME + "." + InventoryContract.ProductInnerEntry.COLUMN_SORTNAME);
            sProductInnerProjectMap.put(DESCRIPTION, InventoryContract.ProductInnerEntry.TABLE_NAME + "." + InventoryContract.ProductInnerEntry.COLUMN_DESCRIPTION);
            sProductInnerProjectMap.put(CATEGORY, InventoryContract.CategoryEntry.TABLE_NAME + "." + InventoryContract.CategoryEntry._ID);
            sProductInnerProjectMap.put(CATEGORYNAME, InventoryContract.CategoryEntry.TABLE_NAME + "." + InventoryContract.CategoryEntry.COLUMN_NAME);
            sProductInnerProjectMap.put(SUBCATEGORY, InventoryContract.SubcategoryEntry.TABLE_NAME + "." + InventoryContract.SubcategoryEntry._ID);
            sProductInnerProjectMap.put(SUBCATEGORYNAME, InventoryContract.SubcategoryEntry.TABLE_NAME + "." + InventoryContract.SubcategoryEntry.COLUMN_NAME);
            sProductInnerProjectMap.put(PRODUCTCLASS, InventoryContract.ProductClassEntry.TABLE_NAME + "." + InventoryContract.ProductClassEntry._ID);
            sProductInnerProjectMap.put(PRODUCTCLASSDESCRIPTION, InventoryContract.ProductClassEntry.TABLE_NAME + "." + InventoryContract.ProductClassEntry.COLUMN_DESCRIPTION);
            sProductInnerProjectMap.put(SECTOR, InventoryContract.SectorEntry.TABLE_NAME + "." + InventoryContract.SectorEntry._ID);
            sProductInnerProjectMap.put(SECTORNAME, InventoryContract.SectorEntry.TABLE_NAME + "." + InventoryContract.SectorEntry.COLUMN_NAME);
            sProductInnerProjectMap.put(QUANTITY, InventoryContract.ProductEntry.COLUMN_QUANTITY);
            sProductInnerProjectMap.put(VALUE, InventoryContract.ProductEntry.COLUMN_VALUE);
            sProductInnerProjectMap.put(VENDOR, InventoryContract.ProductEntry.COLUMN_VENDOR);
            sProductInnerProjectMap.put(BITMAP, InventoryContract.ProductEntry.COLUMN_BITMAP);
            sProductInnerProjectMap.put(IMAGENAME, InventoryContract.ProductEntry.COLUMN_IMAGENAME);
            sProductInnerProjectMap.put(URL, InventoryContract.ProductEntry.COLUMN_URL);
            sProductInnerProjectMap.put(DATEPURCHASE, InventoryContract.ProductEntry.COLUMN_DATEPURCHASE);
            sProductInnerProjectMap.put(NOTES, InventoryContract.ProductEntry.COLUMN_NOTES);

        }
    }

    public static class Category implements BaseColumns {
        public static final String CONTENT_PATH = "category";
        public static final Uri CONTENR_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final String SERIAL = "serial";
        public static final String NAME = "name";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";

        public static final String[] PROJECTION = new String[]{
                _ID, NAME, SORTNAME, DESCRIPTION
        };
    }

    public static class Subcategory implements BaseColumns {
        public static final String CONTENT_PATH = "subcategory";
        public static final Uri CONTENR_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final String NAME = "name";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";

        public static final String[] PROJECTION = new String[]{
                _ID, NAME, SORTNAME, DESCRIPTION
        };

    }

    public static class ProductClass implements BaseColumns {
        public static final String CONTENT_PATH = "productclass";
        public static final Uri CONTENR_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final String DESCRIPTION = "description";

        public static final String[] ALL_COLUMN = new String[] {
                _ID, DESCRIPTION
        };
    }

}
