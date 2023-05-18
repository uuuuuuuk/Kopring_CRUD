package exam.demodemo.domain.shop.service

import exam.demodemo.domain.shop.entity.Item
import exam.demodemo.domain.shop.exception.ItemNotFoundException
import exam.demodemo.domain.shop.repository.ItemRepository
import exam.demodemo.global.annotation.RollbackServiceAnnotation
import org.springframework.data.repository.findByIdOrNull

@RollbackServiceAnnotation
class DeleteItemService(
        private val itemRepository: ItemRepository
) {
    fun execute(itemId: Long) {
        val itemInfo: Item = itemRepository.findByIdOrNull(itemId) ?: throw ItemNotFoundException()

        itemRepository.delete(itemInfo)
    }
}