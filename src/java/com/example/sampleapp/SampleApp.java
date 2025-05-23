/*
 * Copyright 2018 The Bazel Authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.sampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Minimal sample app to demonstrate mobile-install and rule best practices.
 */
public class SampleApp extends Activity {

  @Override
  public void onCreate(Bundle state) {
    super.onCreate(state);

    SampleRecord record = new SampleRecord("name", 1);

    setContentView(R.layout.basic_activity);
    TextView tv = findViewById(R.id.record_text);
    tv.setText(record.toString());
  }

  public native String getString();

  static {
    System.loadLibrary("sample");
  }
}
