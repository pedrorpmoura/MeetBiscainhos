package com.example.pedrorpmoura.teste;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {

    private TextView questionCounter;
    private TextView questionLabel;
    private Button questionAnswer1;
    private Button questionAnswer2;
    private Button questionAnswer3;
    private Button questionAnswer4;

    private String rightAnswer;
    private int score = 0;
    private int quizCounter = 1;
    static final private int QUIZ_COUNT = 4; //numero de perguntas por quiz

    ArrayList<ArrayList<String>> quizArray= new ArrayList<>();

    String quizData[][] = {
            //{Questao, resposta certa, resposta2, resposta3, resposta4}
            {"Questão exemplo1", "resposta certa", "resposta errada1", "resposta errada2", "resposta errada3"},
            {"Questão exemplo2", "resposta certa", "resposta errada1", "resposta errada2", "resposta errada3"},
            {"Questão exemplo3", "resposta certa", "resposta errada1", "resposta errada2", "resposta errada3"},
            {"Questão exemplo4", "resposta certa", "resposta errada1", "resposta errada2", "resposta errada3"},
            {"Questão exemplo5", "resposta certa", "resposta errada1", "resposta errada2", "resposta errada3"},
            {"Questão exemplo6", "resposta certa", "resposta errada1", "resposta errada2", "resposta errada3"}
    };


    public QuizFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View root_view = inflater.inflate(R.layout.fragment_quiz, container, false);

        questionCounter = (TextView) root_view.findViewById (R.id.questionCounter);
        questionLabel = (TextView) root_view.findViewById (R.id.questionLabel);
        questionAnswer1 = (Button) root_view.findViewById (R.id.questionAnswer1);
        questionAnswer2 = (Button) root_view.findViewById (R.id.questionAnswer2);
        questionAnswer3 = (Button) root_view.findViewById (R.id.questionAnswer3);
        questionAnswer4 = (Button) root_view.findViewById (R.id.questionAnswer4);


        questionAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(v);
            }
        });

        questionAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(v);
            }
        });

        questionAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(v);
            }
        });

        questionAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(v);
            }
        });

        makeQuiz();
        showQuiz();


        return root_view;

    }

    public void makeQuiz(){
        for(int i=0; i<quizData.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            quizArray.add(tmpArray);
        }
    }



    public void showQuiz(){

        questionCounter.setText("Questão " + quizCounter);

        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNum);
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        questionAnswer1.setText(quiz.get(0));
        questionAnswer2.setText(quiz.get(1));
        questionAnswer3.setText(quiz.get(2));
        questionAnswer4.setText(quiz.get(3));

        quizArray.remove(randomNum);
    }

    public void checkAnswer(View view){

        Button answerButton = (Button) view.findViewById (view.getId());
        String buttonText = answerButton.getText().toString();

        String alert;

        if(buttonText.equals(rightAnswer)){
            alert = "Correto!";
            score++;

        }else{
            alert = "Errado.";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(alert);
        if(quizCounter == QUIZ_COUNT) builder.setMessage("Resultado final: " +score + "/4");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(quizCounter == QUIZ_COUNT){
                    score = 0;
                    quizCounter = 1;
                    makeQuiz();
                    showQuiz();
                }else{
                    quizCounter++;
                    showQuiz();
                }
            }
        });

        builder.setCancelable(false);
        AlertDialog alert2 = builder.create();
        alert2.show();
        alert2.getWindow().getAttributes();

        TextView textView = (TextView) alert2.findViewById(android.R.id.message);
        textView.setTextSize(20);

    }

}
