public class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book searchForBook(String ISBNCode) throws Exception{
        for (int i = 0; i < books.length; i++) {
            if (ISBNCode.equals(books[i].getISBNCode())){
                return books[i];
            }
        }
        throw new Exception("Cartea nu este in lista bibliotecii");
    }
}
