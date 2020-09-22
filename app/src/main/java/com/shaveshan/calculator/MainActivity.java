package com.shaveshan.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    Button pow2;
    Button pow;
    Button sin;
    Button cos;
    Button tan;
    Button racine;
    Button fact;
    Button log;
    Button exp;
    Button ln;
    Button rac;
    Button pi;
    Button open;
    Button close;
    Button mod;
    Button singe;
    Button point;
    Button add;
    Button sub;
    Button mul;
    Button div;
    Button equal;
    Button clear;
    Button supp;
    TextView resultTextView;

    String result, tmp , operator;
    String [] tmpOprerator=new String[10];
    int cont,openClose;
    double [] tmpTap = new  double[10];
    boolean n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control();
        calcu();
    }

    private void onNumberButtonClicked(String pos) {
        result = resultTextView.getText().toString();
        if((n && result.indexOf('.')>0)||(n && !(Double.parseDouble(result) == 0)))
            result += pos;
        else{
            n = true;
            result = pos;
        }
        affichage(result);
    }

    private void onOperatorButtonClicked(String operator) {
        onEqualButtonClicked();
        cont ++;
        tmp = (String) resultTextView.getText().toString();
        this.operator = operator;
        n = false;
    }

    private void onClearButtonClicked() {
        cont= 0;
        result = "0";
        tmp = "0";
        resultTextView.setText("0");
        n = false;
    }

    private void calcu(){

        point.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(result.indexOf('.') < 0)
                    result = result + '.';
                affichage(result);
            }
        });
        singe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!(Double.parseDouble(result) == 0))
                    if(( result.indexOf('-') < 0))
                        result = '-' + result;

                    else {
                        int poss = result.indexOf('-');
                        result = result.substring(0, poss) + result.substring(poss + 1);
                    }
                affichage(result);
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!(Double.parseDouble(result) == 0))
                onNumberButtonClicked("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberButtonClicked("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberButtonClicked("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberButtonClicked("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberButtonClicked("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberButtonClicked("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberButtonClicked("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberButtonClicked("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberButtonClicked("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberButtonClicked("9");
            }
        });

        pi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!n)
                    result = String.valueOf(Math.PI);
                    affichage(result);
            }
                });
        pow2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                result = String.valueOf( Math.pow( Double.valueOf(result) , 2 ) );
                affichage(result);
            }
        });
        racine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                result = String.valueOf( Math.pow( Double.valueOf(result) , 0.5 ) );
                affichage(result);
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                result = String.valueOf( Math.sin( Double.valueOf(result)) );
                affichage(result);
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                result = String.valueOf( Math.cos( Double.valueOf(result)) );
                affichage(result);
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                result = String.valueOf( Math.tan( Double.valueOf(result)) );
                affichage(result);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                result = String.valueOf( Math.log10( Double.valueOf(result)) );
                affichage(result);
            }
        });
        ln.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                result = String.valueOf( Math.log( Double.valueOf(result)) );
                affichage(result);
            }
        });
        exp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                result = String.valueOf( Math.exp( Double.valueOf(result)) );
                affichage(result);
            }
        });
        supp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(n){
                    int poss = result.length() - 1;
                    if(poss>0)
                        result = result.substring(0, poss) + result.substring(poss + 1);
                    else if(poss == 0)
                        result = "0";
                }
                affichage(result);
            }
        });
        /*open.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!n && openClose >= 0 && cont >=0) {
                    tmpTap[openClose] = Double.valueOf(result);
                    tmpOprerator[openClose] = operator ;
                    openClose++;

                }
                affichage("(");
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (openClose > 0) {
                    openClose--;
                    onEqualButtonClicked();
                    tmp = String.valueOf(tmpTap[openClose]) ;
                    operator = tmpOprerator[openClose];
                    onEqualButtonClicked();
                }
                affichage(result);
            }
        });*/
        fact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //
                int i;
                double d = Double.valueOf(result),fact = 1;
                if(d<0)
                    d = -d;
                for (i = 0; i<d;i++) {
                    if(i<d){
                        fact = fact * (d-i);
                        result = String.valueOf(fact);
                    }
                    else
                        break;
                }
                affichage(result);

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOperatorButtonClicked("-");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOperatorButtonClicked("+");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOperatorButtonClicked("X");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOperatorButtonClicked("/");
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    onOperatorButtonClicked("%");
                }
            });
        pow.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    onOperatorButtonClicked("pow");
                }
            });
        rac.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOperatorButtonClicked("rac");
            }
        });




        equal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onEqualButtonClicked();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    onClearButtonClicked();
                }
            });
    }

    private void onEqualButtonClicked() {

        n=false;
        double res = Double.valueOf(tmp);
        try {
            if(cont>0){
                cont ++;
                switch (operator) {
                    case "+":
                        res += Double.valueOf( resultTextView.getText().toString());
                        break;
                    case "/":
                        res /= Double.valueOf( resultTextView.getText().toString());
                        break;
                    case "-":
                        res -= Double.valueOf( resultTextView.getText().toString());
                        break;
                    case "X":
                        res *= Double.valueOf( resultTextView.getText().toString());
                        break;
                    case "%":
                        res %=Integer.parseInt( resultTextView.getText().toString());
                        break;
                    case "pow":
                        res = Math.pow(res , Double.valueOf( resultTextView.getText().toString()));
                        break;
                    case "rac":
                        res = Math.pow(res,1/Double.valueOf( resultTextView.getText().toString()));
                        break;
                    case "none":
                        cont++;
                }
                tmp = String.valueOf(res);
                affichage(tmp);
                operator ="none";
            }
        }
        catch (Exception e) {
            affichage("Error");
        }
    }

    private void control(){
        button0 = findViewById(R.id.button0);
        point = findViewById((R.id.buttonPoint));
        equal = findViewById(R.id.buttonEgale);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        add = findViewById(R.id.buttonAdd);
        button4 =  findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        sub= findViewById(R.id.buttonSub);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        mul = findViewById(R.id.buttonMul);
        clear = findViewById(R.id.buttonAC);
        singe = findViewById(R.id.buttonSinge);
        mod = findViewById(R.id.buttonMod);
        div = findViewById(R.id.buttonDiv);
        rac = findViewById(R.id.buttonRacineXY);
        pi = findViewById(R.id.buttonPi);
        open = findViewById(R.id.buttonOpen);
        close = findViewById(R.id.buttonClose);
        supp = findViewById(R.id.buttonSupp);
        racine = findViewById(R.id.buttonRacineCarre);
        fact = findViewById(R.id.buttonFact);
        log = findViewById(R.id.buttonLog);
        ln =  findViewById(R.id.buttonLn);
        exp = findViewById(R.id.buttonExpo);
        pow2 = findViewById(R.id.buttonCarre);
        pow = findViewById(R.id.buttonPow);
        sin = findViewById(R.id.buttonSin);
        cos = findViewById(R.id.buttonCos);
        tan = findViewById(R.id.buttonTan);
        resultTextView = findViewById(R.id.show);
        result = "0";
        tmp = "0";
        cont = 0;
        openClose = 0;
        n = false;
    }

    private void affichage(String result){
        resultTextView.setText(result);
    }
}