package com.abhinag.numbertoword.breaker;

public class Part {

    public final String name;
    public final int startIndexInNumber;
    public final int endIndexInNumber;

    public Part(String name, int startIndexInNumber, int endIndexInNumber) {
        this.name = name;
        this.startIndexInNumber = startIndexInNumber;
        this.endIndexInNumber = endIndexInNumber;
    }
}
