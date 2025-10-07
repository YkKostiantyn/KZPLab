package lab6;

public class Main {
    public static void main(String[] args){
        Set<Student> studentSet = new Set<>();
        studentSet.add(new Student("John", 20));
        studentSet.add(new Student("John", 20));
        studentSet.add(new Student("Florentine", 23));
        studentSet.add(new Student("Tine", 15));
        studentSet.add(new Student("Quentine", 42));

        System.out.println("Student:");
        studentSet.printAll();

        System.out.println("The youngest student: " + studentSet.findMin());

        Set<Book> bookSet = new Set<>();
        bookSet.add(new Book("Java for beginner", 300));
        bookSet.add(new Book("algorithms", 500));
        bookSet.add(new Book("math", 250));
        bookSet.add(new Book("math", 250));
        bookSet.add(new Book("math", 250));
        bookSet.add(new Book("math", 250));

        System.out.println("\nBook:");
        bookSet.printAll();
        System.out.println("The book with the fewest pages: " + bookSet.findMin());

        int countBook = bookSet.size();
        int countStudent = studentSet.size();

        if(countStudent > countBook){
            System.out.println("Student:" + countStudent);
            studentSet.printAll();
        }
        else if(countBook > countStudent){
            System.out.println("Book:" + countBook);
            bookSet.printAll();
        }
        else{
            System.out.println("Student:" + countStudent);
            studentSet.printAll();
            System.out.println("Book:" + countBook);
            bookSet.printAll();
        }
    }
}
