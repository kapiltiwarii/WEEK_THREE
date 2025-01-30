import java.util.Stack;

public class SortStackRecursively {
    // Function to sort a stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Step 1: Pop the top element
            int top = stack.pop();

            // Step 2: Sort the remaining stack
            sortStack(stack);

            // Step 3: Insert the popped element back in sorted order
            insertSorted(stack, top);
        }
    }

    // Helper function to insert an element in a sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        // Base case: If stack is empty or element is greater than top, push it
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Pop the top element and recurse
        int top = stack.pop();
        insertSorted(stack, element);

        // Push the popped element back
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
