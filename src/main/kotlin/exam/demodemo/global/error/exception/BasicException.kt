package exam.demodemo.global.error.exception

import exam.demodemo.global.error.ErrorCode

open class BasicException(val errorCode: ErrorCode) : RuntimeException() {
}