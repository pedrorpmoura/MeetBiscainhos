package com.example.pedrorpmoura.teste;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
    private ImageView questionImage;
    private Button questionAnswer1;
    private Button questionAnswer2;
    private Button questionAnswer3;
    private Button questionAnswer4;

    private String rightAnswer;
    private int score = 0;
    private int quizCounter = 1;
    static final private int QUIZ_COUNT = 8; //numero de perguntas por quiz

    ArrayList<ArrayList<String>> quizArray= new ArrayList<>();

    String quizData[][] = {
            //{Questao, resposta certa, resposta2, resposta3, resposta4}
            {"Como se chamavam os condes do museu dos Biscainhos?", "Bertiandos", "Bragança", "Abrantes", "Albuquerque", "0"},
            {"Em que parte da casa tocavam piano?", "sala de música e jogo", "sala do estrado", "cavalariça", "salão nobre", "0"},
            {"Quando os convidados chegavam ao Palácio dos Biscainhos eram recebidos por quem?", "pagens", "donos da casa", "animais", "cozinheiros", "0"},
            {"Os azulejos que estão na figura encontram-se em que parte da casa?", "no salão nobre", "na entrada", "no jardim", "no oratório", "obj_salao_nobre_azulejos"},
            {"A peça (roda de fumeiro) que que está na figura era usada para fazer o quê?", "secar as carnes", "cortar as carnes", "pendurar colheres de pau", "nenhuma das anteriores", "obj_cozinha_roda"},
            {"Em que século foi fundado o palácio dos Biscainhos?", "século 17", "século 20", "século 6", "século 21", "0"},
            {"Qual é o estilo arquitetônico do Museu dos Biscainhos?", "estilo Barroco", "estilo Manuelino", "estilo Gótico", "estilo Rocócó", "0"},
            {"Em que parte da casa é que os convidados eram recebidos?", "na entrada", "no jardim", "no oratório", "sala de jantar", "0"},
            {"O que representa este azulejo que está no salão nobre?", "montaria", "jardinagem", "pintura", "montaria", "obj_salao_nobre_azulejos"},
            {"Como se chama a árvore mais antiga do jardim?", "tulipeiro", "arbusto", "laranjeira", "roseira", "0"},
            {"Quem servia as refeições na sala de jantar?", "lacaios/ escravos", "condes", "mordomos", "cozinheiros", "0"},
            {"Qual era a finalidade do oratório?", "rezar", "ler", "descansar", "costurar", "0"},
            {"Quando chegavam os convidados onde ficavam os seus cavalos?", "no átrio", "no jardim", "no cavalariça", "na cozinha", "0"},
            {"Onde podes encontrar esta cadeirinha?", "átrio e escadaria", "quarto", "sala de música e jogo", "gabinete", "obj_entrada_cadeirinha"},
            {"O que representam os quanto cantos do teto do salão nobre?", "índios brasileiros", "anjos", "gatos", "escravos", "0"},
            {"Quem é o homem homenageado no teto do salão nobre?", "Beato Minguel de Carvalho", "Papa Francisco", "D. Pedro", "D. Afonso Henriques", "0"},
            {"Se quisesses um livro para ler onde o poderias encontrar?", "no gabinete", "na entrada", "no oratório", "no salão nobre", "0"}
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
        questionImage = (ImageView) root_view.findViewById(R.id.questionImage);
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
            tmpArray.add(quizData[i][5]);

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

        if(quiz.get(5).equals("0")){
            questionImage.setImageResource(0);
        }else{
            int resID = getResources().getIdentifier(quiz.get(5) , "drawable", getActivity().getPackageName());
            questionImage.setImageResource(resID);
        }

        quiz.remove(5);
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
        if(quizCounter == QUIZ_COUNT) builder.setMessage("Resultado final: " +score + "/" + QUIZ_COUNT);

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
