package top.playereg.sys.entity;

public class User {
    /* 构造属性%start=================================================================================================== */
    private int id;
    private String username;
    private String password;
    private String email;
    private String is_root;
    private String is_del;
    /* 构造属性%end=================================================================================================== */

    /* 无参构造方法%start============================================================================================== */
    public User() {
    }
    /* 无参构造方法%end============================================================================================== */

    /* 全参构造方法%start============================================================================================= */
    public User(
            int id,
            String username,
            String password,
            String email,
            String is_root,
            String is_del
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.is_root = is_root;
        this.is_del = is_del;
    }
    /* 全参构造方法%end============================================================================================= */

    /* get&set%start============================================================================================= */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIs_root() {
        return is_root;
    }

    public void setIs_root(String is_root) {
        this.is_root = is_root;
    }

    public String getIs_del() {
        return is_del;
    }

    public void setIs_del(String is_del) {
        this.is_del = is_del;
    }
    /* get&set%end============================================================================================= */

    /* toString%start============================================================================================= */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", is_root='" + is_root + '\'' +
                ", is_del='" + is_del + '\'' +
                '}';
    }
    /* toString%end============================================================================================= */
}
