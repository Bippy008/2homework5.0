package kg.geektech.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout loginLL;
    LinearLayout forgotPasswordLL;
    Button loginBtn;
    TextView gmailTv;
    TextView passwordTv;
    TextView upTextTv;
    TextView vhodTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = findViewById(R.id.btnLogin);
        gmailTv = findViewById(R.id.gmail_tv);
        passwordTv = findViewById(R.id.password_tv);
        loginLL = findViewById(R.id.login_ll);
        forgotPasswordLL = findViewById(R.id.forgotPassword_ll);
        upTextTv = findViewById(R.id.upText_tv);
        vhodTv = findViewById(R.id.vhod_tv);

        gmailTv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (gmailTv.getText().toString().length() > 0) {
                    loginBtn.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    loginBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gmailTv.getText().toString().equals("admin") && passwordTv.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    upTextTv.setVisibility(View.GONE);
                    loginBtn.setVisibility(View.GONE);
                    loginLL.setVisibility(View.GONE);
                    forgotPasswordLL.setVisibility(View.GONE);
                    vhodTv.setVisibility(View.GONE);
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}