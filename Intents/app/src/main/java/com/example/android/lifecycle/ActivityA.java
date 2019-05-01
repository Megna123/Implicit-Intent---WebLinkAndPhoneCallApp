/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.lifecycle.util.StatusTracker;
import com.example.android.lifecycle.util.Utils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;

/**
 * Example Activity to demonstrate the lifecycle callback methods.
 */
public class ActivityA extends Activity {

    private String mActivityName;
    private TextView mCounterView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mActivityName = getString(R.string.activity_a);
        Button runWebsite = (Button) findViewById(R.id.btn_start_dialog);
        runWebsite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText website = (EditText) findViewById(R.id.editurl);
                String strURL = website.getText().toString();
                if (strURL.indexOf("http://www") < 0) {
                    strURL = "http://www." + strURL;
                }
                Intent implicit = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(strURL));
                startActivity(implicit);
            }
        });
        Button dialPhNumber = (Button) findViewById(R.id.callbtn);
        dialPhNumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText phNumber = (EditText) findViewById(R.id.callurl);
                Intent implicit = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:"+phNumber.getText().toString()));
                startActivity(implicit);
            }
        });
    }

    public void finishActivityA(View v) {
        ActivityA.this.finish();
    }

}
