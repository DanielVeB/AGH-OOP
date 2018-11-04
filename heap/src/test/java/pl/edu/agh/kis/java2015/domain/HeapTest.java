package pl.edu.agh.kis.java2015.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HeapTest {
	
	@Test
	public void insert0intoNewHeap_topIs0() {
		
		Heap heap = new Heap();
		heap.insert(0);
		
		assertEquals("size should be 1",1,heap.size());
		assertEquals(0,(int)heap.top(),0.001);
		assertEquals(1,heap.size());
	}
	
	@Test
	public void insert0AndThen2intoNewHeap_topIs2() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		
		assertEquals("size should be 2",2,heap.size());
		assertEquals(2,(int)heap.top(),0.001);
	}
	
	@Test
	public void insert0And2And3And5And6intoNewHeap_topIs6() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		
		assertEquals(6,(int)heap.top(),0.001);
	}

	@Test
	public void extracMaxElementAndReturnValue(){
		Heap heap=new Heap();
		heap.insert(1);
		heap.insert(20);
		heap.insert(13);
		heap.insert(51);
		heap.insert(121);
		heap.insert(123);
		heap.insert(132);
		heap.insert(11);

		assertEquals(132,(int)heap.extractmax());
		assertEquals(123,(int)heap.extractmax());
		assertEquals(121,(int)heap.extractmax());

	}
	@Test
    public void deleteMaxElement(){
        Heap heap=new Heap();
        heap.insert(1.);
        heap.insert(20.);
        heap.insert(13.);
        heap.insert(51.);
        heap.insert(121.31);
        heap.insert(123.);
        heap.insert(132.);
        heap.insert(11.1);

        heap.deletemax();
        assertEquals(7,heap.size());

    }
    @Test
    public void replaceMaxElementWithNewValue(){
        Heap heap=new Heap();
        heap.insert(1);
        heap.insert(5);
        heap.insert(2);
        heap.insert(10);
        heap.insert(4);

        assertEquals(5,heap.replace(2));
        assertEquals(12,heap.replace(12));

    }
    @Test
    public void createNewHeap(){
        Heap heap=new Heap();
        LinkedList<Double>linkedList= new LinkedList<Double>(){{
            add(1.0);
            add(12.01);
            add(2.3);
            add(212.3);
            add(13.23);
            add(2.3);
            add(33.1);
            add(21.3);
            add(85.);
        }};
        heap.heapify(linkedList);

        assertEquals(212.3,(double)heap.extractmax(),0.001);
        assertEquals(85,(double)heap.extractmax(),0.001);

    }

}
