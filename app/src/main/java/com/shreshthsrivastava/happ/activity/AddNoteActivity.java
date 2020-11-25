package com.shreshthsrivastava.happ.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.shreshthsrivastava.happ.R;
import com.shreshthsrivastava.happ.database.model.Note;
import com.shreshthsrivastava.happ.dialog.MoodBottomSheetDialog;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNoteActivity extends AppCompatActivity implements MoodBottomSheetDialog.MoodItemClickListener{

    private EditText titleEditText;
    private EditText descriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        titleEditText=findViewById(R.id.title_edit_text);
        descriptionEditText=findViewById(R.id.description_edit_text);
        getSupportActionBar().setTitle("Add Note");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.save,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.home:
            {
                finish();
                return true;
            }
            case R.id.note_save_btn: {
                saveNote();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        MoodBottomSheetDialog moodBottomSheetDialog=new MoodBottomSheetDialog((MoodBottomSheetDialog.MoodItemClickListener) this);
        moodBottomSheetDialog.show(getSupportFragmentManager(),"MoodBottomSheet");
    }

    @Override
    public void moodClickListener(int rating) {
        Intent data=new Intent();
        String titleText=titleEditText.getText().toString();
        String descrptionText=descriptionEditText.getText().toString();
        data.putExtra("Note Object",new Note(titleText,descrptionText,rating,new SimpleDateFormat("dd-MM-yyyy").format(new Date())));
        setResult(RESULT_OK,data);
        finish();
//        Toast.makeText(this, ""+rating, Toast.LENGTH_SHORT).show();
    }
}