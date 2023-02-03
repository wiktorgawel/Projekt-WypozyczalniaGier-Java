import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

class ZwrocWypozyczenie {
    private int idgry;
    private int idklienta;
    private int idpracownik;

    private Connection con;
    private Statement stmt;

    public ZwrocWypozyczenie(Connection con, Statement stmt) {
        this.con = con;
        this.stmt = stmt;
    }

    public boolean czyJestWypozyczenie(int idgry, int idklienta, int idpracownik) throws SQLException {
        String queryczyWypozyczono = "SELECT * FROM wypozyczenie where idgry =" + idgry + " and idklienta="+idklienta+" and idpracownik="+idpracownik+" and datazwrotu is null";

        ResultSet rsczyWypozyczono = stmt.executeQuery(queryczyWypozyczono);
        if (!rsczyWypozyczono.next()) {
            System.out.println("Ta gra nie jest wypożyczona przez tego klienta");
            return false;
        }
        return true;
    }

    public void oddajGre() throws SQLException {
        Scanner scan = new Scanner(System.in);
        {
            System.out.print("Podaj id gry: ");
            idgry = scan.nextInt();
            System.out.print("Podaj id klienta: ");
            idklienta = scan.nextInt();
            System.out.print("Podaj id pracownika: ");
            idpracownik = scan.nextInt();
            if(czyJestWypozyczenie(idgry, idklienta, idpracownik)){
                Date zwrot = new Date();
                SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                data.setTimeZone(TimeZone.getTimeZone("CET"));
                String datazwrotu = data.format(zwrot);
                String query = "UPDATE wypozyczenie set datazwrotu='"+datazwrotu +"' where idgry =" + idgry + " and idklienta="+idklienta+" and idpracownik="+idpracownik+" and datazwrotu is null";
                stmt.executeUpdate(query);
                System.out.println("Pomyślnie zwróciłeś grę");

            }
        }
    }
}

