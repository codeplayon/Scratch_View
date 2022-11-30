package com.codeplayon.scratchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ScratchView scratchView;
    Button mask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mask = findViewById(R.id.mask);
        scratchView = findViewById(R.id.scratchView);

        scratchView.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                Toast.makeText(getApplicationContext(), "Reveled", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
                if (percent >= 0.7) {
                    Log.d("Reveal Percentage", "onRevealPercentChangedListener: " + percent);
                }
            }
        });

        mask.setOnClickListener(v -> scratchView.mask());
    }
}