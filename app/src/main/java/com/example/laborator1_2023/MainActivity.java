package com.example.laborator1_2023;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private Button button;

    private AppCompatEditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                if(editText.getText() != null) {
                    str = editText.getText().toString();

                    if(str.isEmpty()) {
                        showErrorPopup();
                    } else {
                        textView.setText(getString(R.string.hello_world) + " " + str );
                    }
                }
            }
        });
    }

    private void showErrorPopup() {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(R.string.error_msg)
                .setPositiveButton(android.R.string.yes, dismissPopup())
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    private DialogInterface.OnClickListener dismissPopup() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        };
    }
}
