package by.epam.minchuk.task1.util.collection.collectionImpl;

import java.util.Objects;

public class MyLinkedList<E> extends MyAbstractCollection<E> {

    protected static class Node<E> {

        private E element;
        private Node<E> next;
        private Node<E> previous;

        public Node(Node<E> n1, E e, Node<E> n2) {
            previous = n1;
            next = n2;
            element = e;
        }

        public E get() {
            return element;
        }

        public Node<E> previous() {
            return previous;
        }

        public Node<E> next() {
            return next;
        }

        public void setNext(Node<E> nextNode) {
            next = nextNode;
        }

        public void setPrevious(Node<E> prevNode) {
            previous = prevNode;
        }
    }

    protected int size = 0;
    protected Node<E> first;
    protected Node<E> last;

    protected MyLinkedList() {
        this.first = new Node<>(null, null, null);
        this.last = first;
    }

    protected MyLinkedList(MyLinkedList<E> template) {
        this();
        if (template != null) {
            Object[] item = new Object[template.size];
            MyLinkedList<Object> newTemplate = (MyLinkedList<Object>)template;
            newTemplate.toArray(item);
            for (Object elem: item) {
                add((E)item);
            }
        }
    }

    /**
     * Returns the number of elements in this list
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains the specified element
     *
     * @param o element whose presence in this collection is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        boolean result = false;
        if ((o != null) && (first != null) && (first.get() != null)) {
            for (Node<E> x = first; x != null; x = x.next()) {
                if (o.equals(x.get())) {
                    result = true;
                }
            }
            return result;
        }
        return result;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element whose presence in this collection is to be ensured
     * @return true (as specified by MyCollection.add(E))
     */
    @Override
    public boolean add(E e) {
        if (e != null) {
            if (first.get() == null) {
                first = new Node<E>(null, e, null);
                last = first;
            } else if (last == first) {
                last = new Node<E>(first, e, null);
                first.setNext(last);
            } else {
                last = new Node<E>(last, e, null);
                Node<E> previous = last.previous();
                previous.setNext(last);
            }
            size++;
            return true;
        }
        return false;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged
     *
     * @param o element to be removed from this collection, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        boolean result = false;
        if (o != null) {
            int deleteCount = 0;
            for (Node<E> x = first; x != null; x = x.next()) {
                if (o.equals(x.get())) {
                    Node<E> prev = x.previous();
                    Node<E> next = x.next();
                    prev.setNext(next);
                    next.setPrevious(prev);
                    size--;
                    deleteCount++;
                }
                result = true;
            }
            if (deleteCount == 0) {
               result = false;
            }
        }
        return result;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        first = new Node<E>(null, null, null);
        last = first;
        size = 0;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence (from first to last element)
     *
     * @param array
     * @return an array containing all of the elements in this list in proper sequence
     */
    @Override
    public E[] toArray(E[] array) {
        int length = array.length;
        Node<E> x = first;
        for (int i = 0; i < length; i++) {
            if (x != null) {
                array[i] = x.get();
                x = x.next();
            } else {
                break;
            }
        }
        return (E[]) array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return size == that.size &&
                first.equals(that.first) &&
                last.equals(that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, first, last);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Node<E> x = first; x != null; x = x.next()) {
            buffer.append(x.get().toString());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
