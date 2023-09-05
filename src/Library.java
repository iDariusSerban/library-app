public class Library {
    private Book[] books;
    private int numberOfBooks;

    public Library(int size) {
        this.books = new Book[size];
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public boolean isBookInList(String ISBNCode) { //verifica daca este cartea in lista
        for (int i = 0; i < numberOfBooks; i++) {
            if (ISBNCode.equals(books[i].getISBNCode())) {
                return true;
            }
        }
        return false;
    }

    public int findIndexOfBook(String ISBNCode) {
        for (int i = 0; i < numberOfBooks; i++) {
            if (ISBNCode.equals(books[i].getISBNCode())) {
                return i;
            }
        }
        return -1;
    }

    public Book findBook(String ISBNCode) {
        for (int i = 0; i < numberOfBooks; i++) {
            if (ISBNCode.equals(books[i].getISBNCode())) {
                return books[i];
            }
        }
        //throw new Exception("Cartea nu este in lista bibliotecii");
        return null;
    }

    public void addBookInList(Book book) {
        books[numberOfBooks] = book;
        numberOfBooks++;
    }

    public void deleteBook(String ISBNCode) {

        //verific daca este cartea in lista
        if (isBookInList(ISBNCode)) {
            //sterg cartea din lista
            int bookIndex = findIndexOfBook(ISBNCode);
            if (bookIndex == numberOfBooks - 1) {
                books[bookIndex] = null;
            } else {
                for (int i = bookIndex; i < numberOfBooks - 1; i++) {
                    books[bookIndex] = books[bookIndex + 1];
                }
                books[numberOfBooks - 1] = null;

            }
            numberOfBooks--;
        }
    }

    public boolean deleteBook(String ISBNCode, int copiesToDelete) {
        if (isBookInList(ISBNCode)) {
            int index = findIndexOfBook(ISBNCode);
            if (books[index].getTotalNumberOfCopies() > copiesToDelete) {
                books[index].setTotalNumberOfCopies(books[index].getTotalNumberOfCopies() - copiesToDelete);
                return true;
            }
        }
        return false;
    }

    public void listBooks() {
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println(books[i]);
        }
    }
}