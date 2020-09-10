package mum.mdp.walmart

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var userList = ArrayList<User>()
    val PICK_NEW_USER_REQUEST = 200
    val PICK_RECOVERY_EMAIL_REQUEST = 202

    fun initUsers(){
        val user1 = User("fname1", "lname1","user1@gmail.com", "pass1")
        val user2 = User("fname2", "lname2","user2@gmail.com", "pass2")
        val user3 = User("fname3", "lname3","user3@gmail.com", "pass3")
        val user4 = User("fname4", "lname4","user4@gmail.com", "pass4")
        val user5 = User("fname5", "lname5","user5@gmail.com", "pass5")
        userList = arrayListOf(user1, user2, user3, user4, user5)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUsers()
    }

    /*fun signIn(view: View) {
        val userName = emailInput.text.toString()
        val password = passwordInput.text.toString()

        if(userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Enter the required fields", Toast.LENGTH_LONG).show()
        } else{
            val user = User(userName, password)
            if(userList.contains(user)){
                val shoppingIntent = Intent(this, ShoppingActivity::class.java)
                shoppingIntent.putExtra("user", user)
                startActivity(shoppingIntent)
            } else Toast.makeText(this, "Please enter a valid email and password!", Toast.LENGTH_LONG).show()
        }
    }*/
    fun signIn(view: View){
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()
        if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) Toast.makeText(this, "Enter your email and password ", Toast.LENGTH_LONG).show()
        else{
            val currentUser = User(email,password)
            if(userList.contains(currentUser)){
                val shoppingIntent = Intent(this, ShoppingActivity::class.java)
                shoppingIntent.putExtra("currentUser", currentUser)
                startActivity(shoppingIntent)

            } else Toast.makeText(this, "Enter your a valid email and password!", Toast.LENGTH_LONG).show()
        }
    }

    fun forgetPassword(view: View){
        val passIntent = Intent(this, ForgetPassword::class.java)
        startActivityForResult(passIntent, 202)
    }

    fun signUp(view: View) {
        val registerIntent = Intent(this, RegisterActivity::class.java)
        startActivityForResult(registerIntent, 200)
    }

    private fun sendEmail(user:User){
        val mailIntent = Intent(Intent.ACTION_SEND)
        mailIntent.data = Uri.parse("mailto:")
        mailIntent.type = "text/plain"
        mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(user.email))
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Password Recovery")
        mailIntent.putExtra(Intent.EXTRA_TEXT, "Your password is ${user.password}")
        try{
            startActivity(Intent.createChooser(mailIntent, "Choose email client ..."))
        }catch(e: Exception){
            Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == PICK_NEW_USER_REQUEST) {
            if(resultCode == Activity.RESULT_OK) {
                val newUser = data?.getSerializableExtra("newUser") as User
                userList.add(newUser)
                Toast.makeText(this,"Account created successfully", Toast.LENGTH_LONG).show()
            }
        }
        if(requestCode == PICK_RECOVERY_EMAIL_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val email = data!!.getStringExtra("email").toString()
                var pass: String? = ""

                //Log.i(MY_TAG, email);

                for (user in userList) {
                    if (user.email.equals(email)) {
                        pass = user.password
                        break
                    }
                }
                Toast.makeText(this, "Your email: $email and password: $pass", Toast.LENGTH_LONG).show()
            }
        }
    }
}