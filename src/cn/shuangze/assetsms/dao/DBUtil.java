package cn.shuangze.assetsms.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 数据库连接与关闭工具类
 */
public class DBUtil {

    private static String driver; // 数据库驱动字符串
    private static String url; // 连接URL字符串
    private static String username; // 数据库用户名
    private static String password; // 用户密码

    static {
        try {
            //静态代码块,在类加载的时候执行
            init();
        } catch (IOException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 初始化连接参数,从配置文件里获得
     * @throws java.io.IOException
     */
    public static void init() throws IOException {
        Properties params = new Properties();
        String configFile = "database.properties";//配置文件路径
        //加载配置文件到输入流中
        InputStream is = DBUtil.class.getClassLoader().getResourceAsStream(configFile);

        //从输入流中读取属性列表
        params.load(is);

        //根据指定的获取对应的值
        driver = params.getProperty("driver");
        url = params.getProperty("url");
        username = params.getProperty("username");
        password = params.getProperty("password");
    }

    /**
     * 获取数据库连接对象。
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static Connection getConnection() throws Exception {
        Connection conn;
        Class.forName(driver);
        conn = DriverManager.getConnection(url, username, password);
        return conn;// 返回连接对象
    }

    public static int exceuteUpdate(Connection conn, String preparedSql, Object[] param) throws SQLException {
        int num;
        try (Connection connection = conn;
                PreparedStatement pstmt = connection.prepareStatement(preparedSql);) {
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
                }
            }
            num = pstmt.executeUpdate();
            return num;
        }
    }
}
