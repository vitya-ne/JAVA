package com.epolsoft;

import com.epolsoft.LambdaCommon.Greeting;
import static java.lang.System.out;

public class Lambda2 {

    static Greeting getLambda() {
        return name -> out.println( "Hello, " + name + " !" );
    }

    private static void sayGreetingTo( String name, Greeting greeting ) {
        greeting.show( name );
    }

    private static void doTask() {
        String name = "Dolly";
        Greeting greeting = getLambda();

        sayGreetingTo( name, greeting );

    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 2 );
        doTask();

    }
}