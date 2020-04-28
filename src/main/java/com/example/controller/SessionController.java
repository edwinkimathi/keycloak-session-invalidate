package com.example.controller;

import com.example.dto.SessionDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Implements an token exchange endpoint to exchange a bearer token for a session ID.
 * This is used by the "EKV Rahmenapp" to get the session ID for device local "Dienste" since they can't use the
 * front channel authentication of this application.
 * This is extra step is required by the "Anno Server" is this scenario since the it will ask this application if a
 * valid session exists.
 */
@RestController
public class SessionController {

    @GetMapping(value = "/session")
    public SessionDTO token(HttpSession session) {
        return new SessionDTO(session.getId());
    }
}
