package de.tuchemnitz.se.openmp.matrixmultiplicator.variants;

import de.tuchemnitz.se.openmp.matrixmultiplicator.Matrix;
import de.tuchemnitz.se.openmp.matrixmultiplicator.MatrixMultiplicator;

public class MatrixMultiplicatorVariantC extends MatrixMultiplicator {

	@Override
	public long multiplyMatrix(final Matrix matrixA, final Matrix matrixB, Matrix result) {
		
		int[][] contentResult = result.getContent();
		int[][] contentMatrixA = matrixA.getContent();
		int[][] contentMatrixB = matrixB.getContent();
		
		long start, end;
		start = System.nanoTime();

		// omp parallel for schedule(static)
		for (int j = 0; j < matrixA.getWidth(); j++) {
			for (int i = 0; i < matrixB.getHeight(); i++) {
				for (int k = 0; k < matrixA.getHeight(); k++) {
					contentResult[i][j] = contentResult[i][j] + contentMatrixA[i][k] * contentMatrixB[k][j];
					// result[i][j] = result[i][j] + matrixA[i][k] *
					// matrixB[k][j];
				}
			}
		}

		end = System.nanoTime();
		return end - start;

	}

}
