// Author: Samuel Saint-Fleur
// Course: ITI 1121 University of Ottawa
// Assignment: 1
// Question: 2-3
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
     * 		add the sample [(i, 2i), 5i] for 0&lt;=i&lt;=999
     * 		add the sample [(2i, i), 4i] for 0&lt;=i&lt;=999
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

	/** 
     * In this second method, we will select a plane at random.
     * 	1) we select a line z = ax + by + c, with a, b and c 
     * randomly selected between -100 and +100 
     * 	2) we add 5000 samples randomly selected on the plane
     * with x and y both randomly selected between 50 and 4000. 
     * For each sample we add a "noise" 
     * randomly selected between -20 and +20 (that is, for
     * each randomly selected x and y we add the sample 
     *[ (x,y), ax+by+c+noise).
     * where "noise" is randomly selected between -20 and 20
     *  4) we iterate gradient descent (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     */

	private static void randomPlane(){

		// your code goes there
          LinearRegression linG;
          linG = new LinearRegression(2,5000);
          double la,lb,lc;
          la = generator.nextDouble();
          lb = generator.nextDouble();
          lc = generator.nextDouble();
          double a,b,c;
          a = (200.0*(la)) + -100.0;
          b = (200.0*(lb)) + -100.0;
          c = (200.0*(lc)) + -100.0;

          for (int i = 0; i < 5000; i++)
          {
               double lx,ly,lnoise;
               double x,y,noise;
               lx = generator.nextDouble();
               ly = generator.nextDouble();
               lnoise = generator.nextDouble();

               x = (3950.0*(lx)) + 50.0;
               y = (3950.0*(ly)) + 50.0;
               noise = (40.0*(lnoise)) + -20.0;

               double[] tmp;
               tmp = new double[2];
               tmp[0] = x;
               tmp[1] = y;

               linG.addSample(tmp,a*x + b*y + c + noise);

          }

          System.out.println("Current hypothesis :" + linG.currentHypothesis());
          System.out.println("Current cost :" + linG.currentCost());
          System.out.println("Aiming for : x_3 = "+ a+"x_1 + "+b+"x_2 + "+c+"\n");

          for(int i = 0; i < 10; i++)
          {
               linG.gradientDescent(0.00000004,666);

               System.out.println("Current hypothesis :" + linG.currentHypothesis());
               System.out.println("Current cost :" + linG.currentCost());
               System.out.println("Aiming for : x_3 = "+ a+"x_1 + "+b+"x_2 + "+c+"\n");
          }
	}

	/** 
     * In this third method, we will follow the same approach
     * that the one followed in the method  randomPlane, but
     * this time we will have a variable number of dimensions,
     * specified by the parameter "dimension". We will
     * create 5000 samples of "dimension" dimension, where each
     * dimension will be ranmly selected between  -100 and +100,
     * and a randomly selected noise between -20 and +20 will be
     * added to the result.We will then iterate gradient descent 
     * (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     *
     * @param dimension the number of features
     */
	private static void randomDimension(int dimension){

		// your code goes there
          LinearRegression linG;
          linG = new LinearRegression(dimension,5000);
          double[] lt;
          double[] t;
          String target;
          target = "";

          t = new double[dimension+1];
          lt = new double[dimension+1];

          //Target Values randomized values
          for (int i = 0; i < dimension; i++)
               {
                    lt[i] = generator.nextDouble();
               }

          //Target values ((a)x, (b)y, (c)z...)
          for (int i = 0; i < dimension+1; i++)
          {
               t[i] = (200.0*(lt[i])) + -100.0;
          }

          //Population of 5000 points in LinearRegression
          for (int i = 0; i < 5000; i++)
          {
               double[] lxn;
               double[] xn;
               double lnoise, r, noise;

               //Multivariables
               lxn = new double[dimension];
               xn = new double[dimension];

               //Noise
               lnoise = generator.nextDouble();
               noise = (40.0*(lnoise)) + -20.0;
               r = 0;

               //nextDouble randomized values for multivariables
               for (int w = 0; w < dimension; w++)
               {
                    lxn[w] = generator.nextDouble();
               }

               //Calculation of all vectors (randomizing)
               for (int w = 0; w < dimension; w++)
               {
                    xn[w] = (3950.0*(lxn[w])) + 50.0;
               }

               //Passing vector for input in LinearRegression
               double[] tmp;
               tmp = new double[dimension];
               for (int w = 0; w < dimension; w++)
               {
                    tmp[w] = xn[w];
               }

               //Calculation for r in ((x1...xn)r) in input
               for (int w = 0; w < dimension; w++)
               {
                    r += t[w]*xn[w];
               }
               r += t[dimension] + noise;

               linG.addSample(tmp,r);

          }
          int s = dimension + 1;
          target += "Aiming for : x_" + s + " = ";

          for (int z=0; z<dimension+1;z++)
          {
               int su = z+1;
               if (z != dimension){
                  target += t[z] + "x_"+(su)+" ";  
             } else {
               target += t[z];
             }
               
          }
          System.out.println("Current hypothesis :" + linG.currentHypothesis());
          System.out.println("Current cost :" + linG.currentCost());
          System.out.println(target+"\n");

          for(int i = 0; i < 10; i++)
          {
               linG.gradientDescent(0.000000004,250);

               System.out.println("Current hypothesis :" + linG.currentHypothesis());
               System.out.println("Current cost :" + linG.currentCost());
               System.out.println(target+"\n");
          }
	}


	public static void main(String[] args) {

		System.out.println("randomDimension");
		randomDimension(50);


	}

}
