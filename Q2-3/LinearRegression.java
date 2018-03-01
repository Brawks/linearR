// Author: Samuel Saint-Fleur
// Course: ITI 1121 University of Ottawa
// Assignment: 1
// Question: 2-3
/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent for multiple variables
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 * @author Samuel Saint-Fleur 
 */

public class LinearRegression{


	/** 
     * Number of features (usually "n" in litterature) 
     */
	private int nbreOfFeatures;

	/** 
     * Number of samples (usually "m" in litterature) 
     */
	private int nbreOfSamples;


	/** 
     * the nbreOfFeatures X nbreOfSamples Matrix of samples
     */
	private double[][] samplesMatrix;

	/** 
     * the nbreOfSamples Matrix of samples target values
     */
	private double[] samplesValues;

	/** 
     * the nbreOfFeatures Matrix theta of current hypthesis function
     */
	private double[] theta;


	/** 
     * number of samples received so far
     */
	private int currentNbreOfSamples;

	/** 
     * a place holder for theta during descent calculation
     */
	private double[] tempTheta;


	/** 
     * counts how many iterations have been performed
     */
	private int iteration;


	/** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is theta[i]=0.0 for all i
     * 
     * @param n the number of features that we will have
     * @param m the number of samples that we will have
	 *
     */
 	public LinearRegression(int n, int m){

		// your code goes there
 		nbreOfSamples = m;
 		nbreOfFeatures = n+1;
 		currentNbreOfSamples = 0;
 		iteration = 0;
 		theta = new double[nbreOfFeatures];
 		tempTheta = new double[nbreOfFeatures];
 		samplesMatrix = new double[m][nbreOfFeatures];
 		samplesValues = new double[m];
	}

	/** 
     * Add a new sample to samplesMatrix and samplesValues
     * 
     * @param x the vectors of samples
     * @param y the coresponding expected value
     *
	 */
	public void addSample(double[] x, double y){

		// your code goes there
		for (int i = 0; i < nbreOfFeatures; i++)
		{
			if (i == 0) {
				samplesMatrix[currentNbreOfSamples][0] = 1;
			} else {
				samplesMatrix[currentNbreOfSamples][i] = x[i-1];
			}
		}
		samplesValues[currentNbreOfSamples]=y;
		currentNbreOfSamples++;
	}

	/** 
     * Returns the current hypothesis for the value of the input
     * @param x the input vector for which we want the current hypothesis
     * 
	 * @return h(x)
	 */

	private double hypothesis(double[] x){

		// your code goes there
		double ans=0.0;
		for (int i = 0; i < nbreOfFeatures; i++)
		{
			ans+=theta[i]*x[i];
		}
		return ans;
	}

	/** 
     * Returns a string representation of hypthesis function
     * 
	 * @return the string "theta0 x_0 + theta1 x_1 + .. thetan x_n"
	 */

	public String currentHypothesis(){

		// your code goes there
		String hypo;
		hypo = "h(x) = ";
		for(int i = 0; i < nbreOfFeatures; i++)
		{
			hypo += theta[i]+"*"+"x_"+i;
			if (i!=nbreOfFeatures-1)
			{
				hypo += " + ";
			}
		}
		return hypo;
	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */

	public double currentCost(){

		// your code goes there
		double answer = 0.0;

		for(int i = 0; i < nbreOfSamples; i++)
		{
			answer += (this.hypothesis(samplesMatrix[i])-samplesValues[i])*(this.hypothesis(samplesMatrix[i])-samplesValues[i]);
		}
		return (1.0/nbreOfSamples)*answer;
	}

	/** 
     * runs several iterations of the gradient descent algorithm
     * 
     * @param alpha the learning rate
     *
     * @param numberOfSteps how many iteration of the algorithm to run
     */

	public void gradientDescent(double alpha, int numberOfSteps) {


		// your code goes there
		for (int z = 0;  z < numberOfSteps; z++)
		{
			for(int tmpT = 0; tmpT<nbreOfFeatures;tmpT++)
			{
				tempTheta[tmpT] = theta[tmpT];
			}
			for (int i = 0; i < nbreOfFeatures;i++)
			{
				double ans = 0;
				for (int w = 0; w < nbreOfSamples; w++)
				{
					ans += (this.hypothesis(samplesMatrix[w])-samplesValues[w])*samplesMatrix[w][i];
				}
				tempTheta[i] = tempTheta[i] - alpha*(2.0/nbreOfSamples)*ans;
			}
			for(int tmpT = 0; tmpT<nbreOfFeatures;tmpT++)
			{
					theta[tmpT] = tempTheta[tmpT];
			}
			iteration++;
		}
	}


	/** 
     * Getter for theta
     * Outsiders cannot get the original reference of theta in this way
	 * @return theta
	 */

	public double[] getTheta(){

		// your code goes there
		double[] tmp = new double[nbreOfFeatures];
		for (int i = 0; i <nbreOfFeatures; i++)
		{
			tmp[i]= theta[i];
		}
		return tmp;
	}

	/** 
     * Getter for iteration
     *
	 * @return iteration
	 */

	public int getIteration(){

		// your code goes there
		return iteration;
	}
}
