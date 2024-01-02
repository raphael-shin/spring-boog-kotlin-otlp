package aws.jungseob.o11y.service

import aws.jungseob.o11y.dto.User
import aws.jungseob.o11y.dto.toModel
import aws.jungseob.o11y.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getUser(id: Int): User {
        return userRepository.findByIdOrNull(id)?.toModel()
            ?: throw NotFoundEntityException("Could not found user($id).")
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll().toList().map { it.toModel() }
    }
}

class NotFoundEntityException(message: String?) : RuntimeException(message)