package cn.shuangze.assetsms.dao.impl;

import cn.shuangze.assetsms.dao.AssetsTypeDao;
import cn.shuangze.assetsms.dao.DBUtil;
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
 * 实现接口AssetsTypeDao的方法---增删改查
 */
public class AssetsTypeDaoJDBCImpl implements AssetsTypeDao {
    
    @Override
    public int add(AssetsType assetsType) throws Exception {
        String sql = "insert into Creature(chinaname,latinname,category,feature,distributed,literature,remarks) values(?,?,?,?,?,?,?)";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new String[]{assetsType.getChinaname(), assetsType.getLatinname(),assetsType.getCategory(),assetsType.getFeature(),assetsType.getDistributed(),assetsType.getLiterature(),assetsType.getRemarks()});
        }
    }
    
    @Override
    public int delete(int id) throws Exception {
        String sql = "delete from Creature where creatureno=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Integer[]{id});
        }
    }

    @Override
    public int modify(AssetsType assetsType) throws Exception {
        String sql = "update Creature set chinaname=?,latinname=?,category=?,feature=?,distributed=?,literature=?,remarks=? where creatureno=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{assetsType.getChinaname(), assetsType.getLatinname(),assetsType.getCategory(),assetsType.getFeature(),assetsType.getDistributed(),assetsType.getLiterature(),assetsType.getRemarks(),assetsType.getCreatureno()});
        }
    }
    
    /*
    @Override
    public List<AssetsType> findByBigType(String bType) throws Exception {
        String sql = "select * from assetstype where b_type=?";
        List<AssetsType> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, bType);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new AssetsType(rs.getInt("typeid"), rs.getString("b_type"), rs.getString("s_type")));
                }
                return list;
            }
        }
    }
    
    @Override
    public AssetsType findById(int id) throws Exception {
        String sql = "select * from assetstype where typeID=?";
        AssetsType list=null;
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    list=new AssetsType(rs.getInt("typeid"), rs.getString("b_type"), rs.getString("s_type"));
                }
                return list;
            }
        }
    }

    @Override
    public AssetsType findBySmallType(String sType) throws Exception {
        String sql = "select * from assetstype where s_type=?";
        AssetsType result = null;
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, sType);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    result = new AssetsType(rs.getInt("typeid"), rs.getString("b_type"), rs.getString("s_type"));
                }
                return result;
            }
        }
    }
    */
    
    @Override
    public String[][] findAll() throws Exception {
        String sql = "select * from Creature";
        List<AssetsType> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(new AssetsType(rs.getInt("creatureno"), rs.getString("chinaname"), rs.getString("latinname"), rs.getString("category"), rs.getString("feature"), rs.getString("distributed"), rs.getString("literature"), rs.getString("remarks")));
            }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][8];
        }
        //Creature set chinaname=?,latinname=?,category=?,feature=?,distributed=?,literature=?,remarks=? where creatureno=?";
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getCreatureno());
            sn[i][1] = list.get(i).getChinaname();
            sn[i][2] = list.get(i).getLatinname();
            sn[i][3] = list.get(i).getCategory();
            sn[i][4] = list.get(i).getFeature();
            sn[i][5] = list.get(i).getDistributed();
            sn[i][6] = list.get(i).getLiterature();
            sn[i][7] = list.get(i).getRemarks();
        }
        return sn;
    }
    
    @Override
    public int[] findAllID() throws Exception {
        String sql = "select * from Creature";
        List list = new ArrayList();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(rs.getInt("creatureno"));
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
    public AssetsType findById(int id) throws Exception {
        String sql = "select * from Creature where creatureno=?";
        AssetsType list=null;
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    list=new AssetsType(rs.getInt("creatureno"), rs.getString("chinaname"), rs.getString("latinname"), rs.getString("category"), rs.getString("feature"), rs.getString("distributed"), rs.getString("literature"), rs.getString("remarks"));
                }
                return list;
            }
        }
    }
}
