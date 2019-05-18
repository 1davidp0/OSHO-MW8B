/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;

/**
 *
 * @author DavidGD
 */

//************* MAIN-CLASS **************
public class LogicGames {
    
    public int[] getCardNumbers() {
        
        int[] numbers = new int[12];
        int count = 0;
        
        while(count < 12) {
            Random r = new Random();
            int na = r.nextInt(6) + 1;
            int nvr = 0;
            
            for (int i = 0; i < 12; i++) {
                if(numbers[i] == na) {
                    nvr++;
                }
            }
            if(nvr < 2) {
                numbers[count] = na;
                count++;
            }
            
        }  
        return numbers;
    }
    
}
//***************************************