package eecs1022.example.mcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EntryForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View v)
    {
        View principleView = findViewById(R.id.principleBox);
        EditText principle_text = (EditText) principleView;
        String principle =  principle_text.getText().toString();

        String amortization = ((EditText)findViewById(R.id.amortizationBox)).getText().toString();
        String interest = ((EditText)findViewById(R.id.interestBox)).getText().toString();

        MortageModel model = new MortageModel(principle,interest,amortization);
        String result = model.computePayment();

        ((TextView)findViewById(R.id.answer)).setText(result);
    }





}
