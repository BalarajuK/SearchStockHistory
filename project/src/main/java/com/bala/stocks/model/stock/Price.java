package com.bala.stocks.model.stock;

public class Price {
    private double high;
    private double open;
    private double close;
    private int volume;

    public Price(double high, double open, double close, int volume) {
        this.high = high;
        this.open = open;
        this.close = close;
        this.volume = volume;
    }
    public Price(){

    }

    public double getHigh() {
        return high;
    }

    public double getOpen() {
        return open;
    }

    public double getClose() {
        return close;
    }

    public int getVolume() {
        return volume;
    }

    public String toString(){
        return open + " " + close + " " + high + " " + volume;
    }
}
