package org.superbiz.moviefun.rpi;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class RajeshDequeTest {

    // A double-ended queue or deque is a generialization of a stack and queue that
    // supports adding and removing items from either the front or the back of te data structure.
    //   | |

    private RajeshDeque objectUnderTest;

    @Before
    public void setUp() {
        objectUnderTest = new RajeshDeque();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullpointerByAddingNullAsFirstElement(){
        objectUnderTest.addFirst(null);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(objectUnderTest.isEmpty());
        assertFalse(objectUnderTest.isEmpty());

    }

    @Test
    public void shouldReturnFirstItem() {
        // when
        objectUnderTest.addFirst("foo");
        assertFalse(objectUnderTest.isEmpty());
        assertEquals(1, objectUnderTest.size());
        Iterator iter = objectUnderTest.iterator();
        assertEquals("foo", iter.next());
        objectUnderTest.addFirst("zoo");
        assertEquals("zoo", iter.next());
    }
}
