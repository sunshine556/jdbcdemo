import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {

        System.out.println("欢迎访问数据库：");
        while (true) {
            System.out.println("1.添加一个新用户");
            System.out.println("2.按用户名查询用户");
            System.out.println("3.修改用户密码");
            System.out.println("4.删除用户");
            System.out.println("5.查询并显示所有用户");
            System.out.println("6.退出系统");
            System.out.println("请选择您要进行的操作：");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            //新建User类的对象
            User user = new User();
            //新建UserDao类的对象
            UserDao userDao = new UserDao();


            switch (choice){
                case 1:
                    Scanner sa = new Scanner(System.in);
                    System.out.println("请输入用户名：");
                    String username = sa.next();
                    user.setUsername(username);
                    System.out.println("请输入密码：");
                    String password = sa.next();
                    user.setPassword(password);
                    userDao.add(user);//调用类的静态方法，直接用类名点上静态方法
                    break;
                case 2:
                    Scanner sb = new Scanner(System.in);
                    System.out.println("请输入您要查找的用户名：");
                    String name = sb.nextLine();
                    userDao.query(name);
                    break;
                case 3:
                    Scanner sd = new Scanner(System.in);
                    System.out.println("请输入您要修改密码的用户名：");
                    String name1 = sd.nextLine();
                    user.setUsername(name1);
                    System.out.println("请输入您要更改为的密码：");
                    String pwd = sd.nextLine();
                    user.setPassword(pwd);
                    userDao.update(user);
                    break;
                case 4:
                    System.out.println("请输入您要删除的用户名：");
                    Scanner se = new Scanner(System.in);
                    String name2 = se.nextLine();
                    userDao.delete(name2);
                    break;
                case 5:
                    userDao.queryAll();
                    break;
                case 6:
                    System.out.println("感谢使用数据库访问系统！");
                    System.exit(0);
                    break;

            }
        }


    }





}
