public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Baltagul", "Mihail Sadoveanu", "13579", 10, 1);
        Book book2 = new Book("Ion", "Liviu Rebreanu", "65872", 10, 9);
        Book book3 = new Book("Mara", "Ioan Slavici", "32215", 10, 3);
        Book[] bookList = {book1, book2, book3};
        Library library = new Library(bookList);
        Client client1 = new Client("Marcel", library);
        Admin admin = new Admin("Ion", library);

        try {
            if (client1.isBookAvailable("13579")) {
                System.out.println("Cartea este disponibila");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        client1.viewAvailableBooks();
        System.out.println(" ");
        admin.listAllBooks();
    }
}