package mum.mdp.walmart

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        createAccountBtn.setOnClickListener() { createAccount() }
    }

    private fun createAccount(){
        val email = registerEmailInput.text.toString()
        val firstName = registerFnameInput.text.toString()
        val lastName = registerLnameInput.text.toString()
        val password = registerPasswordInput.text.toString()

        if(email.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty() && password.isNotEmpty()){
            val data = Intent()
            data.putExtra("newUser", User(firstName, lastName, email, password))
            setResult(Activity.RESULT_OK, data)
            finish()
        }else{
            Toast.makeText(this, "Fill the required fields please!", Toast.LENGTH_LONG).show()
        }
    }
}