import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDao {

    Connection conn;
    ResultSet rs = null;

    UserDao() throws Exception {//获得数据库连接
        DBUtil.ConnectDB();
        //左边的this.conn代表的是外面的全局变量Connection conn;
        //等号右边的语句获取的是DBUtil类中的方法返回的是已经连接数据库的conn
        //整句语句就代表把已经连接数据库的conn赋值给本类中还没有连接数据库的conn
        this.conn = (Connection) DBUtil.getConnection();
    }

    /**
     * 添加新用户
     * @param user
     */
    public void add(User user) throws Exception {
        //定义添加用户信息的sql语句
        String sql1 = "insert into userInfo(username, password) VALUES (?,?)";
        String sql2 = "select username from userInfo where username = ?";
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        PreparedStatement pstmt2 = conn.prepareStatement(sql2);
        //设置参数
        pstmt2.setString(1,user.getUsername());
        rs = pstmt2.executeQuery();
            if (!rs.next()){

                pstmt1.setString(1,user.getUsername());
                pstmt1.setString(2,user.getPassword());
                int count = pstmt1.executeUpdate();
                System.out.println("成功添加用户:" + user.getUsername() + "，影响行数：" + count + "\n");
            }else {
                System.out.println("用户已存在");
        }
        pstmt2.close();
        pstmt1.close();
        conn.close();
    }

    /**
     * 按用户名查询用户
     * @param name
     */
    public void query(String name) throws Exception {
        //定义查询表的sql语句
        String sql2 = "select * from userInfo where username = ?";
        //获取执行对象
        PreparedStatement pstmt2 = conn.prepareStatement(sql2);
        //设置参数
        pstmt2.setString(1,name);
        //获取返回结果
        rs = pstmt2.executeQuery();
        while (rs.next()){
            int userorder = rs.getInt(1);
            String username = rs.getString(2);
            String password = rs.getString(3);

            System.out.println("查询到以下结果：");
            System.out.println("用户编号："+userorder+" 用户名："+username+" 用户密码："+password+"\n");
        }
        pstmt2.close();
        conn.close();
    }

    /**
     * 修改用户密码
     */
    public void update(User user) throws Exception {
        //定义修改密码的sql语句
        String sql3 = "update userInfo set password = ? where username = ?";
        String sql2 = "select username from userInfo where username = ?";
        //获取执行对象

        PreparedStatement pstmt2 = conn.prepareStatement(sql2);
        PreparedStatement pstmt3 = conn.prepareStatement(sql3);
        //设置参数
        pstmt2.setString(1,user.getUsername());
        rs = pstmt2.executeQuery();
        if (rs.next()){

            pstmt3.setString(1,user.getPassword());
            pstmt3.setString(2,user.getUsername());
            //获取执行结果
            int count = pstmt3.executeUpdate();
            System.out.println("修改成功！影响行数："+count);

        }else {
            System.out.println("修改失败！用户不存在！");
        }

        pstmt3.close();
        pstmt2.close();
        conn.close();
    }


    /**
     * 删除用户
     * @param name2
     */
    public void delete(String name2) throws Exception {
        //定义删除sql语句
        String sql4 = "delete from userInfo where username = ?";
        //获取执行对象
        PreparedStatement pstmt4 = conn.prepareStatement(sql4);
        //设置参数
        pstmt4.setString(1,name2);
        //获取结果
        int count = pstmt4.executeUpdate();
        //打印结果
        if (count>0){
            System.out.println("删除成功！影响行数："+count);
        }else {
            System.out.println("删除失败！用户不存在！");
        }
        pstmt4.close();
        conn.close();


    }

    /**
     * 查询并显示所有用户
     */
    public void queryAll() throws Exception {
        //定义sql语句
        String sql5 = "select * from userInfo";
        //获取执行对象
        PreparedStatement pstmt5 = conn.prepareStatement(sql5);
        //获取结果
        ResultSet rs = pstmt5.executeQuery();
        System.out.println("表中数据如下：");
        while (rs.next()){
            int userorder = rs.getInt(1);
            String username = rs.getString(2);
            String  userpwd = rs.getString(3);

            System.out.println("用户编号："+userorder+" 用户名："+username+" 用户密码："+userpwd);

        }
        pstmt5.close();
        conn.close();


    }


}
