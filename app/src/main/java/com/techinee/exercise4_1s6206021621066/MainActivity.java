package com.techinee.exercise4_1s6206021621066;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText numberText;
    private Button btnChange;
    private TextView Decimal , Binary , Octal , Hexa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void buttonClick(View view) {

        Toast.makeText(this,"กรุณากรอกตัวเลข " , Toast.LENGTH_LONG).show();
        numberText = (EditText) findViewById(R.id.numberText);
        Decimal =(TextView) findViewById(R.id.Decimal);
        Binary =(TextView) findViewById(R.id.Binary);
        Octal =(TextView) findViewById(R.id.Octal);
        Hexa =(TextView) findViewById(R.id.Hexa);

        int numberBin , numberOct , numberHex , rem;
        String desToBin = "";
        String desToOct = "";
        String desToHex = "";
        char octChars[] = {'0','1','2','3','4','5','6','7'};
        char hexChars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        if(numberText.getText().toString().length() > 0) {
            numberBin = Integer.parseInt(numberText.getText().toString());
            numberOct = Integer.parseInt(numberText.getText().toString());
            numberHex = Integer.parseInt(numberText.getText().toString());

            while (numberBin > 0) {
                int num = numberBin % 2 ;
                numberBin = numberBin / 2 ;
                desToBin = num + desToBin ;
            }
            while (numberOct > 0 ) {
                rem = numberOct % 8;
                desToOct = octChars[rem] + desToOct;
                numberOct = numberOct / 8;
            }
            while (numberHex > 0) {
                rem = numberHex % 16;
                desToHex = hexChars[rem] + desToHex;
                numberHex = numberHex / 16;
            }
        }
        else Toast.makeText(this,"กรอกตัวเลข" , Toast.LENGTH_LONG).show();

            Decimal.setText(numberText.getText().toString() + "");
            Binary.setText(desToBin + "" );
            Octal.setText(desToOct + "" );
            Hexa.setText(desToHex + "" );
    }
}