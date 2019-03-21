package sample;

import java.io.*;

public class Question1 {
  public static void main(String[] args) throws IOException {
	  
	  // Create an output stream for file Question1.dat
      DataOutputStream output = new DataOutputStream(new FileOutputStream("Question1.dat"));

      // Write integers to the file
      for(int i=0; i<100; i++) {
          output.writeInt(i);
      }
      // Create an input stream for file Question1.dat
      DataInputStream input = new DataInputStream(new FileInputStream("Question1.dat"));

      // Read and sum integers in file
      int sum = 0;
      int value;
      while((value = input.read()) != -1)  {
          sum += value;
      }

      System.out.println(sum);

      output.close();
      input.close();
  }
}