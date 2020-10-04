package org.gwnu.tutorial.material;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.gwnu.tutorial.R;

import java.util.Objects;

public class MaterialTutorial extends AppCompatActivity {
    private TextInputLayout passwordTextInput;
    private TextInputEditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_tutorial);
        initView();

        textWatcher();
    }

    private void initView() {
        passwordTextInput = findViewById(R.id.password_text_input);
        passwordEditText = findViewById(R.id.password_edit_text);
    }

    private void textWatcher() {
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (Objects.requireNonNull(passwordEditText.getText()).toString().isEmpty()) {
                    passwordTextInput.setError("암호를 입력해주세요.");
                } else {
                    passwordTextInput.setError(null);
                }
            }
        });
    }
}