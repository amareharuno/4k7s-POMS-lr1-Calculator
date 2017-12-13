package by.bsuir.poms.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.LinkedList;
import java.util.List;

public class CalculatorMainActivity extends AppCompatActivity {

    private HorizontalScrollView horizontalScrollView;

    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonLeftBracket, buttonRightBracket, buttonExponentiation, buttonDot, buttonFactorial,
            buttonSqrt, buttonPlus, buttonMinus, buttonMultiplication, buttonDivision,
            buttonSin, buttonCos, buttonEqual, buttonErase, buttonReset;

    private TextView resultTextView;

    private LinkedList<String> pressedButtonsKeys = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);
        getLinksOnViewComponents();
        setOnClickListeners();
    }

    private void refreshViewedResult() {
        resultTextView.setText(listToString(pressedButtonsKeys));
        horizontalScrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
    }

    private String calculate(String expressionString) {
        double result; // result can be in range: [-2147483648; 2147483647]
        int intResult;

        Expression expression = new Expression(expressionString);
        result = expression.calculate();

        if (result % 1 == 0) {
            intResult = (int) result;
            return String.valueOf(intResult);
        } else {
            return String.valueOf(result);
        }
    }

    private String listToString(List<String> list) {
        StringBuilder resultString = new StringBuilder();
        for (String element : list) {
            resultString.append(element);
        }
        return resultString.toString();
    }

    private final View.OnClickListener simpleButtonOnClickListener = view -> {
        if (pressedButtonsKeys.size() < 15) { // restriction on the number of entered operations and numbers
            Button pressedButton = findViewById(view.getId());
            String pressedButtonValue = pressedButton.getText().toString();
            if (pressedButtonValue.equals(ButtonKeys.BUTTON_SIN)
                    || pressedButtonValue.equals(ButtonKeys.BUTTON_COS)
                    || pressedButtonValue.equals(ButtonKeys.BUTTON_SQRT)) {
                pressedButtonsKeys.add(pressedButtonValue.toLowerCase() + ButtonKeys.BUTTON_LEFT_BRACKET);
            } else {
                pressedButtonsKeys.add(pressedButtonValue.toLowerCase());
            }
            refreshViewedResult();
        }
    };

    private final View.OnClickListener equalButtonOnClickListener = view -> {
        String result = calculate(listToString(pressedButtonsKeys));
        pressedButtonsKeys.clear();
        pressedButtonsKeys.add(result);
        refreshViewedResult();

        if (result.equals("NaN")) {
            pressedButtonsKeys.clear();
        }
    };

    private final View.OnClickListener resetButtonOnClickListener = view -> {
        pressedButtonsKeys.clear();
        refreshViewedResult();
    };

    private final View.OnClickListener eraseButtonOnClickListener = view -> {
        if (!pressedButtonsKeys.isEmpty()) {
            pressedButtonsKeys.removeLast();
            refreshViewedResult();
        }
    };

    private void getLinksOnViewComponents() {
//        resultTextView = findViewById(R.id.editText);
        horizontalScrollView = findViewById(R.id.horizontalScrollView);
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
        buttonErase = findViewById(R.id.button_erase);
        buttonReset = findViewById(R.id.button_reset);
    }

    private void setOnClickListeners() {
        button0.setOnClickListener(simpleButtonOnClickListener);
        button1.setOnClickListener(simpleButtonOnClickListener);
        button2.setOnClickListener(simpleButtonOnClickListener);
        button3.setOnClickListener(simpleButtonOnClickListener);
        button4.setOnClickListener(simpleButtonOnClickListener);
        button5.setOnClickListener(simpleButtonOnClickListener);
        button6.setOnClickListener(simpleButtonOnClickListener);
        button7.setOnClickListener(simpleButtonOnClickListener);
        button8.setOnClickListener(simpleButtonOnClickListener);
        button9.setOnClickListener(simpleButtonOnClickListener);
        buttonLeftBracket.setOnClickListener(simpleButtonOnClickListener);
        buttonRightBracket.setOnClickListener(simpleButtonOnClickListener);
        buttonExponentiation.setOnClickListener(simpleButtonOnClickListener);
        buttonDot.setOnClickListener(simpleButtonOnClickListener);
        buttonFactorial.setOnClickListener(simpleButtonOnClickListener);
        buttonSqrt.setOnClickListener(simpleButtonOnClickListener);
        buttonPlus.setOnClickListener(simpleButtonOnClickListener);
        buttonMinus.setOnClickListener(simpleButtonOnClickListener);
        buttonMultiplication.setOnClickListener(simpleButtonOnClickListener);
        buttonDivision.setOnClickListener(simpleButtonOnClickListener);
        buttonSin.setOnClickListener(simpleButtonOnClickListener);
        buttonCos.setOnClickListener(simpleButtonOnClickListener);

        buttonEqual.setOnClickListener(equalButtonOnClickListener);
        buttonErase.setOnClickListener(eraseButtonOnClickListener);
        buttonReset.setOnClickListener(resetButtonOnClickListener);
    }
}
