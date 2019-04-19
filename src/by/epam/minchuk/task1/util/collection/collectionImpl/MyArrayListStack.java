package by.epam.minchuk.task1.util.collection.collectionImpl;

import by.epam.minchuk.task1.util.collection.MyCollectionException;
import by.epam.minchuk.task1.util.collection.MyStack;

public class MyArrayListStack<E> extends MyArrayList<E> implements MyStack<E> {

    public MyArrayListStack() {
    }

    /**
     * Pushes an item onto the top of this stack
     *
     * @param e the element to push
     */
    @Override
    public void push(E e) {
        super.add(e);
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     * @return The object at the top of this stack (the last item of the Vector object).
     */
    @Override
    public E pop() throws MyCollectionException {
        if (elementData.length != 0 && size != 0) {
            E element = (E) elementData[size - 1];
            Object [] current = new Object[elementData.length-1];
            for (int i = 0; i < elementData.length - 1; i++) {
                current[i] = elementData[i];
            }
            size--;
            elementData = current;
            return  element;
        } else {
            throw new MyCollectionException("this stack is empty");
        }
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     *
     * @return the object at the top of this stack
     */
    @Override
    public E peek() throws MyCollectionException {
        if (elementData.length != 0) {
            return (E) elementData[elementData.length - 1];
        } else {
            throw new MyCollectionException("this stack is empty");
        }
    }
}
