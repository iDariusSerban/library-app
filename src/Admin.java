public class Admin extends User {


    public Admin(String name, Library library) {
        super(name, library);
    }

    public boolean deleteBook(String ISBNCode) {
        getLibrary().deleteBook(ISBNCode);
        return true;
    }

    public void deleteBook(String ISBNCode, int numberOfCopies) {
        getLibrary().deleteBook(ISBNCode, numberOfCopies);

        Book book = getLibrary().findBook(ISBNCode);
        if (book.getTotalNumberOfCopies() < 1) {
            System.out.println("Nu mai sunt copii ale acestei carti inregistrate in sistem");
        }
        book.setTotalNumberOfCopies(book.getTotalNumberOfCopies() - 1);
    }

    public boolean addBook(Book newBook) throws Exception {
        Book bookAlreadyInList = getLibrary().findBook(newBook.getISBNCode());
        if (bookAlreadyInList != null) {
            //modific numarul de copii totale ale cartii
            bookAlreadyInList.setTotalNumberOfCopies(bookAlreadyInList.getTotalNumberOfCopies() + 1);
            return true;
        } else {
            //adaug cartea in lista bibliotecii
            getLibrary().addBookInList(newBook);
            newBook.setTotalNumberOfCopies(1);
            return true;
        }
    }


    public void listAllBooks() {
        getLibrary().listBooks();
    }

    public void listBookDetails(String ISBNCode) {
        System.out.println(getLibrary().findBook(ISBNCode));
    }

    public void viewBorrowedBooks(Client client) {
        for (int i = 0; i < client.getNumberOfBorrowedBooks(); i++) {
            System.out.println(client.getBorrowedBookCodes()[i]);
        }
    }
}

