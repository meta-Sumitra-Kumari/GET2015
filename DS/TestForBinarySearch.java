import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author Sumitra
 *test case for BinarySearch.
 */
public class TestForBinarySearch {

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
	public void testForSameAndLeftMost() {
		int a[]={1,1,1,1,1};
		
		assertEquals(0,BinarySearch.binarySearch(1, 0, 4, 1, a));
	}
	
	@Test
	public void testForSameAndRighttMost() {
		int a[]={1,1,1,1,1};
		
		assertEquals(4,BinarySearch.binarySearch(1, 0, 4, 2, a));
	}
	
	@Test
	public void testForDifferentAndLeftttMost() {
		int a[]={1,2,2,3,4};
		
		assertEquals(1,BinarySearch.binarySearch(2, 0, 4, 1, a));
	}
	
	@Test
	public void testForDifferentAndRighttMost() {
		int a[]={1,2,2,3,4};
		
		assertEquals(2,BinarySearch.binarySearch(2, 0, 4, 2, a));
	}

	@Test
	public void testForAllDifferentAndRighttMost() {
		int a[]={1,2,3,4,5};
		
		assertEquals(4,BinarySearch.binarySearch(5, 0, 4, 2, a));
	}
	@Test
	public void testForAllDifferentAndLefttMost() {
		int a[]={1,2,3,4,5};
		
		assertEquals(4,BinarySearch.binarySearch(5, 0, 4, 1, a));
	}
	@Test
	public void testForNotPresent() {
		int a[]={1,2,3,4,5};
		
		assertNotEquals(-1,BinarySearch.binarySearch(9, 0, 4, 1, a));
	}

}
