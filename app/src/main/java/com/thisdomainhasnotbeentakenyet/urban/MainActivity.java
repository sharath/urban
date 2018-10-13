package com.thisdomainhasnotbeentakenyet.urban;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.tv_hw);

        Button button = findViewById(R.id.b_ct);
        // button.setOnClickListener(this);     Goes to onClick method
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isPressed()) {
                    textView.setText(R.string.gw);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.b_ct){
            // TextView has to be global to interact here.
        }
    }
}
