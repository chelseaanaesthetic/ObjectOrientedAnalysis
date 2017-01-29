import java.util.*;

/**
 * ICS 372.01: Assignment 3
 *
 * A PushbackTokenizer acts as an adapter for a PushbackableTokenizer.
 * @author Chelsea Hanson
 * @version 1.0 9/25/15
 */
public class PushbackTokenizer implements PushbackableTokenizer{
    /*
     * These variables hold the two parts of the original string of words:
     * pushed being the string sent in, and popped being the words read back.
     */
    Stack pushed;
    Stack popped;

    /**
     * Creates a PushbackTokenizer from a specified phrase and gets
     * it ready to print it out word by word and push back words to be
     * printed out again.
     * @param userString an input phrase.
     */
    public PushbackTokenizer(String userString){
        tokenize(userString);
    }

    /**
     * Returns the next word from the phrase.
     * @return the next token.
     */
    @Override
    public String nextToken(){
        if (!pushed.empty()){
            popped.push(pushed.pop());
            return ((String)popped.peek());
        }
        else{
            return ("No Tokens left.");
        }
    }

    /**
     * Returns true if and only if there are more tokens
     * @return true if there is at least one more token; else false
     */
    @Override
    public boolean hasMoreTokens(){
        return (!pushed.empty());
    }

    /**
     * Puts the last printed word back so it can be read again.
     */
    @Override
    public void pushback(){
        if(!popped.empty()){
            pushed.push(popped.pop());
        }
        else{
            System.out.println("No Tokens left.");
        }
    }

    /**
     * Takes a phrase and breaks it down into words and puts in the
     * appropriate Stacks for reading one at a time and pushing back.
     * @param userString The input to be broken down by word.
     */
    private void tokenize(String userString){
        pushed = new Stack();
        popped = new Stack();

        StringTokenizer st = new StringTokenizer(userString);

        while (st.hasMoreTokens()){
            popped.push(st.nextToken());
        }
        while(!popped.empty()) {
            pushed.push(popped.pop());
        }
    }
}