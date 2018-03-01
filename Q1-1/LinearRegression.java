// Author: Samuel Saint-Fleur
// Course: ITI 1121 University of Ottawa
// Assignment: 1
// Question: 1-1
/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent with 1 variable.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 * @author Samuel Saint-Fleur
 */

public class LinearRegression {


	/** 
     * Number of samples (usually "m" in litterature) 
     */
	private int nbreOfSamples;


	/** 
     * the sample vector
     */
	private double[] samples;

	/** 
     * the samples target values
     */
	private double[] samplesValues;

	/** 
     * the current hypthesis function: theta0 + theta1 x
     */
	private double theta0, theta1;


	/** 
     * used to ensure that the object is ready
     */
	private int currentNbreOfSamples;



	/** 
     * counts how many iterations have been performed
     */
	private int iteration;


	/** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is y = 0;
     * 
     * 
     * @param m the number of samples that we will have
	 *
     */
 	public LinearRegression(int m){

 		// your code goes there
 		nbreOfSamples = m;
 		currentNbreOfSamples = 0;
 		iteration = 0;
 		theta0 = 0;
 		theta1 = 0;
 		samples = new double[m];
 		samplesValues = new double[m];
	}

	/** 
     * Adds a new sample to sample and to samplesValues. This
     * method must be iteratively called with all the samples
     * before the gradient descent can be started
     * 
     * @param x the new sample
     * @param y the corresponding expected value
     *
	 */
	public void addSample(double x, double y){

		// your code goes there
		samples[currentNbreOfSamples] = x;
		samplesValues[currentNbreOfSamples] = y;
		currentNbreOfSamples++;
	}

	/** 
     * Returns the current hypothesis for the value of the input
     * @param x the input for which we want the current hypothesis
     * 
	 * @return theta0 + theta1 x
	 */
	private double hypothesis(double x){
		// your code goes there
		return theta0 + theta1*x;
	}

	/** 
     * Returns a string representation of hypthesis function
     * 
	 * @return the string "theta0 + theta1 x"
	 */
	public String currentHypothesis(){

		// your code goes there
		return "h(x)= "+Double.toString(theta0)+" + "+Double.toString(theta1)+"x";
	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */
	public double currentCost(){
		// your code goes there
		double ans = 0;

		for(int i = 1; i <= nbreOfSamples; i++)
		{
			ans += (this.hypothesis(samples[i-1])-samplesValues[i-1])*(this.hypothesis(samples[i-1])-samplesValues[i-1]);
		}
		return (1.0/nbreOfSamples)*ans;
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
		for (int w = 0; w<numberOfSteps;w++)
		{
			double ans = 0;
			double ans1 = 0;
			for(int i = 1; i <= nbreOfSamples; i++)
			{
				ans+=(this.hypothesis(samples[i-1])-samplesValues[i-1]);
			}
			

			for(int i = 1; i <= nbreOfSamples; i++)
			{
				ans1+=((this.hypothesis(/*Xi*/samples[i-1])-/*Yi*/samplesValues[i-1])*samples[i-1]);
			}

			theta0 = theta0 - alpha*(2.0/nbreOfSamples)*ans;
			theta1 = theta1 - alpha*(2.0/nbreOfSamples)*ans1;
			iteration++;
		}
	}	




	/** 
     * Getter for theta0
     *
	 * @return theta0
	 */

	public double getTheta0(){
		// your code goes there
		return theta0;
	}

	/** 
     * Getter for theta1
     *
	 * @return theta1
	 */

	public double getTheta1(){
		// your code goes there
		return theta1;
	}

	/** 
     * Getter for samples
     *
	 * @return samples
	 */

	public double[] getSamples(){
		// your code goes there
		//Outsiders cannot get the original reference of samples in this way
		double[] tmp = new double[nbreOfSamples];
		for (int i = 0; i < nbreOfSamples; i++)
		{
			tmp[i] = samples[i];
		}
		return tmp;
	}

	/** 
     * Getter for getSamplesValues
     *
	 * @return getSamplesValues
	 */

	public double[] getSamplesValues(){
		// your code goes there
		//Outsiders cannot get the original reference of sampleValues in this way
		double[] tmp = new double[nbreOfSamples];
		for (int i = 0; i < nbreOfSamples; i++)
		{
			tmp[i] = samplesValues[i];
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