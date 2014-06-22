package pl.com.agora.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.text.html.parser.Entity;

import org.junit.Test;

public class CollectionTest {

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

        System.out.println(a);

    }

    @Test
    public void mapIterator() {
        Map<String, String> a = new HashMap<>();
        for (Map.Entry<String, String> entry : a.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
    }

    @Test
    public void shouldCheckCopyOnWriteArrayList() {
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
        a.clear();
        System.out.println(iter.next());
    }

    @Test
    public void shouldCheckHashCode() {

        String a = "a";
        String b = new String("a");
        System.out.println(a.hashCode() + " " + b.hashCode());
    }

    @Test
    public void shouldTestInstantOff() {

        A a = new C();
        A b = new B();
        A c = new C();

        System.out.println("A b = new B(); " + b.getClass());
        System.out.println("A b = new B(); instanceof A=" + (b instanceof A));

        System.out.println("b.equals(a)" + b.equals(a));
        System.out.println("c.equals(a)" + c.equals(a));

    }

    class A {

    }

    class B extends A {
        public boolean equals(Object obj) {
            if (!(obj instanceof B)) {
                return false;
            }
            B a =  (B)obj;
            return true;

        }
    }

    class C extends B {
        public boolean equals(Object obj) {

            if (getClass() != obj.getClass()) {
                return false;
            }
            C c =  (C)obj;
            return true;

        }
    }
}
