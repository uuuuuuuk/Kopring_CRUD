package exam.demodemo.domain.shop.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "item")
@EntityListeners(AuditingEntityListener::class)
class Item (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "item_id")
        val id: Long = 0,
        @Column(name = "title", nullable = false)
        var title: String,
        @Column(name = "content", nullable = false)
        var content: String,
        @Column(name = "price", nullable = false)
        var price: Int,
        @CreatedDate
        var createTime: LocalDateTime,
        @LastModifiedDate
        var editTime: LocalDateTime
) {

        fun update(title: String, content: String, price: Int) {
                this.title = title
                this.content = content
                this.price = price
                this.editTime = LocalDateTime.now()
        }
}
