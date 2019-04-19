package by.epam.minchuk.task1.util.collection.collectionImpl;

import by.epam.minchuk.task1.util.collection.MyQueue;


public class MyArrayListQueue<E> extends MyArrayList<E> implements MyQueue<E> {

    public MyArrayListQueue() {
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of this queue or null if queue is empty
     */
    @Override
    public E element() {
        if (elementData.length !=0) {
            return (E) elementData[0];
        }
        return null;
    }

    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue or null if queue is empty
     */
    @Override
    public E remove() {
        if (elementData.length != 0 && size != 0) {
            E element = (E) elementData[0];
            Object[] current = new Object[elementData.length - 1];
            for (int i = 0; i < elementData.length - 1; i++) {
                current[i] = elementData[i + 1];
            }
            size--;
            elementData = current;
            return element;
        }
        return null;
    }
}


