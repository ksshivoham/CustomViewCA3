package scholarship.upgrad.com.shivamcustom;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
CheckBox cbFever,cbCough,cbBreathing;
RadioGroup rg;
RadioButton rbYes,rbNo;
Button btCalculate,btRefresh;
LinearLayout llChange;
TextView tvPercentage;
Animation a;
int percentage=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbFever=findViewById(R.id.cbFever);
        cbCough=findViewById(R.id.cbCough);
        a= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anti);
        btRefresh=findViewById(R.id.btRefresh);
        btRefresh.setEnabled(false);
        cbBreathing=findViewById(R.id.cbBreathing);
        tvPercentage=findViewById(R.id.tvPercentage);
        rg=findViewById(R.id.rg);
        rbYes=findViewById(R.id.rbYes);
        llChange=findViewById(R.id.llChange);
        rbNo=findViewById(R.id.rbNo);
        btCalculate=findViewById(R.id.btCalculate);
        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

btCalculate.startAnimation(a);

                if(cbFever.isChecked())
                {
                    percentage+=20;
                }
                if(cbCough.isChecked())
                {
                    percentage+=20;
                }
                if(cbBreathing.isChecked())
                {
                    percentage+=20;
                }
                if (rbYes.isChecked())
                {
                    percentage+=35;
                }

                if(percentage>90)
                {

                    llChange.setBackgroundColor(Color.RED);
                    tvPercentage.setText(percentage+"%");

                }
                else
                if (percentage>=40)
                {

                    llChange.setBackgroundColor(Color.YELLOW);
                    tvPercentage.setText(percentage+"%");


                }
                else
                if (percentage<40)
                {

                    llChange.setBackgroundColor(Color.GREEN);
                    tvPercentage.setText(percentage+"%");


                }

                btCalculate.setEnabled(false);
                btCalculate.setVisibility(View.INVISIBLE);
                btRefresh.setEnabled(true);
                btRefresh.setVisibility(View.VISIBLE);

            }
        });
        btRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                startActivity(getIntent());
            }
        });
    }
}
