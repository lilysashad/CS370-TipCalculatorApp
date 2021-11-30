package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    Button buttonCompute;
    EditText checkAmountValue;
    EditText partySizeValue;
    String Tip15;
    TextView fifteenPercentTipValue;
    String Tip20;
    TextView twentyPercentTipValue;
    String Tip25;
    TextView twentyfivePercentTipValue;
    String Total15;
    TextView fifteenPercentTotalValue;
    String Total20;
    TextView twentyPercentTotalValue;
    String Total25;
    TextView twentyfivePercentTotalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        buttonCompute = findViewById(R.id.buttonCompute);

        checkAmountValue = findViewById(R.id.checkAmountValue);

        partySizeValue = findViewById(R.id.partySizeValue);

        fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);

        twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);

        twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);

        fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);

        twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);

        twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);

        buttonCompute.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                String amount = checkAmountValue.getText().toString();

                String party = partySizeValue.getText().toString();

                if(amount.equals("") || party.equals("") || party.equals("0")){

                    Toast.makeText(TipCalculatorActivity.this, "Invalid input", Toast.LENGTH_LONG).show();

                    return;

                }

                else{

                    calculateTipAndTotal(amount, party);

                }

            }

        });
    }

    public void calculateTipAndTotal(String amount, String party){

        double numAmount = Double.parseDouble(amount);

        double numParty = Double.parseDouble(party);

        double perPerson = numAmount / numParty;

        Tip15 = String.valueOf(Math.round(perPerson * .15));

        fifteenPercentTipValue.setText(Tip15);

        Tip20 = String.valueOf(Math.round(perPerson * .20));

        twentyPercentTipValue.setText(Tip20);

        Tip25 = String.valueOf(Math.round(perPerson * .25));

        twentyfivePercentTipValue.setText(Tip25);

        Total15 = String.valueOf(Math.round(perPerson + Math.round(perPerson * .15)));

        fifteenPercentTotalValue.setText(Total15);

        Total20 = String.valueOf(Math.round(perPerson + Math.round(perPerson * .20)));

        twentyPercentTotalValue.setText(Total20);

        Total25 = String.valueOf(Math.round(perPerson + Math.round(perPerson * .25)));

        twentyfivePercentTotalValue.setText(Total25);

    }

}