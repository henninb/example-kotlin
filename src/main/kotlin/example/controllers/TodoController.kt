package example.controllers

import example.domain.Todo
import example.services.TodoService
import org.springframework.http.MediaType
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
        mav.addObject("todos", dataList)
        return mav
    }

    @RequestMapping(value = ["/add"], method = [RequestMethod.POST], consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun add(@RequestParam("text") request: String) :String {
      val todo = Todo(0, request)
      todoService.save(todo)
      return "redirect:/index";
    }

    @RequestMapping(value = ["/delete"], method = [RequestMethod.POST], consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun delete(@RequestParam("id") id: Long) :String {
        todoService.delete(id)
        return "redirect:/index";
    }
}