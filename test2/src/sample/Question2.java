package sample;

import java.io.*;
import java.util.Scanner;

public class Question2 {

  public static void main(String[] args) throws IOException {

    // Check command-line parameter usage
    if (args.length != 1) {
      System.out.println("Usage: java Question2 sourcefile");
      System.exit(1);
    }

    // Check if source file exists
    File sourceFile = new File(args[0]);
    if (!sourceFile.exists()) {
       System.out.println("Source file " + args[0] + " does not exist");
       System.exit(2);
    }

    // Create an input stream
    Scanner input = new Scanner(new FileInputStream(sourceFile));

    // Continuously read a byte from input and write it to output
    int lines=0;

    while ((input.hasNext())) {
      lines += 1;
    }

    // Display the file size
    System.out.println("Lines:" + lines);

    input.close();
  }
}