package com.bala.stocks.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradeDay {
    @JsonProperty("date")
    private String date;
    @JsonProperty("open")
    private double open;
    @JsonProperty("close")
    private double close;
    @JsonProperty("high")
    private double high;
    @JsonProperty("low")
    private double low;
    @JsonProperty("adjusted close")
    private double adjustedclose;
    @JsonProperty("volume")
    private long volume;
    @JsonProperty("dividend amount")
    private double dividend;
    @JsonProperty("split coefficient")
    private double split;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getAdjustedclose() {
        return adjustedclose;
    }

    public void setAdjustedclose(double adjustedclose) {
        this.adjustedclose = adjustedclose;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getDividend() {
        return dividend;
    }

    public void setDividend(double dividend) {
        this.dividend = dividend;
    }

    public double getSplit() {
        return split;
    }

    public void setSplit(double split) {
        this.split = split;
    }

    public String toString() {
        return "Trade Info: " +
                " Open=" + open +
                " High=" + high;
    }
}
