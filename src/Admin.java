public class Admin extends User{


    public Admin(String name, Library library) {
        super(name, library);
    }

    public boolean deleteBook(String ISBNCode){
        return true;
    }

    public boolean deleteBook(String ISBNCode, int numberOfCopies){

        return true;

    }

    public void listAllBooks(){
        Book[] books = getLibrary().getBooks();
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }
}
