package mum.mdp.walmart

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_forget_password.*
import kotlinx.android.synthetic.main.activity_main.emailInput

class ForgetPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)
    }

    fun clickRecoveryPassword(view: View) {
        var email = emailInput.text.toString()

        val data = Intent()
        data.putExtra("email", email)
        setResult(Activity.RESULT_OK, data)
        finish()
    }
}
