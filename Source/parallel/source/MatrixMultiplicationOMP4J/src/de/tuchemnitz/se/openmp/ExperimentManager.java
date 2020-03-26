package de.tuchemnitz.se.openmp;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.tuchemnitz.se.openmp.filewriter.CSVWriter;
import de.tuchemnitz.se.openmp.matrixmultiplicator.Matrix;
import de.tuchemnitz.se.openmp.matrixmultiplicator.MatrixMultiplicationFactory;
import de.tuchemnitz.se.openmp.matrixmultiplicator.MatrixMultiplicationVariants;
import de.tuchemnitz.se.openmp.matrixmultiplicator.MatrixMultiplicator;

public class ExperimentManager {

	/**
	 * number of repetition - the experiment will be repeated x times
	 */
	private static final int EXPERIMENT_RUNS = 500;

	/**
	 * The matrix A
	 */
	private static final Matrix EXPERIMENT_MATRIX_A = new Matrix(3000,3000);

	/**
	 * The matrix B
	 */
	private static final Matrix EXPERIMENT_MATRIX_B = new Matrix(3000,3000);

	
	/**
	 * If this is set to true. The Matrix A, B and the result of the multiplication is printed to commandline 
	 */
	private static final boolean EXPERIEMENT_PRINT_RESULTS = false;

	/**
	 * A static logger used for the logging.
	 */
	private final Logger log = Logger.getLogger(Main.class.getName());

	/**
	 * CSV file writer which is used to write the measurements in a csv file
	 */
	private final CSVWriter writer;

	/**
	 * line record for the CSVWriter
	 */
	private String record;

	/**
	 * @throws IOException
	 *             when CSVWriter can not access file
	 */
	public ExperimentManager(final List<MatrixMultiplicationVariants> variantList ) throws IOException {
		MatrixMultiplicator multiplicator;

		writer = new CSVWriter(getDate() + ".csv");
		record = new StringBuilder().append("Run_Nr").append(";").append("TimeStamp").append(";")
				.append("Multiplication_Variant").append(";").append("Timestamp").toString();
		writer.writeLine(record);

		long duration;
		for (MatrixMultiplicationVariants variant : variantList) {
			multiplicator = MatrixMultiplicationFactory.getMatrixMultiplicator(variant);
			for (int i = 0; i < EXPERIMENT_RUNS; i++) {

				duration = multiplyMatrix(EXPERIMENT_MATRIX_A, EXPERIMENT_MATRIX_B, multiplicator);
				writeResultToFile(i, duration, variant);
				
				log.log(Level.INFO, "Run " + i + "/" + EXPERIMENT_RUNS + ": toke " + duration / 1000000 + "ms");

			}
		}

		writer.close();
	}

	private void writeResultToFile(int run, long duration, MatrixMultiplicationVariants variant) {

		record = new StringBuilder().append(run).append(";").append(getDate()).append(";").append(variant).append(";")
				.append(duration).toString();
		writer.writeLine(record);

	}

	private String getDate() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

		Date today = Calendar.getInstance().getTime();

		return df.format(today);
	}

	/**
	 * 
	 * In this method matrixA and matrixB are initialized with random numbers
	 * for the size given by m,n,i,j.
	 * 
	 * Further this method calls the multiplication method and multiplies the
	 * matrixA with matrixB.
	 * 
	 * @param matrixA
	 *            matrix A (m*n)
	 * @param matrixB
	 *            matrix B (m*n)
	 * @param multiplicator
	 *            MatrixMultiplicator, on which the multiplicate matrix method
	 *            is called. Should not be null!
	 * @return the duration of the actual matrix multiplication
	 */
	private long multiplyMatrix(final Matrix matrixA, final Matrix matrixB, final MatrixMultiplicator multiplicator) {

		final Matrix res = new Matrix(matrixA.getWidth(), matrixB.getHeight());

		matrixA.fillMatrixRandom();
		matrixB.fillMatrixRandom();

		long duration = multiplicator.multiplyMatrix(matrixA, matrixB, res);
		
		if(EXPERIEMENT_PRINT_RESULTS){
			System.out.println("--------- MATRIX A ---------");
			matrixA.printMatrix();
			System.out.println("--------- MATRIX B ---------");
			matrixB.printMatrix();
			System.out.println("--------- RESULT ---------");
			res.printMatrix();
		}
		
		return duration;

	}
}
