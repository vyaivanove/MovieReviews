package com.vyacheslavivanov.moviereviews.api.mappers

import com.vyacheslavivanov.moviereviews.api.dto.review.ReviewListRequest
import com.vyacheslavivanov.moviereviews.api.dto.review.ReviewListResponse
import com.vyacheslavivanov.moviereviews.api.dto.review.ReviewResponse
import com.vyacheslavivanov.moviereviews.data.review.Review
import com.vyacheslavivanov.moviereviews.data.review.ReviewList

fun ReviewListResponse.toDomain(): ReviewList =
    ReviewList(
        mapList(reviewList) {
            it.toDomain()
        },
        hasMore
    )

fun ReviewResponse.toDomain(): Review =
    Review(
        title = title,
        ageRating = ageRating,
        isCriticsPick = isCriticsPick == 1,
        author = author,
        headline = headline,
        summary = summary,
        dateCreated = dateCreated,
        linkUrl = link.url,
        thumbnailUrl = image.src
    )

fun ReviewListRequest.toQueryMap(): Map<String, Any> =
    mapOf(
        "offset" to offset
    )