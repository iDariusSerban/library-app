public class Client extends User {

    private String[] borrowedBookCodes;

    int numberOfBorrowedBooks;


    public Client(String name, Library library) {
        super(name, library);
        this.borrowedBookCodes = new String[10];
        this.numberOfBorrowedBooks = 0;
    }

    public String[] getBorrowedBookCodes() {
        return borrowedBookCodes;
    }

    public void setBorrowedBookCodes(String[] borrowedBookCodes) {
        this.borrowedBookCodes = borrowedBookCodes;
    }

    public int getNumberOfBorrowedBooks() {
        return numberOfBorrowedBooks;
    }

    public void setNumberOfBorrowedBooks(int numberOfBorrowedBooks) {
        this.numberOfBorrowedBooks = numberOfBorrowedBooks;
    }

    public boolean isBookAvailable(String ISBNCode) throws Exception {
        Book book = getLibrary().findBook(ISBNCode);
        if (book==null){
            throw new Exception("Cartea nu este in lista bibliotecii");
        }
        return book.getBorrowedNumberOfCopies() < book.getTotalNumberOfCopies();
    }

    public void viewAvailableBooks() {
        Book[] books = getLibrary().getBooks();
        for (int i = 0; i < getLibrary().getNumberOfBooks(); i++) {
            int availableCopies = books[i].getTotalNumberOfCopies() - books[i].getBorrowedNumberOfCopies();
            if (availableCopies > 0)
                System.out.println("Cartea " + books[i].getTitle() +
                        " Scrisa de " + books[i].getAuthor() +
                        " ISBNCode: " + books[i].getISBNCode() +
                        " Numar de exemplare disponibile " + availableCopies);
        }
    }

    public boolean borrowBook(String ISBNCode) throws Exception {
        if (isBookAvailable(ISBNCode) && numberOfBorrowedBooks < 10) {
            getBorrowedBookCodes()[numberOfBorrowedBooks++] = ISBNCode;
            Book book = getLibrary().findBook(ISBNCode);
            book.setBorrowedNumberOfCopies(book.getBorrowedNumberOfCopies() + 1);
            return true;
        }
        throw new Exception("Nu mai sunt exemplare de imprumutat");
    }

    public boolean returnBook(String ISBNCode) throws Exception {
        // varific sa fie cartea din lista bibliotecii
        Book book = getLibrary().findBook(ISBNCode);
        if (book == null) {
            throw new Exception("Aceasta carte nu este in lista bibliotecii");
        }else{
            //sterg codul din lista clientului
            for (int i = 0; i < numberOfBorrowedBooks; i++) {
                if (ISBNCode.equals(borrowedBookCodes[i])) {
                    if (i < numberOfBorrowedBooks - 1) {
                        for (int k = i; k < numberOfBorrowedBooks - 1; k++) {
                            borrowedBookCodes[k] = borrowedBookCodes[k + 1];
                        }
                    } else {
                        borrowedBookCodes[i] = null;
                    }
                    numberOfBorrowedBooks--;
                }

            }
        }
        //scad numarul de copii imprumutate ale carti din lista librariei
        if (book.getBorrowedNumberOfCopies() < 1) {
            throw new Exception("Au fost returnate toate exemplarele acestei carti");
        } else {
            book.setBorrowedNumberOfCopies(book.getBorrowedNumberOfCopies() - 1);
            // aici e posibil sa treaca de capatul din stanga in cazul in care se face retur la mai multe carti decat sunt in total
            return true;
        }
    }


}
