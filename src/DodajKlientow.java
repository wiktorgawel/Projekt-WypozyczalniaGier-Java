import java.sql.*;
import java.util.Scanner;

class DodajKlientow extends BaseDodaj{

    public DodajKlientow(Connection con, Statement stmt) {
    super(con, stmt);
    }

    public void dodaj() throws SQLException {
        Scanner scan = new Scanner(System.in);
        {
            System.out.print("Podaj id klienta: ");
            int id = scan.nextInt();
            System.out.print("Podaj imię klienta: ");
            String imie = scan.nextLine();
            System.out.print("Podaj nazwisko klienta: ");
            String nazwisko = scan.nextLine();

            String query = "INSERT INTO klienci(idklienci, imie, nazwisko) VALUES (" + id + ", '" + imie + "', '" + nazwisko + "')";
            stmt.executeUpdate(query);
            System.out.println("Klient został dodany");
            System.out.println("----------------------------------------------------------------");
        }
    }
}



