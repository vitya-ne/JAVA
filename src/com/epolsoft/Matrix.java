package com.epolsoft;

import java.util.Scanner;

public class Matrix {
    private int[][] values;
    private int x_size;
    private int y_zise;

    public int[][] getValues() {
        return values;
    }

    public void setValues( int[][] new_values ) {
        values = new_values;
    }

    public static int[][] enterData( int x_size, int y_zise ) {
        Scanner in = new Scanner(System.in);
        int[][] result = new int[x_size][y_zise];

        for (int i = 0; i < x_size; i++) {
            for (int j = 0; j < y_zise; j++) {
                result[i][j] = in.nextInt();
            }
            System.out.print( "\n" );

        }

        return result;
    }

    public void addMatrix( Matrix matrix ) {
        int[][] current = this.values;
        int[][] second_matrix = matrix.getValues();

        for (int i = 0; i < this.x_size; i++) {
            for (int j = 0; j < this.y_zise; j++) {
                current[i][j] = current[i][j] + second_matrix[i][j];
            }

        }

    }

    public void subMatrix( Matrix matrix ) {
        int[][] current = this.values;
        int[][] second_matrix = matrix.getValues();

        for (int i = 0; i < this.x_size; i++) {
            for (int j = 0; j < this.y_zise; j++) {
                current[i][j] = current[i][j] - second_matrix[i][j];
            }

        }

    }

    public void printData() {
        System.out.println( "Matrix data [ " + x_size + ":" + y_zise + "]:" );

        for (int i = 0; i < x_size; i++) {
            for (int j = 0; j < y_zise; j++) {
                System.out.print( " " + this.values[i][j]);
            }
            System.out.print( "\n" );
        }

    }


    public Matrix( int x_size, int y_zise ) {
        this.x_size = x_size;
        this.y_zise = y_zise;
        this.values = enterData( x_size, y_zise );
    }

}
