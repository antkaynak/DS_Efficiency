package com.project.two;


/**
 * @author Pellumb Baboci - 160315049
 * @author Ant Kaynak - 150315004
 * */
public class MyArrayList
{
    private static final int DEFAULT_CAPACITY = 10;
    
    private Integer[] theItems;
    private int theSize;
    /**
     * Construct an empty ArrayList.
     */
    public MyArrayList()
    {
        doClear();
    }
    
    /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size()
    {
        return theSize;
    }
    
    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty()
    {
        return size() == 0;
    }
    
    /**
     * Returns the item at position idx.
     * @param idx the index to search in.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public Integer get( int idx )
    {
        if( idx < 0 || idx >= size( ) )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + size( ) );
        return theItems[ idx ];    
    }
        
    /**
     * Changes the item at position idx.
     * @param idx the index to change.
     * @param newVal the new value.
     * @return the old value.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public Integer set( int idx, Integer newVal )
    {
        if( idx < 0 || idx >= size( ) )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + size( ) );
        Integer old = theItems[ idx ];
        theItems[ idx ] = newVal;
        
        return old;    
    }
    
    /**
     * Adds an item to this collection, at the end.
     * @param x any object.
     */
    public boolean add(Integer x)
    {
        add(size(), x);  
		return true;
    }
    
    /**
     * Adds an item to this collection, at the specified index.
     * @param x any object.
     */
    public void add(int idx, Integer x)
    {
        if(theItems.length == size())
            ensureCapacity(size() * 2);

        for(int i=theSize; i>idx; i--)
            theItems[i] = theItems[i - 1];

        theItems[idx] = x;
        theSize++;  
    }
    
    /**
     * Returns a String representation of this collection.
     */
    public String toString()
    {
        String rStr = "[ ";

        for(int i=0; i<size(); i++)
            rStr = rStr + theItems[i] + " ";
        rStr = rStr + "]";

        return rStr;
    }  
    
    private void doClear()
    {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }
    
    private void ensureCapacity(int newCapacity)
    {
        if( newCapacity < theSize )
            return;

        Integer[] old = theItems;
        theItems = new Integer[newCapacity];
        for( int i = 0; i < size(); i++ )
            theItems[ i ] = old[ i ];
    }

    public static int getDefaultCapacity() {
        return DEFAULT_CAPACITY;
    }

    public Integer[] getTheItems() {
        return theItems;
    }

    public void setTheItems(Integer[] theItems) {
        this.theItems = theItems;
    }

    public int getTheSize() {
        return theSize;
    }

    public void setTheSize(int theSize) {
        this.theSize = theSize;
    }
}