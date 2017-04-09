
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Writer;


/** 
   Encrypts and decrypt messages using Caesar Cypher
   @author aniquedavla
*/
 class DecoratorTester
{
   /** 
     Creates EncryptingWriter and DecryptingReader objects and uses them
     to write to and read from a file
   */
   public static void main(String[] args) throws IOException
   {
	  System.out.println("Encrypting started: ");
      EncryptingWriter encrip = new EncryptingWriter(new FileWriter("test.out"));
      encrip.write("abcdefghijklmnopqrstuvwxyz", 0, 26);
      PrintWriter w = new PrintWriter(encrip, true);
      w.println("abcdefghijkl2mnopqrstuvwxyz");
      w.println("ABCDEFGHIJKL2MNOPQRSTUVWXYZ");

      char inChars[] = 
         "--------------------------".toCharArray();
      
      System.out.println("\n\nDecrypting: ");
      DecryptingReader r = new DecryptingReader(new FileReader("test.out"));
      r.read(inChars, 0, 26);
      System.out.println(inChars);
 BufferedReader b = new BufferedReader(r);
      String string = b.readLine();
      System.out.println(string);
      string = b.readLine();
      System.out.println(string);
      
   } 
}
