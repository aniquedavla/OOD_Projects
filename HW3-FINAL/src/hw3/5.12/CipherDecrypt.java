/**
   An interface for encryption and decryption algorithms
*/
public interface CipherDecrypt
{
   /**
     The decryption algorithm
     @param cbuf contains the characters to decrypt
   */
  public void decrypt(char[] cbuf);
}