package com.octo.moss

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.activity_authentication.*


class AuthenticationActivity : AppCompatActivity() {

    companion object {
        private const val RC_SIGN_IN = 18907
        private const val ID_CLIENT =
            "989410481742-r3ee6oii8m7oob91jsbcs9cf7skn2d16.apps.googleusercontent.com"
    }

    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestIdToken(ID_CLIENT)
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)

        googleSignInButton.setOnClickListener {
            startActivityForResult(googleSignInClient.signInIntent, RC_SIGN_IN)
        }
    }

    override fun onStart() {
        super.onStart()
        handleAccount(GoogleSignIn.getLastSignedInAccount(this))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            startActivity(Intent(this, QuestionDetailsActivity::class.java))

            // TODO
//            try {
//                val account = GoogleSignIn.getSignedInAccountFromIntent(data).getResult(
//                    ApiException::class.java
//                )
//                handleAccount(account)
//            } catch (e: ApiException) {
//                Toast.makeText(this, "Error while signing in", Toast.LENGTH_SHORT).show()
//                Log.e("MOSS", "ApiException", e)
//            }
        } else {
            Toast.makeText(this, "Mais whaaaat ?!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleAccount(account: GoogleSignInAccount?) {
        val email = account?.email
        if (email != null) {
            goToQuestionList(email)
        }
    }

    private fun goToQuestionList(accountEmail: String) {
        Toast.makeText(this, "Signed in $accountEmail !", Toast.LENGTH_SHORT).show()
    }

}
