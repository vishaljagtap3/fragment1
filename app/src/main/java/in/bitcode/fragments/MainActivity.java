package in.bitcode.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtCount;
    private Button mBtnResetCount;
    private FragmentManager mFragmentManager;
    private CounterFragment mCounterFragment1, mCounterFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        mEdtCount = findViewById(R.id.edtCount);
        mBtnResetCount = findViewById(R.id.btnResetCount);

        mFragmentManager = getSupportFragmentManager();
        mCounterFragment1 = (CounterFragment) mFragmentManager.findFragmentById(R.id.counterFragment1);
        mCounterFragment2 = (CounterFragment) mFragmentManager.findFragmentById(R.id.counterFragment2);

        mBtnResetCount.setOnClickListener(new BtnResetCountClickListener());
    }

    private class BtnResetCountClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int newCount = Integer.parseInt( mEdtCount.getText().toString() );
            mCounterFragment1.reset(newCount);
            mCounterFragment2.reset(newCount);

        }
    }
}