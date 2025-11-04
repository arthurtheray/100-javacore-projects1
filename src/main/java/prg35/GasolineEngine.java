package prg35;

public class GasolineEngine implements Engine {
    private static final int DEFAULT_TORQUE = 200;
    private static final int DEFAULT_RPM = 2000;
    private boolean isStarted = false;

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
