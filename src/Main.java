import enams.Gender;
import enams.Genre;
import enams.Language;
import model.Book;
import model.User;
import service.impl.BookImpl;
import service.impl.UserImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookImpl book = new BookImpl();
        UserImpl user = new UserImpl();
        List<User> users = new ArrayList<>(List.of(
                new User(1L,"Eliza","Ashyrbaeva","eliza@gmail.com","+996777444555", Gender.FEMALE, BigDecimal.valueOf(5000),null),
                new User(2L,"Nuriza","MURATOVA","nuriza@gmail.com","+9960774555666", Gender.FEMALE, BigDecimal.valueOf(5000),null),
                new User(3L,"Alibek","Altynbek uulu","alibek@gmail.com","+996999222111", Gender.MALE, BigDecimal.valueOf(5000),null),
                new User(4L,"Adil","Aibaeva","adil@gmail.com","+996333666555", Gender.MALE, BigDecimal.valueOf(5000),null),
                new User(5L,"Kanykey","Ashyrbaeva","kanykey@gmail.com","+996444555666", Gender.FEMALE, BigDecimal.valueOf(5000),null)));
        List<Book>books  = List.of(
                new Book(11L,"Ak keme", Genre.ROMANCE,BigDecimal.valueOf(1000),"Chyngyz Aitmatov", Language.KYRGYZ, LocalDate.of(2001,10,22)),
                new Book(22L,"Ant", Genre.FANTASY,BigDecimal.valueOf(2000),"Nurzhigit KADYRBEKOV", Language.RUSSIAN, LocalDate.of(2012,1,2)),
                new Book(33L,"Toolor", Genre.FANTASY,BigDecimal.valueOf(500),"Chyngyz Aitmatov", Language.KYRGYZ, LocalDate.of(1985,10,22)),
                new Book(44L,"Rameo i Julietta", Genre.ROMANCE,BigDecimal.valueOf(800),"Uilliam Shekspir", Language.ENGLISH, LocalDate.of(1879,5,8)),
                new Book(55L,"Taras Bulba", Genre.HISTORICAL,BigDecimal.valueOf(600),"Lev Tolstoi", Language.RUSSIAN, LocalDate.of(1886,10,22))
        );

        while (true) {
            int number = new Scanner(System.in).nextInt();
            switch (number) {
                case 1 -> System.out.println(book.createBooks(books));
                case 2 -> System.out.println(book.getAllBooks());
                case 3 -> System.out.println(book.removeBookById(new Scanner(System.in).nextLong()));
                case 4 -> System.out.println(book.sortBooksByPriceInDescendingOrder());
                case 5 -> System.out.println(book.filterBooksByPublishedYear());
                case 6 -> System.out.println(book.getBooksByGenre(new Scanner(System.in).nextLine()));
                case 7 -> System.out.println(book.getBookByInitialLetter());
                case 8 -> System.out.println(book.maxPriceBook());
                case 9 -> System.out.println(user.createUser(users));
                case 10 -> System.out.println(user.findAllUsers());
                case 11 -> System.out.println(user.findUserById(new Scanner(System.in).nextLong()));
                case 12 -> System.out.println(user.removeUserByName(new Scanner(System.in).nextLine()));
                case 13 -> user.updateUser(new Scanner(System.in).nextLong());
                case 14 -> user.groupUsersByGender();
                case 15 -> System.out.println(user.buyBooks(new Scanner(System.in).nextLine(), null));

            }
        }
    }
}
