package com.epicodus.bogglish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private char[] allLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    private ArrayList<Character> boggleLetters = new ArrayList<Character>();
    private ArrayList<String> boggleWords = new ArrayList<String>();
    @Bind(R.id.boggleLettersTextView) TextView mBoggleLetterTextView;
    @Bind(R.id.allWordsButton) Button mAllWordsButton;
    @Bind(R.id.addWordButton) Button mAddWordButton;
    @Bind(R.id.inputEditText) EditText mInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Random rand = new Random();
        for(int i=0; i<8; i++) {
            if (i<2) {
                int randomNumber = rand.nextInt(vowels.length);
                boggleLetters.add(vowels[randomNumber]);
            }else{
                int randomNumber = rand.nextInt(allLetters.length);
                boggleLetters.add(allLetters[randomNumber]);
            }
        }
        Collections.shuffle(boggleLetters);
        String boggleString = boggleLetters.toString();
        mBoggleLetterTextView.setText(boggleString);

        mAllWordsButton.setOnClickListener(this);
        mAddWordButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mAllWordsButton) {
            Intent intent = new Intent(MainActivity.this, WordListActivity.class);
            intent.putExtra("words", boggleWords);
            startActivity(intent);
        }
        if(v == mAddWordButton){
            String wordToAdd = mInputEditText.getText().toString();
            if(wordToAdd.length()<3){
                Toast.makeText(MainActivity.this,"Must be at least 3 letters",Toast.LENGTH_SHORT).show();
            } else if(boggleWords.contains(wordToAdd)) {
                Toast.makeText(MainActivity.this, "You already used that word!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Yeah!", Toast.LENGTH_SHORT).show();
                boggleWords.add(wordToAdd);
            }







            //if doesnt contain all  letters toast
                //check for repeated letters










            mInputEditText.setText("");
        }
    }

}

