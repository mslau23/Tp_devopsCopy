package datastruct;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyUnsortedListTest {


	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/


	//Tests isEmpty()
	@Test
	public void testIsEmptyWithEmptyList() {
		UnsortedList<String> emptyList = MyUnsortedList.of();
		assertTrue(emptyList.isEmpty());
	}

	@Test
	public void testIsEmptyWithNotEmptyList() {
		UnsortedList<String> notEmptyList = MyUnsortedList.of("element");
		notEmptyList.append("element");
		assertFalse(notEmptyList.isEmpty());
	}

	//Test size()
	@Test
	public void sizeEmpty() {
		UnsortedList<String> emptyList = MyUnsortedList.of();
		assertEquals(emptyList.size(),0);
	}
	@Test
	public void sizeNotEmpty() {
		UnsortedList<String> notEmptyList = MyUnsortedList.of("element");
		assertEquals(notEmptyList.size(),1);
	}

	//Test prepend(E element)
	//test de la taille
	@Test
	public void preprendEmptyListSize() {
		UnsortedList<String> emptyList = MyUnsortedList.of();
		emptyList.prepend("element");
		assertTrue(emptyList.size()==1);
	}
	@Test
	public void preprendNotEmptyListSize() {
		UnsortedList<String> notEmptyList = MyUnsortedList.of("element");
		notEmptyList.prepend("element");
		assertTrue(notEmptyList.size()==2);
	}

	//test du contenu
	public void prependListElement() {
		UnsortedList<String> listA = MyUnsortedList.of();
		UnsortedList<String> listB = MyUnsortedList.of();
		String element = new String("element");
		listA.prepend(element);
		listB.insert(element, 0);
		assertEquals(listA, listB);
	}

	//Test append(E element)
	@Test
	public void apprendEmptyListSize() {
		UnsortedList<String> emptyList = MyUnsortedList.of();
		emptyList.prepend("element");
		assertTrue(emptyList.size()==1);
	}
	@Test
	public void apprendNotEmptyListSize() {
		UnsortedList<String> notEmptyList = MyUnsortedList.of("element");
		notEmptyList.prepend("element");
		assertTrue(notEmptyList.size()==2);
	}

	//test du contenu
	@Test
	public void apprendListElement() {
		UnsortedList<String> listA = MyUnsortedList.of();
		UnsortedList<String> listB = MyUnsortedList.of();
		String element = new String("element");
		listA.append(element);
		listB.insert(element, listB.size());
		assertEquals(listA, listB);
	}


	//Test insert(E element, int pos)
	@Test
	public void insertSpePos() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,4);
		list.insert(3, 2);
		assertEquals(4, list.size());
	}
	@Test
	public void insertInvalidPos() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2);
		assertThrows(
				IndexOutOfBoundsException.class, () -> {
					list.insert(3,5);}
				);
		assertThrows(
				IndexOutOfBoundsException.class, () -> {
					list.insert(3,-1);}
				);
	}
	@Test
	public void insertBegining() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2);
		list.insert(0, 0);
		assertEquals(3, list.size());	
	}
	@Test
	public void insertEnd() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2);
		list.insert(3, list.size());
		assertEquals(3, list.size());
	}

	//Test pop()
	@Test
	public void popEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertThrows(EmptyListException.class, () -> list.pop());
	}
	@Test
	public void popNotEmptyElement() {
		UnsortedList<Integer> listA = MyUnsortedList.of(0,1);
		assertEquals(Integer.valueOf(0), listA.pop());
	}
	@Test
	public void popNotEmptySize() {
		UnsortedList<Integer> listA = MyUnsortedList.of(0,1);
		listA.pop();
		assertEquals(1, listA.size());
	}

	//Test popLast()
	@Test
	public void popLastEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertThrows(EmptyListException.class, () -> list.popLast());
	}
	@Test
	public void popLastNotEmptyElement() {
		UnsortedList<Integer> listA = MyUnsortedList.of(0,1);
		assertEquals(Integer.valueOf(1), listA.popLast());
	}
	@Test
	public void popLastNotEmptySize() {
		UnsortedList<Integer> listA = MyUnsortedList.of(0,1);
		listA.popLast();
		assertEquals(1, listA.size());
	}

	//Test remove(int pos)
	@Test
	public void removeSpePos() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3);
		list.remove(2);
		assertEquals(2, list.size());
	}
	@Test
	public void removeInvalidPos() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2);
		assertThrows(
				IndexOutOfBoundsException.class, () -> {
					list.remove(3);}
				);
		assertThrows(
				IndexOutOfBoundsException.class, () -> {
					list.remove(-1);}
				);
	}
	@Test
	public void removeBegining() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2);
		list.remove(0);
		assertEquals(1, list.size());
	}
	@Test
	public void removeEnd() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2);
		list.remove(list.size()-1);
		assertEquals(1, list.size());
	}
}
