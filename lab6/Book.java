package lab6;

public class Book implements Comparable<Book> {
    private String title;
    private int pages;

    public Book(String title, int pages){
        this.title = title;
        this.pages = pages;
    }

    @Override
    public int compareTo(Book other){
        return Integer.compare(this.pages, other.pages);
    }

    @Override
    public String toString(){
        return title + " (" + pages + " years old)";
    }
}
