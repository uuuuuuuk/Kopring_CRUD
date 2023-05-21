package exam.demodemo.domain.user.entity

import javax.persistence.*

@Entity
@Table(name = "user")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        val userId: Long = 0,
        @Column(name = "id", nullable = false)
        var id: String,
        @Column(name = "password", nullable = false)
        var password: String,
)
