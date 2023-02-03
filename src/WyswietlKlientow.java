import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class WyswietlKlientow extends BaseWyswietl{

    public WyswietlKlientow(Connection con, Statement stmt) {
       super(con, stmt);
    }
    public void wyswietl() throws SQLException {
        String query = "SELECT * FROM klienci";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int idklienci = rs.getInt("idklienci");
            String imie = rs.getString("imie");
            String nazwisko = rs.getString("nazwisko");
            System.out.println(+ idklienci +"  " + imie + " " + nazwisko);
        }
        System.out.println("----------------------------------------------------------------");
    }
}

