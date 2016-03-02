package edu.depaul.csc595.careapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

import edu.depaul.csc595.careapp.Helpers.Quiz;

public class QuizActivity extends AppCompatActivity {

    //ArrayList Questions
    ArrayList<TextView> questions;
    ArrayList<RadioGroup> questionsRadioGroup;
    ArrayList<CheckBox> question01CheckBoxList;
    ArrayList<CheckBox> question02CheckBoxList;
    ArrayList<CheckBox> question03CheckBoxList;
    ArrayList<Button> buttonsArray;

    //Quiz Object
    ArrayList<Quiz> quizs;
    int numberOfQuestions;

    //Buttons
    ViewFlipper flipper;
    TextView txtTop;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        flipper = (ViewFlipper) findViewById(R.id.viewFlipperQuiz);
        txtTop = (TextView) findViewById(R.id.questionHeaderText);
        progress = (ProgressBar) findViewById(R.id.progressBarQuiz);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btnCloseQuiz);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        numberOfQuestions = 3;

        txtTop.setText("QUESTION 1 OF " + numberOfQuestions);
        progress.setProgress((1 * 100)/numberOfQuestions);
        prepareQuiz(numberOfQuestions);

    }

    @Override
    public void onBackPressed()
    {
        if (flipper.getDisplayedChild() < 3 && flipper.getDisplayedChild() > 0)
        {
            flipper.showPrevious();
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (flipper.getDisplayedChild() < 3 && flipper.getDisplayedChild() > 0)
        {
            flipper.showPrevious();
        }
        else
        {
            super.onBackPressed();
        }

        return true;
    }

    private View.OnClickListener onButtonClick = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Button b = (Button) v;
            int currentQuestion;

            if(b.getText().equals("NEXT"))
            {
                if(isTheQuestionAnswred(flipper.getDisplayedChild()))
                {
                    flipper.showNext();
                }
                else
                {
                    Snackbar.make(flipper, "You must answer the question before advance.", Snackbar.LENGTH_LONG).show();
                }
            }
            else if(b.getText().equals("PREVIOUS"))
                flipper.showPrevious();
            else
            {
                if(isTheQuestionAnswred(flipper.getDisplayedChild()))
                {
                    fillResultsView(numberOfQuestions);
                    flipper.setDisplayedChild(3);
                    findViewById(R.id.layoutQuestionsProgress).setVisibility(View.GONE);

                }
                else
                {
                    Snackbar.make(flipper, "You must answer the question before advance.", Snackbar.LENGTH_LONG).show();
                }
            }


            currentQuestion = flipper.getDisplayedChild() + 1;
            txtTop.setText("QUESTION " + currentQuestion + " OF " + numberOfQuestions);
            progress.setProgress((currentQuestion * 100)/numberOfQuestions);
        }
    };

    protected boolean isTheQuestionAnswred (int displayedQuestion)
    {

        if (quizs.get(displayedQuestion).isStyleCheckBox())
        {
            ArrayList<CheckBox> array;
            boolean ret = false;

            switch (displayedQuestion)
            {
                case 0:
                    array = question01CheckBoxList;
                    break;
                case 1:
                    array = question02CheckBoxList;
                    break;
                case 2:
                    array = question03CheckBoxList;
                    break;
                default:
                    return false;
            }

            for (int i = 0; i < array.size(); i++)
            {
                if (array.get(i).isChecked())
                {
                    quizs.get(displayedQuestion).setUserAnswers(i);
                    ret = true;
                }

            }

            return ret;
        }
        else
        {
            boolean ret = false;
            int index;
            switch (displayedQuestion)
            {
                case 0:
                    if (questionsRadioGroup.get(0).getCheckedRadioButtonId() != -1)
                    {
                        index = questionsRadioGroup.get(0).indexOfChild(questionsRadioGroup.get(0).findViewById(questionsRadioGroup.get(0).getCheckedRadioButtonId()));
                        quizs.get(displayedQuestion).setUserAnswers(index);
                        ret = true;
                    }
                    break;
                case 1:
                    if (questionsRadioGroup.get(1).getCheckedRadioButtonId() != -1)
                    {
                        index = questionsRadioGroup.get(1).indexOfChild(questionsRadioGroup.get(1).findViewById(questionsRadioGroup.get(1).getCheckedRadioButtonId()));
                        quizs.get(displayedQuestion).setUserAnswers(index);
                        ret = true;
                    }
                    break;
                case 2:
                    if (questionsRadioGroup.get(2).getCheckedRadioButtonId() != -1)
                    {
                        index = questionsRadioGroup.get(2).indexOfChild(questionsRadioGroup.get(2).findViewById(questionsRadioGroup.get(2).getCheckedRadioButtonId()));
                        quizs.get(displayedQuestion).setUserAnswers(index);
                        ret = true;
                    }
                    break;
            }

            return ret;
        }

    }

    protected void prepareQuiz(int numberOfQuestions)
    {
        //Initializing quizs Array. This array will be used during all this activity life.
        quizs = new ArrayList<Quiz>();

        //Mock Quizs
        Quiz question01 = new Quiz(
                "The only time you can cross two solid yellow lines is when:",
                "Continuous yellow lines should never be crossed. Unless it is the only option to avoid an accident.",
                false,
                new ArrayList<String>() {{
                    add("You need to pass.");
                    add("Turning left at an intersection.");
                    add("The car in front of you is driving under the speed limit.");
                    add("There is a strange object on the road.");
                    add("You should never cross double solid yellow lines.");
                }},
                new ArrayList<Integer>() {{add(4);}}
        );

        Quiz question02 = new Quiz(
                "Always leave extra space in front of you when (select all that apply):",
                "Keep a safe distance from vehicles in front of you is a very good practice. By doing this, you will have more time to react to an unforeseen situation.",
                true,
                new ArrayList<String>() {{
                    add("Driving in bad weather.");
                    add("Another driver is following you closely.");
                    add("You are following a motorcycle.");
                    add("You are having problems with your car.");
                    add("Never leave extra space in front of you.");
                }},
                new ArrayList<Integer>() {{
                    add(0);
                    add(2);
                    add(3);
                }}
        );

        Quiz question03 = new Quiz(
                "To safely navigate through a curve, you should:",
                "The best thing to do is reduce your speed before entering in the curve. It will avoid you to lost the car control inside the curve due to physical forces.",
                false,
                new ArrayList<String>() {{
                    add("Slow down before entering a curve and avoid braking while in the curve.");
                    add("Accelerate in the curve.");
                    add("Brake once you are in the curve to slow down.");
                    add("Maintain your regular speed there is no other traffic.");
                    add("Break until the car stops and then make the curve");
                }},
                new ArrayList<Integer>() {{add(0);}}
        );


        //Here we fill the questions Array with the proper number of questions
        switch (numberOfQuestions)
        {
            case 1:
                quizs.add(question01);
                break;
            case 2:
                quizs.add(question01);
                quizs.add(question02);
                break;
            case 3:
                quizs.add(question01);
                quizs.add(question02);
                quizs.add(question03);
                break;
            default:
                quizs = null;
        }

        hideEverything();
        setButtonsVisibility();
        prepareQuestions(numberOfQuestions);
    }

    protected void prepareQuestions (int numberOfQuestions)
    {
        for (int i = 0; i < numberOfQuestions; i++)
        {
            questions.get(i).setText(quizs.get(i).getQuestion());

            if (quizs.get(i).isStyleCheckBox())
            {
                switch (i)
                {
                    case 0:
                        prepareQuestionsFillAlternatives(question01CheckBoxList, null, i);
                        break;
                    case 1:
                        prepareQuestionsFillAlternatives(question02CheckBoxList, null, i);
                        break;
                    case 3:
                        prepareQuestionsFillAlternatives(question03CheckBoxList, null, i);
                        break;
                }
            }
            else
            {
                prepareQuestionsFillAlternatives(null, questionsRadioGroup.get(i), i);
            }

        }
    }

    protected void prepareQuestionsFillAlternatives (ArrayList<CheckBox> checkboxList, RadioGroup radioGroup, int quizIndex)
    {
        int j = 0;

        if (checkboxList != null)
        {
            for(CheckBox c: checkboxList)
            {
                if (quizs.get(quizIndex).getAlternatives().size() > j)
                {
                    c.setVisibility(View.VISIBLE);
                    c.setText(quizs.get(quizIndex).getAlternatives().get(j));
                    j++;
                }
            }
        }
        else
        {
            radioGroup.setVisibility(View.VISIBLE);
            for(int i = 0; i < radioGroup.getChildCount(); i++)
            {
                View radio = radioGroup.getChildAt(i);
                if(radio instanceof RadioButton)
                {
                    if(quizs.get(quizIndex).getAlternatives().size() > i)
                    {
                        radio.setVisibility(View.VISIBLE);
                        ((RadioButton) radio).setText(quizs.get(quizIndex).getAlternatives().get(i));
                        radio.setSelected(false);
                    }
                    else
                    {
                        radio.setVisibility(View.GONE);
                    }
                }
            }

        }
    }

    protected void fillResultsView(int numberOfQuestions)
    {
        ArrayList<LinearLayout> cards = new ArrayList<LinearLayout>();
        ArrayList<TextView> cardsText = new ArrayList<TextView>();
        float userGrade = 0;

        LinearLayout card1 = (LinearLayout) findViewById(R.id.card1);
        LinearLayout card2 = (LinearLayout) findViewById(R.id.card2);
        LinearLayout card3 = (LinearLayout) findViewById(R.id.card3);

        TextView titleCard1 = (TextView) findViewById(R.id.txtCardTitle1);
        TextView questionCard1 = (TextView) findViewById(R.id.question1);
        TextView answerCard1 = (TextView) findViewById(R.id.txtAnswer1);
        TextView expalanationCard1 = (TextView) findViewById(R.id.txtExplanation1);

        TextView titleCard2 = (TextView) findViewById(R.id.txtCardTitle2);
        TextView questionCard2 = (TextView) findViewById(R.id.question2);
        TextView answerCard2 = (TextView) findViewById(R.id.txtAnswer2);
        TextView expalanationCard2 = (TextView) findViewById(R.id.txtExplanation2);

        TextView titleCard3 = (TextView) findViewById(R.id.txtCardTitle3);
        TextView questionCard3 = (TextView) findViewById(R.id.question3);
        TextView answerCard3 = (TextView) findViewById(R.id.txtAnswer3);
        TextView expalanationCard3 = (TextView) findViewById(R.id.txtExplanation3);

        TextView txtUserGrade = (TextView) findViewById(R.id.txtQuizResults);
        ProgressBar progress = (ProgressBar) findViewById(R.id.quizResultsProgress);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        cardsText.add(titleCard1);
        cardsText.add(questionCard1);
        cardsText.add(answerCard1);
        cardsText.add(expalanationCard1);

        cardsText.add(titleCard2);
        cardsText.add(questionCard2);
        cardsText.add(answerCard2);
        cardsText.add(expalanationCard2);

        cardsText.add(titleCard3);
        cardsText.add(questionCard3);
        cardsText.add(answerCard3);
        cardsText.add(expalanationCard3);

        for(LinearLayout l : cards)
            l.setVisibility(View.GONE);

        for (int i = 0; i < numberOfQuestions; i++)
        {
            cards.get(i).setVisibility(View.VISIBLE);

            userGrade += quizs.get(i).getGrade();

            String correctAnswers = "";

            for (String s: quizs.get(i).getCorrectAnswers())
                correctAnswers += "- " + s + "\n";

            if (i == 0)
            {
                cardsText.get(i).setText("Question " + (i + 1));
                cardsText.get(i + 1).setText(quizs.get(i).getQuestion());
                cardsText.get(i + 2).setText(correctAnswers);
                cardsText.get(i + 3).setText(quizs.get(i).getExplanation());
            }
            else if (i == 1)
            {
                cardsText.get(i + 3).setText("Question " + (i + 1));
                cardsText.get(i + 4).setText(quizs.get(i).getQuestion());
                cardsText.get(i + 5).setText(correctAnswers);
                cardsText.get(i + 6).setText(quizs.get(i).getExplanation());
            }
            else
            {
                cardsText.get(i + 6).setText("Question " + (i + 1));
                cardsText.get(i + 7).setText(quizs.get(i).getQuestion());
                cardsText.get(i + 8).setText(correctAnswers);
                cardsText.get(i + 9).setText(quizs.get(i).getExplanation());
            }

        }

        userGrade = (userGrade * 100) / (numberOfQuestions * 100);
        txtUserGrade.setText("Your grade is " + (int)userGrade);
        progress.setProgress((int)userGrade);

    }

    protected void hideEverything ()
    {
        // This function is used to hide all elements on the screen at the quiz beginning
        // It also includes elements inside their respective ArrayLists so it's easy to manipulate them in the future

        //Initializing ArrayLists
        questions = new ArrayList<TextView>();
        questionsRadioGroup = new ArrayList<RadioGroup>();
        question01CheckBoxList = new ArrayList<CheckBox>();
        question02CheckBoxList = new ArrayList<CheckBox>();
        question03CheckBoxList = new ArrayList<CheckBox>();
        buttonsArray = new ArrayList<Button>();

        buttonsArray.add((Button) findViewById(R.id.btnPreviousQuestion1));
        buttonsArray.add((Button) findViewById(R.id.btnNextQuestion1));
        buttonsArray.add((Button) findViewById(R.id.btnFinishQuiz1));

        buttonsArray.add((Button) findViewById(R.id.btnPreviousQuestion2));
        buttonsArray.add((Button) findViewById(R.id.btnNextQuestion2));
        buttonsArray.add((Button) findViewById(R.id.btnFinishQuiz2));

        buttonsArray.add((Button) findViewById(R.id.btnPreviousQuestion3));
        buttonsArray.add((Button) findViewById(R.id.btnNextQuestion3));
        buttonsArray.add((Button) findViewById(R.id.btnFinishQuiz3));


        TextView question01 = (TextView) findViewById(R.id.txtQuestion1);
        TextView question02 = (TextView) findViewById(R.id.txtQuestion2);
        TextView question03 = (TextView) findViewById(R.id.txtQuestion3);

        questions.add(question01);
        questions.add(question02);
        questions.add(question03);



        RadioGroup question01Radios = (RadioGroup) findViewById(R.id.radioGroupQuestion1);
        RadioGroup question02Radios = (RadioGroup) findViewById(R.id.radioGroupQuestion2);
        RadioGroup question03Radios = (RadioGroup) findViewById(R.id.radioGroupQuestion3);

        questionsRadioGroup.add(question01Radios);
        questionsRadioGroup.add(question02Radios);
        questionsRadioGroup.add(question03Radios);




        CheckBox question01Alternative01 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox question01Alternative02 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox question01Alternative03 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox question01Alternative04 = (CheckBox) findViewById(R.id.checkBox4);
        CheckBox question01Alternative05 = (CheckBox) findViewById(R.id.checkBox5);

        question01CheckBoxList.add(question01Alternative01);
        question01CheckBoxList.add(question01Alternative02);
        question01CheckBoxList.add(question01Alternative03);
        question01CheckBoxList.add(question01Alternative04);
        question01CheckBoxList.add(question01Alternative05);



        CheckBox question02Alternative06 = (CheckBox) findViewById(R.id.checkBox6);
        CheckBox question02Alternative07 = (CheckBox) findViewById(R.id.checkBox7);
        CheckBox question02Alternative08 = (CheckBox) findViewById(R.id.checkBox8);
        CheckBox question02Alternative09 = (CheckBox) findViewById(R.id.checkBox9);
        CheckBox question02Alternative10 = (CheckBox) findViewById(R.id.checkBox10);

        question02CheckBoxList.add(question02Alternative06);
        question02CheckBoxList.add(question02Alternative07);
        question02CheckBoxList.add(question02Alternative08);
        question02CheckBoxList.add(question02Alternative09);
        question02CheckBoxList.add(question02Alternative10);



        CheckBox question03Alternative11 = (CheckBox) findViewById(R.id.checkBox11);
        CheckBox question03Alternative12 = (CheckBox) findViewById(R.id.checkBox12);
        CheckBox question03Alternative13 = (CheckBox) findViewById(R.id.checkBox13);
        CheckBox question03Alternative14 = (CheckBox) findViewById(R.id.checkBox14);
        CheckBox question03Alternative15 = (CheckBox) findViewById(R.id.checkBox15);

        question03CheckBoxList.add(question03Alternative11);
        question03CheckBoxList.add(question03Alternative12);
        question03CheckBoxList.add(question03Alternative13);
        question03CheckBoxList.add(question03Alternative14);
        question03CheckBoxList.add(question03Alternative15);


        // Set all elements as GONE
        for(CheckBox c: question01CheckBoxList)
            c.setVisibility(View.GONE);

        for(CheckBox c: question02CheckBoxList)
            c.setVisibility(View.GONE);

        for(CheckBox c: question03CheckBoxList)
            c.setVisibility(View.GONE);

        for (RadioGroup r: questionsRadioGroup)
            r.setVisibility(View.GONE);

        for(Button b: buttonsArray)
        {
            b.setVisibility(View.GONE);
            b.setOnClickListener(onButtonClick);
        }

    }

    protected void setButtonsVisibility()
    {
        switch (numberOfQuestions)
        {
            case 1:
                buttonsArray.get(0).setVisibility(View.GONE);
                buttonsArray.get(1).setVisibility(View.VISIBLE);
                buttonsArray.get(2).setVisibility(View.GONE);
                break;
            case 2:
                buttonsArray.get(0).setVisibility(View.GONE);
                buttonsArray.get(1).setVisibility(View.VISIBLE);
                buttonsArray.get(2).setVisibility(View.GONE);
                buttonsArray.get(3).setVisibility(View.VISIBLE);
                buttonsArray.get(4).setVisibility(View.GONE);
                buttonsArray.get(5).setVisibility(View.VISIBLE);
                break;
            case 3:
                buttonsArray.get(0).setVisibility(View.GONE);
                buttonsArray.get(1).setVisibility(View.VISIBLE);
                buttonsArray.get(2).setVisibility(View.GONE);
                buttonsArray.get(3).setVisibility(View.VISIBLE);
                buttonsArray.get(4).setVisibility(View.VISIBLE);
                buttonsArray.get(5).setVisibility(View.GONE);
                buttonsArray.get(6).setVisibility(View.VISIBLE);
                buttonsArray.get(7).setVisibility(View.GONE);
                buttonsArray.get(8).setVisibility(View.VISIBLE);
        }
    }


}