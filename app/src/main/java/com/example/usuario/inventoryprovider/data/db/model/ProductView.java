package com.example.usuario.inventoryprovider.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 2/02/18.
 */

public class ProductView   implements  Parcelable{
    private  String  categoryName;
    private String subcategoryName;
    private String productClassDescription;
    private String sectorName;
    private int _id;
    private String serial;
    private String modelCode;
    private String sortname;
    private String description;
    private int category;
    private int subcategory;
    private int productClass;
    private int sector;
    private int quantity;
    private double value;
    private String vendor;
    private String bitmap;
    private String imageName;
    private String url;
    private String datePurchase;
    private String note;

    public ProductView(int _id, String serial, String modelCode, String sortname, String description, int category,String categoryName, int subcategory,String subcategoryName, int productClass,String productClassDescription, int sector,String sectorName, int quantity, double value, String vendor, String bitmap, String imageName, String url, String datePurchase, String note) {
        this._id = _id;
        this.serial = serial;
        this.modelCode = modelCode;
        this.sortname = sortname;
        this.description = description;
        this.category = category;
        this.subcategory = subcategory;
        this.productClass = productClass;
        this.sector = sector;
        this.quantity = quantity;
        this.value = value;
        this.vendor = vendor;
        this.bitmap = bitmap;
        this.imageName = imageName;
        this.url = url;
        this.datePurchase = datePurchase;
        this.note = note;
        this.categoryName = categoryName;
        this.subcategoryName = subcategoryName;
        this.productClassDescription = productClassDescription;
        this.sectorName = sectorName;
    }


    protected ProductView(Parcel in) {
        categoryName = in.readString();
        subcategoryName = in.readString();
        productClassDescription = in.readString();
        sectorName = in.readString();
        _id = in.readInt();
        serial = in.readString();
        modelCode = in.readString();
        sortname = in.readString();
        description = in.readString();
        category = in.readInt();
        subcategory = in.readInt();
        productClass = in.readInt();
        sector = in.readInt();
        quantity = in.readInt();
        value = in.readDouble();
        vendor = in.readString();
        bitmap = in.readString();
        imageName = in.readString();
        url = in.readString();
        datePurchase = in.readString();
        note = in.readString();
    }

    public static final Creator<ProductView> CREATOR = new Creator<ProductView>() {
        @Override
        public ProductView createFromParcel(Parcel in) {
            return new ProductView(in);
        }

        @Override
        public ProductView[] newArray(int size) {
            return new ProductView[size];
        }
    };

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(int subcategory) {
        this.subcategory = subcategory;
    }

    public int getProductClass() {
        return productClass;
    }

    public void setProductClass(int productClass) {
        this.productClass = productClass;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBitmap() {
        return bitmap;
    }

    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public String getProductClassDescription() {
        return productClassDescription;
    }

    public void setProductClassDescription(String productClassDescription) {
        this.productClassDescription = productClassDescription;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categoryName);
        dest.writeString(subcategoryName);
        dest.writeString(productClassDescription);
        dest.writeString(sectorName);
        dest.writeInt(_id);
        dest.writeString(serial);
        dest.writeString(modelCode);
        dest.writeString(sortname);
        dest.writeString(description);
        dest.writeInt(category);
        dest.writeInt(subcategory);
        dest.writeInt(productClass);
        dest.writeInt(sector);
        dest.writeInt(quantity);
        dest.writeDouble(value);
        dest.writeString(vendor);
        dest.writeString(bitmap);
        dest.writeString(imageName);
        dest.writeString(url);
        dest.writeString(datePurchase);
        dest.writeString(note);
    }
}
