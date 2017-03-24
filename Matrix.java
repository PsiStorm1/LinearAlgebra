/*
This was created independently by, and is the intellectual property of, Anthony Pangelinan.

This is a Matrix object that stores information regarding an n by m matrix of doubles.
This object keeps track of how many rows and columns are in the matrix, and has basic functions 
   to return information about the Matrix Object.
*/

public class Matrix {
   private int rows;
   private int columns;
   private double[][] myMatrix; // nxm matrix is stored
   
   // This initializes the matrix to the desired size.
   // Matrix takes integers of the desired number of rows and columns as parameters.
   public Matrix(int rows, int columns) {
      this.rows = rows;
      this.columns = columns;
      myMatrix = new double[rows][columns];
   }
   
   // This returns an integer of the number of rows in the matrix (the value of n).
   public int getRows() {
      return rows;
   }
   
   // This returns an integer of the number of columns in the matrix (the value of m).
   public int getColumns() {
      return columns;
   }
   
   // This edits the contents of the matrix at the desired location.
   // This function alerts the user if the desired matrix location does not exist for
   //    this matrix.
   // add takes integers of the desired row and column to edit, and a double of the value
   //    to be added to the matrix, as parameters.
   public void add(int row, int column, double value) {
      if(row < 0 || column < 0 || row > this.rows || column > this.columns) {
         System.out.println("Desired location outside of matrix boundaries.");
      } else {
         myMatrix[row][column] = value;
      }
   }
   
   // This gets the contents of the matrix at the desired location.
   // This function alerts the user if the desired matrix location does not exist for
   //    this matrix.
   // getValue takes integers of the desired row and column as parameters.
   public double getValue(int row, int column) {
      if(row < 0 || column < 0 || row > this.rows || column > this.columns) {
         System.out.println("Desired location outside of matrix boundaries.");
         return -1;
      } else {
         return myMatrix[row][column];
      }
   }
   
   // This prints the full matrix to the console.
   // printMatrix assumes the entire matrix is already constructed.
   public void printMatrix() {
      for(int row = 0; row < rows; row++) {
         System.out.print("|");
         for(int column = 0; column < columns; column++) {
            if(myMatrix[row][column] < 10){//can only handle things of upto 3 decimal places
               System.out.print("    " + myMatrix[row][column] + "    ");
            } else if(myMatrix[row][column] >= 10 && myMatrix[row][column] < 100) {
               System.out.print("    " + myMatrix[row][column] + "   ");
            } else {
               System.out.print("   " + myMatrix[row][column] + "   ");
            }
         }
         System.out.println("|");
      }
   }
}