package com.epolsoft;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

import static java.lang.System.out;


/*
 *  Вернуть лямбду, которая решает уравнение x^2 + 3x – 1 для заданного x
 */

public class Lambda15 {
    static IntUnaryOperator getLambda() {
        return  x-> x * x + 3 * x - 1;
    }

    private static void showEquation( int num, IntUnaryOperator lambda ) {

        out.println( "calc: " +
                " x = " +
                num +
                ", x^2 + 3x - 1 = " +
                lambda.applyAsInt( num )
        );

    }

    private static void doTask() {

        IntUnaryOperator lambda = getLambda();

        showEquation( 2, lambda );
        showEquation( 4, lambda );
        showEquation( -2, lambda );
    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 15 );
        doTask();

    }
}