
import java.sql.*;
import java.util.Scanner;


class UsunGre {
    private Connection con;
    private Statement stmt;


    public UsunGre(Connection con, Statement stmt) {
        this.con = con;
        this.stmt = stmt;
    }

    public void usun() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj ID gry do usunięcia: ");
        int id = scan.nextInt();
        scan.nextLine();

        String query = "DELETE FROM gry WHERE id = " + id;
        stmt.executeUpdate(query);
        System.out.println("Gra została usunięty z bazy danych.");
        System.out.println("----------------------------------------------------------------");
    }
}

