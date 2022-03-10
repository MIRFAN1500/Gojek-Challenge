package com.binar.gojekchallenge.utility

import android.content.Context
import android.widget.Toast

fun Context.toast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, text, duration).show()