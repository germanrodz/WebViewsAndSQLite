package com.blovvme.webviewsandsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    EditText etName;
    EditText etNumber;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        //instance
        WebViewClient webViewClient = new WebViewClient();
        //create new client
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //add client to the web view
        webView.setWebViewClient(webViewClient);
        //load url
        //need dto go to te manifest and add permision
        webView.loadUrl("https://developer.android.com");

        etName=(EditText)findViewById(R.id.etName);
        etNumber =(EditText)findViewById(R.id.etNumber);
        //call from database
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.saveNewContact("John", "223344");
        databaseHelper.getContacts();;

    }

    public void saveContact(View view){
        MyContact contact = new MyContact(etName.getText().toString(),etNumber,getText().toString());

    }
}
