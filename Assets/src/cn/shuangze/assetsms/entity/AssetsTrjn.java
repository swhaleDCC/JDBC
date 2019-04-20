package cn.shuangze.assetsms.entity;

import java.io.Serializable;
/**
 * 资产信息操作类
 */
public class AssetsTrjn implements Serializable{
    private int jourNo;
    private String fromAcc;
    private int AssetsID;
    private String regDate;
    private int personID;
    private String purpose;
    private String other;

    public AssetsTrjn(String fromAcc, int AssetsID, String regDate, int personID, String purpose, String other) {
        this.fromAcc = fromAcc;
        this.AssetsID = AssetsID;
        this.regDate = regDate;
        this.personID = personID;
        this.purpose = purpose;
        this.other = other;
    }

    public AssetsTrjn(int jourNo, String fromAcc, int AssetsID, String regDate, int personID, String purpose, String other) {
        this.jourNo = jourNo;
        this.fromAcc = fromAcc;
        this.AssetsID = AssetsID;
        this.regDate = regDate;
        this.personID = personID;
        this.purpose = purpose;
        this.other = other;
    }

    public int getJourNo() {
        return jourNo;
    }

    public void setJourNo(int jourNo) {
        this.jourNo = jourNo;
    }

    public String getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(String fromAcc) {
        this.fromAcc = fromAcc;
    }

    public int getAssetsID() {
        return AssetsID;
    }

    public void setAssetsID(int AssetsID) {
        this.AssetsID = AssetsID;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
    
}
