package ba.sum.fpmoz.wineshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class GlavnaAktivnost extends AppCompatActivity {

    EditText email_korisnik_txt;
    EditText lozinka_korisnik_txt;
    Button registracija_btn;
    Button login_btn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavna_aktivnost);


    auth = FirebaseAuth.getInstance();

        this.email_korisnik_txt = findViewById(R.id.email_txt);
        this.lozinka_korisnik_txt = findViewById(R.id.lozinka_txt);
        email_korisnik_txt.setError("You need to enter a name");

        this.registracija_btn = findViewById(R.id.registracija_btn);
        this.login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email= email_korisnik_txt.getText().toString();
            String lozinka= lozinka_korisnik_txt.getText().toString();

            if (email.equals("") || lozinka.equals("")) {
                Toast.makeText(GlavnaAktivnost.this, "Molimo popnuite sva polja!", Toast.LENGTH_SHORT).show();
            }
            else {
                auth.signInWithEmailAndPassword(email, lozinka).addOnCompleteListener(GlavnaAktivnost.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Uspješna prijava", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(GlavnaAktivnost.this, ListaVinaAktivnost.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Neuspješna prijava", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }});


        registracija_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String email= email_korisnik_txt.getText().toString();
            String lozinka= lozinka_korisnik_txt.getText().toString();

            if (email.equals("") || lozinka.equals("")){
                Toast.makeText(GlavnaAktivnost.this, "Molimo popnuite sva polja!", Toast.LENGTH_SHORT).show();
            }
            else {
                auth.createUserWithEmailAndPassword(email,lozinka).addOnCompleteListener(GlavnaAktivnost.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(GlavnaAktivnost.this, "Uspješno ste registrirani", Toast.LENGTH_SHORT).show();
                        email_korisnik_txt.setText("");
                        lozinka_korisnik_txt.setText("");
                    }
                });}

        }

    });
}
}
