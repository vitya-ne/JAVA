package com.epolsoft;

import java.util.function.IntUnaryOperator;

import static java.lang.System.out;


/*
 *  Вернуть лямбду, которая решает уравнение x*x*x + y*y*y + z*z*z + u*u*u + v*v*v для заданных (x,y,z,u,v)
 */

public class Lambda17 {
    @FunctionalInterface
    private interface FuncFiveArgs<One, Two, Three, Four, Five> {
        Five apply( One one, Two two, Three three, Four four, Five five );
    }

    static FuncFiveArgs getLambda() {
        IntUnaryOperator cube = x -> x * x * x;
        return  ( x, y, z, u, v ) ->
                cube.applyAsInt( (Integer) x ) +
                cube.applyAsInt( (Integer) y ) +
                cube.applyAsInt( (Integer) z ) +
                cube.applyAsInt( (Integer) u ) +
                cube.applyAsInt( (Integer) v );

    }

    private static void showEquation( int x, int y, int z, int u, int v, FuncFiveArgs lambda ) {

        out.print( "calc: " +
                "\nx = " + x +
                ", y = " + y +
                ", z = " + z +
                ", u = " + u +
                ", v = " + v +
                "\nx*x*x + y*y*y + z*z*z + u*u*u + v*v*v = " +
                lambda.apply( x, y, z, u, v ) +
                "\n\n"
        );

    }

    private static void doTask() {

        FuncFiveArgs lambda = getLambda();

        showEquation( 2,4,5 ,8 ,4 , lambda );
        showEquation( 4,5,32, 10,-5, lambda );
        showEquation( -2, 1, 0,14 ,5 , lambda );
    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 17 );
        doTask();

    }
}