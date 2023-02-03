import java.sql.*;
import java.util.Scanner;

class DodajPracownika extends BaseDodaj {

    public DodajPracownika(Connection con, Statement stmt) {
   super(con, stmt);
    }

    public void dodaj() throws SQLException {
        Scanner scan = new Scanner(System.in);
        {
            System.out.print("Podaj id pracownika: ");
            int id = scan.nextInt();
            System.out.print("Podaj imię pracownika: ");
            String imie = scan.nextLine();
            System.out.print("Podaj nazwisko pracownika: ");
            String nazwisko = scan.nextLine();
            System.out.print("Podaj wiek pracownika: ");
            int wiek = scan.nextInt();

            String query = "INSERT INTO pracownicy (id, imie, nazwisko, wiek) VALUES (" + id + ", '" + imie + "', '" + nazwisko + "', " + wiek +")";
          stmt.executeUpdate(query);
            System.out.println("Pracownik został pomyślnie dodany.");
            System.out.println("----------------------------------------------------------------");
        }
    }
}



