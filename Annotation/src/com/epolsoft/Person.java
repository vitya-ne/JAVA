package com.epolsoft;

@ClassData(
    author = "Bill Gates",
    lastModified = "02.05.2019",
    company = "Microsoft",
    currentRevision = 2
)
public class Person {
    @FieldName( type = "person" )
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Person(String name, int age ) {
        this.name = name;
        this.age = age;
    }
}