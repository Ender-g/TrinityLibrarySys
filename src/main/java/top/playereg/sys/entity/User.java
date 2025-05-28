package top.playereg.sys.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String is_root;
    private String is_del;
    private String book_borrow_id;
    private String book_borrow_time;

    public User() {
    }

    public User(
            int id,
            String username,
            String password,
            String email,
            String is_root,
            String is_del,
            String book_borrow_id,
            String book_borrow_time
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.is_root = is_root;
        this.is_del = is_del;
        this.book_borrow_id = book_borrow_id;
        this.book_borrow_time = book_borrow_time;
    }

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

    public String getBook_borrow_id() {
        return book_borrow_id;
    }

    public void setBook_borrow_id(String book_borrow_id) {
        this.book_borrow_id = book_borrow_id;
    }

    public String getBook_borrow_time() {
        return book_borrow_time;
    }

    public void setBook_borrow_time(String book_borrow_time) {
        this.book_borrow_time = book_borrow_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", is_root='" + is_root + '\'' +
                ", is_del='" + is_del + '\'' +
                ", book_borrow_id='" + book_borrow_id + '\'' +
                ", book_borrow_time='" + book_borrow_time + '\'' +
                '}';
    }
}
