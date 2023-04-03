package wlai.etiquettesplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        TextView username = (TextView) findViewById(R.id.usernameEText);
        TextView password = (TextView) findViewById(R.id.passwordEtext);

        MaterialButton loginButton = (MaterialButton) findViewById(R.id.loginbutton);

        //admin and admin
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("test") && password.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_LONG).show();
                    Intent intent =  new Intent(MainActivity.this, MainPage.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_LONG).show();
            }
        });


        //setContentView(R.layout.authentification_page);


    }
    public void confirmChoices(){
        Toast.makeText(this, "Your item selection has been confirmed", Toast.LENGTH_LONG).show();
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

}