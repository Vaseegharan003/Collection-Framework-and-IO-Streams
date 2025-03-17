class NumberPrinter {
    private int number = 1;
    private final int MAX = 10;
    
    public synchronized void printOdd() {
        while (number <= MAX) {
            if (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Odd: " + number);
            number++;
            notify();
        }
    }
    
    public synchronized void printEven() {
        while (number <= MAX) {
            if (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Even: " + number);
            number++;
            notify();
        }
    }
}

public class OddEvenThreads {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();
        
        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);
        
        oddThread.start();
        evenThread.start();
    }
}
