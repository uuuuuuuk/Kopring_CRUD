package exam.demodemo.domain.shop.service

import exam.demodemo.domain.shop.entity.Item
import exam.demodemo.domain.shop.exception.ItemNotFoundException
import exam.demodemo.domain.shop.presentation.data.response.DetailItemResponseDto
import exam.demodemo.domain.shop.repository.ItemRepository
import exam.demodemo.global.annotation.ReadOnlyServiceAnnotation
import org.springframework.data.repository.findByIdOrNull

@ReadOnlyServiceAnnotation
class GetItemService(
        private val itemRepository: ItemRepository
) {
    fun execute(itemId: Long): DetailItemResponseDto {
        val itemInfo: Item = itemRepository.findByIdOrNull(itemId)?: throw ItemNotFoundException()

        return toResponse(itemInfo)
    }

    private fun toResponse(item: Item): DetailItemResponseDto =
            DetailItemResponseDto(
                    id = item.id,
                    title = item.title,
                    content = item.content,
                    price = item.price,
                    createTime = item.createTime,
                    editTime = item.editTime
            )
}