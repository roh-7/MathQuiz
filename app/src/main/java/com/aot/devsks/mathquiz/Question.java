package com.aot.devsks.mathquiz;

import java.util.Random;

/**
 * Created by devsks on 09/08/2016 AD.
 */
public class Question {
    private int number;
    private boolean answer;
    private int mod;
    private Random generator;

    Question()
    {
        mod = 103;
        generator = new Random();
        getNextQuestion();
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
        this.number = generator.nextInt(mod);
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
