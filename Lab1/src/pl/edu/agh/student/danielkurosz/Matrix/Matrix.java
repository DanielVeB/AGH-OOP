package pl.edu.agh.student.danielkurosz.Matrix;

import java.util.Scanner;

class Matrix {
    private int[][] table;

    Matrix(int _x, int _y) {
        table = new int[_x][_y];
    }

    Matrix(Matrix a) {
        this.table = new int[a.table.length][a.table[0].length];
        for (int i = 0; i < a.table.length; ++i) {
            System.arraycopy(a.table[i], 0, table[i], 0, a.table[0].length);
        }
    }

    void display() {
        for (int[] aTable : table) {
            for (int j :aTable) {
                System.out.print(j+" | ");
            }
            System.out.println();
        }
    }

    void setTable() {
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i < table.length; ++i) {
            for (int j = 0; j < table[0].length; ++j) {
                System.out.print((i+1)+" rzad, "+(j+1)+" kolejka: ");
                table[i][j]=scanner.nextInt();
            }

        }
    }
    Matrix add(Matrix a)throws OwnException{
        if(!check(a))throw new OwnException("Macierz jest zlych wymiarow");
        Matrix newmatrix=new Matrix(table.length,table[0].length);
        for (int i=0;i<table.length;++i){
            for (int j=0;j<table[0].length;++j){
                newmatrix.table[i][j]=table[i][j]+a.table[i][j];
            }
        }
        return newmatrix;
    }
    Matrix sub(Matrix a)throws OwnException{
        if(!check(a))throw new OwnException("Macierz jest zlych wymiarow");
        Matrix newmatrix=new Matrix(table.length,table[0].length);
        for (int i=0;i<table.length;++i){
            for (int j=0;j<table[0].length;++j){
                newmatrix.table[i][j]=table[i][j]-a.table[i][j];
            }
        }
        return newmatrix;
    }
    Matrix mul(Matrix a)throws OwnException{
        if(!checkformultiply(a))throw new OwnException("Macierz jest zlych wymiarow");
        Matrix newmatrix=new Matrix(table.length,a.table[0].length);
        int sum;
        for(int i=0;i<newmatrix.table.length;++i){
            for (int j=0;j<newmatrix.table[0].length;++j){
                sum=0;
                for(int k=0;k<a.table.length;++k){
                    sum+=table[i][k]*a.table[k][j];
                }
                newmatrix.table[i][j]=sum;
            }
        }
        return newmatrix;
    }

    private boolean check(Matrix a){
        return (this.table.length==a.table.length && this.table[0].length==a.table[0].length);
    }
    private boolean checkformultiply(Matrix a){
        return (this.table[0].length==a.table.length );
    }
}

class OwnException extends Exception{
    OwnException(String message){
        System.out.print(message);
    }
}
