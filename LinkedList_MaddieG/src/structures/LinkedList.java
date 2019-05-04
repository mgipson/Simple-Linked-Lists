package structures;

/**
 *  Linked List class makes a singly linked list with a generic type.
 *  It references the private Node class.
 *
 *  @author madisongipson
 */
public class LinkedList<E>
//public class LinkedList
{
    /////////////////////////////
    //         Properties      //
    /////////////////////////////
    private Node<E> myHead;
    private int mySize;
    
    /////////////////////////////
    //         Methods         //
    /////////////////////////////
    
    /**
     *  Default constructor that creates an empty linked list
     *
     *  <pre>
     *  pre:  the linked list is empty
     *  post: the linked list is empty
     *  </pre>
     */
    public LinkedList()
    {
        myHead = null;
    }
    
    /**
     *  Constructor that creates a new linked list with a single 
     *  node storing the object passed in
     *
     *  <pre>
     *  pre:  myHead points to null (the linked list is empty)
     *  post: myHead points to the only node in the linked list,
     *        that node holding the object passed in
     *  </pre>
     *
     *  @param datum an object to be inserted at the head of the
     *         linked list
     */
    public LinkedList(E e)
    {
        myHead = new Node<E>(e);
    }

    /**
     *  Adds a node to the head of the linked list; the special
     *  condition of an empty linked list is handled without
     *  special treatment since if myHead points to null, that
     *  simply becomes the next node in the list, immediately
     *  following the new entered node at the head of the list
     *
     *  <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the beginning of the list
     *  </pre>
     *
     *  @param node the node to be entered
     */
    private void addFirst(Node<E> node)
    {
    	node.setNext(myHead);
        myHead = node;
        if(myHead.getData() != null)
        {
        	mySize++;
        }
    }
    
    /**
     *  Adds a node to the head of the linked list; the special
     *  condition of an empty linked list is handled without
     *  special treatment since if myHead points to null, that
     *  simply becomes the next node in the list, immediately
     *  following the new entered node at the head of the list
     *
     *  <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the beginning of the list
     *  </pre>
     *
     *  @param datum the object used to creat a new node to be 
     *         entered at the head of the list
     */
    public void addFirst(E e)
    {
        Node<E> node;
        
        node = new Node<E>(e);
        this.addFirst(node);
    }
    
    /**
     *  Adds a node to the tail of the linked list; the special
     *  condition of an empty linked list is handled separately
     *
     *  <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the end of the list
     *  </pre>
     *
     *  @param node the node to be entered
     */
    private void addLast(Node<E> node)
    {
        Node<E> lastNode;
        
        if(myHead==null)
        {
            this.addFirst(node);
        }
        else
        {
            lastNode = this.getPrevious(null);
            lastNode.setNext(node);
            mySize++;
            //node.setNext(null);
        }
    }
    
    /**
     *  Adds a node to the tail of the linked list; the special
     *  condition of an empty linked list is handled separately
     *
     *  <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the end of the list
     *  </pre>
     *
     *  @param datum the object used to creat a new node to be 
     *         entered at the tail of the list
     */
    public void addLast(E e)
    {
        Node<E> node;
        
        node = new Node<E>(e);
        this.addLast(node);
    }
    
    /**
     *  Deletes a node from the list if it is there
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: if the node to be deleted is in the list,
     *        the node no longer exists in the list; the
     *        node previous to the node to be deleted now
     *        points to the node following the deleted node
     *  </pre>
     *
     *  @param node the node to be deleted from the list
     *
     *  @return boolean indicating whether or not the node
     *          was deleted
     */
    private boolean remove(Node<E> node)
    {
    	Node<E> currentNode;
        currentNode = getPrevious(node);
        if(currentNode == null && node == null)
    	{
    		return false;
    	}
        if(currentNode == null && node.getNext() == null)
        {
        	myHead = null;
        	mySize--;
        	return true;
        }
        if(currentNode == null && node.getNext() != null)
        {
        	myHead = node.getNext();
        	mySize--;
        	return true;
        }
        currentNode.setNext(node.getNext());
        mySize--;
    	return true;
    }
    
    /**
     *  Deletes a node from the list if it is there
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: if the node to be deleted is in the list,
     *        the node no longer exists in the list; the
     *        node previous to the node to be deleted now
     *        points to the node following the deleted node
     *  </pre>
     *
     *  @param datum the object to be deleted from the list
     *
     *  @return boolean indicating whether or not the node
     *          was deleted
     */
    public boolean remove(E e)
    {
         if(contains(e) == true)
         {
        	 return this.remove(findNode(e));
         }
         return false;
    }
    
    /**
     *  Find a node in the list with the same data as that passed in 
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: list is unchanged
     *  </pre>
     *
     *  @param datum the object for which a node is to be found 
     *         in the list
     *
     *  @return null if a node with the given object datum is not in
     *          the list, or the node if it does
     */
    private Node<E> findNode(E e)
    {
        Node<E> currentNode;
        E currentDatum;
        
        currentNode = myHead;
        currentDatum = null;
        
        while(currentNode != null)
        {
            currentDatum = currentNode.getData();
            if(currentDatum.equals(e))
            {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }
    
    /**
     *  Determine if a node exists in the list with the same 
     *  data as that passed in 
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: list is unchanged
     *  </pre>
     *
     *  @param datum the object for which a node is to be found 
     *         in the list
     *
     *  @return false if a node with the given object datum is not in
     *          the list, or true if it does
     */
    public boolean contains(E e)
    {
    	Node<E> node;
        node = new Node<E>(e);
        if(findNode(e) == null)
        {
        	return false;
        }
        else if(findNode(e).myData == node.myData)
        {
        	return true;
        }
        
        return false;
    }
    
    /**
     *  Determines the node that resides one closer to the
     *  head of the list than the node passed in
     *
     *  <pre>
     *  pre:  the list has 0 or more nodes
     *  post: the list is unchanged
     *  </pre>
     *
     *  @param node the node whose predecessor is being looked for
     *
     *  @return the node that resides one closer to the head of the
     *          list than the node passed in
     */
    private Node<E> getPrevious(Node<E> node)
    {
        Node<E> currentNode;
        
        currentNode = myHead;
        
        if(currentNode == node)
        {
            return null;
        }
        
        while(currentNode!=null && currentNode.getNext() != node)
        {
            currentNode = currentNode.getNext();
        }
        
        return currentNode;
    }
   
    /**
     *  A new node is entered into the list immediately before
     *  the designated node
     *
     *  <pre>
     *  pre:  the list may have 0 or more nodes in it
     *  post: if the beforeNode is not in the list, no change
     *        takes place to the list; otherwise, the new
     *        node is entered in the appropriate place
     *  </pre>
     *
     *  @param node the node to be entered into the list
     *  @param beforeNode the node after which the new node
     *         is to be entered, so that it is the node before 
     *         the node
     *
     *  @return boolean designating if the node was or was not
     *          entered into list
     */
    private boolean insertBefore(Node<E> node, Node<E> beforeNode)
    {
    		if(this.getPrevious(beforeNode) == null)
    		{
    			this.addFirst(node);
    		}
    		else
    		{
    			node.setNext(beforeNode);
    			this.getPrevious(beforeNode).setNext(node);
    	        mySize++;
    	        return true; 
    		}
    	return false;
    }
    
    /**
     *  A new node with datum is entered into the list immediately
     *  before the node with beforeDatum, the designated node
     *
     *  <pre>
     *  pre:  the list may have 0 or more nodes in it
     *  post: if the node with beforeDatum is not in the list, 
     *        no change takes place to the list; otherwise, a new
     *        node is entered in the appropriate place with the 
     *        object datum
     *  </pre>
     *
     *  @param datum the object used to create the new node 
     *         to be entered into the list
     *  @param beforeDatum the datum of the node before which the 
     *         new node is to be entered
     *
     *  @return boolean designating if the node was or was not
     *          entered
     */
    public boolean insertBefore(E e, E eBefore)
    {
    	Node<E> node = new Node<E>(e);
    	Node<E> beforeNode = findNode(eBefore);
    	
    	if((contains(eBefore) == true || eBefore == null) && myHead != null)
    	{
    		if(insertBefore(node, beforeNode) == true)
        	{
        		return true;
        	}
        	else
        	{
        		return false;
        	}
    	}
    	return false;
    }
    
    /**
     *  print the list by converting the objects in the list
     *  to their string representations
     *
     *  <pre>
     *  pre:  the list has 0 or more elements
     *  post: no change to the list
     *  </pre>
     */
    public String toString()
    {
        String string;
        Node<E> currentNode;
        
        currentNode = myHead;
        
        string = "head ->";
        
        while(currentNode!=null)
        {
            string += currentNode.getData().toString()+ " -> ";
            currentNode = currentNode.getNext();
        }
        string += "|||";
        return string;
    }

    /**
     *  Returns the index of the node you're looking for.
     *
     *  <pre>
     *  pre:  linked list that is not empty
     *  </pre>
     *
     *  @param data of the node you're looking for
     */
    public int indexOf(E e)
    {
        Node<E> node = findNode(e); //returns the node of the object
        
        Node<E> currentNode = myHead; 
        int index = -1; 
        
        if(myHead == null || node == null) //if list is empty or the Object o is null (not in list)
        {
        	return index; //return -1 as index
        }
        while(currentNode != null) //goes through list starting at beginning- while list has next
        {
        	index++;
        	if(currentNode == node)
        	{
        		break;
        	}
        	else
        	{
        		currentNode = currentNode.getNext();
        	}
        }
    	return index; 
    }

    /**
     *  Removes the first node in the list, which is the head.
     *
     *  <pre>
     *  pre:  head that is not null
     *  post: myHead.next() becomes the first, size decreases
     *  </pre>
     */
    public E removeFirst()
    {
    	this.remove(myHead);
    	return null;
    }
    
    /**
     *  Removes the last node in the list.
     *
     *  <pre>
     *  pre:  last that is not null
     *  post: the second to last node becomes the last
     *  		and size decreases
     *  </pre>
     */
    public E removeLast()
    {
    	if(getPrevious(null) == myHead) //only one node in list (at head)
    	{
    		this.remove(myHead);
    		return null;
    	}
    	else
    	{
    		this.remove(getPrevious(null));
    		return this.getLast();
    	}
    }

    /**
     *  Simply returns the size, because size is 
     *  dynamically adjusted in other methods.
     */
    public int size()
    {
    	//dynamically increases by being included in every other method
        return mySize;
    }

    /**
     *  If the first node is null, then getFirst
     *  should return node. Otherwise, return the data
     *  at the first node.
     */
    public E getFirst()
    {
    	if(myHead.getData() == null)
    	{
    		return null;
    	}
    	return myHead.getData();
    }
    
    /**
     *  If the last node is null, then getLast
     *  should return node. Otherwise, return the data
     *  at the last node.
     */
    public E getLast()
    {
    	if(getPrevious(null).getData() == null)
    	{
    		return null;
    	}
        return this.getPrevious(null).getData(); 
    }

    /**
     *  Sets the first node in the list to the 
     *  element given. 
     *
     *  <pre>
     *  pre: list cannot be empty
     *  post: first node is set to the given node, unless
     *  		the given node is null, then the first
     *  		node is simply removed
     *  </pre>
     *  
     *  @param node you would like to set the first to
     */
    public void setFirst(E e)
    {
    	if(e != null)
    	{ 
    		if(myHead != null)
    		{
    			removeFirst();
    			addFirst(e);
    		}
    	}
    	if(e == null)
    	{
    		removeFirst();
    	}
    	
    }
    
    //setter
    private void setHead(Node<E> node)
    {
        myHead = node;
    }
    
    //getter
    private Node<E> getHead()
    {
        return myHead;
    }
    
    private class Node<T>
    {
        ///////////////////////////////////
        //           Properties          //
        ///////////////////////////////////
        private T myData;
        private Node<T> myNext;
        
        ///////////////////////////////////
        //             Methods           //
        ///////////////////////////////////
        
        /**
         *  Default constructor for a node with null
         *  data and pointer to a next node
         */
        public Node()
        {
            myData = null;
            myNext = null;
        }
        
        /**
         *  Constructor for a node with some object for
         *  its data and null for a pointer to a next node
         *
         *  <pre>
         *  pre:  a null node
         *  post: a node with some object for its data and
         *        null for a pointer to a next node
         *  </pre>
         *
         *  @param datum an object for the node's data
         */
        public Node(T t)
        {
            myData = t;
            myNext = null;
        }
        
        /**
         *  Constructor for a node with some object for 
         *  its data and a pointer to another node
         *
         *  <pre>
         *  pre:  a null node
         *  post: a node with some object for its data and
         *        a pointer to a next node
         *  </pre>
         *
         *  @param datum an object for the node's data
         *  @param next the node that this node points to
         */
        public Node(T t, Node<T> next)
        {
            myData = t;
            myNext = next;
        }
        
        // Accessor methods
        public void setData(T t)
        {
            myData = t;
        }
        
        public T getData()
        {
            return myData;
        }
        
        public void setNext(Node<T> next)
        {
            myNext = next;
        }
        
        public Node<T> getNext()
        {
            return myNext;
        }
    }
    
}
