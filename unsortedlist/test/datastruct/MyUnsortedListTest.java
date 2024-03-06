package datastruct;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyUnsortedListTest {
	
	MyUnsortedList<Integer> emptyList;
	MyUnsortedList<Integer> filledList;
	
	@Before
	public void setUp() 
	{
		emptyList = MyUnsortedList.of();
		filledList = MyUnsortedList.of(1,2,3);
	}
	
	@Test
	public void isEmptyTest()
	{	
		assertTrue("List is empty",emptyList.isEmpty());
		assertFalse("List has elements",filledList.isEmpty());
	}
	
	@Test
	public void sizeTest() 
	{
		assertEquals(0,emptyList.size());
		assertEquals(3,filledList.size());
//		System.out.println("Test passed");
	}
	
	@Test
	public void prependTest() 
	{
		filledList.prepend(5);
		emptyList.prepend(1);
		assertTrue(5 == filledList.getHead());
		assertTrue(1 == emptyList.getHead());
		assertFalse(6 == filledList.getHead());
	}
	
	@Test
	public void appendTest()
	{
		filledList.append(4);
		emptyList.append(5); 
		emptyList.append(6);
		assertEquals("Lists are equal",MyUnsortedList.of(1,2,3,4), filledList);
		assertNotEquals("Lists are not equal",MyUnsortedList.of(5,6,7), emptyList);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertTest() throws Exception
	{
		//exception case
		filledList.insert(5, -1);
		filledList.insert(6, 4);
		//normal functionality testing
		filledList.insert(5, 2);
		assertEquals("Lists are equals",MyUnsortedList.of(1,2,5,3), filledList);
		filledList.insert(6, 3);
		assertNotEquals("Lists are not equal",MyUnsortedList.of(1,2,5,3),filledList);
		//test of case position == 0
		emptyList.insert(1, 0);
		assertEquals("Lists are equal",MyUnsortedList.of(1),emptyList);
	}
	
	@Test(expected = EmptyListException.class)
	public void popTest()
	{
		//exception case 
		emptyList.pop();
		
		//basic Testing 
		int expected = filledList.getHead();
		int expectedSize = filledList.size() - 1;
		int result = filledList.pop();
		assertTrue("Popped the right head lol", expected == result);
		assertTrue("Same size", expectedSize == filledList.size());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeTest() 
	{	
		//exception case 
		filledList.remove(-1);
		filledList.remove();
		
	}
}
