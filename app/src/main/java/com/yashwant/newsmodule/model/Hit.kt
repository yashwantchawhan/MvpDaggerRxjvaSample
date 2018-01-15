package com.yashwant.newsmodule.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Hit {

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("author")
    @Expose
    var author: String? = null
    @SerializedName("points")
    @Expose
    var points: Int? = null
    @SerializedName("story_text")
    @Expose
    var storyText: String? = null
    @SerializedName("comment_text")
    @Expose
    var commentText: Any? = null
    @SerializedName("num_comments")
    @Expose
    var numComments: Int? = null
    @SerializedName("story_id")
    @Expose
    var storyId: Any? = null
    @SerializedName("story_title")
    @Expose
    var storyTitle: Any? = null
    @SerializedName("story_url")
    @Expose
    var storyUrl: Any? = null
    @SerializedName("parent_id")
    @Expose
    var parentId: Any? = null
    @SerializedName("created_at_i")
    @Expose
    var createdAtI: Int? = null
    @SerializedName("_tags")
    @Expose
    var tags: List<String>? = null
    @SerializedName("objectID")
    @Expose
    var objectID: String? = null
    @SerializedName("_highlightResult")
    @Expose
    var highlightResult: HighlightResult? = null

}
