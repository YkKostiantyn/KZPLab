package lab6;

import java.util.*;

public class Set<T extends Comparable<T>> {
    private List<T> elements;

    public Set(){
        elements = new ArrayList<>();
    }

    //add elements
    public void add(T element){
        if(!elements.contains(element)){
            elements.add(element);
        }
    }

    //remote element
    public void remote(T element){
        elements.remove(element);
    }

    //search min element
    public T findMin(){
        if(elements.isEmpty()) return null;
        T min = elements.get(0);
        for(T el : elements){
            if(el.compareTo(min) < 0){
                min = el;
            }
        }
        return min;
    }

    public void printAll(){
        for(T el : elements){
            System.out.println(el);

        }
    }
}
