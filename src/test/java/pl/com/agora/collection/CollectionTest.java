package pl.com.agora.collection;

import static java.lang.String.format;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class CollectionTest {

	@Test
	public void mapIterator() {
		Map<String, String> a = new HashMap<>();
		for (Map.Entry<String, String> entry : a.entrySet()) {
			entry.getKey();
			entry.getValue();
		}
	}

	// CopyOnWriteArrayList vs ArrayList
	@Test
	public void shouldCheckCopyOnWriteArrayList() {
		// given
		List<String> a = new CopyOnWriteArrayList<>();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("d");
		a.add("e");
		a.add("f");
		a.add("g");
		a.add("h");

		Iterator<String> iter = a.iterator();
		System.out.println(iter.next());
		// then
		a.clear();
		// when
		System.out.println(iter.next());
	}

	@Test
	public void shouldCheckHashCode() {

		String a = "a";
		String b = new String("a");
		System.out.println(a.hashCode() + " " + b.hashCode());
	}

	@Test
	public void shouldCheckCapacity() {

		int oldCapacity = 100;

		int newCapacity = oldCapacity + (oldCapacity >> 1);

		System.out.println(newCapacity);

		oldCapacity = newCapacity;
		newCapacity = oldCapacity + (oldCapacity >> 1);
		System.out.println(newCapacity);

		oldCapacity = newCapacity;
		newCapacity = oldCapacity + (oldCapacity >> 1);
		System.out.println(newCapacity);

	}

	@Test
	public void shouldTestInstantOff() {
		// given
		A a = new A();
		A b = new B();
		// then
		System.out.println("a.equalsInstans(b)" + a.equalsInstans(b));
		System.out.println("a.equalsGetClass(b)" + a.equalsGetClass(b));

	}

	class A {

		public boolean equalsInstans(Object obj) {
			if (!(obj instanceof A)) {
				return false;
			}
			A a = (A) obj;
			return true;

		}

		public boolean equalsGetClass(Object obj) {
			if (getClass() != obj.getClass()) {
				return false;
			}
			A a = (A) obj;
			return true;

		}

	}

	class B extends A {

	}

	// @Test
	public void shouldCheckHashMap() {
		HashMap<User, String> hashmaps = new HashMap<User, String>();
		User user = new User(1, "Imie");
		User userNext = new User(1, "Imie");
		hashmaps.put(user, "");
		hashmaps.put(userNext, "");

		System.out.println(format("HashMapa %s", hashmaps));
	}

	// @Test
	public void shouldCheckRetainAll() {

		ArrayList<String> a = new ArrayList<>();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("d");
		a.add("e");
		a.add("f");
		a.add("g");
		a.add("h");

		List<String> b = new ArrayList<>();
		b.add("c");
		b.add("d");
		b.add("e");
		b.add("f");
		b.add("g");
		b.add("h");

		boolean abc = a.retainAll(b);

		System.out.println();
		System.out.println(a);
	}

	// @Test
	public void shuldReturnSizeList() {

		long startTime = System.nanoTime();

		ArrayList<Integer> a = new ArrayList<Integer>(1000000);
		for (int i = 0; i < 10000000; i++) {
			a.add(i);
		}

		long endTime = System.nanoTime();

		long duration = endTime - startTime;

		System.out.println(String.format("duration ArrayList [%s]",
				TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS)));

		long startTime2 = System.nanoTime();

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		for (int i = 0; i < 10000000; i++) {
			a2.add(i);
		}

		long endTime2 = System.nanoTime();

		long duration2 = endTime2 - startTime2;

		System.out.println(String.format("duration ArrayList 2 [%s]",
				TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS)));

		long startTime3 = System.nanoTime();

		LinkedList<Integer> b = new LinkedList<Integer>(a);
		for (int i = 0; i < 10000000; i++) {
			b.add(i);
		}

		long endTime3 = System.nanoTime();

		long duration3 = endTime3 - startTime3;

		System.out.println(String.format("duration LinkedList [%s]",
				TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS)));

	}

	/* kolejka porownanie do ArrayList */
	// @Test
	public void shouldCCheckQueue() {
		System.out.println("kolejka porownanie do ArrayList");
		ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
		arrayDeque.add(5);
		arrayDeque.add(4);
		arrayDeque.add(3);
		arrayDeque.add(2);
		arrayDeque.add(1);

		System.out.println(arrayDeque.getLast());
		System.out.println(arrayDeque.peek());

	}

}
