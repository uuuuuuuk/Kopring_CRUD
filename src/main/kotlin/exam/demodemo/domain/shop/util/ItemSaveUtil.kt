package exam.demodemo.domain.shop.util

import exam.demodemo.domain.shop.entity.Item
import exam.demodemo.domain.shop.repository.ItemRepository
import org.springframework.stereotype.Component

@Component
class ItemSaveUtil (

    private val itemRepository: ItemRepository
) {
    fun saveItem(item: Item) =
            itemRepository.save(item)
}