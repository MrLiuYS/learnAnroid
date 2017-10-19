package com.mrliuys.android.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.textView)
    EditText textView;
    @BindView(R.id.button_AC)
    Button buttonAC;
    @BindView(R.id.button_AM)
    Button buttonAM;
    @BindView(R.id.button_sign)
    Button buttonSign;
    @BindView(R.id.button_except)
    Button buttonExcept;
    @BindView(R.id.button_7)
    Button button7;
    @BindView(R.id.button_8)
    Button button8;
    @BindView(R.id.button_9)
    Button button9;
    @BindView(R.id.button_multiply)
    Button buttonMultiply;
    @BindView(R.id.button_4)
    Button button4;
    @BindView(R.id.button_5)
    Button button5;
    @BindView(R.id.button_6)
    Button button6;
    @BindView(R.id.button_minus)
    Button buttonMinus;
    @BindView(R.id.button_1)
    Button button1;
    @BindView(R.id.button_2)
    Button button2;
    @BindView(R.id.button_3)
    Button button3;
    @BindView(R.id.button_add)
    Button buttonAdd;
    @BindView(R.id.button_0)
    Button button0;
    @BindView(R.id.button_point)
    Button buttonPoint;
    @BindView(R.id.button_equal)
    Button buttonEqual;

    private int symol = -1;
    private String parma0;
    private boolean isStartSecondParma = false; //开始输入第二个参数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.button_AC, R.id.button_AM, R.id.button_sign, R.id.button_except, R.id.button_7, R.id.button_8, R
            .id.button_9, R.id.button_multiply, R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_minus, R.id
            .button_1, R.id.button_2, R.id.button_3, R.id.button_add, R.id.button_0, R.id.button_point, R.id
            .button_equal})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.button_AC:
                textView.setText("");
                symol = -1;
                isStartSecondParma = false;
                break;
            case R.id.button_AM:
                break;
            case R.id.button_sign:
                break;
            case R.id.button_except:

                funSymol(view.getId());

                break;
            case R.id.button_7:


                funInput("7");

                break;
            case R.id.button_8:

                funInput("8");
                break;
            case R.id.button_9:
                funInput("9");
                break;
            case R.id.button_multiply:
                funSymol(view.getId());
                break;
            case R.id.button_4:
                funInput("4");
                break;
            case R.id.button_5:
                funInput("5");
                break;
            case R.id.button_6:
                funInput("6");
                break;
            case R.id.button_minus:
                funSymol(view.getId());
                break;
            case R.id.button_1:
                funInput("1");
                break;
            case R.id.button_2:
                funInput("2");
                break;
            case R.id.button_3:
                funInput("3");
                break;
            case R.id.button_add:
                funSymol(view.getId());
                break;
            case R.id.button_0:
                funInput("0");
                break;
            case R.id.button_point:
                funInput(".");
                break;
            case R.id.button_equal:
                funSymol(view.getId());
                break;
        }
    }

    private void funInput(String inputStr) {

        if (isStartSecondParma) {

            textView.setText(inputStr);

            isStartSecondParma = false;

        } else {
            textView.setText(textView.getText().toString() + inputStr);
        }

    }


    private void funSymol(int aSymol) {

        isStartSecondParma = true;

        if (symol != -1) {

            parma0 = algorithm(parma0, symol, textView.getText().toString());

            textView.setText(parma0);

        } else {

            parma0 = textView.getText().toString();

        }

        if (aSymol == R.id.button_equal) {
            symol = -1;
            return;
        }

        symol = aSymol;

    }

    private String algorithm(String a, int symol, String b) {

        DecimalFormat format = new DecimalFormat("#.#");

        switch (symol) {

            case R.id.button_except:

                if (Double.parseDouble(b) != 0) {

                    return format.format(Double.parseDouble(a) / Double.parseDouble(b));
                }

                break;
            case R.id.button_multiply:

                return format.format(Double.parseDouble(a) * Double.parseDouble(b));

            case R.id.button_minus:

                return format.format(Double.parseDouble(a) - Double.parseDouble(b));

            case R.id.button_add:
                return format.format(Double.parseDouble(a) + Double.parseDouble(b));

            default:

                break;
        }

        return "0";

    }


}
