package org.superbiz.moviefun.rpi;

import junit.framework.TestCase;

//emptszgtrmwrtgrow

public class MapTest extends TestCase{

	Map empty = new Map();
	Map one = new Map();
	Map many = new Map();
	
	protected void setUp() {
		one.put(1, "victor");
		many.put(1, "victor");
		many.put(2, "sanjeev");
	}
	
	public void testEmpty() {
		assertTrue(empty.isEmpty());
		assertFalse(one.isEmpty());
		assertFalse(many.isEmpty());
	}
	
	public void testSize() {
		assertEquals(0, empty.size());
		assertEquals(1, one.size());
//		assertTrue(many.size() > 1);
		assertEquals(2, many.size());
	}
	
	public void testGet() {
		assertEquals(null, empty.get(1));
		
		assertEquals("victor", one.get(1));
		assertEquals(null, one.get(2));
		
		assertEquals("victor", many.get(1));
		assertEquals("sanjeev", many.get(2));
		assertEquals(null, many.get(3));
	}
	
	public void testRemove() {
		Map map = new Map();
		map.put(1, "victor");
		map.put(2, "sanjeev");
		map.remove(1);
		assertEquals("sanjeev", map.get(2));
		assertEquals(null, map.get(1));
		assertEquals(1, map.size());
		
		map.remove(3);
		assertEquals(1, map.size());
	}
	
	public void testOverwrite() {
		Map map = new Map();
		map.put(1, "v");
		map.put(1, "k");
		assertEquals("k", map.get(1));
		assertEquals(1, map.size());
	}
	
	public void testGrow() {
		Map map = new Map();
		int limit = 11000;
		for(int i=0;i<limit;i++) {
			map.put(i, "" + i);
		}
		assertEquals(limit, map.size());
	}
	
}

