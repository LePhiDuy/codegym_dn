package model;

public class Currency {
    private double usd;
    private double rate;

    public Currency() {
    }

    public Currency(double usd, double rate) {
        this.usd = usd;
        this.rate = rate;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
