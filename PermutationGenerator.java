
/**
 * Lab 19.2 Permutation Generator
 * 
 * Emily Zhuang
 * Mr. Lantsberger
 * APCS:Period 4
 * 14 December 2016
 */

import apcslib.*;               //for format
import java.util.*;             //for ArrayList
import java.util.Random;        //for random generator

class PermutationGenerator
{    
    ArrayList permute;    //stores values 1 to 10 in an ArrayList of length 10
    
    /**
     * Constructor for objects of class Permutations. This method instantiates
     * the ArrayList to a length of 10. This will eventually store the values
     * from 1 to 10.
     */
    public PermutationGenerator()
    {
        //instantiates ArrayList of length 10
        permute = new ArrayList (10);
    }
    
    /**
     * This method will fill the ArrayList with a permutation of 
     * different combinations of the values from 1 to 10. It will then print 
     * ten different permutations.
     */
    public void printPermutation()
    {
        ArrayList permutation;  //stores new permutations
        
        System.out.println("Random Permutation List Generator\n");
        setTen();   //fills the original permute ArrayList with values 1 to 10
        
        //finds the next permutation
        permutation = nextPermutation();
        
        //prints ten permutations
        for (int k = 1; k <= 10; k++)
        {
            System.out.print("List " + Format.right(k, 2) + ":  ");
            
            for (int i = 0; i < 10; i++)
            {
                System.out.print(Format.right(((Integer)permutation.get(i)).intValue(), 2) + " ");
            }
            System.out.println();
            //resets the permute ArrayList and finds the next permutation
            setTen();
            permutation = nextPermutation();
        }
    }
    
    /**
     * Fills the permute ArrayList with values from 1 to 10.
     */
    private void setTen()
    {
        Integer num;
        
        for (int k = 0; k < 10; k++)
        {
            num = new Integer(k + 1);   //sets num to value from 1 to 10
            permute.add(num);           //adds the Integer object to the ArrayList
        }
    }
    
    /**
     * This method will randomly generate a new permutation by 
     * generating a random index and filling a new ArrayList output
     * with the values. It will then remove the filled value from 
     * permute until the entire ArrayList is full. 
     */
    private ArrayList nextPermutation ()
    {
        Random die = new Random();              //random number generator
        ArrayList output = new ArrayList(10);   //the permutation
        int index;                              //the index in the permute ArrayList
        
        //randomly generates ten indices and fills the output
        for (int k = 0; k < 10; k++)
        {
            index = die.nextInt(10 - k);
            output.add((Integer)permute.remove(index));
        }
        
        return output;
    }
}
