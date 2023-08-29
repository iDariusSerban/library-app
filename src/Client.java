public class Client extends User {

    private String[] borrowedBookCodes;


    public Client(String name, Library library) {
        super(name, library);
        this.borrowedBookCodes = new String[10];
    }

    public String[] getBorrowedBookCodes() {
        return borrowedBookCodes;
    }

    public void setBorrowedBookCodes(String[] borrowedBookCodes) {
        this.borrowedBookCodes = borrowedBookCodes;
    }


    public boolean isBookAvailable(String ISBNCode) throws Exception {
        Book book = getLibrary().searchForBook(ISBNCode);
        if (book.getBorrowedNumberOfCopies() < book.getTotalNumberOfCopies()) {

            return true;
        }
        return false;
    }

    public void viewAvailableBooks() {
        Book[] books = getLibrary().getBooks();
        for (int i = 0; i < books.length; i++) {
            int availableCopies = books[i].getTotalNumberOfCopies() - books[i].getBorrowedNumberOfCopies();
            if (availableCopies>0)
                System.out.println("Cartea " + books[i].getTitle() +
                        " Scrisa de " + books[i].getAuthor() +
                        " ISBNCode " + books[i].getISBNCode() +
                        " Numar de exemplare disponibile " + availableCopies);
        }
    }

    public boolean borrowBook(String ISBNCode) {
        return true;
    }


}
