package com.epolsoft;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import static java.lang.System.out;


/*
 *  Вернуть лямбду, которая возвращает сумму двух входных аргументов
 *  К предыдущей лямбде добавить возведение в квадрат
 */

public class Lambda10 {

    static BinaryOperator<Float> getLambda() {
        UnaryOperator<Float> square = z -> z * z;
        BinaryOperator<Float> sum = Lambda9.getLambda();
        return ( x, y ) -> square.apply( sum.apply( x, y) );
    }

    private static void showSum( float num1, float num2, BinaryOperator<Float> lambda ) {

        out.println( "calc: (" +
                num1 +
                " + " +
                num2 +
                ")^2 = " +
                lambda.apply( num1, num2 )
        );

    }

    private static void doTask() {

        BinaryOperator<Float> lambda = getLambda();

        showSum( 2, 5, lambda );
        showSum( (float)12, -9, lambda );
        showSum( -5, (float)3, lambda );
    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 10 );
        doTask();

    }
}