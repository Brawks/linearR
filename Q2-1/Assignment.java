// Author: Samuel Saint-Fleur
// Course: ITI 1121 University of Ottawa
// Assignment: 1
// Question: 2-1
/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. 
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 * @author Samuel Saint-Fleur
 */

public class Assignment {


	/** 
     * Random generator 
     */
	private static java.util.Random generator = new java.util.Random();

    /** 
     * In this first method, we are simply using sample points that are
     * on a straight plane. We will use the plane z= x + 2x.
     * In his method, 
     * 	1) we create an instance of LinearRegression.
     * 	2) we add 2,000 samples from the plane z= x + 2x as follows:
     * 		add the sample [(i, 2i), 5i] for 0<=i<=999
     * 		add the sample [(2i, i), 4i] for 0<=i<=999
     *  3) we iterate gradient descent 10,000, printing out the
     * current hypothesis and the current cost every 1,000 
     * iterations, using a step alpha of 0.000000003
     */
    private static void setPlane(){

		// your code goes there
        LinearRegression linG;
        linG = new LinearRegression(2,2000);

        for(double i = 0; i < 1000; i+=1)
        {
            double[] pt1, pt2;
            pt1 = new double[2];
            pt2 = new double[2];

            pt1[0] = i;
            pt2[0] = 2.0*i;

            pt1[1] = 2.0*i;
            pt2[1] = i;

            linG.addSample(pt1,5.0*i);
            linG.addSample(pt2,4.0*i);
        }
        

        System.out.println("Current hypothesis :" + linG.currentHypothesis());
        System.out.println("Current cost :" + linG.currentCost());

        for(int i = 1; i <= 10; i++)
        {
            linG.gradientDescent(0.000000003,1000);

            System.out.println("Current hypothesis :" + linG.currentHypothesis());
            System.out.println("Current cost :" + linG.currentCost());
        }
	}




	public static void main(String[] args) {

		System.out.println("setPlane");
		setPlane();


	}

}
