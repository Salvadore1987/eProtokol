package uz.protokol.asbt.eprotokol.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uz.protokol.asbt.eprotokol.R;
import uz.protokol.asbt.eprotokol.builders.RetfrofitBuilder;
import uz.protokol.asbt.eprotokol.models.Login;
import uz.protokol.asbt.eprotokol.models.LoginResponse;
import uz.protokol.asbt.eprotokol.services.LoginService;

public class LoginActivity extends AppCompatActivity {

    private LoginService loginService;
    private final String TAG = LoginActivity.class.getSimpleName();
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Login login = new Login();
        EditText usernameTxt = findViewById(R.id.jetton_text);
        EditText passwordTxt = findViewById(R.id.password_text);
        Button submitBtn = findViewById(R.id.submitBtn);
        frameLayout = findViewById(R.id.spinnerLayout);

        submitBtn.setOnClickListener((v) -> {
            frameLayout.setVisibility(View.VISIBLE);
            try {
                loginService = RetfrofitBuilder
                        .build(getApplicationContext()).create(LoginService.class);
            } catch (IOException ex) {
                Log.e(TAG, ex.getMessage());
            } catch (NullPointerException ex) {
                Log.e(TAG, ex.getMessage());
            }
            login.setGrantType("password");
            login.setUsername(usernameTxt.getText().toString());
            login.setPassword(passwordTxt.getText().toString());

            loginService.login(login.getGrantType(), login.getUsername(), login.getPassword())
                    .enqueue((new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if (response.isSuccessful()) {
                                Log.i(TAG, response.body().toString());
                                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                                LoginActivity.this.startActivity(mainIntent);
                            } else {
                                Log.e(TAG, response.errorBody().toString());
                                Toast toast = Toast.makeText(getApplicationContext(), R.string.error_login_text_message, Toast.LENGTH_LONG);
                                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 10);
                                toast.show();
                            }
                            frameLayout.setVisibility(View.GONE);
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Log.e(TAG, t.getMessage());
                            frameLayout.setVisibility(View.GONE);
                            Toast toast = Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 10);
                            toast.show();
                        }
                    }));
        });

    }
}
