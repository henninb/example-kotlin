package example.services

import example.domain.Todo
import example.repositories.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService (private var todoRepository: TodoRepository) {
    fun findAllTodos() : List<Todo> {
        return todoRepository.findAll()
    }
}