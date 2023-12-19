import java.util.Scanner;

public class WashingMachine {
    private static Scanner scanner = new Scanner(System.in);
    private Tank tank;


    public WashingMachine() {
        this.tank = new Tank(200);
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            handleMenuChoice(choice);
        } while (choice != 4);
    }

    private void displayMenu() {
        System.out.println(ANSI_GREEN + "Washing Machine Menu:" + ANSI_RESET);
        System.out.println("1. Washing");
        System.out.println("2. Tank");
        System.out.println("3. Components");
        System.out.println("4. Turn off");
        System.out.print("Enter your choice: ");
    }

    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                handleWashingMenu();
                break;
            case 2:
                System.out.println(ANSI_YELLOW + "Tank content: " + tank.getLiquidAmount() + "ml" + ANSI_RESET);
                break;
            case 3:
                displayComponentsInfo();
                break;
            case 4:
                System.out.println("Turning off the washing machine.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void handleWashingMenu() {
        int washingChoice;
        do {
            displayWashingMenu();
            washingChoice = scanner.nextInt();
            handleWashingChoice(washingChoice);
        } while (washingChoice != 6);
    }

    private void displayWashingMenu() {
        System.out.println(ANSI_GREEN + "Washing Modes:" + ANSI_RESET);
        System.out.println("1. Bawalna");
        System.out.println("2. Fast");
        System.out.println("3. Delicate");
        System.out.println("4. Synthetics");
        System.out.println("5. Custom (Max 4 kg)");
        System.out.println("6. Back to menu");
        System.out.print("Enter your choice: ");
    }

    private void handleWashingChoice(int washingChoice) {
        switch (washingChoice) {
            case 1:
                // Bawalna mode
                startWashing("Bawalna", 60, 1000, 50, 2, 4);
                break;
            case 2:
                // Fast mode
                startWashing("Fast", 40, 2000, 40, 1, 2);
                break;
            case 3:
                // Delicate mode
                startWashing("Delicate", 50, 1000, 30, 3, 6);
                break;
            case 4:
                // Synthetics mode
                startWashing("Synthetics", 70, 1500, 40, 1.5, 5);
                break;
            case 5:
                // Custom mode
                handleCustomMode();
                break;
            case 6:
                // Back to menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    private void startWashing(String mode, int temperature, int spinSpeed, int detergentConsumption, double washingTime, int maxWeight) {
        if (tank.getLiquidAmount() >= detergentConsumption) {
            int clothesWeight = 4;
            if (clothesWeight <= maxWeight) {
                tank.removeLiquid(detergentConsumption);
                System.out.println(ANSI_YELLOW + "Washing started - " + mode + " mode" + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "Temperature: " + temperature + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "Spin Speed: " + spinSpeed + " RPM" + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "Detergent Consumption: " + detergentConsumption + " ml" + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "Washing Time: " + washingTime + " hours" + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "Max Weight: " + maxWeight + " kg" + ANSI_RESET);
                System.out.println("Washing finished");
            } else {
                System.out.println(ANSI_RED + "Too much weight of clothes. Maximum allowed weight is " + maxWeight + "kg." + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + "Not enough washing liquid. Please refill the tank." + ANSI_RESET);
        }
    }
    private void handleCustomMode() {
        System.out.print("Enter water temperature: ");
        int temperature = scanner.nextInt();
        System.out.print("Enter spin speed (RPM): ");
        int spinSpeed = scanner.nextInt();
        System.out.print("Enter detergent consumption (ml): ");
        int detergentConsumption = scanner.nextInt();
        if (tank.getLiquidAmount() >= detergentConsumption) {
            System.out.print("Enter washing time (hours): ");
            int washingTime = scanner.nextInt();
            int maxWeight = 4;
            tank.removeLiquid(detergentConsumption);
            System.out.println(ANSI_YELLOW + "Temperature: " + temperature + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "Spin Speed: " + spinSpeed + " RPM" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "Detergent Consumption: " + detergentConsumption + " ml" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "Washing Time: " + washingTime + " hours" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "Max Weight: " + maxWeight + " kg" + ANSI_RESET);
            System.out.println("Washing finished");
        } else{
            System.out.println(ANSI_RED + "Not enough washing liquid. Please refill the tank." + ANSI_RESET);
        }
    }

    private void displayComponentsInfo() {
        System.out.println(ANSI_RED + "To be continued" + ANSI_RESET);
    }
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
}
