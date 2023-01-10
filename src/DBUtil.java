import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

        //获取数据库连接
        //导入注册驱动
        private static String url = "jdbc:mysql:///Information?useSSL=false";
        private static String usename = "root";
        private static String pwd = "123456";
        private static Connection conn = null;

        //建立连接数据库的方法
        public static void ConnectDB() throws Exception {
            conn = DriverManager.getConnection(url,usename,pwd);
        }

        //返回建立的conn连接
        public static Connection getConnection() {
        return conn;
        }

        //设置conn数据库连接关闭
        public static void closeConnection() throws Exception {
            conn.close();
        }









}
