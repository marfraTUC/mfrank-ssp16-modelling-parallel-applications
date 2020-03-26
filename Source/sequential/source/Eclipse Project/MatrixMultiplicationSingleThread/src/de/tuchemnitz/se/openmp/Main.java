package de.tuchemnitz.se.openmp;

import java.io.IOException;
import java.util.ArrayList;

import de.tuchemnitz.se.openmp.matrixmultiplicator.MatrixMultiplicationVariants;

/**
 * 
 * 
 * @author mfrank
 * @version 0.8
 */
public class Main {

	

	
	/**
	 * Main method which initialise a multiplicator from the set type first.
	 * 
	 * Further the method contains the experiment-loop, which will call the multiplyMatrix method EXPERIMENT_RUNS times.  
	 * 
	 * 
	 * @param args
	 *            not used jet
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ArrayList<MatrixMultiplicationVariants> variants = new ArrayList<MatrixMultiplicationVariants>();
		
		//variants.addAll(Arrays.asList(MatrixMultiplicationVariants.values()));
		
		variants.add(MatrixMultiplicationVariants.VARIANT_B);
		
		new ExperimentManager(variants);
	}

		

	}

	