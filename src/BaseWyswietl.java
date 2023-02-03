import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseWyswietl {

    protected Connection con;
    protected Statement stmt;

    public BaseWyswietl(Connection con, Statement stmt) {
        this.con = con;
        this.stmt = stmt;
    }
    public abstract void wyswietl() throws SQLException;
}
