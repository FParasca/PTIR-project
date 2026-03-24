package domain;

public class Shift {
    private String shiftStart;
    private String shiftFinish;

    public Shift(String shiftStart, String shiftFinish) {
        this.shiftStart = shiftStart;
        this.shiftFinish = shiftFinish;
    }

    public String getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(String shiftStart) {
        this.shiftStart = shiftStart;
    }

    public String getShiftFinish() {
        return shiftFinish;
    }

    public void setShiftFinish(String shiftFinish) {
        this.shiftFinish = shiftFinish;
    }
}
