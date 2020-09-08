package mum.mdp.tablayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.addButton)
        btnAdd.setOnClickListener {
            Toast.makeText(this, "Add Button Pressed", Toast.LENGTH_LONG).show()
            var version: String? = version.text.toString()
            var codeName: String? = codeName.text.toString()

            val layout = findViewById<TableLayout>(R.id.table)
            val tableRow = TableRow(getApplicationContext())
            tableRow.setPadding(5, 5, 5, 5)
            tableRow.setBackgroundColor(Color.rgb(233, 30,99))

            val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
            tableRow.setLayoutParams(layoutParams)

            val textVersion = TextView(this)
            textVersion.setText(version)
            tableRow.addView(textVersion, 0)

            val textCodeName = TextView(this)
            textCodeName.setText(codeName)
            tableRow.addView(textCodeName, 1)

            table.addView(tableRow)

            this.version.text.clear()
            this.codeName.text.clear()
        }
    }
}