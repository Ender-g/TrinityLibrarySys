/*
 *
 * @author: playereg
 * @description: 书本实体类
 * @version: 1.0
 *
 * */

package top.playereg.sys.entity;

public class Books {
    private int id;
    private String bookName;
    private int bookNumber;
    private String is_del;

    public Books() {
    }

    public Books(int id, String bookName, int bookNumber, String is_del) {
        this.id = id;
        this.bookName = bookName;
        this.bookNumber = bookNumber;
        this.is_del = is_del;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getIs_del() {
        return is_del;
    }

    public void setIs_del(String is_del) {
        this.is_del = is_del;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookNumber='" + bookNumber + '\'' +
                ", is_del='" + is_del + '\'' +
                '}';
    }
}
