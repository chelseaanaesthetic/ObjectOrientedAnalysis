/**
 * ICS 372.01: Assignment 3
 *
 * The AdapterDriver tests the functionality of a PushbackableTokenizer using the
 * PushbackTokenizer adapter. All test statements come directly from the assignment
 * description and criteria document for Assignment 3 on D2L
 * @author Chelsea Hanson
 * @version 1.0 9/25/15
 */
public class AdapterDriver {

    public static void main(String[] args){

        PushbackableTokenizer pushbackTokenizer = new PushbackTokenizer("Hello this is a test");
        
        System.out.println(pushbackTokenizer.nextToken());
        System.out.println(pushbackTokenizer.nextToken());
        System.out.println(pushbackTokenizer.nextToken());
        
        pushbackTokenizer.pushback();
        pushbackTokenizer.pushback();
        
        System.out.println(pushbackTokenizer.nextToken());
        System.out.println(pushbackTokenizer.nextToken());
        System.out.println(pushbackTokenizer.nextToken());
        System.out.println(pushbackTokenizer.nextToken());
        
        pushbackTokenizer.pushback();
        pushbackTokenizer.pushback();
        
        System.out.println(pushbackTokenizer.nextToken());
        System.out.println(pushbackTokenizer.nextToken());
    }
}