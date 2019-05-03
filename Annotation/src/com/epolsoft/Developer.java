package com.epolsoft;

@ClassData(
    author = "VNEZ",
    lastModified = "03.05.2019"
)
public class Developer extends Person {
    private int WorkExperience;

    Developer( String name, int age ) {
        this( name, age, 0 );
    }

    Developer( String name, int age, int experience ) {
        super( name, age );
        this.WorkExperience = experience;
    }
}