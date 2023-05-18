package exam.demodemo.domain.shop.exception

import exam.demodemo.global.error.ErrorCode
import exam.demodemo.global.error.exception.BasicException

class ItemNotFoundException : BasicException(ErrorCode.ITEM_NOT_FOUND) {
}