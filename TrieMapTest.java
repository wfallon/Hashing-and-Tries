import static org.junit.Assert.*;

import org.junit.Test;

public class TrieMapTest {

    @Test
    public void test() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put("key", 1);
        map.put("kentucky", 2);
        map.put("hello", 3);
        assertEquals(Integer.valueOf(1), map.get("key"));
        assertEquals(Integer.valueOf(2), map.get("kentucky"));
        assertEquals(Integer.valueOf(3), map.get("hello"));
        assertNull(map.get("kentuck"));
        assertEquals(3, map.size());
        assertEquals(Integer.valueOf(2), map.remove("kentucky"));
        assertEquals(2, map.size());
        assertEquals(Integer.valueOf(1), map.get("key"));
        map.put("kentucky", 2);
        assertEquals(3, map.size());
        assertEquals(Integer.valueOf(2), map.get("kentucky"));
        assertEquals(Integer.valueOf(1), map.remove("key"));
        assertEquals(2, map.size());
        //assertEquals(Integer.valueOf(3), map.remove("hello"));
        assertEquals(Integer.valueOf(2), map.remove("kentucky"));
    }
    
    @Test
    public void testPut() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put("key", 1);
        map.put("kentucky", 2);
        map.put("kentuckyo", 4);
        map.put("hello", 3);
        assertEquals(Integer.valueOf(1), map.get("key"));
        assertEquals(Integer.valueOf(2), map.get("kentucky"));
        assertEquals(Integer.valueOf(3), map.get("hello"));
        assertEquals(Integer.valueOf(4), map.get("kentuckyo"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testPutIllegalKey() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put(null, 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testPutIllegalValue() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put("hi", null);
    }
    
    @Test
    public void testGet() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put("key", 1);
        map.put("kentucky", 2);
        map.put("kentuckyo", 4);
        map.put("hello", 3);
        assertEquals(Integer.valueOf(1), map.get("key"));
        assertEquals(Integer.valueOf(2), map.get("kentucky"));
        assertEquals(Integer.valueOf(3), map.get("hello"));
        assertEquals(Integer.valueOf(4), map.get("kentuckyo"));
        assertNull(map.get("hi"));
        assertNull(map.get("kentuck"));
        assertNull(map.get("kentuckyoo"));
    }
    
    @Test
    public void testGetEmpty() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        assertNull(map.get("hi"));
        map.put("kentucky", 2);
        map.put("kentuckyo", 4);
        map.remove("kentucky");
        assertNull(map.get("kentucky"));
        map.remove("kentuckyo");
        assertNull(map.get("kentuckyo"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetIllegalKey() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put("hi", 1);
        map.get(null);
        
    }
    
    @Test
    public void testContainsKey() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put("key", 1);
        map.put("kentucky", 2);
        map.put("kentuckyo", 4);
        map.put("hello", 3);
        assertTrue(map.containsKey("key"));
        assertTrue(map.containsKey("kentucky"));
        assertTrue(map.containsKey("kentuckyo"));
        assertTrue(map.containsKey("hello"));
        map.remove("hello");
        assertFalse(map.containsKey("hello"));
        map.remove("kentucky");
        assertFalse(map.containsKey("kentucky"));
        assertTrue(map.containsKey("kentuckyo"));
        assertTrue(map.containsKey("key"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testContainsKeyIllegalKey() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put("hi", 1);
        map.containsKey(null);
        
    }

    
    @Test
    public void testContainsValue() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put("key", 1);
        map.put("kentucky", 2);
        map.put("kentuckyo", 4);
        map.put("hello", 3);
        assertTrue(map.containsValue(1));
        assertTrue(map.containsValue(2));
        assertTrue(map.containsValue(3));
        assertTrue(map.containsValue(4));
        map.remove("hello");
        assertFalse(map.containsValue(3));
        map.remove("kentucky");
        assertFalse(map.containsValue(2));
        assertTrue(map.containsValue(4));
        assertTrue(map.containsValue(1));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testContainsValueIllegalValue() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put("hi", 1);
        map.containsValue(null);
        
    }
    
    @Test
    public void testRemove() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put("key", 1);
        map.put("kentucky", 2);
        map.put("kentuckyo", 4);
        map.put("hello", 3);
        map.remove("hello");
        assertNull(map.get("hello"));
        assertFalse(map.containsKey("hello"));
        assertFalse(map.containsValue(3));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveIllegalValue() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put("hi", 1);
        map.remove(null);
        
    } 
    
    @Test
    public void testClear() {
        TrieMap<Integer> map = new TrieMap<Integer>();
        map.put("key", 1);
        map.clear();
        assertEquals(0, map.size());
        assertNull(map.get("key"));
    }
}
