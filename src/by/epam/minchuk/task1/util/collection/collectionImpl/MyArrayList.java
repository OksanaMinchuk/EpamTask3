package by.epam.minchuk.task1.util.collection.collectionImpl;

import java.util.Arrays;

public class MyArrayList<E> extends MyAbstractCollection<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    protected Object[] elementData;
    protected int size;

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     * Returns the element at the specified position in this list
     *
     * @param index
     * @return the element at the specified position in this list
     */
    public E get(int index){
        if (index >= 0 && index < size) {
            return (E) elementData[index];
        }  else {
            throw new IndexOutOfBoundsException("The index is out of range " + index);
        }
    }


    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     *
     */
    public E set (int index, E element){
        if (index >= 0 && index < size) {
            E oldValue = (E) elementData[index];
            elementData[index] = element;
            return oldValue;
        } else {
            throw new IndexOutOfBoundsException("The index is out of range " + index);
        }
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index
     * @return true if this list contained the element with this index
     */
    public boolean removeAt(int index) { //TODO throw exception
        if (index >= 0 && index < size) {
            int capasity = elementData.length;
            Object[] newArray = new Object[capasity - 1];
            if (index == capasity - 1) {
                for (int i = 0; i < capasity - 1; i++) {
                    newArray[i] = elementData[i];
                }
            } else {
                for (int i = 0, j = 0; i < capasity - 1; i++, j++) {
                    if (j == index) {
                        j++;
                    }
                    newArray[i] = elementData[j];
                }
            }
            elementData = newArray;
            return true;
        } else {
            throw new IndexOutOfBoundsException("The index is out of range " + index);
        }
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains the specified element.
     * More formally, returns true if and only if this list contains at least
     * one element e such that (o==null ? e==null : o.equals(e)).
     *
     * @param o element whose presence in this collection is to be tested
     * @return true if this list contains the specified element
     *
     */
    @Override
    public boolean contains(Object o) {
        boolean result = false;
        if (o != null) {
            for (Object elem: elementData) {
                if (o.equals(elem)) {
                    result = true;
                }
            }
            result = false;
        }
        return result;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element whose presence in this collection is to be ensured
     * @return true is element had been added
     */
    @Override
    public boolean add(E e) {
        if (e != null) {
            if (size == elementData.length) {
                elementData = Arrays.copyOf(elementData, size + 1);
            }
            elementData[size++] = e;
            return true;
        }
        return false;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If the list does not contain the element, it is unchanged
     *
     * @param o element to be removed from this collection, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        boolean result = false;
        if (o != null) {
            for (int i = 0; i <elementData.length; i++) {
                if (o.equals(elementData[i])) {
                    removeAt(i);
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        elementData = new Object[0];
    }

    @Override
    public E[] toArray(E[] array) {
        if (array.length != 0) {
            for (int i = 0; i < array.length; i++) {
                if (i < size) {
                    array[i] = (E) elementData[i];
                } else {
                    array[i] = null;
                }
            }
        }
        return array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArrayList<?> that = (MyArrayList<?>) o;

        if (size != that.size) return false;
        return Arrays.equals(elementData, that.elementData);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(elementData);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            buffer.append(elementData[i]);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
