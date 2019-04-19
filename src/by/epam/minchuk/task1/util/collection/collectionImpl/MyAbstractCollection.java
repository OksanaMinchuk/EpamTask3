package by.epam.minchuk.task1.util.collection.collectionImpl;

import by.epam.minchuk.task1.util.collection.MyCollection;

import java.io.Serializable;

public abstract class MyAbstractCollection<E> implements MyCollection<E>, Serializable {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

}
