package example.controllers

import example.domain.Todo
import example.services.TodoService
import jakarta.ws.rs.core.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView


@Controller
class TodoController(private var todoService: TodoService) {

    @RequestMapping(value = ["/index"], method = [RequestMethod.GET])
    fun index(): ModelAndView {
        val mav = ModelAndView("index")
        val dataList = todoService.findAllTodos()
        println(dataList)
        //mav.addObject("todos", mapOf("todos" to dataList))
        mav.addObject("todos", dataList)
        return mav
    }

    @RequestMapping(value = ["/add"], method = [RequestMethod.POST], consumes = [MediaType.APPLICATION_FORM_URLENCODED])
    fun add(@RequestParam("text") request: String) :String {
      println(request)
      val todo = Todo(0, request)
      todoService.save(todo)
      println("add value")
      return "redirect:/index";
    }

    @RequestMapping(value = ["/delete"], method = [RequestMethod.POST], consumes = [MediaType.APPLICATION_FORM_URLENCODED])
    fun delete(@RequestParam("id") id: Long) :String {
        //println(request)
        todoService.delete(id)
        return "redirect:/index";
    }
}