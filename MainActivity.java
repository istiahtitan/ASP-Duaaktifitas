package com.arruya.choco.duaaktivitas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE="pesan";
    EditText mpesan;
    TextView mpesankembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpesan = findViewById(R.id.pesan);
        mpesankembali = findViewById(R.id.terima_pesan_kembali);
        Intent intent = getIntent();
        mpesankembali.setText(intent.getStringExtra(Main2Activity.EXTRA_MESSAGE));
        Log.d("LOG_TAG", "onCreate");
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if (isVisible){
                mpesankembali.setText(savedInstanceState.getString("reply_text"));
                mpesankembali.setVisibility(View.VISIBLE);
            }
        }
    }

    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        if (mpesankembali.getVisibility() == View.VISIBLE){
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", mpesankembali.getText().toString());
        }

    }

    public MainActivity() {
        super();
    }

    public void kirim(View view) {
        Intent intent=new Intent(this,Main2Activity.class);
        intent.putExtra(EXTRA_MESSAGE,mpesan.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LOG_TAG", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LOG_TAG", "on Restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LOG_TAG", "on Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LOG_TAG", "on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LOG_TAG", "on Destroy");
    }

}
