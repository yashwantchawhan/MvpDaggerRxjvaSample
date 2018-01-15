package com.yashwant.newsmodule.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Url {

    @SerializedName("value")
    @Expose
    var value: String? = null
    @SerializedName("matchLevel")
    @Expose
    var matchLevel: String? = null
    @SerializedName("fullyHighlighted")
    @Expose
    var fullyHighlighted: Boolean? = null
    @SerializedName("matchedWords")
    @Expose
    var matchedWords: List<String>? = null

}
