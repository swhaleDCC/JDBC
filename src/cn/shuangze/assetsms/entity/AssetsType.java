package cn.shuangze.assetsms.entity;

import java.io.Serializable;
import java.util.Objects;
/**
 * 资产类别类
 */
public class AssetsType implements Serializable{
    int creatureno;
    private String chinaname;
    private String latinname;
    private String category;
    private String feature;
    private String distributed;
    private String literature;
    private String remarks;

    public AssetsType(String chinaname, String latinname, String category, String feature, String distributed, String literature, String remarks) {
        this.chinaname = chinaname;
        this.latinname = latinname;
        this.category = category;
        this.feature = feature;
        this.distributed = distributed;
        this.literature = literature;
        this.remarks = remarks;
    }

    public AssetsType(int creatureno, String chinaname, String latinname, String category, String feature, String distributed, String literature, String remarks) {
        this.creatureno = creatureno;
        this.chinaname = chinaname;
        this.latinname = latinname;
        this.category = category;
        this.feature = feature;
        this.distributed = distributed;
        this.literature = literature;
        this.remarks = remarks;
    }

    public int getCreatureno() {
        return creatureno;
    }

    public void setCreatureno(int creatureno) {
        this.creatureno = creatureno;
    }

    public String getChinaname() {
        return chinaname;
    }

    public void setChinaname(String chinaname) {
        this.chinaname = chinaname;
    }

    public String getLatinname() {
        return latinname;
    }

    public void setLatinname(String latinname) {
        this.latinname = latinname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getDistributed() {
        return distributed;
    }

    public void setDistributed(String distributed) {
        this.distributed = distributed;
    }

    public String getLiterature() {
        return literature;
    }

    public void setLiterature(String literature) {
        this.literature = literature;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "AssetsType{" + "creatureno=" + creatureno + ", chinaname=" + chinaname + ", latinname=" + latinname + ", category=" + category + ", feature=" + feature + ", distributed=" + distributed + ", literature=" + literature + ", remarks=" + remarks + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.creatureno;
        hash = 71 * hash + Objects.hashCode(this.chinaname);
        hash = 71 * hash + Objects.hashCode(this.latinname);
        hash = 71 * hash + Objects.hashCode(this.category);
        hash = 71 * hash + Objects.hashCode(this.feature);
        hash = 71 * hash + Objects.hashCode(this.distributed);
        hash = 71 * hash + Objects.hashCode(this.literature);
        hash = 71 * hash + Objects.hashCode(this.remarks);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AssetsType other = (AssetsType) obj;
        if (this.creatureno != other.creatureno) {
            return false;
        }
        if (!Objects.equals(this.chinaname, other.chinaname)) {
            return false;
        }
        if (!Objects.equals(this.latinname, other.latinname)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.feature, other.feature)) {
            return false;
        }
        if (!Objects.equals(this.distributed, other.distributed)) {
            return false;
        }
        if (!Objects.equals(this.literature, other.literature)) {
            return false;
        }
        if (!Objects.equals(this.remarks, other.remarks)) {
            return false;
        }
        return true;
    }

    
}
