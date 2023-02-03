import java.sql.*;

class WyswietlWypozyczenia extends BaseWyswietl{
    public WyswietlWypozyczenia(Connection con, Statement stmt) {
   super(con, stmt);
    }
    public void wyswietl() throws SQLException {
        String query = "SELECT * FROM wypozyczenie";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            int idgry = rs.getInt("idgry");
            int idklienta = rs.getInt("idklienta");
            int idpracownik = rs.getInt("idpracownik");
            Date datawypozyczenia = rs.getDate("datawypozyczenia");
            Date dataZwrotu = rs.getDate("datazwrotu");
            String zwrot = dataZwrotu == null ?"Jest wypożyczona":new java.util.Date(dataZwrotu.getTime()).toString();
            System.out.println(idgry +" " + idklienta + " " +idpracownik + " data wypozyczenia " + new java.util.Date(datawypozyczenia.getTime())+ " " + zwrot);
        }
        System.out.println("----------------------------------------------------------------");
    }
}

