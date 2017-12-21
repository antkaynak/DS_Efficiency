package com.project.five;


/**
 * @author Pellumb Baboci - 160315049
 * @author Ant Kaynak - 150315004
 * */
public class MyArrayList<AnyType>
{
    private static final int DEFAULT_CAPACITY = 10;

    private AnyType[] theItems;
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
    public AnyType get( int idx )
    {
        if( idx < 0 || idx >= size( ) )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + size( ) );
        return theItems[ idx ];
    }

    /**
     * Adds an item to this collection, at the end.
     * @param x any object.
     */
    public boolean add(AnyType x)
    {
        add(size(), x);
		return true;
    }

    /**
     * Adds an item to this collection, at the specified index.
     * @param x any object.
     */
    public void add(int idx, AnyType x)
    {
        if(theItems.length == size())
            ensureCapacity(size() * 2);

        for(int i=theSize; i>idx; i--)
            theItems[i] = theItems[i - 1];

        theItems[idx] = x;
        theSize++;
    }

    /**
     * Removes an item from this collection.
     * @param idx the index of the object.
     * @return the item was removed from the collection.
     */
    public AnyType remove(int idx)
    {
        AnyType removedItem = theItems[ idx ];

        for(int i=idx; i<size()-1; i++)
            theItems[i] = theItems[i + 1];
        theSize--;

        return removedItem;
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

        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for( int i = 0; i < size(); i++ )
            theItems[ i ] = old[ i ];
    }



    public int getTheSize() {
        return theSize;
    }

}