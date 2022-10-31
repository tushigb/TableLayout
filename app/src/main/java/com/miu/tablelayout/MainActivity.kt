package com.miu.tablelayout

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener {

            if (version.text.isEmpty() || name.text.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Version & code name cannot be blank!",
                    Toast.LENGTH_LONG
                )
                    .show()
            } else {
                val tableRow = TableRow(applicationContext)
                val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
                tableRow.layoutParams = layoutParams

                val col1 = TextView(this)
                col1.text = version.text.toString()
                col1.setPadding(10)
                println(ContextCompat.getColor(applicationContext, R.color.cyan))
                col1.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.cyan))

                val col2 = TextView(this)
                col2.text = name.text.toString()
                col2.setPadding(10)
                col2.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.cyan))

                tableRow.addView(col1)
                tableRow.addView(col2)
                tableRow.setPadding(0, 0, 0, 10)

                table.addView(tableRow)

                version.text.clear()
                name.text.clear()

                Toast.makeText(
                    applicationContext,
                    "New Android version added into table view",
                    Toast.LENGTH_LONG
                ).show()
            }

        }
    }
}