package com.example.jay_cee.winning;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    TextView num1;
    TextView num2;
    TextView num3;
    TextView num4;
    TextView num5;
    TextView num6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rbutton = (Button) findViewById(R.id.randomButton);


        rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n;


               assign();
            }
        });
    }



    // Getting and Displaying Random Numbers to label
    private void assign(){
        ArrayList num= GetFive();

        // Getting the Textfield from viewer and changing text.
        num1 =  (TextView) findViewById(R.id.num1);

        num1.setText(  num.get(0).toString());

        num2 =  (TextView) findViewById(R.id.num2);

        num2.setText(  num.get(1).toString());


        num3 =  (TextView) findViewById(R.id.num3);

        num3.setText(  num.get(2).toString());

        num4 =  (TextView) findViewById(R.id.num4);

        num4.setText(  num.get(3).toString());


        num5 =  (TextView) findViewById(R.id.num5);

        num5.setText(  num.get(4).toString());

        num6 =  (TextView) findViewById(R.id.num6);

        num6.setText( num.get(5).toString());

    }


    private int RandomNum(int max , int min){

        Random rand = new Random();
        int randomNum;
        randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }


    private ArrayList GetFive(){
        boolean newnum = true;
        ArrayList LottoNum = new ArrayList() ;
        boolean pass= false;
        int xx =0;


        // Filling the List up with Numbers and making sure there are no repeats.
        do {
            int nuum=0;
            int max =7;   // MAX
            int min= 1;  //MIN

            // FIRST NUMBER
            if(LottoNum.size() == 0){
                nuum = RandomNum(max, min);
                LottoNum.add(nuum);
            }
            else if(LottoNum.size() == 5){
                max = 67;
                min = 1;

                nuum = RandomNum(max, min);
                LottoNum.add(nuum);
            }
            else {          // SECOND numbers to Fifth.

                nuum = RandomNum(max, min);
              //  LottoNum.add(nuum);
                    for(int x=0; x<LottoNum.size(); x++)
                    {


                        if (Integer.parseInt(LottoNum.get(x).toString())== nuum)
                        {
                            newnum = false;
                        }

                    }


                if(newnum == true){
                    LottoNum.add(nuum);
                }
                newnum = true;



            }




        }while(LottoNum.size() != 6);



        return LottoNum;

    }
}
