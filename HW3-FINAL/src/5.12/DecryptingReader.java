
import java.io.Reader;
import java.io.IOException;

/** 
   DecryptingReader decrypts text after reading it.
*/
public class DecryptingReader extends Reader implements CipherDecrypt
{
	static final int CAESAR_OFFSET = 3;
	static final int ALPHABET_SIZE = 26;
        private Reader reader;
   /** 
      Initializes an decrypting reader that decorates a given reader
      @param reader the reader to decorate
   */
   public DecryptingReader(Reader reader)
   {
      this.reader = reader;
   }

   /** 
      Read the specified characters into a buffer
      @param cbuf the buffer to read into
      @param off the offset within the buffer to start reading
      @param len the number of characters to read
   */
   public int read(char[] cbuf, int off, int len) throws IOException
   {
      int result = reader.read(cbuf, off, len);
      decrypt(cbuf);
      return result;
   }

   /**
   	decrypts encrypted data by shifting letters 3 places down
   	@param buff the character sequence to decrypt
   */
   public void decrypt(char[] cbuf)
   {
      for(int i = 0; i < cbuf.length; i++)
      {
         char c = cbuf[i];
         if (Character.isLetter(c))
         {
            c = (char) ((int) c - CAESAR_OFFSET);
            if (!Character.isLetter(c))
               c = (char) ((int) c + ALPHABET_SIZE);
            cbuf[i] = c;  
         }
      }  
   }
   
   /** 
      Close the reader
   */
   public void close() throws IOException
   {
      reader.close();
   }

  
}
