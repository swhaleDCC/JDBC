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
 * 实现接口PersonTypeDao的方法---增删改查
 */
public class PersonTypeDaoJDBCImpl implements PersonTypeDao {

    @Override
    public int add(PersonType personType) throws Exception {
        String sql = "insert into person(Name,Sex,Dept,Job,Other) values(?,?,?,?,?)";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{personType.getName(),personType.getSex(), personType.getDept(),personType.getJob(), personType.getOther()});
        }
    }
    
    @Override
    public int delete(int id) throws Exception {
        String sql = "delete from person where PersonID=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Integer[]{id});
        }
    }

    @Override
    public int modify(PersonType personType) throws Exception {
        String sql = "update person set Name=?,Sex=?,Dept=?,Job=?,Other=? where PersonID=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{personType.getName(),personType.getSex(), personType.getDept(),personType.getJob(), personType.getOther(),personType.getPersonID()});
        }
    }

    @Override
    public String[][] findAssetsID(int id) throws Exception {
        String sql = "select * from person where PersonID=?";
        List<PersonType> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new PersonType(rs.getInt("PersonID"),rs.getString("Name"), rs.getString("Sex"), rs.getString("Dept"),rs.getString("Job"), rs.getString("Other")));
                }  
            }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][8];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getPersonID());
            sn[i][1] = list.get(i).getName();
            sn[i][2] = list.get(i).getSex();
            sn[i][3] = list.get(i).getDept();
            sn[i][4] = list.get(i).getJob();
            sn[i][5] = list.get(i).getOther();
        }
        return sn;
    }
    @Override
    public PersonType findAssetsItem(int id) throws Exception {
        String sql = "select * from person where PersonID=?";
        PersonType list=null;
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list=new PersonType(rs.getInt("PersonID"),rs.getString("Name"), rs.getString("Sex"), rs.getString("Dept"),rs.getString("Job"), rs.getString("Other"));
                }  
            }
        }
        return list;
    }

    @Override
    public String[][] findAll() throws Exception {
        String sql = "select * from person";
        List<PersonType> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(new PersonType(rs.getInt("PersonID"),rs.getString("Name"), rs.getString("Sex"), rs.getString("Dept"),rs.getString("Job"), rs.getString("Other")));
            }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][8];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = Integer.toString(list.get(i).getPersonID());
            sn[i][1] = list.get(i).getName();
            sn[i][2] = list.get(i).getSex();
            sn[i][3] = list.get(i).getDept();
            sn[i][4] = list.get(i).getJob();
            sn[i][5] = list.get(i).getOther();
        }
        return sn;
    }
    
    @Override
    public int[] findID() throws Exception {
        String sql = "select * from person";
        List list = new ArrayList();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(rs.getInt("PersonID"));
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
}
