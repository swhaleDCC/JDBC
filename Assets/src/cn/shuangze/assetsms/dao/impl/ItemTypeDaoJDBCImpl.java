package cn.shuangze.assetsms.dao.impl;

import cn.shuangze.assetsms.dao.*;
import cn.shuangze.assetsms.entity.*;
import java.util.List;
import static cn.shuangze.assetsms.dao.DBUtil.exceuteUpdate;
import static cn.shuangze.assetsms.dao.DBUtil.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * 实现接口ItemTypeDao的方法---增删改查
 */
public class ItemTypeDaoJDBCImpl implements ItemTypeDao {
    TrjnTypeDaoJDBCImpl trjn=new TrjnTypeDaoJDBCImpl();

    @Override
    public int add(ItemType itemType) throws Exception {
        String sql = "insert into assets(name,TypeID,Model,Price,BuyDate,Status,Other) values(?,?,?,?,?,?,?)";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{itemType.getName(),itemType.getTypeID(), itemType.getModel(),itemType.getPrice(), itemType.getBuyDate(),itemType.getStatus(), itemType.getOther()});
        }
    }
    
    @Override
    public int delete(int id) throws Exception {
        String sql = "delete from assets where assetsID=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Integer[]{id});
        }
    }

    @Override
    public int modify(ItemType itemType) throws Exception {
        String sql = "update assets set name=?,TypeID=?,Model=?,Price=?,BuyDate=?,Status=?,Other=? where assetsID=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{itemType.getName(),itemType.getTypeID(), itemType.getModel(),itemType.getPrice(), itemType.getBuyDate(),itemType.getStatus(), itemType.getOther(),itemType.getAssetsID()});
        }
    }

    @Override
    public String[][] findAssetsID(int id) throws Exception {
        String sql = "select * from assets where assetsID=?";
        List<ItemType> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new ItemType(rs.getInt("assetsID"),rs.getString("name"),rs.getInt("TypeID"),rs.getString("Model"), rs.getString("Price"), rs.getString("BuyDate"),rs.getString("Status"), rs.getString("Other")));
                }
                String[][] sn = null;
                int size = list.size();
                if (!list.isEmpty()) {
                    sn = new String[list.size()][8];
                }
                for (int i = 0; i < size; i++) {
                    sn[i][0] = Integer.toString(list.get(i).getAssetsID());
                    sn[i][1] = list.get(i).getName();
                    sn[i][3] = list.get(i).getModel();
                    sn[i][2] = Integer.toString(list.get(i).getTypeID());
                    sn[i][4] = list.get(i).getPrice();
                    sn[i][5] = list.get(i).getBuyDate();
                    sn[i][6] = list.get(i).getStatus();
                    sn[i][7] = list.get(i).getOther();
                }
                return sn;
            }
        }
    }
    @Override
    public ItemType findAssetsItem(int id) throws Exception {
        String sql = "select * from assets where assetsID=?";
        ItemType list=null;
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list=new ItemType(rs.getInt("assetsID"),rs.getString("name"),rs.getInt("TypeID"),rs.getString("Model"), rs.getString("Price"), rs.getString("BuyDate"),rs.getString("Status"), rs.getString("Other"));
                }
                return list;
            }
        }
    }

    @Override
    public String[][] findAll() throws Exception {
        String sql = "select * from assets";
        List<ItemType> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(new ItemType(rs.getInt("assetsID"),rs.getString("name"),rs.getInt("TypeID"),rs.getString("Model"), rs.getString("Price"), rs.getString("BuyDate"),rs.getString("Status"), rs.getString("Other")));
            }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][8];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getAssetsID());
            sn[i][1] = list.get(i).getName();
            sn[i][3] = list.get(i).getModel();
            sn[i][2] = Integer.toString(list.get(i).getTypeID());
            sn[i][4] = list.get(i).getPrice();
            sn[i][5] = list.get(i).getBuyDate();
            sn[i][6] = list.get(i).getStatus();
            sn[i][7] = list.get(i).getOther();
        }
        return sn;
    }
    
    @Override
    public List findAllID() throws Exception {
        String sql = "select * from assets";
        List list = new ArrayList();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(rs.getInt("assetsID"));
            }
        }
        return list;
    }

    @Override
    public int[] findAllIDs() throws Exception {
        String sql = "select * from assets";
        List list = new ArrayList();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(rs.getInt("AssetsID"));
            }
        }
        int[] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new int[list.size()];
        }
        for (int i = 0; i < size; i++) {
            sn[i] = (int) (list.get(i));
        }
        return sn;
    }
            
    @Override
    public int[] findNoUsingID() throws Exception {
        List allList = findAllID();//所有资产
        List usingList=trjn.findID();//已使用资产
        
        int[] sn = null;
        
        for (int i = 0; i < usingList.size(); i++) {
            if(allList.contains(usingList.get(i))){
                allList.remove(usingList.get(i));
            }
        }
        sn=new int[allList.size()];
        for (int i = 0; i < allList.size(); i++) {
            sn[i] = (int) (allList.get(i));
        }
        return sn;
    }   
    
    @Override
    public String[][] findNoUsingItem() throws Exception {
        String sql = "select * from assets where assetsID=?";
        List<ItemType> list = new ArrayList<>();
        
        int[] id=findNoUsingID();
        String[][] sn = null;
        
        for(int i=0;i<id.length;i++){
            try (Connection conn = DBUtil.getConnection();
                    PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, id[i]);
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        list.add(new ItemType(rs.getInt("assetsID"),rs.getString("name"),rs.getInt("TypeID"),rs.getString("Model"), rs.getString("Price"), rs.getString("BuyDate"),rs.getString("Status"), rs.getString("Other")));
                    }
                }
            }
        }
        if (!list.isEmpty()) {
            sn = new String[list.size()][8];
        }
        for (int i = 0; i < list.size(); i++) {
            sn[i][0] = Integer.toString(list.get(i).getAssetsID());
            sn[i][1] = list.get(i).getName();
            sn[i][2] = Integer.toString(list.get(i).getTypeID());
            sn[i][3] = list.get(i).getModel();
            sn[i][4] = list.get(i).getPrice();
            sn[i][5] = list.get(i).getBuyDate();
            sn[i][6] = list.get(i).getStatus();
            sn[i][7] = list.get(i).getOther();
        }
        return sn;
    }
    
    @Override
    public String[][] findUsingItem() throws Exception {
        List usingList=trjn.findID();//已使用资产编号
        int[] id=new int[usingList.size()];
        for (int i = 0; i < usingList.size(); i++) {
            id[i] = (int) (usingList.get(i));
        }
        String sql = "select * from assets where assetsID=?";
        List<ItemType> list = new ArrayList<>();
        String[][] sn = null;
        for(int i=0;i<id.length;i++){
            try (Connection conn = DBUtil.getConnection();
                    PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, id[i]);
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        list.add(new ItemType(rs.getInt("assetsID"),rs.getString("name"),rs.getInt("TypeID"),rs.getString("Model"), rs.getString("Price"), rs.getString("BuyDate"),rs.getString("Status"), rs.getString("Other")));
                    }
                }
            }
        }
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][8];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getAssetsID());
            sn[i][1] = list.get(i).getName();
            sn[i][2] = Integer.toString(list.get(i).getTypeID());
            sn[i][3] = list.get(i).getModel();
            sn[i][4] = list.get(i).getPrice();
            sn[i][5] = list.get(i).getBuyDate();
            sn[i][6] = list.get(i).getStatus();
            sn[i][7] = list.get(i).getOther();
        }
        return sn;
    }
    
    //状态为已借出的
    @Override
    public String[][] findUsing() throws Exception {
        String sql = "select * from assets where Status=?";
        List<ItemType> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1,"领用");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new ItemType(rs.getInt("assetsID"),rs.getString("name"),rs.getInt("TypeID"),rs.getString("Model"), rs.getString("Price"), rs.getString("BuyDate"),rs.getString("Status"), rs.getString("Other")));
                }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][8];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getAssetsID());
            sn[i][1] = list.get(i).getName();
            sn[i][2] = Integer.toString(list.get(i).getTypeID());
            sn[i][3] = list.get(i).getModel();
            sn[i][4] = list.get(i).getPrice();
            sn[i][5] = list.get(i).getBuyDate();
            sn[i][6] = list.get(i).getStatus();
            sn[i][7] = list.get(i).getOther();
        }
        return sn;
    }
    }
    //状态为可用的
    @Override
    public String[][] findBack() throws Exception {
        String sql = "select * from assets where Status=?";
        List<ItemType> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1,"可用");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new ItemType(rs.getInt("assetsID"),rs.getString("name"),rs.getInt("TypeID"),rs.getString("Model"), rs.getString("Price"), rs.getString("BuyDate"),"可用", rs.getString("Other")));
                }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][8];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getAssetsID());
            sn[i][1] = list.get(i).getName();
            sn[i][2] = Integer.toString(list.get(i).getTypeID());
            sn[i][3] = list.get(i).getModel();
            sn[i][4] = list.get(i).getPrice();
            sn[i][5] = list.get(i).getBuyDate();
            sn[i][6] = list.get(i).getStatus();
            sn[i][7] = list.get(i).getOther();
        }
        return sn;
    }
    }
    public int[] findBackID() throws Exception {
        String sql = "select * from assets where Status=?";
        List list = new ArrayList();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1,"可用");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(rs.getInt("assetsID"));
                }
        }
        int[] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new int[list.size()];
        }
        for (int i = 0; i < size; i++) {
            sn[i] = (int) list.get(i);
        }
        return sn;
    }
    }

}
