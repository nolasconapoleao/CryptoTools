/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptotools;

import java.util.Scanner;

/**
 *
 * @author nolasco
 */
class TextUserInterface {
    //Instantiate cryptoAnalyst class
    CryptoAnalyst ca = new CryptoAnalyst();

    //Create string variables text and key
    private String plaintext = "";
    private String cyphertext = "";
    private String text = "";
    private int k=0;
    private String key = "a";
    
    //Print menu
    public void printMenu() {
        System.out.println("###########TUI###########");
        System.out.println("Message: " + text + "; K: " + k + "; Key: " + key);
        System.out.println("1. Insert message");
        System.out.println("2. Mono Alphabetic Encode");
        System.out.println("3. Mono Alphabetic Decode");
        System.out.println("4. Poli Alphabetic Encode");
        System.out.println("5. Poli Alphabetic Decode");
        System.out.println("6. Mono Alphabetic Brute Force Decode");
        System.out.println("7. Set Mono Key");
        System.out.println("8. Set Poli Key");
        System.out.println("0. Close application.");
        System.out.println("#########################");
    }
    
    //Change message
    public void setMessage (String message) {
        this.text = message;
    }
    
    //Mono alphabetic encryption 
    public void encMono() {
        cyphertext = ca.encodeMono(text, k);
        System.out.println(cyphertext);
    }
    
    //Mono alphabetic decryption
    public void decMono() {
        plaintext = ca.decodeMono(text, k);
        System.out.println(plaintext);
    }
    
    //Change moono alphabetic key
    void decBruteMono() {
        for(int i=0; i<26; i++) {
            plaintext = ca.decodeMono(text, i);
            System.out.println(plaintext);
        }
    }
    
    //Poli alphabetic encryption
    public void encPoli() {
        cyphertext = ca.encodePoli(text, key);
        System.out.println(cyphertext);
    }
    
    //Poli alphabetic decryption
    public void decPoli() {
        plaintext = ca.decodePoli(text, key);
        System.out.println(plaintext);
    }
    
    //Change moono alphabetic key
    public void setK (int k) {
        this.k = k;
    }
    
    //Change poli alphabetic key
    public void setKey (String key) {
        this.key = key;
    }
    
}
