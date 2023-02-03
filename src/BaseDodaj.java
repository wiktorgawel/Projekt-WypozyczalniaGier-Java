import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseDodaj {

        protected Connection con;
        protected Statement stmt;

        public BaseDodaj(Connection con, Statement stmt) {
            this.con = con;
            this.stmt = stmt;
        }
public abstract void dodaj() throws SQLException;
}
