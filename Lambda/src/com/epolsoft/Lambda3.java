package com.epolsoft;

import com.epolsoft.LambdaCommon.Greeting;
import static java.lang.System.out;

public class Lambda3 {

    @FunctionalInterface
    private interface FullGreeting {
        void show( String name, Greeting greeting );
    }

    private static FullGreeting getFullLambda() {
        return ( name, hello ) -> {
            hello.show( name );
            out.println( "Have a nice day!" );
        };
    }

    private static void sayFullGreetingTo( String name, FullGreeting greeting ) {
        Greeting hello = Lambda2.getLambda();

        greeting.show( name, hello );
    }

    private static void doTask() {
        String name = "Kitty";

        FullGreeting greeting = getFullLambda();

        sayFullGreetingTo( name, greeting );

    }

    public static void main( String[] args ) {

        LambdaCommon.showTask( 3 );
        doTask();

    }
}