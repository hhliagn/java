package C00_算法;

import java.util.Arrays;
import java.util.Stack;

public class MyStack<T> implements SimpleStack<T> {
    private int capacity;
    private T[] array;
    private int top = -1;
    private int size = 0;
    Stack stack = new Stack();

    public MyStack() {
        this.array = (T[]) new Object[this.capacity];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public synchronized void push(T item) {
        this.ensureCapacity(this.size);
        ++this.size;
        this.array[++this.top] = item;
    }

    public synchronized T pop() {
        if (this.isEmpty()) {
            throw new RuntimeException();
        } else {
            --this.size;
            return this.array[this.top--];
        }
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException();
        } else {
            return this.array[this.top];
        }
    }

    public synchronized int size() {
        return this.size;
    }

    private void ensureCapacity(int size) {
        if (this.array.length >= size) {
            Object[] old = this.array;
            this.array = (T[]) Arrays.copyOf(old, size * 2 + 1);
        }
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack();
        String str = "this is a message this is a message this is a message";
        String[] split = str.split(" ");
        String[] var7 = split;
        int var6 = split.length;

        for(int var5 = 0; var5 < var6; ++var5) {
            String s = var7[var5];
            myStack.push(s);
        }

        int size = myStack.size();

        while(!myStack.isEmpty()) {
            System.out.println((String)myStack.pop());
        }

        System.out.println(size);
    }
}
