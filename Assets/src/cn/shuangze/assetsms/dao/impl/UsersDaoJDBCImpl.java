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
 * 实现UsersDao接口的方法
 */
public class UsersDaoJDBCImpl implements UsersDao {

    @Override
    public int add(Users user) throws Exception {
        String sql = "insert into users(username,password,phone,mail) values(?,?,?,?)";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{user.getUsername(),user.getPassword(),user.getPhone(),user.getMail()});
        }
    }
    
    @Override
    public int modify(Users user) throws Exception {
        String sql = "update users set username=?,password=?,phone=?,mail=? where userno=?";
        try (Connection conn = getConnection();) {
            return exceuteUpdate(conn, sql, new Object[]{user.getUsername(),user.getPassword(),user.getPhone(),user.getMail(),user.getUserno()});
        }
    }
    //所有的用户名
    @Override
    public List<String> findAllName() throws Exception {
        String sql = "select * from users";
        List<String> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(rs.getString("username"));
            }
        }
        return list;
    }
    //指定用户名的用户
    @Override
    public Users findNameUser(String name) throws Exception {
        String sql = "select * from users where username=?";
        Users use=null;
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, name);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    use=new Users(rs.getString("username"), rs.getString("password"), rs.getString("phone"),rs.getString("mail"));
                }
                return use;
            }
        }
    }

    @Override
    public String[][] findName(String name) throws Exception {
        String sql = "select * from users where username=?";
        List<Users> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, name);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new Users(rs.getString("username"), rs.getString("password"), rs.getString("phone"),rs.getString("mail")));
                }
                String[][] sn = null;
                int size = list.size();
                if (!list.isEmpty()) {
                    sn = new String[list.size()][4];
                }
                for (int i = 0; i < size; i++) {
                    sn[i][0] = list.get(i).getUsername();
                    sn[i][1] = list.get(i).getPassword();
                    sn[i][2] = list.get(i).getPhone();
                    sn[i][3] = list.get(i).getMail();
                }
                return sn;
            }
        }
    }

    @Override
    public String[][] findAll() throws Exception {
        String sql = "select * from users";
        List<Users> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                list.add(new Users(rs.getString("username"), rs.getString("password"), rs.getString("phone"),rs.getString("mail")));
            }
        }
        String[][] sn = null;
        int size = list.size();
        if (!list.isEmpty()) {
            sn = new String[list.size()][4];
        }
        for (int i = 0; i < size; i++) {
            sn[i][0] = list.get(i).getUsername();
            sn[i][1] = list.get(i).getPassword();
            sn[i][2] = list.get(i).getPhone();
            sn[i][3] = list.get(i).getMail();
        }
        return sn;
    }
}
