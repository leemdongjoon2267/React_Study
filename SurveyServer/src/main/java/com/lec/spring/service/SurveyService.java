package com.lec.spring.service;

import com.lec.spring.domain.Survey;
import com.lec.spring.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public List<Survey> findAll() {

        return surveyRepository.findAll();
    }

    public Optional<Survey> findById(Long id) {

        return surveyRepository.findById(id);
    }

    public Survey save(Survey survey) {

        return surveyRepository.save(survey);
    }

    public Survey update(Survey survey) {

        Optional<Survey> existingSurvey = surveyRepository.findById(survey.getId());

        if (existingSurvey.isPresent()) {

            Survey updatedSurvey = existingSurvey.get();

            updatedSurvey.setGender(survey.getGender());

            updatedSurvey.setArea(survey.getArea());

            updatedSurvey.setFavorite(survey.getFavorite());

            return surveyRepository.save(updatedSurvey);
        }
        return null;
    }

    public boolean deleteById(Long id) {

        if (surveyRepository.existsById(id)) {

            surveyRepository.deleteById(id);

            return true;
        }

        return false;
    }
}
