package com.epolsoft;

enum Checks { MIN, MAX, EQUAL, NOTEQUAL };

public final class Reflection_Source extends Reflection_SourceSuper implements Reflection_SourceInterface{
    private int number;
    private String name = "default";
    private String[] Persons;
    final char MAX_SIZE = 15;
    private Checks FirstCheck = Checks.MAX;

    private static String info = "REFLECTION!";


    public int getNumber() {
        return number;
    }

    public void setNumber( int number ) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    private void printData(){
        System.out.println( number + name );
    }

    public static String getInfo() {
        return info;
    }

    public Reflection_Source(int number ) {
        this.number = number;
    }
}