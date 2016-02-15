package edu.depaul.csc595.careapp.Lucas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import edu.depaul.csc595.careapp.R;

public class QuestionsViewer extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private int currentQuestion = 0;
    private int questionNumber = 3;

    private final String [] QUESTIONS = {
            "PERGUNTA 1",
            "PERGUNTA 2",
            "PERGUNTA 3"
    };

    private final String [][] ANSWERS = {
            {
                    "P1 - R1",
                    "P1 - R2",
                    "P1 - R3",
                    "P1 - R4",
                    "P1 - R5"},
            {
                    "P2 - R1",
                    "P2 - R2",
                    "P2 - R3",
                    "P2 - R4",
                    "P2 - R5"},
            {
                    "P3 - R1",
                    "P3 - R2",
                    "P3 - R3",
                    "P3 - R4",
                    "P3 - R5"},
    };

    TextView questionText;
    RadioButton [] radio = new RadioButton[5];
    CheckBox [] checkBox = new CheckBox[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        QuestionType type = QuestionType.CHECKBOX;

//        if(type == QuestionType.CHECKBOX) {
//            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//            radioGroup.
//        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_viewer);

        TextView questionHeaderText = (TextView) findViewById(R.id.questionHeaderText);

        int printCQ = this.currentQuestion + 1;
        questionHeaderText.setText("QUESTION " + printCQ + " UP TO " + this.questionNumber + ":");

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(this.questionNumber);

        questionText = (TextView) findViewById(R.id.questionText);
        questionText.setText(QUESTIONS[this.currentQuestion]);

        checkBox[0] = (CheckBox) findViewById(R.id.checkBox1);
        checkBox[1] = (CheckBox) findViewById(R.id.checkBox2);
        checkBox[2] = (CheckBox) findViewById(R.id.checkBox3);
        checkBox[3] = (CheckBox) findViewById(R.id.checkBox4);
        checkBox[4] = (CheckBox) findViewById(R.id.checkBox5);

        radio[0] = (RadioButton) findViewById(R.id.radioButton1);
        radio[1] = (RadioButton) findViewById(R.id.radioButton2);
        radio[2] = (RadioButton) findViewById(R.id.radioButton3);
        radio[3] = (RadioButton) findViewById(R.id.radioButton4);
        radio[4] = (RadioButton) findViewById(R.id.radioButton5);

        if(type == QuestionType.CHECKBOX) {
            for(int i = 0; i < 5; i++) {
                checkBox[i].setText(ANSWERS[0][i]);
                radio[i].setVisibility(View.INVISIBLE);
            }
        } else {
            for(int i = 0; i < 5; i++) {
                radio[i].setText(ANSWERS[0][i]);
                checkBox[i].setVisibility(View.INVISIBLE);
            }
        }

        Button nextScreen = (Button) findViewById(R.id.nextScreen);
        nextScreen.setText("Answer Quiz");

        nextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestion++;
                if (currentQuestion < 3) {
                    int printCQ = currentQuestion + 1;
                    TextView questionHeaderText = (TextView) findViewById(R.id.questionHeaderText);
                    questionHeaderText.setText("QUESTION " + printCQ + " UP TO " + questionNumber + ":");

                    ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
                    progressBar.setProgress(currentQuestion);

                    questionText.setText(QUESTIONS[currentQuestion]);

                    for (int i = 0; i < 5; i++) {
                        radio[i].setText(ANSWERS[currentQuestion][i]);
                        radio[i].setChecked(false);

                        checkBox[i].setText(ANSWERS[currentQuestion][i]);
                        checkBox[i].setChecked(false);
                    }
                } else {
                    finish();
                }
            }
        });
    }
}
