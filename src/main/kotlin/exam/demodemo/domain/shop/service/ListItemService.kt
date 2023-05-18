package exam.demodemo.domain.shop.service

import exam.demodemo.domain.shop.entity.Item
import exam.demodemo.domain.shop.presentation.data.response.ItemResponseDto
import exam.demodemo.domain.shop.presentation.data.response.ListItemResponseDto
import exam.demodemo.domain.shop.repository.ItemRepository
import exam.demodemo.global.annotation.ReadOnlyServiceAnnotation

@ReadOnlyServiceAnnotation
class ListItemService(
        private val itemRepository: ItemRepository
) {
    fun execute(): ListItemResponseDto = ListItemResponseDto(
            itemList = itemRepository.findAll()
                    .map { it.toDto() }
    )

    private fun Item.toDto(): ItemResponseDto =
            ItemResponseDto(
                    title = this.title,
                    createTime = this.createTime
            )
}