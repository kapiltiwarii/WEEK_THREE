import java.util.Stack;

public class QueueUsingStack{
    Stack <Integer> stack1 = new Stack<>();
    Stack <Integer> stack2 = new Stack<>();

    public void enqueue(int item){
     stack1.push(item);
    }

    public int dequeue(){
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Peek: " + queue.peek()); // Expected Output: 1
        System.out.println(queue.dequeue()); // Expected Output: 1
        System.out.println("Peek: " + queue.peek()); // Expected Output: 2
        System.out.println(queue.dequeue()); // Expected Output: 2
        System.out.println(queue.dequeue()); // Expected Output: 3

        System.out.println("Is queue is empty");

    }
}
