package com.example.nestedrecyclerview

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class FieldData(
    @SerializedName("field_id")
    val id: String? = null,
    val hint: String? = null,
    @SerializedName("field_type")
    val type: String? = null,
    val keyboard: String? = null,
    val required: Boolean? = false,
    @SerializedName("is_active")
    val isActive: Boolean? = false,
    val icon: String? = null
)
