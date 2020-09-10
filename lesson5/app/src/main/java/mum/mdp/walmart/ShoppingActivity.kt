package mum.mdp.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    private lateinit var user: User
    var categoryList = ArrayList<Category>()
    //var productList = ArrayList<Product>()
    var images = intArrayOf(R.drawable.electronics, R.drawable.clothing, R.drawable.beauty, R.drawable.food)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        user = getIntent().getSerializableExtra("currentUser") as User
        welcomeText.text = "Welcome ${user.email}"

        initCategories()
        categoryGridView.adapter = CategoryAdapter(this, categoryList, user)
    }

   fun initCategories(){
        val electronics = Category("Electronics", "Electronic devices",R.drawable.electronics)
        val clothing = Category("Clothing","Clothes", R.drawable.clothing)
        val beauty = Category("Beauty","Beauty products", R.drawable.beauty)
        val food = Category("Food","Foods", R.drawable.food)

        categoryList = arrayListOf(electronics, clothing, beauty, food)
    }

//    fun onClickCategory(view: View) {
//
//        Toast.makeText(this, "This is an electronic category.", Toast.LENGTH_LONG).show()
//        var intent = Intent(this, CardViewMainActivity::class.java)
//        //var s = productList.stream().filter { t: Product -> t.catid.toString() == "1" }.toArray()
//        intent.putExtra("productList", productList )
//        startActivity(intent)
//    }
}