//package ru.itis.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//@EnableWebMvc
//public class MvcConfig extends WebMvcConfigurerAdapter {
//    private static String UPLOAD_FOLDER;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/images/**", "/css/**", "/js/**")
//                .addResourceLocations("file:///" + UPLOAD_FOLDER,
//                        "classpath:/static/css/",
//                        "classpath:/static/js/");
//    }
//
//    @Value("${my.files-url}")
//    public void setUploadFolder(String uploadFolder) {
//        UPLOAD_FOLDER = uploadFolder;
//    }
//
//}
