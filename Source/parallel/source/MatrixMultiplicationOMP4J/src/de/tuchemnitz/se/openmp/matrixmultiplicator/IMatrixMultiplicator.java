package de.tuchemnitz.se.openmp.matrixmultiplicator;

/**
 * Interface for the MatrixMultiplicator Component. 
 * 
 * @author mfrank
 * @version 0.8
 */
public interface IMatrixMultiplicator {

	/**
	 * Multiplies two matrixes and returns the result in a new matrix  
	 * 
	 * @param matrixA first matrix
	 * @param matrixB second matrix 
	 * @return result of the multiplication
	 */
	public long multiplyMatrix(final Matrix matrixA, final Matrix matrixB, final Matrix res);
	 
	
}
