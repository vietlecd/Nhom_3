package com.javaweb.controller;

import com.javaweb.model.LoginRequest;
import com.javaweb.model.RegisterRequest;
import com.javaweb.model.mongo_entity.userData;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.CreateToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
//import java.util.List;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/refreshToken")
    public String refreshToken() {
        return "test";
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletResponse res) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        userData user = userRepository.findByUsername(username);
        LoginFunc.checkUser(user);
        if (user.getPassword().equals(password)) {
            LoginFunc.setCookie(username, password, res);

            return new ResponseEntity<>(
                    new Responses(
                            new Date(),
                            "200",
                            "Đăng nhập thành công",
                            "/auth/login"),
                    HttpStatus.OK);
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Sai tên đăng nhập hoặc mật khẩu");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req, HttpServletRequest res) {
            RegisterFunc.bodyInformationCheck(req);

            userData user = new userData(
                    req.getUsername(),
                    req.getName(),
                    req.getPassword(),
                    req.getEmail(),
                    0,
                    LoginFunc.getClientIp(res)
            );
            RegisterFunc.checkUserAndEmail(user, userRepository);

            userRepository.save(user);
            return new ResponseEntity<>(
                    new Responses(
                            new Date(),
                            "200",
                            "Đăng kí tài khoản thành công",
                            "/auth/logOut"),
                    HttpStatus.OK);
    }

    @GetMapping("/logOut")
    public ResponseEntity<?> logout(HttpServletResponse res) {
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        res.addCookie(cookie);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", new Date());
        response.put("status", "200");
        response.put("message", "Đăng xuất thành công");
        response.put("path", "/auth/logOut");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    static class RegisterFunc {
        static void checkUserAndEmail(userData userData, UserRepository userRepository) {
            if(checkUser(userData.getUsername(), userRepository)) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username này đã được đăng kí!");
            }

            if(checkEmail(userData.getEmail(), userRepository)) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email này đã được đăng kí!");
            }
        }

        static void bodyInformationCheck(@RequestBody RegisterRequest req) {
            if (req.getEmail() == null || req.getUsername() == null || req.getPassword() == null) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Không được bỏ trống thông tin!");
            }
        }

        static boolean checkUser(String user, UserRepository userRepository) {
            return userRepository.findByUsername(user) != null;
        }

        static boolean checkEmail(String email, UserRepository userRepository) {
            return userRepository.findByEmail(email) != null;
        }
    }
    static class LoginFunc {
        static List<String> getClientIp(HttpServletRequest request) {
            List<String> list = new ArrayList<>();

            String ip = request.getHeader("x-forwarded-for");
            if (ip != null && !ip.isEmpty()) {
                ip = ip.split(",")[0];
            }
            else {
                ip = request.getRemoteAddr();
            }

            list.add(ip);
            return list;
        }

        static void checkUser(userData user) {
            if(user == null) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Sai tên đăng nhập hoặc mật khẩu");
            }
        }

        static void setCookie(String username, String password, HttpServletResponse res) {
            String token = CreateToken.createToken(username, password);

            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 13);

            res.addCookie(cookie);
        }
    }

    @Data
    @AllArgsConstructor
    private class Responses{
        private Date timestamp;
        private String status;
        private String message;
        private String path;
    }
}
