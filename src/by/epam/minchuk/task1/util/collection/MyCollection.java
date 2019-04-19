package by.epam.minchuk.task1.util.collection;

/**
 * The root interface in the collection hierarchy.
 *
 * @param <E> the type of elements in this collection
 *
 * @autor Oksana Minchuk
 * @version 1.0 10.03.2019
 */

public interface MyCollection<E> {

    /**
     * Returns the number of elements in this collection.
     * @return the number of elements in this collection
     */
    int size();

    /**
     * Returns <tt>true</tt> if this collection contains no elements.
     * @return <tt>true</tt> if this collection contains no elements.
     */
    boolean isEmpty();

    /**
     * Returns <tt>true</tt> if this collection contains the specified element.
     *
     * @param o element whose presence in this collection is to be tested
     * @return <tt>true</tt> if this collection contains the specified element
     *
     */
    boolean contains(Object o);

    /**
     * Ensures that this collection contains the specified element (optional
     * operation).  Returns <tt>true</tt> if this collection changed as a
     * result of the call.  (Returns <tt>false</tt> if this collection does
     * not permit duplicates and already contains the specified element.)
     *
     * @param e element whose presence in this collection is to be ensured
     * @return <tt>true</tt> if this collection changed as a result of the call
     */
    boolean add(E e);

    /**
     * Removes a single instance of the specified element from this
     * collection, if it is present (optional operation).
     * Returns <tt>true</tt> if this collection contained the specified element (or
     * equivalently, if this collection changed as a result of the call).
     *
     * @param o element to be removed from this collection, if present
     * @return <tt>true</tt> if an element was removed as a result of this call
     */
    boolean remove(Object o);

    /**
     * Removes all of the elements from this collection (optional operation).
     * The collection will be empty after this method returns.
     */
    void clear();

    /**
     * Returns an array containing all of the elements in this collection.
     *
     * @param a the array into which the elements of this collection are to be stored, if it is big enough; otherwise,
     *          a new array of the same runtime type is allocated for this purpose.
     * @return an array containing all of the elements in this collection
     */
    E[] toArray (E[] a);

}
