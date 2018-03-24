package chapter2operators;

/**
 * Created by nayanzin on 22.06.17.
 */
class Book{
    boolean checkOut = false;

    public Book(boolean checkOut){
        this.checkOut = checkOut;
    }

    public void checkIn(){
        this.checkOut = false;
    }

    @Override
    protected void finalize(){
        if(checkOut == true)
            System.out.print("The book is check getStr");
    }
}

public class TerminationCondition {
    public static void main(String[] args){
        Book book = new Book(true);
        book.checkIn();

        new Book(true);
        System.gc();
    }
}
