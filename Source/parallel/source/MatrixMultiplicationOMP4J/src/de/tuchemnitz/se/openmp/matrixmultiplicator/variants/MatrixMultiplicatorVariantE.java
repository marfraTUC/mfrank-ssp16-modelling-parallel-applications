package de.tuchemnitz.se.openmp.matrixmultiplicator.variants;

import de.tuchemnitz.se.openmp.matrixmultiplicator.Matrix;
import de.tuchemnitz.se.openmp.matrixmultiplicator.MatrixMultiplicator;

public class MatrixMultiplicatorVariantE extends MatrixMultiplicator {

	@Override
	public long multiplyMatrix(final Matrix matrixA, final Matrix matrixB, final Matrix result) {

		int[][] contentResult = result.getContent();
		int[][] contentMatrixA = matrixA.getContent();
		int[][] contentMatrixB = matrixB.getContent();
		
		long start,end;
		start = System.nanoTime();

		// omp parallel for schedule(static) threadNum(2)
		for (int k = 0; k < matrixA.getWidth(); k++) {
			for (int i = 0; i < matrixB.getHeight(); i++) {
				for (int j = 0; j < matrixA.getHeight(); j++) {
					contentResult[i][j] = contentResult[i][j] + contentMatrixA[i][k] * contentMatrixB[k][j];
				}
			}
		}

		end = System.nanoTime();
		return end - start;

	}

}