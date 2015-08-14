package com.example.yoyo.sismicapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DbHelper1 extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz1";
    // tasks table name
    private static final String TABLE_QUEST = "quest1";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private SQLiteDatabase dbase;
    public DbHelper1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql);
        addQuestions();
//db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("¿Dónde se inicia la ruptura en un sismo?","Hipocentro","Epicentro","Baricentro", "Hipocentro");
        this.addQuestion(q1);
        Question q2=new Question("¿Dónde ocurrio el terremoto más potente de la historia?","New York - USA","Valdivia - Chile", "Seoul - Korea","Valdivia - Chile");
        this.addQuestion(q2);
        Question q3=new Question("¿Cúal es el criterio de la escala de Mercalli?","La energía liberada durante el sismo", "Utilizando datos de los sismografos", "Observando los efectos y daños causados por el temblor", "Observando los efectos y daños causados por el temblor");
        this.addQuestion(q3);
        Question q4=new Question("¿Cuál fue la potencia en escala de Richter del terremoto del 27F?", "9.5", "8.8", "8.1", "8.8");
        this.addQuestion(q4);
        Question q5=new Question("A qué se asemeja un fenomeno sismico","Lanzar una esfera metalica y una plama a la misma altura","El movimiento de las olas oceanicas","Lanzar un objeto en un estanque","Lanzar un objeto en un estanque");
        this.addQuestion(q5);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
// Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
//SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
// Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}