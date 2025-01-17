package com.example.week1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.view.Window;
import android.view.WindowManager;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private CircleImageView profileImage;
    private TextView studentName, studentId, resultText;
    private EditText editTextInput;
    private Button btnReverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileImage = findViewById(R.id.profile_image);
        studentName = findViewById(R.id.student_name);
        studentId = findViewById(R.id.student_id);
        editTextInput = findViewById(R.id.editTextInput);
        btnReverse = findViewById(R.id.btnReverse);
        resultText = findViewById(R.id.resultText);

        profileImage.setImageResource(R.drawable.user);
        studentName.setText("Phun Gia Long");
        studentId.setText("MSSV: 22110367");

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        StringBuilder oddNumbers = new StringBuilder();
        StringBuilder evenNumbers = new StringBuilder();

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.append(number).append(" ");
            } else {
                oddNumbers.append(number).append(" ");
            }
        }

        Log.d(TAG, "Số chẵn: " + evenNumbers.toString());
        Log.d(TAG, "Số lẻ: " + oddNumbers.toString());

        btnReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTextInput.getText().toString();

                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập chuỗi", Toast.LENGTH_SHORT).show();
                } else {
                    String[] words = inputText.trim().split("\\s+");

                    StringBuilder reversedText = new StringBuilder();
                    for (int i = words.length - 1; i >= 0; i--) {
                        reversedText.append(words[i]).append(" ");
                    }

                    String result = reversedText.toString().trim().toUpperCase();

                    resultText.setText(result);
                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}