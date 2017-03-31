package lab1.ru.vsu.amm;

import java.util.Random;

public class Array<T> implements IArray<T> {
    private T[] a;
    private int capacity;
    private int length;

    public Array () {
        this(0);
    }

    public Array (int capacity) {
        this.capacity = capacity < 2 ? 10 : capacity;
        this.length = 0;
        this.a = (T[])new Object[this.capacity];
    }

    public int getLength () {
        return length;
    }

    private void qsort (int l, int r, Comparator<T> comparator) {
        if (l >= r) {
            return;
        }
        int p = partition(l, r, comparator);
        qsort(l, p, comparator);
        qsort(p + 1, r, comparator);
    }

    private int partition (int l, int r, Comparator<T> comparator) {
        int rand = new Random().nextInt(r - l + 1) + l;
        T x = a[rand];
        int i = l - 1;
        int j = r + 1;
        while (true) {
            while (comparator.compare(a[--j], x) > 0) {
            }
            while (comparator.compare(a[++i], x) < 0) {
            }
            if (i < j) {
                T t = a[i];
                a[i] = a[j];
                a[j] = t;
            } else {
                return j;
            }
        }
    }

    @Override
    public Array<T> insert (int index, T value) {
        if (index < 0 || length < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (capacity < length + 1) {
            reallocate();
        }
        for (int i = length; i > index; i--) {
            a[i] = a[i - 1];
        }
        a[index] = value;

        length++;

        return this;
    }

    private void reallocate () {
        int newCapacity = capacity * 3 / 2;
        T[] t = (T[])new Object[newCapacity];
        for (int i = 0; i < capacity; i++) {
            t[i] = a[i];
        }
        a = t;
        capacity = newCapacity;
    }

    @Override
    public Array<T> add (T value) {
        insert(length, value);
        return this;
    }

    @Override
    public Array<T> sort (Comparator<T> comparator) {
        qsort(0, length - 1, comparator);
        return this;
    }

    @Override
    public Array<T> remove (int index) {
        for (int i = index; i < length - 1; i++) {
            a[i] = a[i + 1];
        }
        length--;

        return this;
    }

    @Override
    public T get (int index) {
        if (index < 0 || length <= index) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return a[index];
    }

    @Override
    public Array<T> set (int index, T value) {
        if (index < 0 || length <= index) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        a[index] = value;

        return this;
    }
}