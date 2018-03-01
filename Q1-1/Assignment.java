// Author: Samuel Saint-Fleur
// Course: ITI 1121 University of Ottawa
// Assignment: 1
// Question: 1-1
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
     * In this first method, we are simply using sample points that are
     * on a straight line, namely y = x;
     * In his method, 
     *    1) we create an instance of LinearRegression.
     *    2) we add 1,000 samples (from 0 to 999) from the line y=x
     *  3) We create an instance of Display
     *  4) we iterate gradient descent 5,000, updating the instance
     * of Display every 100 iteration, using a step alpha of 0.000000003
     */

     private static void setLine(){

          // your code goes there
          LinearRegression linG;
          linG = new LinearRegression(1000);
          for(double i = 0; i < 1000;i++)
          {
               linG.addSample(i,i);
          }

          System.out.println("Current hypothesis :" + linG.currentHypothesis());
          System.out.println("Current cost :" + linG.currentCost());

          Display myDisplay;
          myDisplay = new Display(linG);
          myDisplay.update();

          for(int i = 1; i <= 50; i++)
          {
               linG.gradientDescent(0.000000003,100);
               System.out.println("Current hypothesis :" + linG.currentHypothesis());
               System.out.println("Current cost :" + linG.currentCost());
               myDisplay.update();
          }
     }



     public static void main(String[] args) {

          System.out.println("setLine");
          setLine();

     }

}