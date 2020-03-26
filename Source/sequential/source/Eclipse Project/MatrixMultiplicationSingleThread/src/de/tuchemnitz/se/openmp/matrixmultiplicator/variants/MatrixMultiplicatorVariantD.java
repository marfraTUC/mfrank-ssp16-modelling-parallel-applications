package de.tuchemnitz.se.openmp.matrixmultiplicator.variants;

import de.tuchemnitz.se.openmp.matrixmultiplicator.Matrix;
import de.tuchemnitz.se.openmp.matrixmultiplicator.MatrixMultiplicator;

public class MatrixMultiplicatorVariantD extends MatrixMultiplicator{

	public long multiplyMatrix(final Matrix matrixA, final Matrix matrixB, final Matrix result ) {

		int[][] contentResult = result.getContent();
		int[][] contentMatrixA = matrixA.getContent();
		int[][] contentMatrixB = matrixB.getContent();
		
		long start,end;
		start = System.nanoTime();
		
		// omp parallel for schedule(static)
		for (int j = 0; j < matrixA.getWidth(); j++) {
			for (int k = 0; k < matrixB.getHeight(); k++) {
				for (int i = 0; i < matrixA.getHeight(); i++) {
					contentResult[i][j] = contentResult[i][j] + contentMatrixA[i][k] * contentMatrixB[k][j];				
				}
			}
		}
		
		end = System.nanoTime();
		return end-start;
	}

}
