package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    TextView tv_question;
    Button b_true,b_false;

    com.example.truefalse.Questions mQuestions;
    int questionsLength;

    ArrayList<com.example.truefalse.Item> questionsList;

    int currentQuestion = 0;
    boolean winner = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init stuff
        tv_question = (TextView)findViewById(R.id.tv_question);
        b_true = (Button)findViewById(R.id.b_true);
        b_false = (Button)findViewById(R.id.b_false);

        mQuestions = new com.example.truefalse.Questions();
        questionsLength = mQuestions.mQuestions.length;

        questionsList = new ArrayList<>();

        //save all the questions in the list
        for(int i = 0;i<questionsLength;i++){
            questionsList.add(new com.example.truefalse.Item(mQuestions.getQuestion(i), mQuestions.getAnswer(i)));
        }

        //shuffle the questions
        Collections.shuffle(questionsList);

        //start the game
        setQuestion(currentQuestion);

        b_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkQuestion(currentQuestion)) {
                    //correct - the game continues
                    currentQuestion++;
                    if(currentQuestion < questionsLength) {
                        setQuestion(currentQuestion);
                    } else{
                        //game over - winner
                        winner = true;
                        endGame();
                    }
                } else {
                    //wrong - the game ends
                    endGame();
                }


            }
        });
        b_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkQuestion(currentQuestion)) {
                    //correct - the game continues
                    currentQuestion++;
                    if(currentQuestion < questionsLength) {
                        setQuestion(currentQuestion);
                    } else{
                        //game over - winner
                        winner = true;
                        endGame();
                    }
                } else {
                    //wrong - the game ends
                    endGame();
                }

            }
        });

    }

    //show question on the screen
    private void setQuestion(int number) {
        tv_question.setText(questionsList.get(number).getQuestion());

    }

    //check if the answer is right
    private boolean checkQuestion(int number) {
        String answer = questionsList.get(number).getAnswer();
        return answer.equals("true");
    }

    //game over
    private void endGame() {
        if(winner){
            Toast.makeText(this, "Game Over! You win!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Game Over! You lose!", Toast.LENGTH_SHORT).show();
            finish();
        }

    }
}