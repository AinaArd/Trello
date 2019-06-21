//package ru.itis.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import ru.itis.models.Test;
//import ru.itis.repositories.CommentMongoRepository;
//
//@Controller
//public class TestController {
//    @Autowired
//    private CommentMongoRepository commentMongoRepository;
//
//    @GetMapping(path = "/test")
//    public String simpleTest(ModelMap model) {
//        Test newTest = Test.builder()
//                .id(15L)
//                .content("some testing")
//                .build();
//        Test savedTest = commentMongoRepository.save(newTest);
//        model.addAttribute("test", savedTest);
//        return "test";
//    }
//}
