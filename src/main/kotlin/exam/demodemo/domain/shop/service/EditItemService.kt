package exam.demodemo.domain.shop.service

import exam.demodemo.domain.shop.entity.Item
import exam.demodemo.domain.shop.exception.ItemNotFoundException
import exam.demodemo.domain.shop.presentation.data.request.EditItemRequest
import exam.demodemo.domain.shop.repository.ItemRepository
import exam.demodemo.global.annotation.RollbackServiceAnnotation
import org.springframework.data.repository.findByIdOrNull

@RollbackServiceAnnotation
class EditItemService(
        private val itemRepository: ItemRepository
) {
    fun execute(editItemRequest: EditItemRequest, itemId: Long): Item {
        val itemInfo: Item = itemRepository.findByIdOrNull(itemId)?: throw ItemNotFoundException()

        toDto(editItemRequest)
                .let { itemInfo.update(title = it.title, content = it.content, price = it.price) }

        return itemInfo
    }

    private fun toDto(editItemRequest: EditItemRequest): EditItemRequest =
            EditItemRequest(
                    title = editItemRequest.title,
                    content = editItemRequest.content,
                    price = editItemRequest.price
            )
}