package com.maktab.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static EditText mEditText;
    private String savedText;
    private static final String SAVED_TEXT_KEY = "some_key";


    Button[] btn = new Button[10];
    String temp1, editTextValue;
    TextView edt1;
    int temp = 0;
    Button btn_add, btn_mul, btn_div, btn_min, btn_equal, btn_del, btn_dot;
    private static final String BUNDLE_KEY_NUM_ONE = "NumberOne";
    private static final String BUNDLE_KEY_NUM_TWO = "NumberTwo";
    private static final String BUNDLE_KEY_OPERATION1 = "OPERATION1";
    private static final String BUNDLE_KEY_OPERATION2 = "OPERATION2";
    private static final String BUNDLE_KEY_OPERATION3 = "OPERATION3";
    private static final String BUNDLE_KEY_OPERATION4 = "OPERATION4";


    float mValueOne = 0, mValueTwo = 0;

    boolean mAddition = false, mSubtract = false, mMultiplication = false, mDivision = false;


    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        outState.putFloat(BUNDLE_KEY_NUM_ONE, mValueOne);
        outState.putFloat(BUNDLE_KEY_NUM_TWO, mValueTwo);
        outState.putBoolean(BUNDLE_KEY_OPERATION1, mDivision);
        outState.putBoolean(BUNDLE_KEY_OPERATION2, mMultiplication);
        outState.putBoolean(BUNDLE_KEY_OPERATION3, mAddition);
        outState.putBoolean(BUNDLE_KEY_OPERATION4, mSubtract);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            Log.d("TESTTEST", "AFTER");
            mValueOne = savedInstanceState.getFloat(BUNDLE_KEY_NUM_ONE);
            mValueTwo = savedInstanceState.getFloat(BUNDLE_KEY_NUM_TWO);
            mDivision = savedInstanceState.getBoolean(BUNDLE_KEY_OPERATION1);
            mMultiplication = savedInstanceState.getBoolean(BUNDLE_KEY_OPERATION2);
            mAddition = savedInstanceState.getBoolean(BUNDLE_KEY_OPERATION3);
            mSubtract = savedInstanceState.getBoolean(BUNDLE_KEY_OPERATION4);
        }
        findview();
        click();
    }


    private void findview() {
        int i = 0;
        String b;
        Resources res = getResources();
        for (i = 0; i <= 9; i++) {
            b = "btn" + i;
            btn[i] = (Button) findViewById(res.getIdentifier(b, "id", getPackageName()));
        }
        edt1 = findViewById(R.id.edt1);
        btn_add = findViewById(R.id.btn_plus);
        btn_div = findViewById(R.id.btn_div);
        btn_min = findViewById(R.id.btn_min);
        btn_mul = findViewById(R.id.btn_mul);
        btn_equal = findViewById(R.id.btn_equal);
        btn_del = findViewById(R.id.btn_delete);
        btn_dot = findViewById(R.id.btn_dot);
    }


    public void click() {

        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(edt1.getText() + "0");

            }
        });


        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(edt1.getText() + "1");

            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(edt1.getText() + "2");
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(edt1.getText() + "3");
            }
        });

        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(edt1.getText() + "4");


            }
        });

        btn[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(edt1.getText() + "5");
            }
        });

        btn[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(edt1.getText() + "6");
            }
        });

        btn[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(edt1.getText() + "7");
            }
        });

        btn[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(edt1.getText() + "8");
            }
        });

        btn[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(edt1.getText() + "9");
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edt1 == null) {
                    edt1.setText("");
                } else {
                    mValueOne = Float.parseFloat(edt1.getText() + "");
                    mAddition = true;
                    edt1.setText(null);
                }

            }
        });

        btn_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mValueOne = Float.parseFloat(edt1.getText() + "");
                mSubtract = true;
                edt1.setText(null);

            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mValueOne = Float.parseFloat(edt1.getText() + "");
                mMultiplication = true;
                edt1.setText(null);

            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mValueOne = Float.parseFloat(edt1.getText() + "");
                mDivision = true;
                edt1.setText(null);
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mValueTwo = Float.parseFloat(edt1.getText() + "");

                if (mAddition == true) {
                    edt1.setText(mValueOne + mValueTwo + "");
                    mAddition = false;
                }

                if (mSubtract == true) {
                    edt1.setText(mValueOne - mValueTwo + "");
                    mSubtract = false;
                }

                if (mMultiplication == true) {
                    edt1.setText(mValueOne * mValueTwo + "");
                    mMultiplication = false;
                }

                if (mDivision == true) {
                    if (mValueTwo != 0)
                        edt1.setText(mValueOne / mValueTwo + "");
                    else
                        edt1.setText("Error.Div By Zero");

                    mDivision = false;
                }

            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText("");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText(edt1.getText() + ".");

            }
        });


    }


}