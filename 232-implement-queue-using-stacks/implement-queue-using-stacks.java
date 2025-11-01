import java.util.Stack;

/**
 * Implementation of a Queue using two stacks.
 * This follows the FIFO (First-In-First-Out) principle using two stacks.
 */
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * Constructor to initialize the stacks.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of the queue.
     * @param x The element to be added.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes and returns the element from the front of the queue.
     * @return The front element of the queue, or -1 if the queue is empty.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            }
            transferFrom1to2();
        }
        return stack2.pop();
    }

    /**
     * Returns the element at the front of the queue without removing it.
     * @return The front element of the queue, or -1 if the queue is empty.
     */
    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            }
            transferFrom1to2();
        }
        return stack2.peek();
    }

    /**
     * Checks if the queue is empty.
     * @return True if the queue is empty, false otherwise.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    /**
     * Transfers all elements from stack1 to stack2 to maintain queue order.
     */
    private void transferFrom1to2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}

/**
 * Example Usage:
 * MyQueue obj = new MyQueue();
 * obj.push(10);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */