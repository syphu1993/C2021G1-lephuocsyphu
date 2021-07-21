package question.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import question.dto.QuestionDto;
import question.model.Question;
import question.model.QuestionType;
import question.service.IQuestionService;
import question.service.IQuestionTypeService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class QuestionController {
    @Autowired
    IQuestionService questionService;
    @Autowired
    IQuestionTypeService questionTypeService;

    @ModelAttribute("questionTypes")
    public Iterable<QuestionType> showType(){
        return questionTypeService.findAll();
    }
    @GetMapping(value = {"/","/home"})
    public String showHome(){
        return "home/index";
    }

//    @GetMapping(value = "/questions")
//    public String showListQuestions(@PageableDefault(size = 3) Pageable pageable, Model model){
//        Page<Question> questions = questionService.findAll(pageable);
//        model.addAttribute("questions",questions);
//        return "question/list";
//    }
    @GetMapping(value = "/question-create")
    public String showFormCreate(Model model){
        model.addAttribute("questionDto",new QuestionDto());
        return "question/create";
    }
    @PostMapping(value ="/question-create")
    public String createQusetion(@ModelAttribute @Valid QuestionDto questionDto,BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "question/create";
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto,question);
        question.setFlag(1);
        this.questionService.save(question);
        model.addAttribute("message","A question was created!");
        return "question/create";
    }

   @PostMapping(value = "/question-del")
   public String  delCustomer(@RequestParam Integer  id){
       Optional<Question> customer = questionService.findById(id);
       customer.get().setFlag(0);
       this.questionService.save(customer.get());
       return "redirect:/questions";
   }
    @GetMapping(value = "/questions")
    public String showListFind(@PageableDefault(size = 3) Pageable pageable,
                                   @RequestParam Optional<String> keyName, @RequestParam Optional<String> typeOfQuestion,
                                   Model model){
        String keyValue ="";
        String keyTypeValue ="";
        if (keyName.isPresent()){
            keyValue=keyName.get();
        }
        if (typeOfQuestion.isPresent()){
            keyTypeValue=typeOfQuestion.get();
        }
        Page<Question> questions = questionService.findAllByName(pageable,keyValue,keyTypeValue);
        model.addAttribute("keyValue",keyValue);
        model.addAttribute("keyTypeValue",keyTypeValue);
        model.addAttribute("questions",questions);
        return "question/list";
    }
}
