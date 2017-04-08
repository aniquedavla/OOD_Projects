package Five12;

import java.io.Writer;
import java.io.IOException;

/** 
   A decorator class for encrypting text before writing it.
*/
public class EncryptingWriter extends Writer implements CypherEncrypt
{
   static final int CAESAR_OFFSET = 3;
   static final int ALPHABET_SIZE = 26;
   private Writer writer;
   /** 
      Construct an encrypting writer that decorates a given writer
      @param writer the writer to decorate
   */
   public EncryptingWriter(Writer writer)
   {
      this.writer = writer;
   }

   /** 
      Write the specified characters from a buffer
      @param cbuf the buffer to write
      @param off the offset within the buffer to start writing
      @param len the number of characters to write
   */
   public void write(char[] cbuf, int off, int len) throws IOException
   {
      printString("Before: ", cbuf);
      encrypt(cbuf);
      printString("After: ", cbuf);
      System.out.println();
      writer.write(cbuf, off, len);
   }

   
   /**
   	prints the character sequence so we can see before and after results
   	@param str description(before or after)
   	@param cbuf the character sequence
   */
   public void printString(String str, char[] cbuf){
	   System.out.printf("%8s", str);
	   for(char c : cbuf)
		   System.out.print(c);
	   System.out.println();
   }
   
   /**
   	encrypt data using caesar cypher by shifting characters 3 places up
   	@param cbuf the character sequence to encrypt
   */
   public void encrypt(char[] cbuf)
   {
      for(int i = 0; i < cbuf.length; i++)
      {
         char c = cbuf[i];
         if (Character.isLetter(c))
         {
            c = (char) ((int) c + CAESAR_OFFSET);
            if (!Character.isLetter(c))
               c = (char) ((int) c - ALPHABET_SIZE);
            cbuf[i] = c; 
         }
      }  
   }
   
   
   /** 
      Close the writer
   */
   public void close() throws IOException
   {
      writer.close();
   }

   /** 
      Flush the writer
   */
   public void flush() throws IOException
   {
      writer.flush();
   }

   
}
