package com.lcwd.user.service.controller;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    private Logger logger = LoggerFactory.getLogger(UserController.class);


    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@RequestBody User user){

        User user1 = userServices.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/getallusers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServices.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    int retryCount=1;

    @GetMapping("/getuser/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod ="ratingHotelFallBack" )
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        logger.info("retrycount : {}",retryCount);
        retryCount++;
        User user = userServices.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    //creating fall back method for circuit breaker
    //Here return type of fallback method will be same as the method for which circuit breaker is written

    public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex ){
            logger.info("Fallback is executed because service is down : ", ex.getMessage());
        User user = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy because some service is down")
                .userId("141234")
                .build();
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);

    }


}
