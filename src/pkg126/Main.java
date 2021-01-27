/*
 * Project: Exercise 12.8
 * Lauren Smith
 * 11/30/20 
 * Converts hexadecimal to decimal with an error class for invalid hex chars
 */
package pkg126;

public class Main {
    //method that takes hexadecimal string and converts each digit 
    public static int parseHex(String hexString) throws HexFormatException 
    {
        //assigns first digit and then uses for loop to convert the rest 
        //using convertHextoDec method
        int value=convertHextoDec(hexString.charAt(0));
        for(int i=1; i<hexString.length(); i++) 
        {
            value=value*16+hexString.charAt(i)-'0';
        } 
        //returns value of converted hex char
        return value; 
    }
    //method that converts hex chars to ecimals uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu
    static int convertHextoDec(char ch) throws HexFormatException 
    {//uses a set of if statements to assign correct value to char
        if(ch=='A') 
        {
            return 10; 
        } 
        else if(ch=='B') 
        {
            return 11; 
        }
        else if(ch=='C') 
        {
            return 12; 
        }
        else if(ch=='D') 
        {
            return 13; 
        }
        else if(ch=='E') 
        {
            return 14; 
        }
        else if(ch=='F') 
        {
            return 15; 
        } 
        //if char isn't a letter but a number it puts it in front of a 0
        else if(ch<='9'&&ch>='0') 
        {
            return ch-'0'; 
        } 
        //if it's none of the above it's invalid so it throws a HexFormatException
        else 
        {
            //error thrown saying illegal charecter followed by the illegal charecter
            throw new HexFormatException("illegal hex charecter "+ ch); 
        }
    }
    public static void main(String[] args) throws HexFormatException {
        //tests the program with a valid and invalid hexadecimal
        System.out.println(parseHex("A5"));
        System.out.println(parseHex("T10"));
    }
    
}
//HexFormatException class extends the exception class 
class HexFormatException extends Exception 
{
    //constructor with no paarameters that has the error message of illegal hex 
    //charecter
    HexFormatException() 
    {
        super("illegal hex charecters"); 
    } 
    //constructor with msg parameter. Msg is passed super class constructor 
    HexFormatException(String msg) 
    {
        super(msg); 
    }
}
