package com.epolsoft;

import java.util.function.UnaryOperator;

import static java.lang.System.out;


/*
 *  Добавить к лямбде, которая возводит число в квадрат инкремент после
 */

public class Lambda14 {
    private static UnaryOperator<Float> getLambda() {
        UnaryOperator<Float> square = Lambda12.getLambda(); // z -> z * z;

        return  z -> LambdaCommon.increment.apply( square.apply( z ) );
    }

    private static void showIncSquare( float num, UnaryOperator<Float> lambda ) {

        out.println( "calc: " +
                num +
                " ^2 + 1 = " +
                lambda.apply( num )
        );

    }

    private static void doTask() {

        UnaryOperator<Float> lambda = getLambda();

        showIncSquare( 8, lambda );
        showIncSquare( (float) 24.5, lambda );
        showIncSquare( -5, lambda );
    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 14 );
        doTask();

    }
}