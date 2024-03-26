package com.jcisneros12.mygooglegeminiapp.utils


/**
 * @author Juan Cisneros on 22/03/2024
 */


fun handleSliderRange(float: Float): Int {
    return when (float) {
        0f -> { 5 }
        25f -> { 6 }
        50f -> { 7 }
        75f -> { 8 }
        100f -> { 9 }
        else -> { 10 }
    }
}