package exam.demodemo.domain.shop.presentation.controller

import exam.demodemo.domain.shop.presentation.data.request.CreateItemRequest
import exam.demodemo.domain.shop.presentation.data.request.EditItemRequest
import exam.demodemo.domain.shop.presentation.data.response.DetailItemResponseDto
import exam.demodemo.domain.shop.presentation.data.response.ListItemResponseDto
import exam.demodemo.domain.shop.service.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/item")
class ItemController (

        private val createItemService: CreateItemService,
        private val deleteItemService: DeleteItemService,
        private val editItemService: EditItemService,
        private val getItemService: GetItemService,
        private val listItemService: ListItemService

) {

    @PostMapping
    fun createItem(
        @Valid @RequestBody createItemRequest: CreateItemRequest
    ): ResponseEntity<Void> =
            createItemService.execute(createItemRequest)
                    .run { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PutMapping("/{itemId}")
    fun edit(
      @Valid @RequestBody editItemRequest: EditItemRequest,
      @PathVariable itemId: Long
    ): ResponseEntity<Void> =
            editItemService.execute(editItemRequest, itemId)
                    .run { ResponseEntity.status(HttpStatus.OK).build() }

    @DeleteMapping("/{itemId}")
    fun deleteBoard(
        @PathVariable itemId: Long
    ): ResponseEntity<Void> =
            deleteItemService.execute(itemId)
                    .run { ResponseEntity.status(HttpStatus.NO_CONTENT).build() }

    @GetMapping
    fun findItems(
    ): ResponseEntity<ListItemResponseDto> =
            ResponseEntity.status(HttpStatus.OK).body(listItemService.execute())

    @GetMapping("/{itemId}")
    fun findBoard(@PathVariable itemId: Long
    ): ResponseEntity<DetailItemResponseDto> =
            ResponseEntity.status(HttpStatus.OK).body(getItemService.execute(itemId))
}