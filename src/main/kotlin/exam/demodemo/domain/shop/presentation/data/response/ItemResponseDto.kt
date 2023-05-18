package exam.demodemo.domain.shop.presentation.data.response

import java.time.LocalDateTime

data class ItemResponseDto(
        val title: String,
        val createTime: LocalDateTime
)
