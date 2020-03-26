package de.tuchemnitz.se.openmp.matrixmultiplicator;

import de.tuchemnitz.se.openmp.matrixmultiplicator.variants.MatrixMultiplicatorVariantA;
import de.tuchemnitz.se.openmp.matrixmultiplicator.variants.MatrixMultiplicatorVariantB;
import de.tuchemnitz.se.openmp.matrixmultiplicator.variants.MatrixMultiplicatorVariantC;
import de.tuchemnitz.se.openmp.matrixmultiplicator.variants.MatrixMultiplicatorVariantD;
import de.tuchemnitz.se.openmp.matrixmultiplicator.variants.MatrixMultiplicatorVariantE;
import de.tuchemnitz.se.openmp.matrixmultiplicator.variants.MatrixMultiplicatorVariantF;

/**
 * Factory. Creates a new Instance of a specific matrix multiplicator type. 
 * 
 * @author mfrank
 * @verion 0.8
 *
 */
public class MatrixMultiplicationFactory {
 
	/**
	 * Creates a new Instance of a specific matrix multiplicator type. 
	 * 
	 * @param type matrix multiplicator type
	 * @return matrix multiplicator of given type
	 */
	public static MatrixMultiplicator getMatrixMultiplicator(final MatrixMultiplicationVariants type){
		MatrixMultiplicator res = null;
		
		switch (type) {
		case VARIANT_A:
			res = new MatrixMultiplicatorVariantA();
			break;

		case VARIANT_B:
			res = new MatrixMultiplicatorVariantB();
			break;
		
		case VARIANT_C:
			res = new MatrixMultiplicatorVariantC();
			break;
		
		case VARIANT_D:
			res = new MatrixMultiplicatorVariantD();
			break;
		case VARIANT_E:
			res = new MatrixMultiplicatorVariantE();
			break;
			
		case VARIANT_F:
			res = new MatrixMultiplicatorVariantF();
			break;
		default:
			break;
		}
		
		return res;
		
	}
}
