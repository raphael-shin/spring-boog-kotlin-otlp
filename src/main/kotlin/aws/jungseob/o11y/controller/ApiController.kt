package aws.jungseob.o11y.controller

import aws.jungseob.o11y.dto.User
import aws.jungseob.o11y.service.UserService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
class ApiController(
    private val userService: UserService
) {
    @GetMapping("/api/users/{id}")
    fun getUser(@PathVariable id: Int): User {
        logger.info { "getUser called." }
        return userService.getUser(id)
    }

    @GetMapping("/api/users")
    fun getAllUsers(): List<User> {
        logger.info { "getUser called." }
        return userService.getAllUsers()
    }
}