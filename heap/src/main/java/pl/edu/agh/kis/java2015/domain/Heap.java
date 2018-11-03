package pl.edu.agh.kis.java2015.domain;

import java.util.ArrayList;

public class Heap {

    private int heapSize = 0;
    private ArrayList<Double> tab = new ArrayList<>();

    public void insert(double value) {
        int currentIndex = heapSize;
        int parentIndex = parentIndex(currentIndex);
        tab.add(value);
        while (isChildGreaterThanParent(currentIndex, parentIndex)) {
            swapElements(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = parentIndex(currentIndex);
        }
        heapSize++;
    }
    public void display(){
        for (double i : tab){
            System.out.println(i);
        }
    }

    public boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
        return tab.get(currentIndex) > tab.get(parentIndex);
    }

    public void swapElements(int currentIndex, int parentIndex) {
        Double parentValue = parentValue(currentIndex);
        Double currentValue = tab.get(currentIndex);
        tab.set(parentIndex, currentValue);
        tab.set(currentIndex, parentValue);
    }

    public Double parentValue(int currentIndex) {
        Double parentValue = tab.get(parentIndex(currentIndex));
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

    public double top() {
        return tab.get(0);
    }

    public void maxheapify(ArrayList<Double>tab,int i){
        int l=leftIndex(i);
        int r=rightIndex(i);
        int largest;
        if(l<heapSize && tab.get(l)>tab.get(i)){
            largest=l;
        }else largest=i;
        if(r<heapSize && tab.get(r)>tab.get(largest)){
            largest=r;
        }
        if(largest!=i){
            double ivalue=tab.get(i);
            double larvalue=tab.get(largest);
            tab.set(i,larvalue);
            tab.set(largest,ivalue);
            maxheapify(tab,largest);
        }

    }

    public double extractmax() {
        double max = tab.get(0);
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
    public double replace(double n){
        double max=tab.get(0);
        tab.set(0,n);
        if(n<max){
            maxheapify(tab,0);
        }
        return tab.get(0);
    }
}
