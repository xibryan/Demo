package sample.algorithm.tree;

public class RBTree<T>
{
    private Node head;

    private static enum Color
    {
        RED, BLACK
    }

    private static class Node<T>
    {
        T value;
        Color color;

        Node(T value, Color color)
        {
            this.value = value;
            this.color = color;
        }

        Node(T value)
        {
            this(value, Color.BLACK);
        }
    }
}
