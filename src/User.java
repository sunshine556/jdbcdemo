public class User {

    private int userorder;
    private String username;
    private String password;


    public User() {
    }

    public User(int userorder, String username, String password) {
        this.userorder = userorder;
        this.username = username;
        this.password = password;
    }

    /**
     * 获取
     * @return userorder
     */
    public int getUserorder() {
        return userorder;
    }

    /**
     * 设置
     * @param userorder
     */
    public void setUserorder(int userorder) {
        this.userorder = userorder;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User{userorder = " + userorder + ", username = " + username + ", password = " + password + "}";
    }
}
