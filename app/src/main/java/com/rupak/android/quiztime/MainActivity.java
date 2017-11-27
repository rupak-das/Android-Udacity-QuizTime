package com.rupak.android.quiztime;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.RestrictTo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

int Score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** Method for calculating score for question 1 */

    private int q1_ans() {
        int Score_1 = 0;

        RadioButton is_a1 = (RadioButton) findViewById(R.id.a1);
        boolean a1_checked = is_a1.isChecked();

        RadioButton is_a2 = (RadioButton) findViewById(R.id.a2);
        boolean a2_checked = is_a2.isChecked();

        RadioButton is_a3 = (RadioButton) findViewById(R.id.a3);
        boolean a3_checked = is_a3.isChecked();

        if (a1_checked) {
            Score_1 = 1;
        }

        if (a2_checked){
            Score_1 = 0;
        }

        if (a3_checked){
            Score_1 = 0;
        }
        return Score_1;
    }

    /** Method for calculating score for question 2 */

    private int q2_ans() {
        int Score_2 = 0;

        RadioButton is_b1 = (RadioButton) findViewById(R.id.b1);
        boolean b1_checked = is_b1.isChecked();

        RadioButton is_b2 = (RadioButton) findViewById(R.id.b2);
        boolean b2_checked = is_b2.isChecked();

        RadioButton is_b3 = (RadioButton) findViewById(R.id.b3);
        boolean b3_checked = is_b3.isChecked();

        if (b1_checked) {
            Score_2 = 1;
        }

        if (b2_checked){
            Score_2 = 0;
        }

        if (b3_checked){
            Score_2 = 0;
        }
        return Score_2;
    }

    /** Method for calculating score for question 3 */

    private int q3_ans() {
        int Score_3 = 0;

        RadioButton is_c1 = (RadioButton) findViewById(R.id.c1);
        boolean c1_checked = is_c1.isChecked();

        RadioButton is_c2 = (RadioButton) findViewById(R.id.c2);
        boolean c2_checked = is_c2.isChecked();

        RadioButton is_c3 = (RadioButton) findViewById(R.id.c3);
        boolean c3_checked = is_c3.isChecked();

        if (c1_checked) {
            Score_3 = 0;
        }

        if (c2_checked){
            Score_3 = 1;
        }

        if (c3_checked){
            Score_3 = 0;
        }
        return Score_3;
    }

    /** Method for calculating score for question 3 */

    private int q4_ans() {
        int Score_4 = 0;

        RadioButton is_d1 = (RadioButton) findViewById(R.id.d1);
        boolean d1_checked = is_d1.isChecked();

        RadioButton is_d2 = (RadioButton) findViewById(R.id.d2);
        boolean d2_checked = is_d2.isChecked();

        RadioButton is_d3 = (RadioButton) findViewById(R.id.d3);
        boolean d3_checked = is_d3.isChecked();

        if (d1_checked) {
            Score_4 = 0;
        }

        if (d2_checked){
            Score_4 = 0;
        }

        if (d3_checked){
            Score_4 = 1;
        }
        return Score_4;
    }

    /** Method for calculating score for question 3 */

    private int q5_ans() {
        int Score_5 = 0;

        RadioButton is_e1 = (RadioButton) findViewById(R.id.e1);
        boolean e1_checked = is_e1.isChecked();

        RadioButton is_e2 = (RadioButton) findViewById(R.id.e2);
        boolean e2_checked = is_e2.isChecked();

        RadioButton is_e3 = (RadioButton) findViewById(R.id.e3);
        boolean e3_checked = is_e3.isChecked();

        if (e1_checked) {
            Score_5 = 1;
        }

        if (e2_checked){
            Score_5 = 0;
        }

        if (e3_checked){
            Score_5 = 0;
        }
        return Score_5;
    }

/** Method for displaying Quiz Score summary on Screen when clicked on Submit Button */

    public void submitOnClick(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        Score = q1_ans() + q2_ans() + q3_ans() + q4_ans() + q5_ans();


        String message = "Name: " + name;
        message += "\nYour Score: " + Score;
        displayScore(message);

    }

    /** Method for displaying Message */

    public void displayScore(String message) {

        TextView scoreSummaryTextView = (TextView) findViewById(R.id.score_details);
        scoreSummaryTextView.setText(message);

    }

/** Method for sending Score via Email */

    public void doneOnClick(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        CheckBox check_box = (CheckBox) findViewById(R.id.chk_box);
        boolean is_checked = check_box.isChecked();

        String doneMessage = "Name: " + name;
        doneMessage += "\nYour Score: " + Score;
        displayScore(doneMessage);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Quiz Score " + name);
        intent.putExtra(Intent.EXTRA_TEXT, doneMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }

    }

    /** Method for reseting the Radio Buttons */

    public void radioReset(){

        RadioGroup radioG1 = (RadioGroup) findViewById(R.id.radio_group_1);
        radioG1.clearCheck();

        RadioGroup radioG2 = (RadioGroup) findViewById(R.id.radio_group_2);
        radioG2.clearCheck();

        RadioGroup radioG3 = (RadioGroup) findViewById(R.id.radio_group_3);
        radioG3.clearCheck();

        RadioGroup radioG4 = (RadioGroup) findViewById(R.id.radio_group_4);
        radioG4.clearCheck();

        RadioGroup radioG5 = (RadioGroup) findViewById(R.id.radio_group_5);
        radioG5.clearCheck();


    }

    /** Method for reset the activity of the app or reset the app */

    public void resetOnClick(View view) {

        Intent intent = getIntent();
        finish();
        startActivity(intent);


    }

}
