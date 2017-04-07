package lab4.ru.vsu.amm.avl_tree;

public class Tree<T extends Comparable<T>, U> {
    private Node<T, U> root;

    private Node<T, U> add (Node<T, U> newNode, Node<T, U> currentRoot) {
        if (currentRoot == null) {
            return newNode;
        }
        if (newNode.getKey().compareTo(currentRoot.getKey()) >= 0) {
            currentRoot.setRight(add(newNode, currentRoot.getRight()));
        } else {
            currentRoot.setLeft(add(newNode, currentRoot.getLeft()));
        }
        return balance(currentRoot);
    }

    public Tree<T, U> add (T key, U value) {
        Node<T, U> newNode = new Node<>(key, value );
        return add(newNode);
    }



    private Tree<T, U> add (Node<T, U> newNode) {
        if (newNode != null && newNode.getKey() != null) {
            this.root = add(newNode, this.root);
        }
        return this;
    }

    public Node<T, U> find (Node<T, U> targetNode) {
        if (targetNode == null || targetNode.getKey() == null) {
            return null;
        }
        return find(targetNode.getKey());
    }

    Node<T, U> find (T target) {
        if (this.root == null) {
            return null;
        }
        return find(target, this.root);
    }

    private Node<T, U> find (T target, Node<T, U> root) {
        if (target.equals(root.getKey())) {
            return root;
        }
        boolean less = target.compareTo(root.getKey()) < 0;

        if (less && root.getLeft() != null) {
            return find(target, root.getLeft());
        }
        if (!less && root.getRight() != null) {
            return find(target, root.getRight());
        }
        return null;
    }

    public Tree<T, U> removeIfExists (Node<T, U> targetNode) {
        if (targetNode == null || targetNode.getKey() == null) {
            return this;
        }
        return removeIfExists(targetNode.getKey());
    }

    Tree<T, U> removeIfExists (T target) {
        this.root = remove(target, this.root);
        return this;
    }

    private Node<T, U> remove (T target, Node<T, U> root) {
        if (root == null) {
            return null;
        }
        int cmp = target.compareTo(root.getKey());
        if (cmp > 0) {
            root.setRight(remove(target, root.getRight()));
        } else if (cmp < 0) {
            root.setLeft(remove(target, root.getLeft()));
        } else {
            if (root.getRight() == null) {
                return root.getLeft();
            }
            Node<T, U> min = findMin(root.getRight());
            min.setRight(removeMin(root.getRight()));
            min.setLeft(root.getLeft());
            return balance(min);
        }

        return balance(root);
    }

    private Node<T, U> findMin (Node<T, U> p) {
        while (p.getLeft() != null) {
            p = p.getLeft();
        }
        return p;
    }

    private Node<T, U> removeMin (Node<T, U> p) {
        if (p.getLeft() == null) {
            return p.getRight();
        }
        p.setLeft(removeMin(p.getLeft()));
        return balance(p);
    }

    private Node<T, U> rotateRight (Node<T, U> p) {
        Node<T, U> q = p.getLeft();
        p.setLeft(q.getRight());
        q.setRight(p);
        return q;
    }

    private Node<T, U> rotateLeft (Node<T, U> q) {
        Node<T, U> p = q.getRight();
        q.setRight(p.getLeft());
        p.setLeft(q);
        return p;
    }

    private Node<T, U> balance (Node<T, U> p) {
        p.recalculateHeight();
        int balanceFactor = getBalanceFactor(p);

        if (balanceFactor == 2) {
            if (getBalanceFactor(p.getRight()) < 0) {
                p.setRight(rotateRight(p.getRight()));
            }
            return rotateLeft(p);
        }
        if (balanceFactor == -2) {
            if (getBalanceFactor(p.getLeft()) > 0) {
                p.setLeft(rotateLeft(p.getLeft()));
            }
            return rotateRight(p);
        }
        return p;
    }

    private int getBalanceFactor (Node<T, U> p) {
        if (p == null) {
            return 0;
        }
        int rightHeight = p.getRight() != null ? p.getRight().getHeight() : 0;
        int leftHeight = p.getLeft() != null ? p.getLeft().getHeight() : 0;

        return rightHeight - leftHeight;
    }

    final class Node<K extends T, V extends U> {
        private Node<K, V> left;
        private Node<K, V> right;
        private K key;
        private V value;
        // height of subtree with root == this
        private int height;

        private Node (K key, V value, Node<K, V> left, Node<K, V> right) {
            setKey(key);
            setLeft(left);
            setRight(right);
            setValue(value);
        }

        private Node (K key, Node<K, V> left, Node<K, V> right) {
            this(key, null, left, right);
        }

        private Node (K key, V value) {
            this(key, value, null, null);
        }

        private Node (K key) {
            this(key, null);
        }

        V getValue () {
            return value;
        }

        Node<K, V> setValue (V value) {
            this.value = value;
            return this;
        }

        Node<K, V> getLeft () {
            return left;
        }

        Node<K, V> setLeft (Node<K, V> child) {
            this.left = child;
            recalculateHeight();
            return this;
        }

        Node<K, V> getRight () {
            return right;
        }

        Node<K, V> setRight (Node<K, V> right) {
            this.right = right;
            recalculateHeight();
            return this;
        }

        K getKey () {
            return key;
        }

        Node<K, V> setKey (K key) {
            this.key = key;
            return this;
        }

        int getHeight () {
            return height;
        }

        private Node recalculateHeight () {
            int lh = getLeft() == null ? 0 : getLeft().getHeight();
            int rh = getRight() == null ? 0 : getRight().getHeight();
            this.height = (lh > rh ? lh : rh) + 1;
            return this;
        }
    }
}
