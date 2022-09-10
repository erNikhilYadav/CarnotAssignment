package com.ezyloads.carnotassignment

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ezyloads.carnotassignment.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @Author: Nikhil Yadav
 * @Date: 10-09-2022.
 */

@RunWith(AndroidJUnit4::class)
class SampleAndroidTest {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun scroll_to() {

    }
}