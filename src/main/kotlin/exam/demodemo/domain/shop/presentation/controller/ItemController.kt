package exam.demodemo.domain.shop.presentation.controller

import exam.demodemo.domain.shop.presentation.data.request.CreateItemRequest
import exam.demodemo.domain.shop.service.CreateItemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/item")
class ItemController (

        private val createItemService: CreateItemService
) {

    @PostMapping
    fun createItem(
        @Valid @RequestBody createItemRequest: CreateItemRequest
    ): ResponseEntity<Void> =
            createItemService.execute(createItemRequest)
                    .run { ResponseEntity.status(HttpStatus.CREATED).build() }
}