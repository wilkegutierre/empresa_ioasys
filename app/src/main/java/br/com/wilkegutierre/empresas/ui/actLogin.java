package br.com.wilkegutierre.empresas.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.com.wilkegutierre.empresas.R;
import br.com.wilkegutierre.empresas.model.LoginModel;
import br.com.wilkegutierre.empresas.model.LoginResultModel;
import br.com.wilkegutierre.empresas.presenter.Login;
import br.com.wilkegutierre.empresas.presenter.LoginPresenter;

public class actLogin
        extends AppCompatActivity
        implements Login.LoginView {

    private EditText edtEmail, edtPassword;
    private Button btnSignin;
    private TextView tvErrorValidateLogin;
    private FrameLayout progressLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);

        progressLogin = findViewById(R.id.progressLogin);
        edtEmail = findViewById(R.id.edtEmailLogin);
        edtEmail.addTextChangedListener(validateEmail);
        tvErrorValidateLogin = findViewById(R.id.tvErrorValidateLogin);
        tvErrorValidateLogin.setVisibility(View.GONE);

        edtPassword = findViewById(R.id.edtPassword);

        btnSignin = findViewById(R.id.btnSignin);
        btnSignin.setOnClickListener(checkLogin);
    }

    private TextWatcher validateEmail = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable edit) {
            if (Patterns.EMAIL_ADDRESS.matcher(edit).matches()) {
                tvErrorValidateLogin.setVisibility(View.GONE);
            } else {
                tvErrorValidateLogin.setVisibility(View.VISIBLE);
            }
        }
    };

    private View.OnClickListener checkLogin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            progressBarConnection();
            login();
        }
    };

    private void login() {
        LoginModel loginRequest = new LoginModel();
        loginRequest.setEmail(edtEmail.getText().toString());
        loginRequest.setPassword(edtPassword.getText().toString());

        Login.LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.setView(this);
        loginPresenter.login(loginRequest);

    }

    private void progressBarConnection() {
        if (progressLogin.getVisibility() == View.VISIBLE) {
            progressLogin.setVisibility(View.GONE);
        } else {
            progressLogin.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void paramsUserLogin(LoginResultModel loginResultModel) {
        loginPreferences(loginResultModel);
        signin();
    }

    private void signin() {
        Intent intent = new Intent(this, actSearchResult.class);
        startActivity(intent);
    }

    private void loginPreferences(LoginResultModel loginResultModel) {
        SharedPreferences preferences = getSharedPreferences("login_user", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token", loginResultModel.getToken());
        editor.putString("uid", loginResultModel.getUid());
        editor.putString("client", loginResultModel.getClient());
        editor.commit();
    }

    @Override
    public void showError() {
        Toast.makeText(
                this,
                "Login Failed!",
                Toast.LENGTH_SHORT).show();

    }
}