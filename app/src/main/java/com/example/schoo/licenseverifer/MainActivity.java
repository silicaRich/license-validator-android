package com.example.schoo.licenseverifer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "NfcDemo";

    //    private TextView mTextView;
    private Button signupButton;
    private NfcAdapter mNfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //etSupportActionBar(toolbar);



        //mTextView = (TextView) findViewById(R.id.first_name_label);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        //   mTextView.setText("NFC is disabled.");

        if (mNfcAdapter == null) {
            // Stop here, we definitely need NFC
            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
            finish();
            return;

        }

        if (!mNfcAdapter.isEnabled()) {
            //      mTextView.setText("NFC is disabled.");
        } else {
            //    mTextView.setText(R.string.explanation);
            //mTextView.setText("NFC is enabled");
        }

        handleIntent(getIntent());
        initFields();

        signupButton = (Button) findViewById(R.id.signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initFields();
            }
        });
    }

    private void handleIntent(Intent intent) {
        // TODO: handle Intent
    }

    // Initialize fields for License
    private void initFields() {

        EditText firstName = (EditText) findViewById(R.id.first_name_text);
        EditText lastName = (EditText) findViewById(R.id.first_name_text);
        EditText dob = (EditText) findViewById(R.id.date_of_birth_text);
        EditText address = (EditText) findViewById(R.id.first_name_text);
    //    EditText city = (EditText) findViewById(R.id.city_text);
        EditText state = (EditText) findViewById(R.id.state_text);
        EditText zipcode = (EditText) findViewById(R.id.zip_text);
        EditText licenseNumber = (EditText) findViewById(R.id.license_number_text);
        String endpoint = "?dl_sn=" + licenseNumber + "&fullname=" + firstName + lastName
                + "&street1=" + "&zip=" + zipcode + "&dob=" + dob;
        enrollment(endpoint);
    }

    // Api Calls
    private void enrollment(String endpoint){

        String request = "http://54.174.128.27:8123" + endpoint;

        StringRequest myReq = new StringRequest(Method.POST,
                "http://ave.bolyartech.com/params.php",
                createMyReqSuccessListener(),
                createMyReqErrorListener()) {

            protected Map<string, string=""> getParams() throws com.android.volley.AuthFailureError {
                Map<string, string=""> params = new HashMap<string, string="">();
                params.put("param1", num1);
                params.put("param2", num2);
                return params;
            };
        };
        queue.add(myReq);




    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
