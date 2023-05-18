package exam.demodemo.global.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
        val error: Int,
        val message: String
) {
    ITEM_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "해당 상품을 찾을 수 없습니다."),
    ALREADY_EXIST_TITLE(HttpStatus.CONFLICT.value(), "이미 존재하는 상품입니다.")
}