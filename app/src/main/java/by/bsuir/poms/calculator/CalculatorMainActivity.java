package by.bsuir.poms.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorMainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonLeftBracket, buttonRightBracket, buttonExponentiation, buttonDot, buttonFactorial,
            buttonSqrt, buttonPlus, buttonMinus, buttonMultiplication, buttonDivision,
            buttonSin, buttonCos, buttonEqual;

    TextView resultTextView;

    Float result = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);
        getLinksOnViewComponents();
        setOnClickListeners();
    }

    private void getLinksOnViewComponents() {
        resultTextView = findViewById(R.id.resultTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonLeftBracket = findViewById(R.id.button_left_bracket);
        buttonRightBracket = findViewById(R.id.button_right_bracket);
        buttonExponentiation = findViewById(R.id.button_exponentiation);
        buttonDot = findViewById(R.id.button_dot);
        buttonFactorial = findViewById(R.id.button_factorial);
        buttonSqrt = findViewById(R.id.button_sqrt);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMultiplication = findViewById(R.id.button_multiplication);
        buttonDivision = findViewById(R.id.button_division);
        buttonSin = findViewById(R.id.button_sin);
        buttonCos = findViewById(R.id.button_cos);
        buttonEqual = findViewById(R.id.button_equal);
    }

    private void setOnClickListeners() {
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonLeftBracket.setOnClickListener(this);
        buttonRightBracket.setOnClickListener(this);
        buttonExponentiation.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonFactorial.setOnClickListener(this);
        buttonSqrt.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiplication.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonSin.setOnClickListener(this);
        buttonCos.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int clickedElementId = view.getId();
        if (clickedElementId == R.id.button0 || clickedElementId == R.id.button1
                || clickedElementId == R.id.button2 || clickedElementId == R.id.button3
                || clickedElementId == R.id.button4 || clickedElementId == R.id.button5
                || clickedElementId == R.id.button6 || clickedElementId == R.id.button7
                || clickedElementId == R.id.button8 || clickedElementId == R.id.button9) {
            onClickNumberButton(clickedElementId);
        } else {
            switch (clickedElementId) {
                case R.id.button_left_bracket: break;
                case R.id.button_right_bracket: break;
                case R.id.button_exponentiation: break;
                case R.id.button_dot: break;
                case R.id.button_factorial: break;
                case R.id.button_sqrt: break;
                case R.id.button_plus: break;
                case R.id.button_minus: break;
                case R.id.button_multiplication: break;
                case R.id.button_division: break;
                case R.id.button_sin: break;
                case R.id.button_cos: break;
                case R.id.button_equal: break;
            }
        }
    }

    private void onClickNumberButton(int clickedElementId) {
    }
}
