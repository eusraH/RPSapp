package com.example.eusrahasan.rpsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {



    //created the variables
    Button Begin;
    Button b_rock, b_paper, b_scissors;
    Button b_reset;
    TextView tv_score;
    ImageView iv_YouChose, iv_ComputerChose;

    int counter =0;

    int HumanScore, ComputerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //assign the variables in the ids
        b_paper = (Button) findViewById(R.id.b_paper);
        b_rock = (Button) findViewById(R.id.b_rock);
        b_scissors = (Button) findViewById(R.id.b_scissors);

        b_reset = (Button) findViewById(R.id.b_reset);

        iv_YouChose = (ImageView) findViewById(R.id.iv_YouChose);
        iv_ComputerChose = (ImageView) findViewById(R.id.iv_ComputerChose);

        tv_score = (TextView) findViewById(R.id.tv_score);

        Begin = (Button) findViewById(R.id.button);


        //create some actions

        Button mainActivity =  (Button) findViewById(R.id.b_reset); //this is going to take user back to the main page once reset button is clicked
        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });


        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //set the correct picture when a button is clicked
                iv_YouChose.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity2.this, message, Toast.LENGTH_SHORT).show();

                //show score
                tv_score.setText("  Human:  " + Integer.toString(HumanScore) + " || Computer:" + Integer.toString(ComputerScore)); //to show the score
            }
        });

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                iv_YouChose.setImageResource(R.drawable.rock);
                String message= play_turn("rock");
                Toast.makeText(MainActivity2.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText(" Human:  " + Integer.toString(HumanScore) + " || Computer: " + Integer.toString(ComputerScore)); //to show the score


            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                iv_YouChose.setImageResource(R.drawable.scissors);
                String message= play_turn("scissors");
                Toast.makeText(MainActivity2.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText(" Human: " + Integer.toString(HumanScore) + " || Computer: " + Integer.toString(ComputerScore)); //to show the score


            }
        });



    }

    public String play_turn( String player_choice){

        String computer_choice = ""; //for computer
        Random r = new Random();  //producing random number

        //choose between options 1 2 0r 3
        int computer_choice_number= r.nextInt(3) + 1;

        if(computer_choice_number==1){
            computer_choice= "rock";
        }
        else if (computer_choice_number==2){
            computer_choice="scissors";
        }
        else if (computer_choice_number==3){
            computer_choice="paper";
        }


        //Set computer image based on the choice
        if(computer_choice=="rock"){
            iv_ComputerChose.setImageResource(R.drawable.rock);
        }
        else if(computer_choice=="scissors"){
            iv_ComputerChose.setImageResource(R.drawable.scissors);
        }
        else if(computer_choice=="paper"){
            iv_ComputerChose.setImageResource(R.drawable.paper);
        }


        //Compare Computer choice and Human choice and declare winner

        if (computer_choice == player_choice) {
            return "It's a draw, nobody won.";
        }
        else{

            if (player_choice == "rock" && computer_choice == "scissors") {
                HumanScore++;
                return "Rock beats scissors, you win!";

            }
            else if (player_choice == "rock" && computer_choice == "paper") {
                ComputerScore++;
                return "Paper covers rock, computer wins!";

            } else if (player_choice == "scissors" && computer_choice == "rock") {
                ComputerScore++;
                return "Rock beats scissors, computer wins!";

            } else if (player_choice == "scissors" && computer_choice == "paper") {
                HumanScore++;
                return "Scissors cut paper, you win!";

            } else if (player_choice == "paper" && computer_choice == "scissors") {
                ComputerScore++;
                return "Scissors cut paper, computer wins!";

            } else if (player_choice == "paper" && computer_choice == "rock") {
                HumanScore++;
                return "Rock beats scissors, you win!";
            }



        }

        return "I'm not sure yet.";
    }

}
