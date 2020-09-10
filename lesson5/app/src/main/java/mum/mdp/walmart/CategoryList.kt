package mum.mdp.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_category_list.*
import kotlinx.android.synthetic.main.activity_category_list.*
import kotlinx.android.synthetic.main.activity_shopping.categoryText

class CategoryList : AppCompatActivity() {
    private lateinit var user: User
    var productList = ArrayList<Product>()

    fun initProducts(){
        val electronics = Category("Electronics", "Electronic devices", R.drawable.electronics)
        val clothing = Category("Clothing", "Clothes", R.drawable.clothing)
        val food = Category("Food", "Foods", R.drawable.food)
        val beauty = Category("Beauty", "Beauty tools", R.drawable.beauty)

        val tv = Product(10, electronics, "Samsung tv", 749.00, "black", R.drawable.tv, "65 inch QLED tv")
        val laptop = Product(11, electronics, "Surface laptop", 1250.00, "rose", R.drawable.laptop, "Surface laptop 3")
        val headphones = Product(12, electronics, "Beats headphones", 350.00, "black red", R.drawable.headphones, "Beats Studio 3 headphone")
        val jacket = Product(20, clothing, "Jacket", 50.00, "yellow", R.drawable.jacket, "Raining jacket")
        val blouse = Product(21, clothing, "Blouse", 20.00, "red", R.drawable.blouse, "Women blouse")
        val jeans = Product(22, clothing, "Jeans", 30.00, "light blue", R.drawable.jeans, "Men light blue jeans")
        val dress = Product(23, clothing, "Dress", 45.00, "emerald", R.drawable.dress, "Women dress")
        val chocolate = Product(30, food, "Belgium chocolate", 15.00, "brown", R.drawable.chocolate, "Belgium dark chocolate")
        val chips = Product(31, food, "Lays chips", 3.00, "lime", R.drawable.chips, "Dill pickle flavored chips")
        val candy = Product(32, food, "Skittles", 1.00, "all", R.drawable.candy, "Skittles candy")
        val drink = Product(33, food, "Cola", 1.00, "red", R.drawable.drink, "Coca cola")
        val lipstick = Product(41, beauty, "Lipstick", 13.00, "red", R.drawable.lipstick, "Red lipstick")
        val faceCream = Product(42, beauty, "Estee Lauder cream", 45.00, "rose gold", R.drawable.facecream, "Estee Lauder day cream")
        val eyeshadow = Product(43, beauty, "Eye shadow", 31.00, "nude", R.drawable.eyeshadow, "Nude collection")
        val faceWash = Product(44, beauty, "Face wash", 21.00, "blue", R.drawable.facewash, "Kehl face wash")
        productList = arrayListOf(tv, laptop, headphones, jacket, blouse, jeans, dress, chocolate, chips, candy, drink, lipstick, faceCream, faceWash, eyeshadow)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)

        initProducts()
        user = intent.getSerializableExtra("currentUser") as User
        welcomeText.text = "Welcome ${user.email}"
        val category = intent.getSerializableExtra("currentCategory") as Category
        categoryText.text = "Products of ${category.name}"
            var filteredProducts = productList.filter { product -> product.category == category }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, filteredProducts)
        productListView.adapter = adapter

        productListView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${filteredProducts[position].description} && ${filteredProducts[position].price}", Toast.LENGTH_SHORT).show()
        }
    }
}