package org.gwnu.tutorial.dagger2

import android.util.Log
import javax.inject.Inject

class Burger @Inject constructor(val bun: WheatBun, val patty: Patty) {

    fun info() {
        Log.d("info", "${bun.getBun()}, ${patty.getPatty()}")
    }
}