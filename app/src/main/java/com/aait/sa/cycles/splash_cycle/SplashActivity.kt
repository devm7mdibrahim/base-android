package com.aait.sa.cycles.splash_cycle

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.aait.sa.R
import com.aait.sa.base.BaseActivity
import com.aait.sa.cycles.auth_cycle.AuthActivity
import com.aait.sa.cycles.home_cycle.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lifecycleScope.launchWhenCreated {
            delay(2000)

            val token = preferenceRepository.getToken().first()

            if (token.isNotEmpty()) {
                openHomeActivity()
            } else {
                openAuthActivity()
            }
        }
    }

    private fun openHomeActivity() {
        Intent(this@SplashActivity, HomeActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK).also {
                startActivity(it)
            }
    }

    private fun openAuthActivity() {
        Intent(this@SplashActivity, AuthActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK).also {
                startActivity(it)
            }
    }
}