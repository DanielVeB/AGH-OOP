package pl.edu.agh.kis.java2015.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTest {
	
	@Test
	public void insert0intoNewHeap_topIs0() {
		
		Heap heap = new Heap();
		heap.insert(0);
		
		assertEquals("size should be 1",1,heap.size());
		assertEquals(0,heap.top(),0.001);
		assertEquals(1,heap.size());
	}
	
	@Test
	public void insert0AndThen2intoNewHeap_topIs2() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		
		assertEquals("size should be 2",2,heap.size());
		assertEquals(2,heap.top(),0.001);
	}
	
	@Test
	public void insert0And2And3And5And6intoNewHeap_topIs6() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		
		assertEquals(6,heap.top(),0.001);
	}

	@Test
	public void extracMaxElementAndReturnValue(){
		Heap heap=new Heap();
		heap.insert(1);
		heap.insert(20);
		heap.insert(13);
		heap.insert(51);
		heap.insert(121.31);
		heap.insert(123);
		heap.insert(132);
		heap.insert(11.1);

		assertEquals(132,heap.extractmax(),0.001);
		assertEquals(123,heap.extractmax(),0.001);
		assertEquals(121.31,heap.extractmax(),0.001);

	}
	@Test
    public void deleteMaxElement(){
        Heap heap=new Heap();
        heap.insert(1);
        heap.insert(20);
        heap.insert(13);
        heap.insert(51);
        heap.insert(121.31);
        heap.insert(123);
        heap.insert(132);
        heap.insert(11.1);

        heap.deletemax();
        assertEquals(7,heap.size());

    }
    @Test
    public void replaceMaxElementWithNewValue(){
        Heap heap=new Heap();
        heap.insert(1);
        heap.insert(20);
        heap.insert(13);
        heap.insert(51);
        heap.insert(123);

        assertEquals(51,heap.replace(43),0.001);
        assertEquals(56,heap.replace(56),0.001);

    }

}
