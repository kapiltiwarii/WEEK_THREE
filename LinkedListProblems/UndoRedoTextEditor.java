class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState currentState; // Current state of the editor
    private int maxHistory; // Maximum size of undo/redo history
    private int historySize; // Current size of the history

    public TextEditor(int maxHistory) {
        this.maxHistory = maxHistory;
        this.historySize = 0;
        this.currentState = new TextState(""); // Initial empty state
    }

    // Add a new text state
    public void addState(String newContent) {
        TextState newState = new TextState(newContent);

        // If there's a "next" state after the current, discard all redo states
        if (currentState != null) {
            currentState.next = null;
        }

        newState.prev = currentState;

        // Move to the new state
        currentState = newState;
        historySize++;

        // If history exceeds the limit, trim the oldest state
        trimHistory();
    }

    // Undo functionality
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more actions to undo.");
        }
    }

    // Redo functionality
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more actions to redo.");
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current Text: " + currentState.content);
        } else {
            System.out.println("No text available.");
        }
    }

    // Trim history if it exceeds the maximum size
    private void trimHistory() {
        if (historySize > maxHistory) {
            TextState oldest = currentState;

            // Traverse to the oldest state
            while (oldest.prev != null) {
                oldest = oldest.prev;
            }

            // Remove the oldest state
            if (oldest.next != null) {
                oldest.next.prev = null;
            }
            oldest.next = null;

            historySize--;
        }
    }
}

public class UndoRedoTextEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10); // Limit history to 10 states

        // Simulate typing actions
        editor.addState("Hello");
        editor.displayCurrentState();

        editor.addState("Hello, World");
        editor.displayCurrentState();

        editor.addState("Hello, World!");
        editor.displayCurrentState();

        // Undo actions
        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        // Redo actions
        editor.redo();
        editor.displayCurrentState();

        // Add new state after undoing
        editor.addState("Hello again!");
        editor.displayCurrentState();

        // Simulate hitting the history limit
        for (int i = 1; i <= 12; i++) {
            editor.addState("State " + i);
        }
        editor.displayCurrentState();
    }
}
