package Five12;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *CypherEncrupt enforces encrypt algorithm
 * Created by aniquedavla on 4/8/17.
 */
public interface CypherEncrypt {

    /**
     * The encryption algorithm
     *
     * @param cbuf contains the characters to encrypt
     *
     */
    public void encrypt(char[] cbuf);
}
