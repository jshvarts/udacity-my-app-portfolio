package com.jshvarts.udacity.udacityportfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AppPortfolioActivity extends AppCompatActivity {

    private Toast appToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_portfolio_activity);

        LinearLayout buttonsLayout = (LinearLayout) findViewById(R.id.app_porfolio_linear_layout);
        for(int i=0; i < buttonsLayout.getChildCount(); i++) {
            View view = buttonsLayout.getChildAt(i);
            if (view instanceof Button) {
                setupButton((Button) view);
            }
        }
    }

    /**
     * Validates button text availability and adds OnClickListener for each button
     *
     * @param button
     */
    private void setupButton(final Button button) {
        String buttonText = button.getText().toString();
        if (TextUtils.isEmpty(buttonText)) {
            Log.e(getClass().getSimpleName(), "empty button text!");
            return;
        }
        final String msg = buildMsg(buttonText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (appToast != null) {
                    appToast.cancel();
                }
                appToast = Toast.makeText(AppPortfolioActivity.this, msg, Toast.LENGTH_SHORT);
                appToast.show();
            }
        });
    }

    /**
     * Builds message based on button text
     *
     * @param buttonText
     * @return
     */
    private String buildMsg(String buttonText) {
        StringBuilder msg = new StringBuilder();
        msg.append("This button will launch ");
        msg.append(buttonText);
        msg.append(buttonText.endsWith("App") ? "!" : " App!");
        return msg.toString();
    }
}
