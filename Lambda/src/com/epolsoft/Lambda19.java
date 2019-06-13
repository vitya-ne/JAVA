package com.epolsoft;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

import static java.lang.System.out;


/*
 *  Вернуть лямбду, которая производит композицию двух функций.
 *    (f1,f2) => f2(f1(x)) . Для этого реализовать функциональный интерфейс.
 *    f.compose(x->x*2,x->x-1).apply(10))
 */

public class Lambda19 {
    @FunctionalInterface
    private interface Compose {
        IntUnaryOperator compose( IntUnaryOperator f, IntUnaryOperator s );
    }

    static Compose getLambda() {
        return ( x, y ) -> y.compose( x );

    }

    private static void showExp( IntUnaryOperator f, IntUnaryOperator s, Integer i, Compose lambda ) {

        IntUnaryOperator result = lambda.compose( f, s );
        out.print( "calc: " +
                result.applyAsInt( i ) +
                "\n"
        );

    }

    private static void doTask() {

        Compose lambda = getLambda();

        showExp( x->x*2, x->x-1, 10, lambda );
        showExp(
                lambda.compose(x -> x * x, x -> x - 10),
                lambda.compose( x -> x / 2, x -> x + 1 ),
                10,
                lambda
        );
    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 19 );
        doTask();

    }
}