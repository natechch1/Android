package com.example.caps;
//Student Name: Shuyi shi

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class CapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caps_layout);
        initialize();
    }
    private Game game;
    private String qt;
    private String an;
    private int sc;
    private int qn;
    private ScrollView sv;
    private LinearLayout op;
    private TextView tv;
    private String l = "";
    private String pl = "";

    private void initialize()
    {
        sv = findViewById(R.id.sv);
        sv.removeAllViews();
        op = new LinearLayout(this);
        op.setOrientation(LinearLayout.VERTICAL);
        sv.addView(op);
        tv = new TextView(this);
        tv.setGravity(Gravity.LEFT);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        tv.setTypeface(null, Typeface.NORMAL);
        op.addView(tv);
        qn = 1;
        sc = 0;
        ((TextView) findViewById(R.id.score)).setText("SCORE = " + sc);
        ((TextView) findViewById(R.id.qNum)).setText("Q# " + qn);
        ask();
    }
    private void ask()
    {
        game = new Game();
        String [] s = game.qa().split("\n");
        qt = s[0];
        an = s[1];
        ((TextView) findViewById(R.id.question)).setText(qt);
    }

    public void onDone(View v)
    {
        String userInput = ((EditText) findViewById(R.id.answer)).getText().toString();
        String upperCaseInput = userInput.toUpperCase();
        if (!upperCaseInput.equalsIgnoreCase(""))
        {
            if (upperCaseInput.equalsIgnoreCase(an))
            {
                sc++;
                ((TextView) findViewById(R.id.score)).setText("SCORE = " + sc);
            }
            l = "Q# " + qn + ": " + qt + "\n" + "Your answer: " + upperCaseInput + "\n" + "Correct answer: " + an + "\n\n";
            tv.setText(l+ pl);
            pl = l + pl;
            qn++;

            if (qn >= 10)
            {
                ((TextView) findViewById(R.id.qNum)).setText("GAME OVER!");
                findViewById(R.id.done).setEnabled(false);
            }
            else
            {
                ((TextView) findViewById(R.id.qNum)).setText("Q# " + qn);
                ask();
            }

            ((EditText) findViewById(R.id.answer)).setText("");
        }
    }
}
// Student Name: Hongce Chen
// This lab was was done with partner Shuyi Shi
//video link: https://www.youtube.com/watch?v=cKg7KyBT2R0
