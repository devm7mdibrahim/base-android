package com.devm7mdibrahim.utils.spinner

import android.content.Context
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

fun AutoCompleteTextView.init(
    context: Context,
    list: List<String>,
    onItemSelected: (Int) -> Unit
) {
    val arrayAdapter =
        ArrayAdapter(context, android.R.layout.simple_list_item_1, list)
    setAdapter(arrayAdapter)
    onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
        onItemSelected(position)
    }
}