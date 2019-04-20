package cn.shuangze.assetsms.entity;

import java.io.Serializable;
/**
 * 资产信息类
 */
public class ItemType implements Serializable{
    private int assetsID;
    private String name;
    private int typeID;
    private String model;
    private String price;
    private String buyDate;
    private String status;
    private String other;

    public ItemType(int assetsID) {
        this.assetsID = assetsID;
    }   
    
    public ItemType(String name, int typeID, String model, String price, String buyDate, String status, String other) {
        this.name = name;
        this.typeID = typeID;
        this.model = model;
        this.price = price;
        this.buyDate = buyDate;
        this.status = status;
        this.other = other;
    } 
    
    public ItemType(int assetsID, String name, int typeID, String model, String price, String buyDate, String status, String other) {
        this.assetsID = assetsID;
        this.name = name;
        this.typeID = typeID;
        this.model = model;
        this.price = price;
        this.buyDate = buyDate;
        this.status = status;
        this.other = other;
    }

    public int getAssetsID() {
        return assetsID;
    }

    public void setAssetsID(int assetsID) {
        this.assetsID = assetsID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
    
    @Override
    public String toString() {
        return "资产编号：" + assetsID + ", 资产名称：" +name + ", 所属类型：" + typeID +"型号：" + model + ", 价格：" +price + ", 购买日期：" + buyDate + ", 状态：" +status + ", 备注：" + other;
    }   
}
