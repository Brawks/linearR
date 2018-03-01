// Author: Samuel Saint-Fleur
// Course: ITI 1121 University of Ottawa
// Assignment: 1
// Question: 1-2
/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. It uses the
 * provided class <b>Display</b> to show the results
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
     * In this second method, we will select a line at random.
     * 	1) we select a line y = ax + b, with a randomly selected
     * between -100 and +100 and b randomly selected between 
     * -250 and +250
     * 	2) we add 500 samples randomly selected on the line
     * between -100 and +300. For each sample we add a "noise" 
     * randomly selected between -1000 and +1000 (that is, for
     * each randomly selected x, we add the sample (x, ax+b+noise).
     * where "noise" is randomly selected between -1000 and 1000
     *  3) We create an instance of Display
     *  4) we iterate gradient descent (find a number of iterations,
     * a number of updates to the instance of Display, and a 
     * step alpha that seems to work
     */
	private static void randomLine(){

		// your code goes there
          LinearRegression linG;
          linG = new LinearRegression(500);
          double la,lb;
          la = generator.nextDouble();
          lb = generator.nextDouble();
          double a,b;
          a = (200.0*(la-0.0)) + -100.0;
          b = (500.0*(lb-0.0)) + -250.0;

          System.out.println("Current hypothesis :" + linG.currentHypothesis());
          System.out.println("Current cost :" + linG.currentCost());
          System.out.println("Aiming for : y = "+ a+"x + "+b);

          //x and y sample generation
          for (int i = 0; i <500; i++)
          {
               double lx,ly;
               lx = generator.nextDouble();
               ly = generator.nextDouble();
               double nx,ny;

                    //X section, [-100,300] 
               nx = 400.0*lx + -100;   
               //Y section, [ax + b - 1000, ax + b + 1000]
               ny = ((a*nx+b+1000)-(a*nx+b-1000))*ly + (a*nx+b-1000);
               linG.addSample(nx,ny);              
          }
          Display myDisplay;
          myDisplay = new Display(linG);
          myDisplay.setTarget(a,b);
          myDisplay.update();

          for(int i = 1; i <= 50; i++)
          {
               linG.gradientDescent(0.000000009,1000);
               System.out.println("Current hypothesis :" + linG.currentHypothesis());
               System.out.println("Current cost :" + linG.currentCost());
               System.out.println("Aiming for : y = "+ a+"x + "+b);
               myDisplay.update();
          }
	}


	public static void main(String[] args) {

		System.out.println("randomLine");
		randomLine();

	}

}
