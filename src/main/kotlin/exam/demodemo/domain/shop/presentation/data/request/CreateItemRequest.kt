package exam.demodemo.domain.shop.presentation.data.request

import javax.validation.constraints.NotBlank

data class CreateItemRequest (
        @NotBlank
        var title: String,
        @NotBlank
        var content: String
)
