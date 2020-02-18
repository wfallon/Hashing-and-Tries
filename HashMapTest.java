import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class HashMapTest {

    @Test
    public void testGetSimple() {
        HashMap<String, Integer> map = new HashMap<String, Integer>(4);
        String str = "key";
        map.put(str, 1);
        assertEquals(Integer.valueOf(1), map.get(str));
    }
    
    
    @Test
    public void testGetAfterResize() {
        HashMap<String, Integer> map = new HashMap<String, Integer>(4);
        String str1 = "key1";
        String str2 = "key2";
        String str3 = "key3";
        String str4 = "key4";
        map.put(str1, 1);
        map.put(str2, 2);
        assertEquals(Integer.valueOf(1), map.get(str1));
        assertEquals(Integer.valueOf(2), map.get(str2));
        map.put(str3, 3);
        map.put(str4, 4);
        assertEquals(Integer.valueOf(1), map.get(str1));
        assertEquals(Integer.valueOf(2), map.get(str2));
        assertEquals(Integer.valueOf(3), map.get(str3));
        assertEquals(Integer.valueOf(4), map.get(str4));
    }
    
    @Test
    public void testGetKeyNotInMap() {
        HashMap<String, Integer> map = new HashMap<String, Integer>(4);
        String str1 = "key1";
        map.put(str1, 1);
        assertNull(map.get("hi"));
    }
    
    @Test
    public void testContainsKey() {
        HashMap<String, Integer> map = new HashMap<String, Integer>(4);
        String str1 = "key1";
        map.put(str1, 1);
        assertTrue(map.containsKey(str1));
    }
    
    @Test
    public void testRemove() {
        HashMap<String, Integer> map = new HashMap<String, Integer>(4);
        String str1 = "key1";
        map.put(str1, 1);
        assertEquals(1, map.size());
        assertEquals(Integer.valueOf(1), map.remove(str1));
        assertEquals(0, map.size());
    }
    
    @Test
    public void testRemove2() {
        HashMap<String, Integer> map = new HashMap<String, Integer>(4);
        String str1 = "key1";
        map.put(str1, 1);
        assertEquals(1, map.size());
        assertNull(map.remove("hi"));
        assertEquals(1, map.size());
    }
    
    @Test
    public void testClear() {
        HashMap<String, Integer> map = new HashMap<String, Integer>(4);
        String str1 = "key1";
        map.put(str1, 1);
        assertEquals(1, map.size());
        map.clear();
        assertEquals(0, map.size());
        assertFalse(map.containsKey(str1));
    }
    
    @Test
    public void testContainsValue() {
        HashMap<String, Integer> map = new HashMap<String, Integer>(4);
        String str1 = "key1";
        map.put(str1, 1);
        assertTrue(map.containsValue(1));
        assertFalse(map.containsValue(2));
    }
    
    @Test
    public void testIterator() {
        HashMap<String, Integer> map = new HashMap<String, Integer>(4);
        String str1 = "key1";
        String str2 = "key2";
        String str3 = "key3";
        String str4 = "key4";
        map.put(str1, 1);
        map.put(str2, 2);
        map.put(str3, 3);
        map.put(str4, 4);
        Iterator<Map.Entry<String, Integer>> iter = map.entryIterator();
        assertTrue(iter.hasNext());
        assertEquals(Integer.valueOf(4), iter.next().getValue());
        assertEquals(Integer.valueOf(3), iter.next().getValue());
        assertEquals(Integer.valueOf(2), iter.next().getValue());
        assertEquals(Integer.valueOf(1), iter.next().getValue());
        assertFalse(iter.hasNext());
    }
    
    
    @Test
    public void testWithNullKeys() {
        Object obj1 = new Object() {
            @Override
            public int hashCode() {  
                return 0;  
            }
        };
        HashMap<Object, Integer> map = new HashMap<Object, Integer>(4);
        map.put(obj1, 1);
        map.put(null, 2);
        assertEquals(Integer.valueOf(1), map.get(obj1));
        assertEquals(Integer.valueOf(2), map.get(null));
    }
    
    @Test
    public void testBehaviorWithSameHashCodes() {
        Object obj1 = new Object() {
            @Override
            public int hashCode() { 
                return 5; 
            }
        };

        Object obj2 = new Object() {
            @Override
            public int hashCode() { 
                return 5;  
            }
        };
        HashMap<Object, Integer> map = new HashMap<Object, Integer>(4);
        map.put(obj1, 1);
        map.put(obj2, 2);
        assertEquals(Integer.valueOf(1), map.get(obj1));
        assertEquals(Integer.valueOf(2), map.get(obj2));
        assertTrue(map.containsKey(obj1));
        assertFalse(map.containsKey("hi"));
        String str1 = "hi";
        String str2 = "hello";
        map.put(str1, 3);
        map.put(str2, 4);
        assertEquals(Integer.valueOf(1), map.get(obj1));
        assertEquals(Integer.valueOf(2), map.get(obj2));
        assertEquals(Integer.valueOf(3), map.get(str1));
        assertEquals(Integer.valueOf(4), map.get(str2));
        assertEquals(4, map.size());
        assertEquals(Integer.valueOf(1), map.remove(obj1));
        assertEquals(3, map.size());
        assertEquals(Integer.valueOf(2), map.get(obj2));
    }
}
