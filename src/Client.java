public class Client extends User{

    private String[] borrowedBookCodes;
    //definesc un aitrbut al clasei Client de tip Library



    public boolean isBookAvailable (String ISBNCode){
        return true;
    }

    public void viewAvailableBooks(){

    }

    public boolean borrowBook(String ISBNCode){
        return true;
    }


}
