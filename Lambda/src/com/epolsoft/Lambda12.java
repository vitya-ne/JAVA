package com.epolsoft;

import java.util.function.UnaryOperator;

import static java.lang.System.out;


/*
 *  Вернуть лямбду, которая возводит число в квадрат
 */

public class Lambda12 {
    static UnaryOperator<Float> getLambda() {
        return LambdaCommon.square; // z -> z * z;
    }

    private static void showSquare( float num, UnaryOperator<Float> lambda ) {

        out.println( "calc: " +
                num +
                " ^2" +
                " = " +
                lambda.apply( num )
        );

    }

    private static void doTask() {

        UnaryOperator<Float> lambda = getLambda();

        showSquare( 8, lambda );
        showSquare( (float) 24.5, lambda );
        showSquare( -5, lambda );
    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 12 );
        doTask();

    }
}