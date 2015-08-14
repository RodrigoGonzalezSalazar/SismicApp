package com.example.yoyo.sismicapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class QuizActivity extends ActionBarActivity {

//    SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
  //  String trophy1 = settings.getString("trophy1", "");
  //  String trophy2 = settings.getString("trophy2", "");
    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.Menudesafios));
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String trophy1 = settings.getString("trophy1", "");
        String trophy2 = settings.getString("trophy2", "");
        final String whatQuiz = settings.getString("whatQuiz","");
        setContentView(R.layout.activity_quiz);
        if (whatQuiz.equals("info")){
        DbHelper1 db=new DbHelper1(this);
            quesList=db.getAllQuestions();
            currentQ=quesList.get(qid);}
        else if (whatQuiz.equals("prev")){
            DbHelper2 db=new DbHelper2(this);
            quesList=db.getAllQuestions();
            currentQ=quesList.get(qid);
        }

        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
                if(currentQ.getANSWER().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Your score"+score);
                }
                if(qid<5){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else{
                    if (whatQuiz.equals("info")){
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    if(score == 5) {
                        SharedPreferences.Editor edit = settings.edit();
                        String trophy1 = "si";
                        edit.putString("trophy1", trophy1);
                        edit.apply();
                    }
                    else {
                        SharedPreferences.Editor edit = settings.edit();
                        String trophy1 = "no";
                        edit.putString("trophy1", trophy1);
                        edit.apply();
                    }

                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();}
                    else if (whatQuiz.equals("prev")){
                        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score); //Your score
                        if(score == 5) {
                            SharedPreferences.Editor edit = settings.edit();
                            String trophy22 = "si";
                            edit.putString("trophy2", trophy22);
                            edit.apply();
                        }
                        else {
                            SharedPreferences.Editor edit = settings.edit();
                            String trophy22 = "no";
                            edit.putString("trophy2", trophy22);
                            edit.apply();
                        }
                        intent.putExtras(b); //Put your score to your next Intent
                        startActivity(intent);
                        finish();
                    }


                }
            }
        });
    }

    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }
}

