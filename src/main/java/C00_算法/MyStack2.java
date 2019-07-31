package C00_算法;

public class MyStack2<T> implements SimpleStack<T> {
    private MyStack2<T>.Node<T> top = new MyStack2.Node();
    private int size;

    public MyStack2() {
    }

    public boolean isEmpty() {
        return this.top == null || this.top.item == null;
    }

    public synchronized void push(T item) {
        if (item != null) {
            if (this.top == null) {
                this.top = new MyStack2.Node();
                ++this.size;
            } else if (this.top.item == null) {
                this.top.item = item;
            } else {
                new MyStack2.Node(item, this.top);
                MyStack2<T>.Node<T> newTop = this.top;
                ++this.size;
            }

        }
    }

    public synchronized T pop() {
        if (this.isEmpty()) {
            throw new RuntimeException();
        } else {
            T result = this.top.item;
            this.top = this.top.next;
            --this.size;
            return result;
        }
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException();
        } else {
            return this.top.item;
        }
    }

    public synchronized int size() {
        return this.size;
    }

    public static void main(String[] args) {
        MyStack2<String> myStack = new MyStack2();
        String str = "this is a message this is a message this is a message";
        String[] split = str.split(" ");
        String[] var7 = split;
        int var6 = split.length;

        for(int var5 = 0; var5 < var6; ++var5) {
            String s = var7[var5];
            myStack.push(s);
        }

        while(!myStack.isEmpty()) {
            System.out.println((String)myStack.pop());
        }

        System.out.println(myStack.size());
    }

    private class Node<T> {
        T item;
        MyStack2<T>.Node<T> next;

        public Node() {
        }

        public Node(T item) {
            this.item = item;
        }

        public Node(T item, MyStack2<T>.Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
