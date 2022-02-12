package com.padovano.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

enum OPERATEUR{
    PLUS,SUBSTRACT,DIVIDE,MULTIPLY
}
public class MainActivity extends AppCompatActivity {
    EditText field;
    Button btn1,btnd,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnpt,btnc,btnpl,btnmoins,egal,btnmult;

    String Val="0";
    OPERATEUR operateur;
    private double first=0,second=0,temp=0;
    private boolean isoperateur=false,isresult=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field=findViewById(R.id.editTextNumberDecimal);
        btn0=findViewById(R.id.btn_0);
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);
        btn5=findViewById(R.id.btn_5);
        btn6=findViewById(R.id.btn_6);
        btn7=findViewById(R.id.btn_7);
        btn8=findViewById(R.id.btn_8);
        btn9=findViewById(R.id.btn_9);
        btnpt=findViewById(R.id.btn_point);
        btnpl=findViewById(R.id.btn_plus);
        btnmoins=findViewById(R.id.btn_moins);
        btnc=findViewById(R.id.btn_c);
        btnd=findViewById(R.id.btn_div);
        btnmult=findViewById(R.id.btn_star);
        egal=findViewById(R.id.btn_egal);

        btn0.setOnClickListener(v -> display(btn0));
        btn1.setOnClickListener(v -> display(btn1));
        btn2.setOnClickListener(v -> display(btn2));
        btn3.setOnClickListener(v -> display(btn3));
        btn4.setOnClickListener(v -> display(btn4));
        btn5.setOnClickListener(v -> display(btn5));
        btn6.setOnClickListener(v -> display(btn6));
        btn7.setOnClickListener(v -> display(btn7));
        btn8.setOnClickListener(v -> display(btn8));
        btn9.setOnClickListener(v -> display(btn9));
        btnpt.setOnClickListener(v -> display(btnpt));
        btnc.setOnClickListener(v ->{
            field.setText("0");
            operateur=null;
            first=0;
            second=0;
            isoperateur=false;
        });
        egal.setOnClickListener(v -> equal());

        btnmult.setOnClickListener(v->Operateur(OPERATEUR.MULTIPLY));
        btnpl.setOnClickListener(v->Operateur(OPERATEUR.PLUS));
        btnmoins.setOnClickListener(v->Operateur(OPERATEUR.SUBSTRACT));
        btnd.setOnClickListener(v->Operateur(OPERATEUR.DIVIDE));
        field.setShowSoftInputOnFocus(false);
        field.setText("0");
    }

    private void Operateur(OPERATEUR op){
        first=Double.parseDouble(field.getText().toString());
        operateur=op;
        isoperateur=true;
    }

    private void display(Button btn){
        String val=btn.getText().toString();
        if(isoperateur){
            field.setText("0");
            isoperateur=false;
        }
        if(val.equals("."))
            if(field.getText().toString().contains("."))
                return;
        if(val.equals("0"))
            if(field.getText().toString().equals("0"))
                return;
        if(field.getText().toString().equals("0")){
            field.setText(btn.getText());
            return;
        }
        field.append(btn.getText());

        isresult=false;
    }
    private void equal(){
        second=Double.parseDouble(field.getText().toString());

        double result=first;
        if(operateur!=null){
            switch (operateur){
                case PLUS:
                    result+=second;
                    break;
                case SUBSTRACT:
                    result-=second;
                    break;
                case DIVIDE:
                    result/=second;
                    break;
                default:
                    result*=second;
                    break;
            }
        }

        first=result;
        field.setText(String.valueOf(result));
//        if(isresult){
//            temp=second;
//            isresult=false;
//        }
    }
}