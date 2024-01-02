package aws.jungseob.o11y.dto

import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,
    val name: String,
    val age: Int,
)

fun UserEntity.toModel(): User {
    return User(
        id = this.id,
        name = this.name,
        age = this.age,
    )
}

data class User(
    val id: Int,
    val name: String,
    val age: Int,
)