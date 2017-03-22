import java.io.*;
import java.util.*;
/*import java.awt.*;
import javax.swing.*;*/

public class ReduceToEchelonForm extends MatrixManipulationToolkit{
   public static void main(String[] args) throws FileNotFoundException{
      // This asks the user if he/she wants to import a matrix from a text file.
      Scanner input = new Scanner(System.in);
      System.out.println("Would you like to import a matrix from file: y/n");
      String userResponse = input.next();
      
      // The number of rows and columns are needed for the matrix dimensions.
      System.out.println("Enter number of rows:");
      int rows = input.nextInt();
      System.out.println("Enter number of columns:");
      int columns = input.nextInt();
      
      // This creates the user's matrix
      double[][] myMatrix = new double[rows][columns];
      
      // This loads the matrix if the user wishes.
      if(userResponse.equals("y") || userResponse.equals("y")) {
         loadMatrix(myMatrix, rows, columns, input);
         
      // This builds the matrix from scratch if the user wishes.
      } else {
         matrixDrawer(rows, columns);
         constructMatrix(input, myMatrix, rows, columns);
      }
      System.out.println("What would you like to do?");
      System.out.print("Press 'T' to find transpose. Press 'R' to reduce the matrix to reduced echelon form.");
      userResponse = input.next();
      if(userResponse.contains("R") || userResponse.contains("r")) {
         reduceToEchelonForm(myMatrix, rows, columns);
         matrixDrawer(myMatrix, rows, columns, rows * columns);
      } else if(userResponse.contains("T") || userResponse.contains("t")) {
         double[][] myTranspose = findTranspose(myMatrix, rows, columns);
         matrixDrawer(myTranspose, columns, rows, rows * columns);
      }
      /*
      System.out.println();         
      //Put this code in MatrixMultiplicationToolkit later
      for(int i = 1; i < Math.min(rows, columns); i++) {
         int rowsToBeReduced = rowOrganizer(myMatrix, rows, columns, i - 1, i - 1);
         System.out.println();
         rowReducer(myMatrix, rows, columns, i - 1, rowsToBeReduced, i - 1);
         matrixDrawer(myMatrix, rows, columns, 24); // for 3x3 matrix test    
      }
      */
      System.out.println("Would you like to save your matrix to disc: y/n?");
      String saveDecision = input.next();
      if(saveDecision.equals("y") || saveDecision.equals("Y")) {
         saveMatrix(myMatrix, rows, columns, input);
      }
   }

   public static void matrixDrawer(int rows, int columns) {
      for(int height = 1; height <= rows; height++) {
         System.out.print("|");
         for(int length = 1; length <= columns; length++) {
            System.out.print("  ---  ");
         }
         System.out.println("|");
      }
   }
   
   public static void constructMatrix(Scanner input, double[][] myMatrix, int rows, int columns) {
      System.out.println("Let's build the matrix:");
      int counter = 0; // This is how many linear steps we are in the matrix.
      for(int row = 0; row < rows; row++) {
         for(int column = 0; column < columns; column++) {
            System.out.println("Value at n=" + (row + 1) + ", m=" + (column + 1) + ":");
            double userValue = input.nextDouble();
            myMatrix[row][column] = userValue;
            matrixDrawer(myMatrix, rows, columns, counter);
            counter++;
         }
      }
   }
   
   public static void matrixDrawer(double[][] myMatrix, int rows, int columns, int lastValue) {
      int localPosition = 0;
      for(int row = 0; row < rows; row++) {
         System.out.print("|");
         for(int column = 0; column < columns; column++) {
            if(localPosition <= lastValue) {
               if(myMatrix[row][column] < 10){//can only handle things of upto 3 decimal places
                  System.out.print("    " + myMatrix[row][column] + "    ");
               } else if(myMatrix[row][column] >= 10 && myMatrix[row][column] < 100) {
                  System.out.print("    "+ myMatrix[row][column] + "   ");
               } else {
                  System.out.print("   "+ myMatrix[row][column] + "   ");
               }   
            } else {
               System.out.print("    ---    ");
            }
            localPosition++;
         }
         System.out.println("|");
      }
   }
   
   public static void saveMatrix(double[][] myMatrix, int n, int m, Scanner input) throws FileNotFoundException{
      System.out.print("Output File Name: ");
      String fileName = input.next();
      PrintStream output = new PrintStream(new File(fileName));
      for(int row = 0; row < n; row++) {
         for(int column = 0; column < m; column++) {
            output.print(myMatrix[row][column] + " ");
         }         
      }
   }
   
   public static void loadMatrix(double[][] myMatrix, int n, int m, Scanner input) throws FileNotFoundException {
      System.out.print("Name of file to load: ");
      String fileName = input.next();
      Scanner fileData = new Scanner(new File((fileName)));
      for(int row = 0; row < n; row++) {
         for(int column = 0; column < m; column++) {
            try {
               myMatrix[row][column] = fileData.nextDouble();
            } catch(NoSuchElementException exception) {
               System.err.println("File matrix incompatible with specified parameters.");
            }
         }         
      }
   }
}