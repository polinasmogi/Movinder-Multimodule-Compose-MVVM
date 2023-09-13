package com.polinasmogi.uikit.loader

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Build
import android.os.CountDownTimer
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.LinearInterpolator
import java.util.Random
import kotlin.math.cos
import kotlin.math.sin


@Suppress("DEPRECATION")
class MovieLoader @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?
) : View(context, attrs) {

    private var rotationDegrees = 0f
    private var countdownValue = 5
    private val countDownTextSize = 500f

    private val random = Random()
    private var horizontalGlitch = 0f
    private var verticalGlitch = 0f

    private val backgroundPaint = Paint().apply {
        color = resources.getColor(com.polinasmogi.uiatoms.R.color.color_background, context.theme)
    }

    private val linePaint = Paint().apply {
        color = resources.getColor(com.polinasmogi.uiatoms.R.color.color_on_background, context.theme)
        style = Paint.Style.STROKE
    }

    private val outlineTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = resources.getColor(com.polinasmogi.uiatoms.R.color.color_on_background, context.theme)
        textSize = countDownTextSize
        textAlign = Paint.Align.CENTER
        typeface = Typeface.DEFAULT_BOLD
        style = Paint.Style.STROKE
        strokeWidth = 1f
    }

    private val countdownTimer = object : CountDownTimer(6000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            countdownValue = (millisUntilFinished / 1000).toInt()
            invalidate()
        }
        override fun onFinish() {
            countdownValue = 0
            invalidate()
            start()
        }
    }

    init {
        startRotationAnimation()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(getScreenSize().width, getScreenSize().height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2f
        val centerY = height / 2f
        canvas.apply {
            // Black background
            drawRect(0f, 0f, width.toFloat(), height.toFloat(), backgroundPaint)

            // Circles
            val bigCircleRadius = (getScreenSize().width * 0.40).toFloat()
            drawCircle(centerX + horizontalGlitch, centerY + verticalGlitch, bigCircleRadius, linePaint)

            val smallCircleRadius = (getScreenSize().width * 0.36).toFloat()
            drawCircle(centerX + horizontalGlitch, centerY + verticalGlitch, smallCircleRadius, linePaint)

            // Rotating line
            val lineLength = getScreenSize().height / 2
            val endX = centerX + lineLength * cos(Math.toRadians(rotationDegrees.toDouble())).toFloat() + horizontalGlitch
            val endY = centerY + lineLength * sin(Math.toRadians(rotationDegrees.toDouble())).toFloat() + verticalGlitch

            drawLine(centerX, centerY, endX, endY, linePaint)

            // Glitchy count down timer text
            for (i in 0 until countdownValue.toString().length) {
                val xPos = centerX + horizontalGlitch
                val yPos = (centerY + countDownTextSize * 0.35).toFloat() + verticalGlitch
                drawText(countdownValue.toString(), xPos, yPos, outlineTextPaint)
            }

            // Noise effect
            drawScratches(canvas)

            // Update glitch effect
            horizontalGlitch = random.nextFloat() * 10 - 5
            verticalGlitch = random.nextFloat() * 10 - 5
        }
    }

    private fun drawScratches(canvas: Canvas?) {
        val numScratches = 50

        for (i in 0 until numScratches) {
            val startX = random.nextInt(width)
            val startY = random.nextInt(height)
            val endX = startX + random.nextInt(20) - 10
            val endY = startY + random.nextInt(20) - 10

            canvas?.drawLine(startX.toFloat(), startY.toFloat(), endX.toFloat(), endY.toFloat(), linePaint)
        }
    }

    private fun startRotationAnimation() {
        ObjectAnimator.ofFloat(this, "rotationDegrees", 0f, 360f).apply {
            duration = 1000
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
            start()
        }
        countdownTimer.start()
        horizontalGlitch = random.nextFloat() * 10 - 5
        verticalGlitch = random.nextFloat() * 10 - 5
    }

    // This function is called in the startRotationAnimation() function, "rotatingDegrees"
    fun setRotationDegrees(degrees: Float) {
        rotationDegrees = degrees
        invalidate()
    }

    private fun getScreenSize(): ScreenSize {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics = windowManager.currentWindowMetrics
            val insets = windowMetrics.windowInsets
                .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            ScreenSize(
                windowMetrics.bounds.width() - insets.left - insets.right,
                windowMetrics.bounds.height() - insets.top - insets.bottom
            )
        } else {
            val displayMetrics = DisplayMetrics()
            val display = windowManager.defaultDisplay
            display.getMetrics(displayMetrics)
            ScreenSize(displayMetrics.widthPixels, displayMetrics.heightPixels)
        }
    }

    internal data class ScreenSize(
        val width: Int,
        val height: Int
    )
}
