package com.epolsoft;

import static java.lang.System.out;
import java.lang.FunctionalInterface;

public class Lambda1 {

    @FunctionalInterface
    private interface TestGreeting {
        void show();
    }


    private static TestGreeting getLambda() {
        return ()-> out.println( "Hello world!" );
    }

    private static void sayGreeting( TestGreeting greeting ) {
        greeting.show();
    }

    private static void doTask() {
        TestGreeting test = getLambda();

        sayGreeting( test );
    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 1 );
        doTask();

    }
}