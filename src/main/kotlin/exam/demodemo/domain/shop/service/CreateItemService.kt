package exam.demodemo.domain.shop.service

import exam.demodemo.domain.shop.entity.Item
import exam.demodemo.domain.shop.presentation.data.dto.CreateItemDto
import exam.demodemo.domain.shop.presentation.data.request.CreateItemRequest
import exam.demodemo.domain.shop.util.ItemSaveUtil
import exam.demodemo.global.annotation.RollbackServiceAnnotation
import java.time.LocalDateTime

@RollbackServiceAnnotation
class CreateItemService (

    private val itemSaveUtil: ItemSaveUtil
) {
    fun execute(createItemRequest: CreateItemRequest) {
        val createItemDto: CreateItemDto = toDto(createItemRequest = createItemRequest)

        return toEntity(createItemDto)
                .let { itemSaveUtil.saveItem(item = it) }
    }

    private fun toDto(createItemRequest: CreateItemRequest): CreateItemDto =
            CreateItemDto(
                    title = createItemRequest.title,
                    content = createItemRequest.content,
                    price = createItemRequest.price
            )

    private fun toEntity(createItemDto: CreateItemDto): Item =
            Item(
                    title = createItemDto.title,
                    content = createItemDto.content,
                    price = createItemDto.price,
                    createTime = LocalDateTime.now(),
                    editTime = LocalDateTime.now()
            )
}