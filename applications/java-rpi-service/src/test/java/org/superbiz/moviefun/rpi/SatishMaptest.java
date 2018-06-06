package org.superbiz.moviefun.rpi;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class SatishMaptest {
    //extends TestCase {

    SatishMap empty = new SatishMap();
    SatishMap one = new SatishMap();
    SatishMap many = new SatishMap();

    @Before
    protected void setUp() {
        one.put("1", "satish");
        many.put("1", "satish");
        many.put("2", "kris");

    }

    @Test
    public void testIsEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(one.isEmpty());
        assertFalse(many.isEmpty());


        assertThat(empty.isEmpty(), is(true));
    }

    @Test
    public void testSize() {
        assertEquals(0, empty.size());
        assertEquals(1, one.size());
        assertTrue(many.size() > 1);
    }

    @Test
    public void testGet() {
        assertNull(empty.get("1"));
        assertNotNull(one.get("1"));
        assertNull(one.get("2"));
        assertNull(many.get("3"));
        assertEquals("satish", one.get("1"));
        assertEquals("satish", many.get("1"));
        assertEquals("kris", many.get("2"));
    }


}
