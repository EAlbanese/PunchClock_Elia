package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/login")
public class LoginController {
    @Inject
    UserService loginService;
}
