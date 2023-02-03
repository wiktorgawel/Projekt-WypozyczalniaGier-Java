import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class WyswietlPracownikow extends BaseWyswietl {

    public WyswietlPracownikow(Connection con, Statement stmt) {
    super(con, stmt);
    }
    public void wyswietl() throws SQLException {
    String query = "SELECT * FROM pracownicy";
    ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
        int idpracownicy = rs.getInt("id");
        String imie = rs.getString("imie");
        String nazwisko = rs.getString("nazwisko");
        int wiek = rs.getInt("wiek");
        System.out.println( + idpracownicy +" IMIE" + imie + " " + nazwisko + " " + wiek);
    }
        System.out.println("----------------------------------------------------------------");
}
}

