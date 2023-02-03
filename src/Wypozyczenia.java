import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

class Wypozyczenia {
    private int idgry;
    private int idklienta;
    private int idpracownik;

    private Connection con;
    private Statement stmt;

    public Wypozyczenia(Connection con, Statement stmt) {
        this.con = con;
        this.stmt = stmt;
    }

    public boolean czyMoznaWypozyczyc(int idgry, int idklienta, int idpracownik) throws SQLException {
        String querygry = "SELECT * FROM gry where id = " + idgry;
        String querypracownicy = "SELECT * FROM pracownicy where id = " + idpracownik;
        String queryklienci = "SELECT * FROM klienci where idklienci = " + idklienta;
        String queryczyWypozyczono = "SELECT * FROM wypozyczenie where idgry =" + idgry + " and datazwrotu is null";
        ResultSet rsgry = stmt.executeQuery(querygry);
        if (!rsgry.next()) {
            System.out.println("Nie ma gry o takim id!");
            return false;
        }
        ResultSet rspracownicy = stmt.executeQuery(querypracownicy);
        if (!rspracownicy.next()) {
            System.out.println("Nie ma takiego pracownika!");
            return false;
        }
        ResultSet rsklienci = stmt.executeQuery(queryklienci);
        if (!rsklienci.next()) {
            System.out.println("Nie ma takiego klienta!");
            return false;
        }
        ResultSet rsczyWypozyczono = stmt.executeQuery(queryczyWypozyczono);
        if (rsczyWypozyczono.next()) {
            System.out.println("Gra jest wypożyczona");
            return false;
        }
        return true;
    }

    public void dodajWypozyczenie() throws SQLException {
        Scanner scan = new Scanner(System.in);
        {
            System.out.print("Podaj id gry: ");
            idgry = scan.nextInt();
            System.out.print("Podaj id klienta: ");
            idklienta = scan.nextInt();
            System.out.print("Podaj id pracownika: ");
            idpracownik = scan.nextInt();
            if(czyMoznaWypozyczyc(idgry, idklienta, idpracownik)){
                Date wypozyczenie = new Date();
                SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                data.setTimeZone(TimeZone.getTimeZone("CET"));
                String datawypozyczeniawyjsciowa = data.format(wypozyczenie);
                String query = "INSERT INTO wypozyczenie (id, idgry, idklienta, idpracownik, datawypozyczenia, datazwrotu) VALUES (null, " + idgry + ", " + idklienta + ", " + idpracownik + ", '" +datawypozyczeniawyjsciowa +"',null)";
                System.out.println("Udalo Ci sie wypozyczyc gre");
                stmt.executeUpdate(query);

            }
            }
        }
}

