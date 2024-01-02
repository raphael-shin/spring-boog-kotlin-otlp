package aws.jungseob.o11y.repository

import aws.jungseob.o11y.dto.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Int> {
}