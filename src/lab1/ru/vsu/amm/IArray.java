package lab1.ru.vsu.amm;

public interface IArray<T> {
    IArray insert (int index, T value);

    IArray add (T value);

    IArray sort (Comparator<T> comparator);

    IArray remove (int index);

    T get (int index);

    IArray set (int index, T value);
}
