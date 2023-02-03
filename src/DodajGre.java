import java.sql.*;
import java.util.Scanner;

class DodajGre extends BaseDodaj {
    public DodajGre(Connection con, Statement stmt) {
  super(con, stmt);
    }

    public void dodaj() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj id gry: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Podaj nazwę gry: ");
        String Tytul = scan.nextLine();
        System.out.print("Podaj gatunek gry: ");
        String Gatunek = scan.nextLine();
        System.out.print("Podaj rok powstania gry: ");
        int Rok = scan.nextInt();

        String query = "INSERT INTO gry (id, Tytul, Gatunek, Rok) VALUES ("+id +", '"+Tytul+"', '" + Gatunek +"', "+Rok+")";
        stmt.executeUpdate(query);
        System.out.println("Gra została dodana do bazy danych.");
        System.out.println("----------------------------------------------------------------");
        System.out.println(query);

    }
}


