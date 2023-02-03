import java.sql.*;
import java.util.Scanner;
import java.sql.DriverManager;

public class WypozyczalniaGier {
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


    public static void main(String[] args) {
        try {
            // Łączenie z bazą danych
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wypozyczalnia-gier", "root", "garfield1");
            stmt = con.createStatement();
            Scanner scan = new Scanner(System.in);
            int wybor;
            do {
                System.out.println("******************************************************");
                System.out.println("WYPOŻYCZALNIA GIER");
                System.out.println("[1]. Wyświetl gry");
                System.out.println("[2]. Dodaj gre do bazy danych");
                System.out.println("[3]. Usuń gre z bazy danych");
                System.out.println("[4]. Dodaj pracownika do wypożyczalni");
                System.out.println("[5]. Wyświetl wszystkich pracowników wypożyczalni");
                System.out.println("[6]. Wypożycz gre");
                System.out.println("[7]. Wyswietl Klientow");
                System.out.println("[8]. Dodaj Klienta");
                System.out.println("[9]. Wyswietl wypozyczenia");
                System.out.println("[10]. Zwroc gre");
                System.out.println("[11]. Wyjdz");
                System.out.println("******************************************************");
                System.out.print("Wybierz opcję: ");
                wybor = scan.nextInt();
                scan.nextLine();



                switch (wybor) {
                    case 1:
                        WyswietlGry wyswietlGry = new WyswietlGry(con, stmt);
                        wyswietlGry.wyswietl();
                        break;
                    case 2:
                        DodajGre dodajGre = new DodajGre(con, stmt);
                        dodajGre.dodaj();
                        break;
                    case 3:
                        UsunGre usunGre = new UsunGre(con, stmt);
                        usunGre.usun();
                        break;
                    case 4:
                        DodajPracownika dodajPracownika = new DodajPracownika(con, stmt);
                        dodajPracownika.dodaj();
                        break;
                    case 5:
                        WyswietlPracownikow pracownicy = new WyswietlPracownikow(con, stmt);
                        pracownicy.wyswietl();
                        break;
                    case 6:
                        Wypozyczenia wypozyczenia = new Wypozyczenia(con, stmt);
                        wypozyczenia.dodajWypozyczenie();
                        break;
                    case 7:
                        WyswietlKlientow wyswietlklientow = new WyswietlKlientow(con, stmt);
                        wyswietlklientow.wyswietl();
                        break;
                    case 8:
                        DodajKlientow dodajKlientow = new DodajKlientow(con, stmt);
                        dodajKlientow.dodaj();
                        break;
                    case 9:
                        WyswietlWypozyczenia wyswietlWypozyczenia = new WyswietlWypozyczenia(con, stmt);
                        wyswietlWypozyczenia.wyswietl();
                        break;
                    case 10:
                        ZwrocWypozyczenie zwrocWypozyczenie = new ZwrocWypozyczenie(con, stmt);
                        zwrocWypozyczenie.oddajGre();
                        break;
                }
            } while (wybor != 11);

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


