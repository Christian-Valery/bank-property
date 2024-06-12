package com.evaluation.bankProperty.controller;

import com.evaluation.bankProperty.bean.UsersBean;
import com.evaluation.bankProperty.bean.UsersToken;
import com.evaluation.bankProperty.config.JwtTokenUtil;
import com.evaluation.bankProperty.model.UsersEntity;
import com.evaluation.bankProperty.model.dto.UsersDto;
import com.evaluation.bankProperty.response.GenericJsonResponse;
import com.evaluation.bankProperty.response.ResponseStatus;
import com.evaluation.bankProperty.service.impl.UserDetailsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RequestMapping("bank_property/api/users")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthenticationController {
    private static final Logger log = LogManager.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsServiceImpl usersService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody()
    public GenericJsonResponse login(@Validated @RequestBody UsersDto usersDto) {
        log.info("dans /login, request : {}", usersDto.toString());
        try {
            String encryptedSecret = jwtTokenUtil.encryptMdp(usersDto.getPassword());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usersDto.getLogin(), usersDto.getPassword()));
            UsersEntity userLogged = usersService.getByLoginAndPassword(usersDto.getLogin(), encryptedSecret);
            if (userLogged == null) {
                log.error("Bad credentials");
                return new GenericJsonResponse(ResponseStatus.BAD_REQUEST, false);
            } else {
                UsersBean userBean = new UsersBean(userLogged.getIdusers(), userLogged.getLogin(), userLogged.getPassword(), userLogged.getName(), userLogged.getBusinessUnit(), userLogged.getContactNumber());
                UserDetails userDetails = usersService.loadUserByUsername(userLogged.getName());
                final String token = jwtTokenUtil.generateToken(userDetails);
                return new GenericJsonResponse(ResponseStatus.SUCCESS, true, new UsersToken( token, userBean));
            }
        } catch (BadCredentialsException bad) {
            log.error("Bad credentials");
            return new GenericJsonResponse(ResponseStatus.BAD_REQUEST, false);
        } catch (Exception e) {
            log.error("Internal Error Server: ", e.getMessage());
            return new GenericJsonResponse(ResponseStatus.INTERNAL_SERVER_ERROR, false);
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody()
    public GenericJsonResponse save(@RequestBody UsersBean usersBean){
        log.info("Dans la méthod /save, request : {}", usersBean.toString());
        usersBean.setPassword(jwtTokenUtil.encryptMdp(usersBean.getPassword()) );
        usersService.save(usersBean);
        return new GenericJsonResponse(ResponseStatus.SUCCESS, true, usersBean);
    }
}
