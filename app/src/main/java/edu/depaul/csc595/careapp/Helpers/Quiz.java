package edu.depaul.csc595.careapp.Helpers;

import java.util.ArrayList;

/**
 * Created by jeffersonalvess on 2/26/16.
 */
public class Quiz
{
    String question;
    String explanation;
    boolean styleCheckBox;
    ArrayList<String> alternatives;
    ArrayList<Integer> answers;
    ArrayList<Integer> userAnswers;

    public Quiz()
    {
    }

    public Quiz(String question, String explanation, boolean styleCheckBox, ArrayList<String> alternatives, ArrayList<Integer> answers)
    {
        this.question = question;
        this.explanation = explanation;
        this.styleCheckBox = styleCheckBox;
        this.alternatives = alternatives;
        this.answers = answers;
        this.userAnswers = new ArrayList<Integer>();
    }

    public int getNumberOfAlternatives()
    {
        return this.alternatives.size();
    }

    public float getGrade()
    {
        float grade = 0;

        if(this.isStyleCheckBox())
        {
            float right = 0;
            float op = answers.size() * 5;

            for (Integer i: userAnswers)
            {
                if (answers.contains(i))
                    right += 5;
                else
                    right--;
            }

            if (right > 0)
                grade = 100 * (right / op);
        }
        else
        {
            for (Integer i : answers)
                if(userAnswers.contains(i))
                    grade = 100;
        }

        return grade;
    }

    public ArrayList<String> getCorrectAnswers()
    {
        ArrayList<String> answers = new ArrayList<String>();

        for(Integer i: this.answers)
            answers.add(alternatives.get(i));

        return answers;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getExplanation()
    {
        return explanation;
    }

    public void setExplanation(String explanation)
    {
        this.explanation = explanation;
    }

    public boolean isStyleCheckBox()
    {
        return styleCheckBox;
    }

    public void setStyleCheckBox(boolean styleCheckBox)
    {
        this.styleCheckBox = styleCheckBox;
    }

    public ArrayList<String> getAlternatives()
    {
        return alternatives;
    }

    public void setAlternatives(ArrayList<String> alternatives)
    {
        this.alternatives = alternatives;
    }

    public ArrayList<Integer> getAnswers()
    {
        return answers;
    }

    public void setAnswers(ArrayList<Integer> answers)
    {
        this.answers = answers;
    }

    public ArrayList<Integer> getUserAnswers()
    {
        return userAnswers;
    }

    public void setUserAnswers(int userAnswer)
    {
        Integer i = new Integer(userAnswer);

        if (!this.userAnswers.contains(i))
            this.userAnswers.add(userAnswer);
    }
}
