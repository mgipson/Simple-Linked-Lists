package testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import structures.LinkedList;

public class TestLL {
	 
	private LinkedList<String> myList;
    
    /**
     * Sets up the LinkedList for our testing.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception
    {
        myList = new LinkedList<String>();
    }

    /**
     * Checks to see if addFirst() works correctly.
     */
    @Test
    public void testAddFirst()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    }

    @Test
    public void testAddFirstNull()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addFirst(null);
    	assertTrue("First node should still be null!", myList.getFirst() == null);
    	assertTrue("Size should still be 0!", myList.size() == 0);
    }
    
    @Test
    public void testAddFirstTwice()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.addFirst("second first");
    	assertFalse("First node should not be 'first'!", myList.getFirst() == "first");
    	assertTrue("First node should be 'second first'!", myList.getFirst() == "second first");
    	assertTrue("Size should be 2!", myList.size() == 2);
    }
    
    /**
     * Checks to see if addLast() works correctly.
     */
    @Test
    public void testAddLast()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addLast("last");
    	assertTrue("Last node should be 'last'!", myList.getLast() == "last");
    	assertTrue("Size should be 1!", myList.size() == 1);
    }

    @Test
    public void testAddLastNull()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addLast(null);
    	assertTrue("Last node should still be null!", myList.getLast() == null);
    	assertTrue("Size should still be 0!", myList.size() == 0);
    }
    
    @Test
    public void testAddLastTwice()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addLast("last");
    	assertTrue("Last node should be 'last'!", myList.getLast() == "last");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.addLast("final last");
    	assertFalse("Last node should not be 'last'!", myList.getLast() == "last");
    	assertTrue("Last node should be 'final last'!", myList.getLast() == "final last");
    	assertTrue("Size should be 2!", myList.size() == 2);
    }
    
    /**
     * Checks to see if setFirst() works correctly.
     */
    @Test
    public void testSetFirst()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);

    	myList.setFirst("second first");
    	assertTrue("First node should have been set to 'second first'!", myList.getFirst() == "second first");
    	assertTrue("Size should still be 1!", myList.size() == 1);
    }
    
    @Test
    public void testSetFirstNull()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.setFirst(null); //means the list is empty
    	assertTrue("'First' should no longer be in list!", myList.contains("first") == false);
    	assertTrue("Size should still be 0!", myList.size() == 0);
    }
    
    @Test
    public void testSetFirstTwice()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.setFirst("second first");
    	assertFalse("First node should not be 'first'!", myList.getFirst() == "first");
    	assertTrue("'First' should no longer be in list!", myList.contains("first") == false);
    	assertTrue("First node should be 'second first'!", myList.getFirst() == "second first");
    	assertTrue("Size should still be 1!", myList.size() == 1);
    	
    	myList.setFirst("third first");
    	assertFalse("First node should not be 'second first'!", myList.getFirst() == "second first");
    	assertTrue("'Second first' should no longer be in list!", myList.contains("second first") == false);
    	assertTrue("First node should be 'third first'!", myList.getFirst() == "third first");
    	assertTrue("Size should still be 1!", myList.size() == 1);
    }
    
    @Test
    public void testSetFirstInEmptyList()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.setFirst("first"); //cannot set the first in a list if first has not been added
    	assertTrue("Size should still be 0!", myList.size() == 0);
    }
    
    /**
     * Checks to see if removeFirst() works correctly.
     */
    @Test
    public void testRemoveFirstOne()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.removeFirst();
    	assertTrue("'First' should no longer be in the list!", myList.contains("first") == false);
    	assertTrue("Size should be 0!", myList.size() == 0);
    }
    
    @Test
    public void testRemoveFirstMultiple()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.addLast("last");
    	assertTrue("Last node should be 'last'!", myList.getLast() == "last");
    	assertTrue("Size should be 2!", myList.size() == 2);
    	
    	myList.removeFirst();
    	assertTrue("'First' should no longer be in the list!", myList.contains("first") == false);
    	assertTrue("First node should now be 'last'!", myList.getFirst() == "last");
    	assertTrue("Size should be 1!", myList.size() == 1);
    }

    /**
     * Checks to see if removeLast() works correctly.
     */
    @Test
    public void testRemoveLastOne()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addLast("last");
    	
    	assertTrue("Last node should be 'last'!", myList.getLast() == "last");
    	assertTrue("First node should also be 'last'!", myList.getFirst() == "last");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.removeLast(); //really it's removing what's at the head
    	assertTrue("'Last' should no longer be in the list!", myList.contains("last") == false);
    	assertTrue("Size should be 0!", myList.size() == 0);
    }
    
    @Test
    public void testRemoveLastMultiple()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	assertTrue("Size should be 1!", myList.size() == 1);
    	myList.addLast("last");
    	assertTrue("Last node should be 'last'!", myList.getLast() == "last");
    	assertTrue("Size should be 2!", myList.size() == 2);
    	
    	myList.removeLast();
    	assertFalse("Last node shoul not be 'last' anymore!", myList.getFirst() == "last");
    	assertTrue("'Last' should no longer be in the list!", myList.contains("last") == false);
    	assertTrue("Size should be 1!", myList.size() == 1);
    }

    /**
     * Checks to see if remove() works correctly.
     */
    @Test
    public void testRemoveMiddle()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.addLast("third");
    	assertTrue("Last node should be 'third'!", myList.getLast() == "third");
    	assertTrue("Size should be 2!", myList.size() == 2);
    	
    	myList.insertBefore("second", "third");
    	assertTrue("Middle node should be 2!", myList.indexOf("second") == 1);
    	assertTrue("Size should be 3!", myList.size() == 3);

    	myList.remove("second");
    	assertFalse("Middle node should not be 'second'!", myList.indexOf("second") == 1);
    	assertTrue("'Second' should no longer be in the list!", myList.contains("second") == false);
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Last node should be 'third'!", myList.getLast() == "third");
    	assertTrue("Size should be 2!", myList.size() == 2);
    }
    
    @Test
    public void testRemoveNull()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.remove(null);
    	assertTrue("Cannot remove 'null' from the list!", myList.remove(null) == false);
    	assertTrue("Size should be 0!", myList.size() == 0);
    }
    
    @Test
    public void testRemoveElementNotIncluded()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);

    	myList.remove("second");
    	assertTrue("Cannot remove 'second' because it's not in the list!", myList.contains("second") == false);
    	assertTrue("Size should still be 1!", myList.size() == 1);
    }
    
    @Test
    public void testRemoveFromEmptyList()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.remove("string");
    	assertTrue("Cannot remove 'string' because list is empty!", myList.contains("string") == false);
    	assertTrue("Size should be 0!", myList.size() == 0);
    }
    
    /**
     * Checks to see if contains() works correctly.
     */
    @Test
    public void testContainsFirst()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	assertTrue("List should contain 'first'!", myList.contains("first") == true);
    }
    
    @Test
    public void testContainsLast()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addLast("last");
    	assertTrue("Last node should be 'last'!", myList.getLast() == "last");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	assertTrue("List should contain 'last'!", myList.contains("last") == true);
    }
    
    @Test
    public void testContainsMiddle()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.addLast("third");
    	assertTrue("Last node should be 'third'!", myList.getLast() == "third");
    	assertTrue("Size should be 2!", myList.size() == 2);
    	
    	myList.insertBefore("second", "third");
    	assertTrue("Middle node should be 'second'!", myList.indexOf("second") == 1);
    	assertTrue("Size should be 3!", myList.size() == 3);
    	
    	assertTrue("List should contain 'second'!", myList.contains("second") == true);
    }

    @Test
    public void testContainsElementNotIncluded()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.addLast("third");
    	assertTrue("Last node should be 'third'!", myList.getLast() == "third");
    	assertTrue("Size should be 2!", myList.size() == 2);
    	
    	myList.insertBefore("second", "third");
    	assertTrue("Middle node should be 2!", myList.indexOf("second") == 1);
    	assertTrue("Size should be 3!", myList.size() == 3);

    	assertTrue("List does not contain 'fourth'!", myList.contains("fourth") == false);
    }
    
    
    
    /**
     * Checks to see if insertBefore() works correctly.
     */
    @Test
    public void testInsertBeforeFirst()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.insertBefore("new first", "first");
    	assertFalse("First node should no longer be 'first'!", myList.getFirst() == "first");
    	assertTrue("First node should now be 'new first'!", myList.getFirst() == "new first");
    	assertTrue("Size should be 2!", myList.size() == 2);
    }
    
    @Test
    public void testInsertBeforeNull()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.insertBefore("last", null);
    	assertTrue("Last node (node before null) should be 'last'!", myList.getLast() == "last");
    	assertTrue("Size should be 2!", myList.size() == 2);
    }
    
    @Test
    public void testInsertBeforeMiddle()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.addLast("third");
    	assertTrue("Last node should be 'third'!", myList.getLast() == "third");
    	assertTrue("Size should be 2!", myList.size() == 2);
    	
    	myList.insertBefore("second", "third");
    	assertTrue("Middle node should be 2!", myList.indexOf("second") == 1);
    	assertTrue("Size should be 3!", myList.size() == 3);
    }
    
    @Test
    public void testInsertBeforeElementNotIncluded()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.insertBefore("second", "third");
    	assertTrue("Cannot insert before a node that isn't in the list!", myList.contains("third") == false);
    	assertTrue("Size should still be 1!", myList.size() == 1);
    }
    
    @Test
    public void testInsertBeforeInEmptyList()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	
    	myList.insertBefore("string", null);
    	assertTrue("Cannot insert when list is empty!", myList.contains(null) == false);
    	assertTrue("Size should be 0!", myList.size() == 0);
    }
    
    /**
     * Checks to see if indexOf() works correctly.
     */
    @Test
    public void testIndexOfOneElementListFirst()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	myList.indexOf("first");
    	assertTrue("Index of 'first' should be 0!", myList.indexOf("first") == 0);
    }
    
    @Test
    public void testIndexOfOneElementListLast()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	myList.addLast("last");
    	assertTrue("Last node should be 'last'!", myList.getLast() == "last");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	assertTrue("Node at index 0 should be 'last'!", myList.indexOf("last") == 0);
    }
    
    @Test
    public void testIndexOfMultipleElementList()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.addLast("third");
    	assertTrue("Last node should be 'third'!", myList.getLast() == "third");
    	assertTrue("Size should be 2!", myList.size() == 2);
    	
    	myList.insertBefore("second", "third");
    	assertTrue("Size should be 3!", myList.size() == 3);
    	
    	assertTrue("Node at index 0 should be 'first'!", myList.indexOf("first") == 0);
    	assertTrue("Node at index 1 should be 'second'!", myList.indexOf("second") == 1);
    	assertTrue("Node at index 2 should be 'third'!", myList.indexOf("third") == 2);
    }

    @Test
    public void testIndexOfNotIncluded()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	
    	myList.addLast("last");
    	assertTrue("Last node should be 'last'!", myList.getLast() == "last");
    	assertTrue("Size should be 2!", myList.size() == 2);
    	
    	myList.indexOf("middle");
    	assertTrue("Node at index 0 should be 'first'!", myList.indexOf("first") == 0);
    	assertTrue("Node at index 1 should be 'last'!", myList.indexOf("last") == 1);
    	assertTrue("Cannot give index of 'middle' because it is not in the list!", myList.contains("middle") == false);
    }
    
    /**
     * Checks to see if size() works correctly.
     */
    @Test
    public void testSizeOne()
    {
    	assertTrue("Size should be 0!", myList.size() == 0);
    	
    	myList.addFirst("first");
    	assertTrue("First node should be 'first'!", myList.getFirst() == "first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    }
    
    @Test
    public void testSizeMultiple()
    {
    	assertTrue("Szie should be 0!", myList.size() == 0);
    	myList.addFirst("first");
    	assertTrue("Size should be 1!", myList.size() == 1);
    	myList.addFirst("second");
    	assertTrue("Size should be 2!", myList.size() == 2);
    	myList.addFirst("third");
    	assertTrue("Size should be 3!", myList.size() == 3);
    	myList.addFirst("fourth");
    	assertTrue("Size should be 4!", myList.size() == 4);
    }

}
