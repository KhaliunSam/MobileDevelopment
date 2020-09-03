package mum.mdp.dinerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val foods = arrayListOf<String>()
        foods.addAll(listOf("Hamburger", "Pizza", "Mexican", "American", "Chinese"))
        decideBtn.setOnClickListener {
            food.text = "${foods.random()}"

        }
        val food = addFoodBtn.setOnClickListener { v ->
            foods.add("${addFood.text}")
            addFood.text.clear()
        }

    }
}