package by.bsuir.poms.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorMainActivity extends AppCompatActivity {

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
    }

    private String calculate(String expression) {
//        Float result = 0f;
        System.out.println(expression);

        // todo: implement
        Object result = null;
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            result = engine.eval("5+4*(7-15)");
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return "result";
    }

    private String listToString(List<String> list) {
        StringBuilder resultString = new StringBuilder();
        for (String element : list) {
            resultString.append(element);
        }
        return resultString.toString();
    }

    private final View.OnClickListener equalButtonOnClickListener = view -> {
        String result = calculate(listToString(pressedButtonsKeys));
        pressedButtonsKeys.clear();
        pressedButtonsKeys.add(result);
        refreshViewedResult();
    };

    private final View.OnClickListener simpleButtonOnClickListener = view -> {
        Button pressedButton = findViewById(view.getId());
        pressedButtonsKeys.add(pressedButton.getText().toString());
        refreshViewedResult();
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
