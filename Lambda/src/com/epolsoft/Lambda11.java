package com.epolsoft;

import static java.lang.System.out;


/*
 *  Вернуть лямбду, которая возвращает сумму трех входных аргументов
 */

public class Lambda11 {
    @FunctionalInterface
    private interface SumFunction<One, Two, Three> {
        Three apply(One one, Two two, Three three);
    }

    static SumFunction<Integer, Integer, Integer> getLambda() {
        return ( x, y, z ) -> x + y + z;
    }

    private static void showSum( int num1, int num2, int num3, SumFunction lambda ) {

        out.println( "calc: " +
                num1 +
                " + " +
                num2 +
                " + " +
                num3 +
                " = " +
                lambda.apply( num1, num2, num3 )
        );

    }

    private static void doTask() {

        SumFunction lambda = getLambda();

        showSum( 2, 5, 3, lambda );
        showSum( -2, 0, 3, lambda );
        showSum( 10, 9, 8, lambda );
    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 11 );
        doTask();

    }
}