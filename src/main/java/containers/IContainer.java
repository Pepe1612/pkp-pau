package containers;

public interface IContainer<T> {

    boolean add(T object);
    T getById(int id);
    T removeById(int id);
    boolean contains(T object);
}
