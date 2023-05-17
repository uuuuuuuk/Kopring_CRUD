package exam.demodemo.domain.shop.repository

import exam.demodemo.domain.shop.entity.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long> {
}