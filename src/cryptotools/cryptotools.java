/*
 * 
 */

package cryptotools;

import java.util.Scanner;
import java.util.Vector;

public class cryptotools {

    public static void main(String[] args) {
        //Instantiate cryptoAnalyst class
        CryptoAnalyst ca = new CryptoAnalyst();
        TextUserInterface tui = new TextUserInterface();
        Boolean close = false;
        Scanner in = new Scanner(System.in);
        String text;
        int k;
        
        while (!close) {
            //Call user interface
            int option;
            tui.printMenu();
            option = in.nextInt();

            switch (option) {
                case 1: //Change text
                    text = in.nextLine();
                    tui.setMessage(text);
                    break;
                case 2: //Mono alphabetic encryption 
                    tui.encMono();
                    break;
                case 3: //Mono alphabetic decryption
                    tui.decMono();
                    break;
                case 4: //Poli alphabetic encryption
                    tui.encPoli();
                    break;
                case 5: //Poli alphabetic decryption
                    tui.decPoli();
                    break;
                case 6: //Brute Force Mono alphabetic decryption
                    tui.decBruteMono();
                    break;
                case 7: //Change moono alphabetic key
                    System.out.println("Insert k: ");
                    k = in.nextInt();
                    tui.setK(k);
                    break;
                case 8: //Change poli alphabetic key
                    System.out.println("Insert key: ");
                    text = in.next();
                    tui.setKey(text);
                    break;
                case 0: //Close program
                    close=true;
                    break;
                default: System.out.println("Invalid option!");
                    break;
            }
        }
    }
    
    
}

