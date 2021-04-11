package com.example.kitchen_recipes.ui.utils

/**
 * A generic wrapper class around data request
 */
data class Data<RequestData>(var responseType: Status, var data: RequestData? = null, var error: Exception? = null)

enum class Status { SUCCESSFUL, ERROR, LOADING }
