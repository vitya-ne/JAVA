package com.epolsoft;

@ClassData(
        author = "EDYT",
        lastModified = "01.03.2012",
        company = "Ericpol",
        currentRevision = 5
)
public class Language {
    @FieldName()
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}