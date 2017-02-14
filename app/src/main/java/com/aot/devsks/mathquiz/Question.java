package com.aot.devsks.mathquiz;

/**
 * Created by devsks on 09/08/2016 AD.
 */
public class Question {
    private int number;
    private boolean answer;
    private  int mod;
    Question()
    {
        mod = 103;
        number =  (12345*152+1) % mod;
        answer = setAnswer();

    }
    private boolean setAnswer()
    {
        int sq = (int)Math.sqrt(number);
        for(int i = 2; i <= sq; i++)
            if( (number % i) == 0)
                    return  false;
        return  true;

    }
    public void getNextQuestion()
    {
        this.number = ( this.number + 12345*152+1)%mod;
        this.answer = setAnswer();
    }
    public boolean getAnswer()
    {
        return answer;
    }
    public  int getNumber()
    {
        return number;
    }


}
