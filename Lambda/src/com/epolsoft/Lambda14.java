package com.epolsoft;

import java.util.function.UnaryOperator;

import static java.lang.System.out;


/*
 *  Добавить к лямбде,
 *    которая выполняет инкремент и возводит число в квадрат, декремент после
 */

public class Lambda14 {
    private static UnaryOperator<Float> getLambda() {
        UnaryOperator<Float> decrement = z -> z - 1;
        UnaryOperator<Float> incSquare = Lambda13.getLambda(); // z -> ( z + 1 ) ^2

        return  z -> incSquare.andThen( decrement ).apply( z );
    }

    private static void showIncSquare( float num, UnaryOperator<Float> lambda ) {

        out.println( "calc: (" +
                num +
                " + 1 )^2 - 1 = " +
                lambda.apply( num )
        );

    }

    private static void doTask() {

        UnaryOperator<Float> lambda = getLambda();

        showIncSquare( 8, lambda );
        showIncSquare( (float) 3.5, lambda );
        showIncSquare( -5, lambda );
    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 14 );
        doTask();

    }
}