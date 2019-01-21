package com.example.murali.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number
    {
        int number;
        public boolean isSquare()
        {
            double squareroot=Math.sqrt(number);
            if(squareroot==Math.floor(squareroot)) {
                return true;
            }
            else
            {
                return false;
            }
        }
        public boolean isTriangular()
        {
            int x=1;
            int triangularNumber=1;
            while(triangularNumber<number)
            {
                x++;
                triangularNumber=triangularNumber+x;
            }
            if(triangularNumber==number)
                return true;
            else
                return false;
        }
    }
public void makeToast(String message)
{
    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
}
    public void checkNumber(View view) {
        String message = "";
        EditText userNumber = (EditText) findViewById(R.id.userNumber);
        if (userNumber.getText().toString().isEmpty()) {
            message = "Please Enter a Number";
            makeToast(message);
        } else {
            Number Mynumber = new Number();
            Mynumber.number = Integer.parseInt(userNumber.getText().toString());
            if (Mynumber.isSquare()) {
                if (Mynumber.isTriangular()) {
                    message = Mynumber.number + " is a Triangular and Square.";
                    makeToast(message);
                } else {
                    message = Mynumber.number + " is a Square only.";
                    makeToast(message);
                }
            } else {

                message = Mynumber.number + " is a Triangular only.";
                makeToast(message);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
