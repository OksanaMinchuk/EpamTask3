package by.epam.minchuk.task1.util.collection;

public interface MyQueue<E> extends MyCollection<E> {

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of this queue or null if queue is empty
     */
    E element();

    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue or null if queue is empty
     */
    E remove();

}
