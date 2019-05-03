package com.epolsoft;

@ClassData(
        author = "VNEZ",
        lastModified = "01.04.2018",
        currentRevision = 3
)
public class Company {
    @FieldName( type = "title" )
    private String name;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Company( String name ) {
        this.name = name;
    }
}