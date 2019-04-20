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
 * 实现接口AssetsTrjnDao的方法
 */
public class TrjnTypeDaoJDBCImpl implements TrjnTypeDao {

    @Override
    public int add(AssetsTrjn trjnType) throws Exception {
        String sql = "insert into assetstrjn(FromAcc,AssetsID,RegDate,PersonID,purpose,Other) values(?,?,?,?,?,?)";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{trjnType.getFromAcc(), trjnType.getAssetsID(),trjnType.getRegDate(),trjnType.getPersonID(),trjnType.getPurpose(),trjnType.getOther()});
        }
    }

    public List findID() throws Exception{
        String sql = "select * from assetstrjn";
        List list = new ArrayList();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(rs.getInt("AssetsID"));
            }
        }
        return list;
    }
    
    @Override
    public String[][] findAll() throws Exception {
        String sql = "select * from assetstrjn where FromAcc=?";
        List<AssetsTrjn> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1,"领用");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new AssetsTrjn(rs.getInt("jourNo"),rs.getString("FromAcc"),rs.getInt("AssetsID"),rs.getString("RegDate"), rs.getInt("PersonID"), rs.getString("purpose"),rs.getString("Other")));
                }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][7];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getJourNo());
            sn[i][1] = list.get(i).getFromAcc(); 
            sn[i][2] = Integer.toString(list.get(i).getAssetsID());
            sn[i][3] = list.get(i).getRegDate();
            sn[i][4] = Integer.toString(list.get(i).getPersonID());
            sn[i][5] = list.get(i).getPurpose();
            sn[i][6] = list.get(i).getOther();
        }
        return sn;
    }
    }
    @Override
    public String[][] findAll2() throws Exception {
        String sql = "select * from assetstrjn where FromAcc=?";
        List<AssetsTrjn> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1,"归还");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new AssetsTrjn(rs.getInt("jourNo"),rs.getString("FromAcc"),rs.getInt("AssetsID"),rs.getString("RegDate"), rs.getInt("PersonID"), rs.getString("purpose"),rs.getString("Other")));
                }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][7];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getJourNo());
            sn[i][1] = list.get(i).getFromAcc(); 
            sn[i][2] = Integer.toString(list.get(i).getAssetsID());
            sn[i][3] = list.get(i).getRegDate();
            sn[i][4] = Integer.toString(list.get(i).getPersonID());
            sn[i][5] = list.get(i).getPurpose();
            sn[i][6] = list.get(i).getOther();
        }
        return sn;
    }
    }
    @Override
    public String[][] findAll3() throws Exception {
        String sql = "select * from assetstrjn where FromAcc=?";
        List<AssetsTrjn> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1,"报废");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new AssetsTrjn(rs.getInt("jourNo"),rs.getString("FromAcc"),rs.getInt("AssetsID"),rs.getString("RegDate"), rs.getInt("PersonID"), rs.getString("purpose"),rs.getString("Other")));
                }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][7];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getJourNo());
            sn[i][1] = list.get(i).getFromAcc(); 
            sn[i][2] = Integer.toString(list.get(i).getAssetsID());
            sn[i][3] = list.get(i).getRegDate();
            sn[i][4] = Integer.toString(list.get(i).getPersonID());
            sn[i][5] = list.get(i).getPurpose();
            sn[i][6] = list.get(i).getOther();
        }
        return sn;
    }
    }
        
    @Override
    public AssetsTrjn findAssetsID(int id) throws Exception {
        String sql = "select * from assetstrjn where assetsID=?";
        AssetsTrjn result = null;
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    result=new AssetsTrjn(rs.getInt("jourNo"),rs.getString("FromAcc"),rs.getInt("AssetsID"),rs.getString("RegDate"), rs.getInt("PersonID"), rs.getString("purpose"),rs.getString("Other"));
                }
            }
            return result;
        }
    }
}
