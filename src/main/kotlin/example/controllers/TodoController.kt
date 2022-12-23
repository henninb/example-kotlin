package example.controllers

import example.services.TodoService
import jakarta.faces.annotation.View
import org.springframework.http.ResponseEntity


import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

//@RestController
@Controller
class TodoController(private var todoService: TodoService) {

    @RequestMapping(value = ["/index"], method = [RequestMethod.GET])
    //@Get("/index")
    @View("index")
    fun index(): ResponseEntity<*> {
        val dataList = todoService.findAllTodos()
        return ResponseEntity.ok(mapOf("dataList" to dataList))
    }

//    @Post("/add")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    fun add(@Body("text") text: String): HttpResponse<*> {
//        val data = Todo(0, text)
//        todoRepository.save(data)
//        return HttpResponse.redirect<Any>(URI.create("/index"))
//    }
//
//    @Post("/delete")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    fun delete(@Body("id") id: Long): HttpResponse<*> {
//        todoRepository.deleteById(id)
//        return HttpResponse.redirect<Any>(URI.create("/index"))
//    }
}