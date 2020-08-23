# Different types of JSON parsing technique

**Below mentioned - **
1. Moshi-
@Json(name = "vote_count") val voteCount: Int = -1

2. GSON-
@SerializedName(“vote_count”) val voteCount: Int = -1

3. Jackson -
@JsonProperty("vote_count") val voteCount: Int = -1
