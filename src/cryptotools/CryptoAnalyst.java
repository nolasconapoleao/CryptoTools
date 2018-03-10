package cryptotools;

import static java.lang.Math.min;
import java.util.Vector;

public class CryptoAnalyst {
    //Encode plaintext mono-alphabetic
    public String encodeMono(String plain, int key) {
        String cypher="";
        char it;
        char encIt;
        
        //Decode plain text into cypher text
        for( int i=0; i< plain.length(); i++) {
            it = plain.charAt(i);
            encIt = encodeChar(it, key);
            
            //Add decoded char is not null append to cypher
            if(encIt != 0 ) {
                cypher += encIt;
            }
        }
        return cypher;
    }
    
    //Decode cyphertext mono-alphabetic
    public String decodeMono(String cypher, int key) {        
        return encodeMono(cypher, 26-key);
    }
    
    //Decode cyphertext poli-alphabetic
    public String encodePoli(String plain, String key) {
        String cypher="";
        char itK;
        char itP;
        char encIt;
        int k;
        
        //Decode plain text into cypher text
        for( int i=0; i< plain.length(); i++) {
            itP = plain.charAt(i);
            itK = key.charAt(i%key.length());
            
            //Decode uppercase letters
            if(itK>='A' & itK<='Z')
                k = (int)(itK - 'A');
            //Decode lowercase letters
            else if(itK>='a' & itK<='z')
                k = (int)(itK - 'a');
            //Ignore remaining characters
            else
                k = 0;
            
            encIt = encodeChar(itP, k);
            
            //Add decoded char is not null append to cypher
            if(encIt != 0 ) {
                cypher += encIt;
            }
        }
        return cypher;
    }
    
    //Encode plaintext poli-alphabetic
    public String decodePoli(String cypher, String key) {
        String keyEnc="";
        char it;
        
        for( int i=0; i< key.length(); i++) {
            it=key.charAt(i);
            
            //Decode uppercase letters
            if(it>='A' & it<='Z')
                keyEnc += (char)('A'+(26 - (int)(it - 'A')));
            //Decode lowercase letters
            else if(it>='a' & it<='z')
                keyEnc += (char)('a'+(26 - (int)(it - 'a')));
            //Ignore remaining characters
            else
                keyEnc += 'A';
        }
        
        return encodePoli(cypher, keyEnc);
    }
    
    //Encode letter
    private char encodeChar(char ch, int k) {        
        //Encode uppercase letters
        if(ch>='A' & ch<='Z')
            return (char)('A' + ((int)ch - 'A' + k)%26);
        //Encode lowercase letters
        else if(ch>='a' & ch<='z')
            return (char)('a' + ((int)ch - 'a' + k)%26);
        //Encode numbers
        else if(ch>='0' & ch<='9')
            return ch;
        //Process spaces
        else if(ch>=' ')
            return 0;
        //Ignore remaining characters
        else       
            return 0;
    }
    
    //Decode letter
    private char decodeChar(char ch, int k) {
        return encodeChar(ch, 26-k);
    }
}
