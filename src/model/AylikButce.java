package model;

public class AylikButce {
    private final String yil;
    private final String ay;
    private double butce;

    public AylikButce(String yil, String ay, double butce) {
        this.yil = yil;
        this.ay = ay;
        this.butce = butce;
    }

    public String getYil() {
        return yil;
    }

    public String getAy() {
        return ay;
    }

    public double getButce() {
        return butce;
    }

    public void setButce(double butce) {
        this.butce = butce;
    }

    @Override
    public String toString() {
        return yil + "," + ay + "," + butce;
    }
}
