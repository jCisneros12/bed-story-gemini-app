package com.jcisneros12.mygooglegeminiapp.core.models

import com.google.gson.Gson


/**
 * @author Juan Cisneros on 04/03/2024
 */
data class PromptStructureModel(
    val about: String? = "",
    val gender: String? = "",
    val age: String? = ""
)

fun PromptStructureModel.toJson(gson: Gson): String {
    return gson.toJson(this)
}