package com.mrliuys.android.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    String a = "";

    String obj = "";

    int symol = -1;


    @OnClick({R.id.button_AC, R.id.button_AM, R.id.button_sign, R.id.button_except, R.id.button_7, R.id.button_8, R
            .id.button_9, R.id.button_multiply, R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_minus, R.id
            .button_1, R.id.button_2, R.id.button_3, R.id.button_add, R.id.button_0, R.id.button_point, R.id
            .button_equal})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.button_AC:
                textView.setText("");
                symol = -1;
                break;
            case R.id.button_AM:
                break;
            case R.id.button_sign:
                break;
            case R.id.button_except:

                if (symol != -1){

                    //进行计算




                }else {

                    a = obj;



                }

                symol = R.id.button_except;


                break;
            case R.id.button_7:

                if (symol != -1){
                    obj = "";
                }

                obj = obj + 7;
                break;
            case R.id.button_8:
                if (symol != -1){
                    obj = "";
                }
                obj = obj + 8;
                break;
            case R.id.button_9:
                obj = obj + 9;
                break;
            case R.id.button_multiply:
                symol = R.id.button_multiply;
                break;
            case R.id.button_4:
                obj = obj + 4;
                break;
            case R.id.button_5:
                obj = obj + 5;
                break;
            case R.id.button_6:
                obj = obj + 6;
                break;
            case R.id.button_minus:
                symol = R.id.button_minus;
                break;
            case R.id.button_1:
                obj = obj + 1;
                break;
            case R.id.button_2:
                obj = obj + 2;
                break;
            case R.id.button_3:
                obj = obj + 3;
                break;
            case R.id.button_add:
                symol = R.id.button_add;
                break;
            case R.id.button_0:
                obj = obj + 0;
                break;
            case R.id.button_point:
                obj = obj + ".";
                break;
            case R.id.button_equal:
                symol = R.id.button_equal;
                break;
        }
    }

    private String  algorithm(String a , int symol , String b) {

        switch (symol){

            case R.id.button_except:

                if (Double.parseDouble(b) != 0){
                    return String.valueOf(Double.parseDouble(a) / Double.parseDouble(b));
                }

                break;
            case R.id.button_multiply:

                return String.valueOf(Double.parseDouble(a) * Double.parseDouble(b));

                break;
            case R.id.button_minus:

                return String.valueOf(Double.parseDouble(a) - Double.parseDouble(b));
                break;
            case R.id.button_add:
                return String.valueOf(Double.parseDouble(a) + Double.parseDouble(b));
                break;
            default:

                break;
        }


    }


}
