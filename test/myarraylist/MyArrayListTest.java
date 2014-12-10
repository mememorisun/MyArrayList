package myarraylist;

import mytest.*;
import static mytest.MyAssertion.*;

public class MyArrayListTest {

	@Test(expected = IllegalArgumentException.class)
	public void testMyArrayList0() {
		new MyArrayList(-1);
	}

	@Test
	public void testMyArrayList1() {
		new MyArrayList(0);
	}

	@Test
	public void testMyArrayList2() {
		new MyArrayList(11);
	}

	@Test
	public void testSize0() {
		MyArrayList list = new MyArrayList(0);
		assertEquals(0, list.size());
	}

	@Test
	public void testSize1() {
		MyArrayList list = new MyArrayList(0);
		list.add(1);
		assertEquals(1, list.size());
	}

	@Test
	public void testSize2() {
		MyArrayList list = new MyArrayList(100);
		list.add(1);
		assertEquals(1, list.size());
	}

	@Test
	public void testSize3() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(0);
		}
		assertEquals(11, list.size());
	}

	@Test
	public void testSize4() {
		MyArrayList list = new MyArrayList();
		for (int i = 0; i < 100; i++) {
			list.add(0);
		}
		assertEquals(100, list.size());
	}

	@Test
	public void testSize5() {
		MyArrayList list = new MyArrayList();
		assertEquals(0, list.size());
	}

	@Test
	public void testIsEmpty0() {
		MyArrayList list = new MyArrayList();
		assertTrue(list.isEmpty());

		list = new MyArrayList(0);
		assertTrue(list.isEmpty());
	}

	@Test
	public void testIsEmpty1() {
		MyArrayList list = new MyArrayList();
		list.add(0);

		assertFalse(list.isEmpty());
	}

	@Test
	public void testContains0() {
		MyArrayList list = new MyArrayList();
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}

		assertTrue(list.contains(9));
		assertFalse(list.contains(12));
	}

	@Test
	public void testIndexOf0() {
		MyArrayList list = new MyArrayList();
		for (int i = 0; i < 11; i++) {
			list.add(i % 4);
		}

		assertEquals(3, list.indexOf(3));
		assertEquals(-1, list.indexOf(5));
	}

	@Test
	public void testLastIndexOf0() {
		MyArrayList list = new MyArrayList();
		for (int i = 0; i < 11; i++) {
			list.add(i % 4);
		}

		assertEquals(7, list.lastIndexOf(3));
		assertEquals(-1, list.lastIndexOf(5));
	}

	@Test
	public void testLastIndexOf1() {
		MyArrayList list = new MyArrayList();

		assertEquals(-1, list.lastIndexOf(5));
	}

	@Test
	public void testToArray0() {
		MyArrayList list = new MyArrayList();
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}

		double[] expected = new double[11];
		for (int i = 0; i < 11; i++) {
			expected[i] = i;
		}

		assertArrayEquals(expected, list.toArray(), 0);
	}

	@Test
	public void testToArray1() {
		MyArrayList list = new MyArrayList(3);

		double[] expected = new double[0];

		assertArrayEquals(expected, list.toArray(), 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet0() {
		MyArrayList list = new MyArrayList();
		list.get(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet1() {
		MyArrayList list = new MyArrayList();
		list.add(0);
		list.get(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet2() {
		MyArrayList list = new MyArrayList();
		list.add(0);
		list.get(2);
	}

	@Test
	public void testGet3() {
		MyArrayList list = new MyArrayList();
		list.add(0);
		list.add(0);
		assertEquals(0, list.get(1), 0.01);
	}

	@Test
	public void testGet4() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		assertEquals(10, list.get(10), 0.01);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet5() {
		MyArrayList list = new MyArrayList(100);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		list.get(11);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet6() {
		MyArrayList list = new MyArrayList(100);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		list.get(-1);
	}

	@Test
	public void testGet7() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		assertEquals(0, list.get(0), 0.01);
	}

	@Test
	public void testSet0() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		list.set(10, 1);
		assertEquals(1, list.get(10), 0.01);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSet1() {
		MyArrayList list = new MyArrayList(100);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		list.set(11, 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSet2() {
		MyArrayList list = new MyArrayList(100);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		list.set(-1, 0);
	}

	@Test
	public void testSet3() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		list.set(0, 10);
		assertEquals(10, list.get(0), 0.01);
	}

	@Test
	public void testAdd0() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		assertEquals(10, list.get(10), 0.01);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAdd1() {
		MyArrayList list = new MyArrayList(100);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		list.add(11, 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAdd2() {
		MyArrayList list = new MyArrayList(100);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		list.add(-1, 0);
	}

	@Test
	public void testAdd3() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		list.add(0, 10);
		assertEquals(10, list.get(0), 0.01);
		assertEquals(0, list.get(1), 0.01);
	}

	@Test
	public void testAdd4() {
		MyArrayList list = new MyArrayList(100);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		list.add(10, 0);
		assertEquals(0, list.get(10), 0.01);
		assertEquals(10, list.get(11), 0.01);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove0() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}

		list.remove(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove1() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}

		list.remove(11);
	}

	@Test
	public void testRemove2() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		assertEquals(0, list.remove(0), 0.01);

		double[] expected = new double[10];
		for (int i = 1; i < 11; i++) {
			expected[i - 1] = i;
		}

		assertArrayEquals(expected, list.toArray(), 0.01);
	}

	@Test
	public void testRemove3() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i);
		}
		assertEquals(10, list.remove(10), 0.01);

		double[] expected = new double[10];
		for (int i = 0; i < 10; i++) {
			expected[i] = i;
		}

		assertArrayEquals(expected, list.toArray(), 0.01);
	}

	@Test
	public void testRemove4() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i % 4);
		}
		assertTrue(list.remove(0.0));

		double[] expected = new double[10];
		for (int i = 1; i < 11; i++) {
			expected[i - 1] = i % 4;
		}

		assertArrayEquals(expected, list.toArray(), 0.01);
	}

	@Test
	public void testRemove5() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i % 4);
		}
		assertTrue(list.remove(3.0));

		double[] expected = {0,1,2,0,1,2,3,0,1,2};

		assertArrayEquals(expected, list.toArray(), 0.01);
	}

	@Test
	public void testRemove6() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i % 4);
		}
		assertFalse(list.remove(4.0));

		double[] expected = {0,1,2,3,0,1,2,3,0,1,2};

		assertArrayEquals(expected, list.toArray(), 0.01);
	}


	@Test
	public void testClear0() {
		MyArrayList list = new MyArrayList(0);
		for (int i = 0; i < 11; i++) {
			list.add(i % 4);
		}
		list.clear();

		double[] expected = new double[0];

		assertArrayEquals(expected, list.toArray(), 0.01);
	}
}
