//package ru.itis.services;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import ru.itis.forms.LoginForm;
//import ru.itis.models.User;
//import ru.itis.repositories.UsersRepository;
//import ru.itis.transfer.TokenDto;
//
//import java.util.Optional;
//
//import static ru.itis.transfer.TokenDto.from;
//
//@Component
//public class LoginServiceImpl implements LoginService {
//
//    @Autowired
//    private TokensRepository tokensRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    @Override
//    public TokenDto login(LoginForm loginForm) {
//        Optional<User> userCandidate = usersRepository.findByLogin(loginForm.getLogin());
//        if(userCandidate.isPresent()) {
//            User user = userCandidate.get();
//            if(passwordEncoder.matches(loginForm.getPassword(),user.getHashPassword())) {
//                Token token = Token.builder()
//                        .user(user)
//                        .value(RandomStringUtils.random(10, true, true))
//                        .build();
//                tokensRepository.save(token);
//                return from(token);
//            }
//        }
//        throw new IllegalArgumentException("User not found");
//    }
//}
