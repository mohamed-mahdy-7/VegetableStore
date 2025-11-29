package com.example.vegetablestore.utils

import android.content.Context
import androidx.core.content.edit

fun setOnboardingCompleted(context: Context, isComplete: Boolean) {
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    prefs.edit { putBoolean("onboarding_done", isComplete) }
}

fun isOnboardingCompleted(context: Context): Boolean {
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    return prefs.getBoolean("onboarding_done", false)
}