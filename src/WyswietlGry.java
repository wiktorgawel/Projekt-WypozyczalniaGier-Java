import java.sql.*;
import java.util.Scanner;



class WyswietlGry extends BaseWyswietl{

    public WyswietlGry(Connection con, Statement stmt) {
        super(con, stmt);
    }

    public void wyswietl() throws SQLException {
        String query = "SELECT * FROM gry";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int idgry = rs.getInt("id");
            String tytul = rs.getString("Tytul");
            String gatunek = rs.getString("Gatunek");
            int rok = rs.getInt("Rok");
            System.out.println( "ID:" + idgry +" TYTUŁ:" + tytul + " GATUNEK:" + gatunek + " ROK WYDANIA:" + rok);
        }
        System.out.println("----------------------------------------------------------------");
    }

}