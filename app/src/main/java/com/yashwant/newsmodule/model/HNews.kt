package com.yashwant.newsmodule.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HNews {

    @SerializedName("hits")
    @Expose
    var hits: List<Hit>? = null
    @SerializedName("nbHits")
    @Expose
    var nbHits: Int? = null
    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("nbPages")
    @Expose
    var nbPages: Int? = null
    @SerializedName("hitsPerPage")
    @Expose
    var hitsPerPage: Int? = null
    @SerializedName("processingTimeMS")
    @Expose
    var processingTimeMS: Int? = null
    @SerializedName("exhaustiveNbHits")
    @Expose
    var exhaustiveNbHits: Boolean? = null
    @SerializedName("query")
    @Expose
    var query: String? = null
    @SerializedName("params")
    @Expose
    var params: String? = null

}
