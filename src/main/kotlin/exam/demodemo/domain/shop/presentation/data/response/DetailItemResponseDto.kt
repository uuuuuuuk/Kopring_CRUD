package exam.demodemo.domain.shop.presentation.data.response

import java.time.LocalDateTime

data class DetailItemResponseDto(
        val id: Long,
        val title: String,
        val content: String,
        val price: Int,
        val createTime: LocalDateTime,
        var editTime: LocalDateTime
)
