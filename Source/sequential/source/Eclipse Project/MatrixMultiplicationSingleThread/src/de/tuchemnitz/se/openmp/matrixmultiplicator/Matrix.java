package de.tuchemnitz.se.openmp.matrixmultiplicator;

import java.util.concurrent.ThreadLocalRandom;

public class Matrix {

	private final int[][] matrix;
	
	public Matrix(int m, int n) {
		matrix = new int[m][n];
	}
	
	
	public int[][] getContent(){
		return matrix;
	}


	public int getWidth() {
		return matrix.length;
	}
	
	public int getHeight(){
		return matrix[0].length;
	}


	public int getCell(int m, int n) {
		return matrix[m][n];
	}
	
	public void addToCell(int m, int n, int toAdd){
		matrix[m][n] += toAdd;
	}
	
	/**
	 * prints a given matrix in the terminal 
	 * 
	 * @param aMatrix matrix to print
	 */
	public void printMatrix(){
		System.out.println("--------------- Matrix ---------------");
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * fills the given matrix with random numbers between 0 and 10.
	 * It will overwrite all values in the matrix. 
	 * 
	 * @param aMatrix matrix to fill 
	 */
	public void fillMatrixRandom(){
		// omp parallel for schedule(static)
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				matrix[i][j] = ThreadLocalRandom.current().nextInt(0, 10 + 1);
			}
		}	
	}
}
