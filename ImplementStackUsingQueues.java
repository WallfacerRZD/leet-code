import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WallfacerRZD
 * @date 2019/1/1 11:18
 */
public class ImplementStackUsingQueues {
    class MyStack {
        private Queue<Integer> queue = new LinkedList<>();
        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.offer(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.offer(queue.remove());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.remove();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
