package com.epolsoft;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Stream4 {


    private static void showFileContent( String file_name ) throws IOException {
        FileReader f = new FileReader( file_name );
        BufferedReader buf = new BufferedReader( f );
        String str;

        while ( ( str = buf.readLine() ) != null ) {
            out.println( str );
        }
    }

    static void doTask() {
        final String F_NAME = "./files/1.txt";
        Stream<String> stream;

        StreamCommon.showTask(4);

        out.println("File content: " + F_NAME);

        try {
            showFileContent(F_NAME);

            stream = Files.lines( Paths.get( F_NAME ) );
            StreamCommon.showStrim(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ){

        doTask();

    }

}
