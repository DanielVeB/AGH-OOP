package pl.edu.agh.kis.java2015.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class Heap<T extends Comparable<T>>{

    private int heapSize = 0;
    private ArrayList<T> tab = new ArrayList<>();

    public void insert(T value) {
        int currentIndex = heapSize;
        int parentIndex = parentIndex(currentIndex);
        tab.add(value);
        while (isChildGreaterThanParent(currentIndex, parentIndex)==1) {
            swapElements(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = parentIndex(currentIndex);
        }
        heapSize++;
    }
    public void display(){
        for (T i : tab){
            System.out.println(i);
        }
    }

    public int isChildGreaterThanParent(int currentIndex, int parentIndex) {
        return tab.get(currentIndex).compareTo(tab.get(parentIndex));
    }

    public void swapElements(int currentIndex, int parentIndex) {
        T parentValue = parentValue(currentIndex);
        T currentValue = tab.get(currentIndex);
        tab.set(parentIndex, currentValue);
        tab.set(currentIndex, parentValue);
    }

    public T parentValue(int currentIndex) {
        T parentValue = tab.get(parentIndex(currentIndex));
        return parentValue;
    }

    public int parentIndex(int currentIndex) {
        return (currentIndex-1)/2;
    }
    public int leftIndex(int currentIndex){
        return 2*currentIndex+1;
    }
    public int rightIndex(int currentIndex){
        return 2*currentIndex+2;
    }

    public int size() {
        return heapSize;
    }

    public T top() {
        return tab.get(0);
    }

    public void maxheapify(ArrayList<T>tab,int i){
        int l=leftIndex(i);
        int r=rightIndex(i);
        int largest;
        if(l<heapSize && tab.get(l).compareTo(tab.get(i))==1){
            largest=l;
        }else largest=i;
        if(r<heapSize && tab.get(r).compareTo(tab.get(largest))==1){
            largest=r;
        }
        if(largest!=i){
            T ivalue=tab.get(i);
            T larvalue=tab.get(largest);
            tab.set(i,larvalue);
            tab.set(largest,ivalue);
            maxheapify(tab,largest);
        }

    }

    public T extractmax() {
        T max = tab.get(0);
        tab.set(0,tab.get(tab.size()-1));
        tab.remove(tab.size()-1);
        heapSize-=1;
        maxheapify(tab,0);
        return max;
    }
    public void deletemax(){
        extractmax();
    }

    /**
     * replace max element with new value
     *
     * @param n the value we replace max element of heap
     * @return new max element of heap
     */
    public T replace(T n){
        T max=tab.get(0);
        tab.set(0,n);
        if(max.compareTo(n)==1){
            maxheapify(tab,0);
        }
        return tab.get(0);
    }
    public void heapify(LinkedList<T>d){
        for (T obj: d){
            insert(obj);
        }
    }

}
