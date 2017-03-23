public class Matrix {
   private int rows;
   private int columns;
   private double[][] myMatrix;
   
   public Matrix(int rows, int columns) {
      this.rows = rows;
      this.columns = columns;
      myMatrix = new double[rows][columns];
   }
   
   public int getRows() {
      return rows;
   }
   
   public int getColumns() {
      return columns;
   }
   
   public void add(int row, int column, double value) {
      myMatrix[row][column] = value;
   }
   
   public double getValue(int row, int column) {
      return myMatrix[row][column];
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