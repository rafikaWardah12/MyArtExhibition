package com.example.submissionakhiraplikasiandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.example.submissionakhiraplikasiandroid.databinding.ActivitySplashScreenBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            textOne.animation = AnimationUtils.loadAnimation(this@SplashActivity, R.animator.anim_one)
            textTwo.animation = AnimationUtils.loadAnimation(this@SplashActivity, R.animator.anim_two)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 3000)

//        private val animationDuration = 1000L // Durasi animasi dalam milidetik
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            setContentView(R.layout.activity_splash_screen)
//
//            // Buat animator untuk logo Anda
//            val animator = AnimatorInflater.loadAnimator(this, R.animator.splash_animation)
//            animator.setTarget(findViewById(R.id.logo)) // Ganti 'logo' dengan ID ImageView Anda
//            animator.duration = animationDuration
//            animator.interpolator = PathInterpolatorCompat.create(0.42f, 0f, 0.58f, 1f)
//
//            // Handler untuk berpindah ke MainActivity setelah animasi selesai
//            val handler = Handler()
//
//            // Jalankan animasi dan berpindah ke MainActivity setelah selesai
//            animator.addListener(object : Animator.AnimatorListener {
//                override fun onAnimationStart(animation: Animator?) {}
//
//                override fun onAnimationEnd(animation: Animator?) {
//                    handler.post {
//                        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
//                        finish()
//                    }
//                }
//                override fun onAnimationCancel(animation: Animator?) {}
//
//                override fun onAnimationRepeat(animation: Animator?) {}
//            })
//
//            animator.start()
//        }

        //TIDAK BISA MUNCUL
//        setContentView(R.layout.activity_splash_screen)
//        Handler().postDelayed({
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, 200)
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            splashScreen.setOnExitAnimationListener { splashScreenView ->
//                val slideUp = ObjectAnimator.ofFloat(
//                    splashScreenView,
//                    View.TRANSLATION_Y,
//                    0f,
//                    -splashScreenView.height.toFloat()
//                )
//                slideUp.interpolator = AnticipateInterpolator()
//                slideUp.duration = 200L
//                // Call SplashScreenView.remove at the end of your custom animation.
//                slideUp.doOnEnd { splashScreenView.remove() }
//
//                //run animation
//                slideUp.start()
//
//                // Get the duration of the animated vector drawable.
//                val animationDuration = splashScreenView.iconAnimationDuration
//                // Get the start time of the animation.
//                val animationStart = splashScreenView.iconAnimationStart
//                // Calculate the remaining duration of the animation.
//                val remainingDuration = if (animationDuration != null && animationStart != null) {
//                    (animationDuration - Duration.between(animationStart, Instant.now()))
//                        .toMillis()
//                        .coerceAtLeast(0L)
//                } else {
//                    0L
//                }
//            }
//        }
    }
}