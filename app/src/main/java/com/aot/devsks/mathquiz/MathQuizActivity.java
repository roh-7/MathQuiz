package com.aot.devsks.mathquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MathQuizActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private long score;
    private TextView questionView;
    private TextView scoreView;
    private  Question ques;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_quiz);

        trueButton = (Button) findViewById(R.id.trueButton);
        falseButton = (Button) findViewById(R.id.falseButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        questionView = (TextView) findViewById(R.id.questionTextView);
        scoreView = (TextView) findViewById(R.id.scoreView);
        ques = new Question();
        score = 0;
        loadQuestion();
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }

        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ques.getNextQuestion();

                loadQuestion();

            }
        });
    }
    void checkAnswer(boolean userAnswer)
    {
        if ( userAnswer == ques.getAnswer() ) {
            score++;
            Toast.makeText(getApplicationContext(), R.string.correct_answer, Toast.LENGTH_SHORT).show();
            ques.getNextQuestion();
            loadQuestion();
        }
        else
            Toast.makeText(getApplicationContext(),R.string.wrong_answer, Toast.LENGTH_SHORT).show();;
    }
    void loadQuestion()
    {
        scoreView.setText("Your Score : " + score);
        questionView.setText("Is "+ ques.getNumber() +" is a prime Number ? ");
    }
}
