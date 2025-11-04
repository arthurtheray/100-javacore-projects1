package prg35;

public class DieselEngine implements Engine {
    private boolean isStarted = false;
    private static final int DEFAULT_TORQUE = 400;
    private static final int DEFAULT_RPM = 1000;

    @Override
    public void start() {
        this.isStarted = true;
    }

    @Override
    public void stop() {
        this.isStarted = false;
    }

    @Override
    public int getTorque() {
        return !isStarted ? 0 : DEFAULT_TORQUE;
    }

    @Override
    public int getRpm() {
        return !isStarted ? 0 : DEFAULT_RPM;
    }
}
