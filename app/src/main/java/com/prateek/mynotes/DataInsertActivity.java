package com.prateek.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.prateek.mynotes.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {
    ActivityDataInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String type = getIntent().getStringExtra("type");
        if(type.equals("update")){
            setTitle("Update Note");
            binding.etTitle.setText(getIntent().getStringExtra("title"));
            binding.etDescription.setText(getIntent().getStringExtra("description"));
            int id=getIntent().getIntExtra("id",0);
            binding.btAdd.setText("Update Note");
            binding.btAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.etTitle.getText().toString() != null){
                        if(!binding.etTitle.getText().toString().isEmpty()){
                            Intent intent = new Intent();
                            intent.putExtra("title",binding.etTitle.getText().toString());
                            intent.putExtra("description",binding.etDescription.getText().toString());
                            intent.putExtra("id",id);
                            setResult(RESULT_OK,intent);
                            finish();
                        }else {
                            Toast.makeText(DataInsertActivity.this, "Please insert title", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            });
        }else {
            setTitle("Add Note");
            binding.btAdd.setText("Add Note");
            binding.btAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.etTitle.getText().toString() != null){
                        if(!binding.etTitle.getText().toString().isEmpty()){
                            Intent intent = new Intent();
                            intent.putExtra("title",binding.etTitle.getText().toString());
                            intent.putExtra("description",binding.etDescription.getText().toString());
                            setResult(RESULT_OK,intent);
                            finish();
                        }else {
                            Toast.makeText(DataInsertActivity.this, "Please insert title", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataInsertActivity.this,MainActivity.class));
    }
}