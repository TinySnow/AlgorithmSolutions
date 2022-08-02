package leetcode.official;

import java.util.ArrayList;

public class Question622 {
    class MyCircularQueue {

        public int[] queue;
        private final int capacity;
        private int head;
        private int tail;

        public MyCircularQueue(int k) {
            capacity = k;
            queue = new int[k];
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            queue[tail % capacity] = value;
            return ++tail >= 0;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            return ++head >= 0;
        }

        public int Front() {
            return isEmpty() ? -1 : queue[head % capacity];
        }

        public int Rear() {
            return isEmpty() ? -1 : queue[(tail - 1) % capacity];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return tail - head == capacity;
        }
    }
}
