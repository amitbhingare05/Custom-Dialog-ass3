package com.example.customdialogass3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textviewresult;
    private Button btnEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textviewresult = findViewById(R.id.txt_textviewresult);
        btnEditor = findViewById(R.id.btn_customDialog);

        btnEditor.setOnClickListener(new BtnCustomDialogClickListener());
    }
    private class BtnCustomDialogClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Dialog customdialogeditor = new Dialog(MainActivity.this);
            customdialogeditor.setContentView(R.layout.customdialogeditor);

            EditText editText = customdialogeditor.findViewById(R.id.editText);
            Button btn_uppercase = customdialogeditor.findViewById(R.id.btn_uppercase);
            Button btn_lowercase = customdialogeditor.findViewById(R.id.btn_lowercase);
            Button btn_init = customdialogeditor.findViewById(R.id.btn_init);
            Button btn_reverse= customdialogeditor.findViewById(R.id.btn_reverse);
            Button btn_ok = customdialogeditor.findViewById(R.id.btn_ok);

            btn_uppercase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText editText  = customdialogeditor.findViewById(R.id.editText);
                    String inputText = editText.getText().toString();
                    String uppercaseText = inputText.toUpperCase();
                    editText.setText(uppercaseText);
                }
            });

            btn_lowercase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText editText  = customdialogeditor.findViewById(R.id.editText);
                    String inputText = editText.getText().toString();
                    String lowerText = inputText.toLowerCase();
                    editText.setText(lowerText);
                }
            });

            btn_init.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText editText  = customdialogeditor.findViewById(R.id.editText);
                    String inputText = editText.getText().toString();
                    String initText = inputText.substring(0, 1).toUpperCase() + inputText.substring(1).toLowerCase();
                    editText.setText(initText);
                }
            });

            btn_reverse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText editText  = customdialogeditor.findViewById(R.id.editText);
                    String inputText = editText.getText().toString();
                    String reversedText = new StringBuilder(inputText).reverse().toString();
                    editText.setText(reversedText);
                }
            });

            btn_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText editText = customdialogeditor.findViewById(R.id.editText);
                    String updatedText = editText.getText().toString();
                    textviewresult.setText(updatedText);
                    customdialogeditor.dismiss();
                }
            });

            customdialogeditor.show();
        }
    }
}


