package com.demo.android.bmi;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class BMI extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        //Listen for button clicks
        Button button = (Button)findViewById(R.id.submit);
        button.setOnClickListener(calcBMI);
    }

    private View.OnClickListener calcBMI = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            DecimalFormat nf = new DecimalFormat("0.00");
            EditText fieldheight = (EditText)findViewById(R.id.height);
            EditText fieldweight = (EditText)findViewById(R.id.weight);
            double height = Double.parseDouble(fieldheight.getText().toString())/100;
            double weight = Double.parseDouble(fieldweight.getText().toString());
            double BMI = weight/(height*height);

            TextView result = (TextView)findViewById(R.id.result);
            result.setText("Your BMI is" + nf.format(BMI));

            //Give health advice
            TextView fieldsuggest = (TextView)findViewById(R.id.suggest);
            if(BMI > 25){
                fieldsuggest.setText(R.string.advice_heavy);
            }
            else if (BMI < 20){
                fieldsuggest.setText(R.string.advice_light);
            }
            else {
                fieldsuggest.setText(R.string.advice_average);
            }

        }

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bmi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
