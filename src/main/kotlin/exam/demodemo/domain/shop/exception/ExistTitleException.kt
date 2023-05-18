package exam.demodemo.domain.shop.exception

import exam.demodemo.global.error.ErrorCode
import exam.demodemo.global.error.exception.BasicException

class ExistTitleException : BasicException(ErrorCode.ALREADY_EXIST_TITLE) {
}