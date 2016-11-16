package com.epicodus.bogglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WordListActivity extends AppCompatActivity {
    @Bind(R.id.wordListView) ListView mWordListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        ArrayList<String> allWords = intent.getStringArrayListExtra("words");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,allWords);
        mWordListView.setAdapter(adapter);
    }
}
