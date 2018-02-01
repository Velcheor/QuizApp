package com.example.android.quizapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    int results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    private int calculateResult(boolean hasFirstAnswer, boolean hasSecondAnswer, boolean hasThirdAnswer, boolean hasFourthAnswer, boolean hasFifthAnswer) {
        results = 0;
        if (hasFirstAnswer)
            results = results + 20;
        if (hasSecondAnswer)
            results = results + 20;
        if (hasThirdAnswer)
            results = results + 20;
        if (hasFourthAnswer)
            results = results + 20;
        if (hasFifthAnswer)
            results = results + 20;
        return results;
    }

    private boolean isFirstAnswer() {
        EditText firstAnswerText = findViewById(R.id.first_answer);
        String answer = firstAnswerText.getText().toString();
        TextView oneQuestionText = findViewById(R.id.text_question_one);
        if (answer.equals("Boris Yeltsin") || answer.equals("Yeltsin") || answer.equals("boris yeltsin") || answer.equals("yeltsin")) {
            oneQuestionText.setTextColor(Color.GREEN);
            return true;
        } else {
            oneQuestionText.setTextColor(Color.RED);
            return false;
        }
    }

    private boolean isSecondAnswer() {
        CheckBox oneCheckRight = findViewById(R.id.second_answer_right_one);
        CheckBox twoCheckRight = findViewById(R.id.second_answer_right_two);
        TextView twoQuestionText = findViewById(R.id.text_question_two);
        if (oneCheckRight.isChecked() && twoCheckRight.isChecked()) {
            twoQuestionText.setTextColor(Color.GREEN);
            return true;
        } else {
            twoQuestionText.setTextColor(Color.RED);
            return false;
        }
    }

    private boolean isThirdAnswer() {
        RadioButton radioButton = findViewById(R.id.third_answer_right);
        TextView threeQuestionText = findViewById(R.id.text_question_three);
        if (radioButton.isChecked()) {
            threeQuestionText.setTextColor(Color.GREEN);
            return true;
        } else {
            threeQuestionText.setTextColor(Color.RED);
            return false;
        }
    }


    private boolean isFourthAnswer() {
        RadioButton fourthAnswerButton = findViewById(R.id.fourth_answer_right);
        TextView fourQuestionText = findViewById(R.id.text_question_four);
        if (fourthAnswerButton.isChecked()) {
            fourQuestionText.setTextColor(Color.GREEN);
            return true;
        } else {
            fourQuestionText.setTextColor(Color.RED);
            return false;
        }
    }

    private boolean isFifthAnswer() {
        EditText fifthAnswerText = findViewById(R.id.fifth_answer);
        TextView fiveQuestionText = findViewById(R.id.text_question_five);
        String answer = fifthAnswerText.getText().toString();
        if (answer.equals("Ivan") || answer.equals("ivan")) {
            fiveQuestionText.setTextColor(Color.GREEN);
            return true;
        } else {
            fiveQuestionText.setTextColor(Color.RED);
            return false;
        }
    }

    public void resultClick(View view) {
        results = calculateResult(isFirstAnswer(), isSecondAnswer(), isThirdAnswer(), isFourthAnswer(), isFifthAnswer());
        if (results == 0) {
            Toast.makeText(this, "You scored 0 point", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(this, "You scored " + results + " points", Toast.LENGTH_LONG).show();
    }
}
