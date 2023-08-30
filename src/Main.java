public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Baltagul", "Mihail Sadoveanu", "13579");
        Book book2 = new Book("Ion", "Liviu Rebreanu", "65872");
        Book book3 = new Book("Mara", "Ioan Slavici", "32215");

        Library library = new Library(10);
        Client client1 = new Client("Marcel", library);
        Admin admin = new Admin("Ion", library);

        try {
            admin.addBook(book1);
            admin.addBook(book1);
            admin.addBook(book1);
            admin.addBook(book2);
            admin.addBook(book2);
            admin.addBook(book2);
            admin.addBook(book3);
            admin.addBook(book3);
            admin.addBook(book3);
            admin.addBook(book3);
            admin.addBook(book3);


            if (client1.isBookAvailable("13579")) {
                System.out.println("Cartea este disponibila pentru imprumut");
            }
            client1.borrowBook("13579");
            client1.borrowBook("13579");
            client1.borrowBook("32215");
            client1.borrowBook("65872");

            client1.returnBook("65872");
            client1.returnBook("65872");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        client1.viewAvailableBooks();
        System.out.println(" ");

        admin.deleteBook("32215",2);
        admin.listBookDetails("65872");
        admin.viewBorrowedBooks(client1);
        admin.listAllBooks();


    }
}