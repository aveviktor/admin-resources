package com.example.adminresources.service;

import com.example.adminresources.bean.NewExerciseCommand;
import com.example.adminresources.entity.Exercise;
import com.example.adminresources.entity.UserExercise;
import com.example.adminresources.repository.ExerciseRepository;
import com.example.adminresources.repository.UserExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Service
public class AdminService extends BaseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    UserExerciseRepository userExerciseRepository;

    public ModelAndView addExercise() {
        return new ModelAndView(ADMIN_PAGE, Map.of("templateName", "addExercise"));
    }

    public ModelAndView showApprovingPage() {
        List<UserExercise> exercises = userExerciseRepository.findAllByIsApprovedFalse();

        ModelAndView modelAndView = new ModelAndView(ADMIN_PAGE);
        modelAndView.addObject("templateName", "showApprovedPage");
        modelAndView.addObject("userExercises", exercises);
        return modelAndView;
    }

    public ModelAndView saveNewExercise(NewExerciseCommand newExerciseCommand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView(ADMIN_PAGE, Map.of(ERROR, getErrors(bindingResult)));
        }
        if(exerciseRepository.getExerciseByName(newExerciseCommand.getName()) == null) {
            Exercise exercise = new Exercise(newExerciseCommand);
            exerciseRepository.save(exercise);
            return new ModelAndView(ADMIN_PAGE, Map.of(SUCCESS, "New exercise was created."));
        }
        return new ModelAndView(ADMIN_PAGE, Map.of(ERROR, "Exercise with name: '" + newExerciseCommand.getName() + "' is exist"));
    }

    public ModelAndView showExistedExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();
        ModelAndView modelAndView = new ModelAndView(ADMIN_PAGE);
        modelAndView.addObject("templateName", "showExistedExercises");
        modelAndView.addObject("exercises", exercises);
        return modelAndView;
    }
}
