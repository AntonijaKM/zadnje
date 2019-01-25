package ba.sum.fpmoz.wineshop;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistracijaAktivnost extends AppCompatActivity {

    EditText email_txt;
    EditText lozinka_txt;
    Button registracija_btn;
    Button login_btn;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija_aktivnost);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() !=null) {
            Intent i = new Intent(RegistracijaAktivnost.this, GlavnaAktivnost.class);
            startActivity(i);
            finish();
        }
        this.email_txt = findViewById(R.id.email_txt);
        this.lozinka_txt = findViewById(R.id.lozinka_txt);
        this.registracija_btn = findViewById(R.id.registracija_btn);
        this.login_btn = findViewById(R.id.login_btn);

        this.login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_txt.getText().toString();
                String lozinka = lozinka_txt.getText().toString();

                if(email.equals("") || lozinka.equals("")){
                    Toast.makeText(getApplicationContext(), "Molimo unesite podatke za prijavu.",Toast.LENGTH_LONG).show();
                    }else {
                    auth.signInWithEmailAndPassword(email,lozinka).addOnCompleteListener(RegistracijaAktivnost.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Uspješna prijava!",Toast.LENGTH_LONG).show();
                                Intent i = new Intent(RegistracijaAktivnost.this, GlavnaAktivnost.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(getApplicationContext(), "Neuspješna prijava!",Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
            }
        });
        registracija_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_txt.getText().toString();
                String lozinka = lozinka_txt.getText().toString();

                auth.createUserWithEmailAndPassword(email, lozinka)
                        .addOnCompleteListener(RegistracijaAktivnost.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(getApplicationContext(), "Uspješno ste registrirani.", Toast.LENGTH_LONG).show();

                            }
                        });
            }
        });
    }
}
