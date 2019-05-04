package com.epolsoft;

public class Tester extends Person {
    private Language[] langs;

    public Language[] getLanguages() {
        return langs;
    }

    Tester( String name, int age ) {
        super( name, age );
    }
}