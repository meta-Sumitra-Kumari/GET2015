package Sorting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Sumitra
 *this is to test sorting
 */
public class TestForSorting {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testForBubbleSort() {
	int a[]={2,1,34,56,234,12};
	BubbleSort bubble=new BubbleSort();
	int expected[]={1,2,12,34,56,234};
	bubble.bubbleSort(a);
	assertArrayEquals(expected,a);
	}
	@Test
	public void testForquickSort() {
	int a[]={2,1,34,56,234,121};
	QuickSort quick=new QuickSort();
	quick.sort(a, 0, 5);
	int expected[]={1,2,34,56,121,234};
	
	assertArrayEquals(expected,a);
	}
	@Test
	public void testForCountingSort() {
	int a[]={5,3,2,1,4,9};
	CountingSort counting =new CountingSort();
	counting.countingSort(a);
	int expected[]={1,2,3,4,5,9};
	
	assertArrayEquals(expected,a);
	}
	@Test
	public void testForRadixSort() {
	int a[]={6,5,4,3,4,2,11,234};
	RadixSort radix=new RadixSort();
	radix.radixSort(a);
	int expected[]={2,3,4,4,5,6,11,234};
	
	assertArrayEquals(expected,a);
	}
	@Test
	public void testForRadixSortAgain() {
	int a[]={6666,54,4,3,434,2,11,234};
	RadixSort radix=new RadixSort();
	radix.radixSort(a);
	int expected[]={2,3,4,11,54,234,434,6666};
	
	assertArrayEquals(expected,a);
	}

}
