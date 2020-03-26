package de.tuchemnitz.se.openmp.matrixmultiplicator.variants;

import de.tuchemnitz.se.openmp.matrixmultiplicator.Matrix;
import de.tuchemnitz.se.openmp.matrixmultiplicator.MatrixMultiplicator;

public class MatrixMultiplicatorVariantB extends MatrixMultiplicator {

	@Override
	public long multiplyMatrix(final Matrix matrixA, final Matrix matrixB, final Matrix result) {

		int[][] contentResult = result.getContent();
		int[][] contentMatrixA = matrixA.getContent();
		int[][] contentMatrixB = matrixB.getContent();
		
		long start,end;
		start = System.nanoTime();

		// omp parallel for schedule(static)
		for (int i = 0; i < matrixA.getWidth(); i++) {
			for (int k = 0; k < matrixB.getHeight(); k++) {
				for (int j = 0; j < matrixA.getHeight(); j++) {
					//res.addToCell(i, j, (matrixA.getCell(i, k) * matrixB.getCell(k, j)));
					contentResult[i][j] = contentResult[i][j] + contentMatrixA[i][k] * contentMatrixB[k][j];
				}
			}
		}

		end = System.nanoTime();
		return end - start;
	}

}
