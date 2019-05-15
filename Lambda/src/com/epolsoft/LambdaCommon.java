package com.epolsoft;

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
}
