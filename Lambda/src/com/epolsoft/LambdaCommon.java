package com.epolsoft;

import java.util.function.UnaryOperator;

import static java.lang.System.out;

class LambdaCommon {

    @FunctionalInterface
    public interface Greeting {
        void show( String name );
    }

    static void showTask( int task_num ) {
        out.println( "\nTask: Lambda" +
                task_num + "\n"
        );
    }

    static UnaryOperator<Float> square = z -> z * z;
}
