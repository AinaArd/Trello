package ru.itis.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ru.itis.models.Card;
import ru.itis.models.Desk;
import ru.itis.services.CardService;
import ru.itis.services.DeskService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Aspect
@Configuration
public class Cache {
    private Map<Long, Desk> cache;

    @Autowired
    private DeskService deskService;

    public Cache() {
        this.cache = new HashMap<>();
    }

    @Around("execution(* *..DeskService.findOneDesk(..))")
    public Optional<Desk> cacheDesk(ProceedingJoinPoint joinPoint) {
        if (cache.containsKey(joinPoint.getArgs()[0])) {
            return Optional.ofNullable(cache.get(joinPoint.getArgs()[0]));
        } else {
            Optional<Desk> deskOptional = null;
            try {
                deskOptional = (Optional<Desk>) joinPoint.proceed(joinPoint.getArgs());
                deskOptional.ifPresent(desk -> cache.put(desk.getId(), desk));
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return deskOptional;
        }
    }

    @Before("execution(* *..DeskService.addDesk(..))")
    public void addCard(JoinPoint jp) {
        Desk desk = (Desk) jp.getArgs()[0];
        cache.put(desk.getId(), desk);
    }

    @Before("execution(* *..CardService.addCard(..))")
    public void editCardName(JoinPoint jp) {
        Card card = (Card) jp.getArgs()[0];
        Desk desk = card.getDesk();
        cache.remove(desk.getId());
    }

}
