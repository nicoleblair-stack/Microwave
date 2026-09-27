//Design and implement a class that simulates a microwave control panel with the following four buttons:
     //   1.	One for increasing the time by 30 seconds.
//2.	One for switching between power levels 1 and 2.3.	A start button.
//4.	A reset button.
//In your Microwave class, each button is implemented as a method. The method for the start button should print a message “Cooking for … seconds at level …”.
//Please also implement a main function that tests out all four buttons in meaningful combination and display clear messages to the user on what operation is carried out by the microwave.


// Microwave class that simulates the control panel buttons
class Microwave {
    private int timeSeconds;
    private int powerLevel;

    // Constructor to set initial state
    public Microwave() {
        this.timeSeconds = 0;
        this.powerLevel = 1;
    }

    // 1. Button to increase time by 30 seconds
    public void addTime() {
        this.timeSeconds += 30;
        System.out.println("[Button] +30s Pressed. Current time: " + this.timeSeconds + " seconds.");
    }

    // 2. Button to switch power level between 1 and 2
    public void switchPower() {
        if (this.powerLevel == 1) {
            this.powerLevel = 2;
        } else {
            this.powerLevel = 1;
        }
        System.out.println("[Button] Power Level Pressed. Switched to Level " + this.powerLevel + ".");
    }

    // 3. Start button
    public void start() {
        if (this.timeSeconds > 0) {
            System.out.println("\n>>> SUCCESS: Cooking for " + this.timeSeconds + " seconds at level " + this.powerLevel + ". <<<\n");
        } else {
            System.out.println("\n>>> ERROR: Cannot start. Please add time first! <<<\n");
        }
    }

    // 4. Reset button
    public void reset() {
        this.timeSeconds = 0;
        this.powerLevel = 1;
        System.out.println("[Button] Reset Pressed. Time reset to 0, Power Level reset to 1.");
    }
}

// Main class to test meaningful button combinations
public class Main {
    public static void main(String[] args) {
        System.out.println("=== INITIALIZING JAVA MICROWAVE SIMULATION ===");
        Microwave myMicrowave = new Microwave();

        // Scenario 1: Attempt to start immediately
        System.out.println("\n--- Test Scenario 1: Pressing Start Immediately ---");
        myMicrowave.start();

        // Scenario 2: Set a 60-second cook cycle at Power Level 2
        System.out.println("--- Test Scenario 2: Setting Time and Power ---");
        myMicrowave.addTime();      // Add 30 seconds
        myMicrowave.addTime();      // Add another 30 seconds (Total 60)
        myMicrowave.switchPower();  // Switch to level 2
        myMicrowave.start();         // Start cooking

        // Scenario 3: Test the Reset button mid-setup
        System.out.println("--- Test Scenario 3: Changing Mind and Resetting ---");
        myMicrowave.addTime();      // Add 30 seconds
        myMicrowave.reset();         // Hit reset
        myMicrowave.start();         // Attempt to start to verify reset worked

        // Scenario 4: Standard Quick Start at default Power Level 1
        System.out.println("--- Test Scenario 4: Standard Quick Start ---");
        myMicrowave.addTime();      // Add 30 seconds
        myMicrowave.start();         // Start cooking
    }
}