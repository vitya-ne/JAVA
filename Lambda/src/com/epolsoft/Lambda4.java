package com.epolsoft;

import java.time.LocalTime;

import static java.lang.System.out;

public class Lambda4 {

    @FunctionalInterface
    private interface CurrTime {
        LocalTime get();
    }

    private static CurrTime getLambda() {
        return () -> LocalTime.now();
    }

    private static void showTime( CurrTime time ) {
        out.println( "Now is: " +
                time.get()
        );
    }

    private static void doTask() {
        CurrTime time = getLambda();

        showTime( time );

    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 4 );
        doTask();

    }
}