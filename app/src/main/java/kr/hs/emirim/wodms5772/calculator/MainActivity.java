package kr.hs.emirim.wodms5772.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button butPlus, butMinus, butDivide, butMultiply;
    EditText editNum1, editNum2;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//얘이름만나면 애들부름
        butPlus=(Button)findViewById(R.id.but_plus);//뷰를 반환한다. -> 형변환 <뷰가 최상위클래스>
        butMinus=(Button)findViewById(R.id.but_minus);
        butDivide=(Button)findViewById(R.id.but_divide);
        butMultiply=(Button)findViewById(R.id.but_multiply);
        editNum1=(EditText)findViewById(R.id.edit_num1);
        editNum2=(EditText)findViewById(R.id.edit_num2);
        textResult=(TextView)findViewById(R.id.text_result);
        butPlus.setOnClickListener(this);//리스너 설정 ->온클릭 호출
        butMinus.setOnClickListener(this);
        butDivide.setOnClickListener(this);
        butMultiply.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {//이벤트가 발생된거 v가 갖고있음
//        2개의 EditText에 입력된 값을 반환받는다.
        String num1Str=editNum1.getText().toString();//toString or String 강제형변환
        String num2Str=editNum2.getText().toString();
        int num1=Integer.parseInt(num1Str);
        int num2=Integer.parseInt(num2Str);
        double result=0;

        switch(v.getId()){ //객체가 갖고있는 id값
            case R.id.but_plus:
                result=num1+num2;
                break;

            case R.id.but_minus:
                result=num1-num2;
                break;
            case R.id.but_divide:
                result=(double)num1/num2; //몫만 반환이 된다 ->둘중하나 실수값으로 형변환해야 더 정확
                break;
            case R.id.but_multiply:
                result=num1*num2;
                break;
        }
        textResult.setText("* 계산 결과: "+result);
    }
}
