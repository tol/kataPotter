package ro.tol.potter;

/**
 * Created by IntelliJ IDEA.
 * User: oana
 * Date: Aug 9, 2009
 * Time: 8:38:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book {

    private Integer type;

    public Book(Integer type) {
        this.type=type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book)
        {
            Book secondBook=(Book)obj;
            return this.getType()==secondBook.getType();
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return "Book{" +
                "type=" + type +
                '}';
    }
}
