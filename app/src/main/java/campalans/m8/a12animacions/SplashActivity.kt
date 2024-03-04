package campalans.m8.a12animacions

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import campalans.m8.a12animacions.databinding.ActivitySplashBinding
import android.view.animation.AnimationUtils


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Aplica la animación a la pilota
        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        binding.ballImageView.startAnimation(rotateAnimation)

        binding.root.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation(
                this,
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            startActivity(intent, options.toBundle())
            finish()
        }, SPLASH_DELAY)
    }

    companion object {
        private const val SPLASH_DELAY: Long = 10000 
    }
}
