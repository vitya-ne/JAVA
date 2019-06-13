package com.epolsoft;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;

import static java.lang.System.out;


/*
 *  Вернуть лямбду, которая запоминает степень, и возвращает лямбду
 *    возводящую входящее значение в степень
 */

public class Lambda18 {

    private static Function<Integer, IntUnaryOperator> getLambda() {
        return x -> y -> (int) Math.pow( y, x );
    }

    private static void showExp(int x, int y, Function<Integer, IntUnaryOperator> lambda ) {

        IntUnaryOperator exp = lambda.apply( y );
        out.print( "calc: " +
                "\nx = " + x +
                ", y = " + y +
                "\nx^y = " +
                exp.applyAsInt( x ) +
                "\n\n"
        );

    }

    private static void doTask() {

        Function<Integer, IntUnaryOperator> lambda = getLambda();

        showExp( 2, 3, lambda );
        showExp( 4, 2, lambda );
        showExp( 10, 3, lambda );
    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 18 );
        doTask();

    }
}