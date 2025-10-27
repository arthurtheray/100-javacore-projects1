package prg23;

public class CountingService {
    private static int count;
    static {
        count = 0;
    }

    public CountingService() {
        System.out.println("counting service instance created. Count is: " + ++count);
    }

    public void resetCount() {
        this.count = 0;
    }
}
