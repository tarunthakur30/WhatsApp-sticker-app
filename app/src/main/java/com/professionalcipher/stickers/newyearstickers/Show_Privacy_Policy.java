package com.professionalcipher.stickers.newyearstickers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Show_Privacy_Policy extends AppCompatActivity {
private TextView textView;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_privacy_policy);
        textView = findViewById(R.id.show_privacy_policy_textView);
        textView.setText(Html.fromHtml(Privacy_PolicyText()));

    }
    private String Privacy_PolicyText(){
        String text = getString(R.string.publisher_Name) +" built the "+
                "<b>" +getString(R.string.app_name) + "</b>"+
                " app as a Free app. This SERVICE is provided by " + getString(R.string.publisher_Name)+" at no cost and is intended for use as is.<br>" +
                "<br>" +
                "This page is used to inform visitors regarding our policies with the collection, use, and disclosure of Personal Information if anyone decided to use our Service. <br>" +
                "<br>" +
                "If you choose to use our Service, then you agree to the collection and use of information in relation to this policy. " +
                "The Personal Information that we collect is used for providing and improving the Service. We will not use or share your " +
                "information with anyone except as described in this Privacy Policy. <br>" +
                "<br>" +
                "The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which is accessible at " +
                "<b>" +getString(R.string.app_name) +"</b>" + " unless otherwise defined in this policy." +
                "<br><br>" +
                "<b>Contact Us </b><br>" +
                "<br>" +
                "If you have any questions or suggestions about our Privacy Policy, do not hesitate to contact us at <i><b>professionalcipher@gmail.com</b></i>. <br>";

        return text;
    }
}