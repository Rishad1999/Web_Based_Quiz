package com.rish.quizApp.Controller;

import ch.qos.logback.core.model.Model;
import com.rish.quizApp.Model.Question;
import com.rish.quizApp.Service.QuestionService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController
{
    @Autowired
    QuestionService questionService;
    //Getting all the questions
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuesions()
    {
        return questionService.getAllQuestions();
    }
    //search by category
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
    {
        return questionService.getQuestionsByCategory(category);
    }
    // adding new question
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);

    }
    @GetMapping("{id}")
    public ResponseEntity<Question> editQuestion(@PathVariable int id)
    {
        //Question existingQuestion = questionService.getQuestionById(id)/// questionService.editQuestion(id);


        return questionService.getQuestionById(id);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable int id,@RequestBody Question question)
    {
        ResponseEntity<Question> existingQuestion = questionService.getQuestionById(id);
        existingQuestion.getBody().setQuestionTitle(question.getQuestionTitle());
        existingQuestion.getBody().setOption1(question.getOption1());
        existingQuestion.getBody().setOption2(question.getOption2());
        existingQuestion.getBody().setOption3(question.getOption3());
        existingQuestion.getBody().setOption4(question.getOption4());
        existingQuestion.getBody().setRightAnswer(question.getRightAnswer());
        existingQuestion.getBody().setDifficultyLevel(question.getDifficultyLevel());
        existingQuestion.getBody().setCategory(question.getCategory());

        return questionService.updateQuestion(existingQuestion.getBody());
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id)
    {
        return questionService.deleteQuestion(id);
    }

}
