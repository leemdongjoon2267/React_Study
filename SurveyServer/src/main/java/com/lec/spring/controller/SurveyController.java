package com.lec.spring.controller;


import com.lec.spring.domain.Survey;
import com.lec.spring.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;


    @GetMapping("/list")
    @CrossOrigin
    public List<Survey> getAllSurveys() {
        return surveyService.findAll();
    }


    @PostMapping("/write")
    @CrossOrigin
    public Survey createSurvey(@RequestBody Survey survey) {
        return surveyService.save(survey);
    }


    @GetMapping("/detail/{id}")
    @CrossOrigin
    public Survey getSurveyById(@PathVariable Long id) {
        Optional<Survey> survey = surveyService.findById(id);
        return survey.orElse(null);
    }


    @PutMapping("/update")
    @CrossOrigin
    public Survey updateSurvey(@RequestBody Survey survey) {
        return surveyService.update(survey);
    }


    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public int deleteSurvey(@PathVariable Long id) {
        boolean isDeleted = surveyService.deleteById(id);
        return isDeleted ? 1 : 0;
    }
}
