package by.epam.minchuk.task1.util.collection.collectionImpl;

import by.epam.minchuk.task1.util.collection.MyStack;

public class MyLinkedListStack<E> extends MyLinkedList<E> implements MyStack<E> {

    public MyLinkedListStack() {
    }

    /**
     * Pushes an item onto the top of this stack
     *
     * @param e the item argument
     */
    @Override
    public void push(E e) {
        super.add(e);
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     *
     * @return The object at the top of this stack
     */
    @Override
    public E pop() {
        E item = last.get();
        last = last.previous();
        last.setNext(null);
        size--;
        return item;
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     *
     * @return the object at the top of this stack
     */
    @Override
    public E peek() {
        return last.get();
    }
}
