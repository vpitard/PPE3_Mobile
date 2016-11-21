package com.example.vpitard.ppe3_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //* test push mael*//
        Button btnConnexion = (Button) findViewById(R.id.btnConnexion);
        btnConnexion.setOnClickListener(observateurclic);
    }

    public View.OnClickListener observateurclic = new View.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnConnexion:
                    String Login = String.valueOf(((EditText) findViewById(R.id.LoginTxt)).getText());
                    String Pwd = String.valueOf(((EditText) findViewById(R.id.PwdTxt)).getText());
                    Connexion cnx = new Connexion();



            }

        }
    }
}
