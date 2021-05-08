package com.org.employeemanager.resource;

import com.org.employeemanager.helper.JWTUtilHelper;
import com.org.employeemanager.model.JWTRequest;
import com.org.employeemanager.model.JWTResponse;
import com.org.employeemanager.service.CustomUserdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeeAuth")
public class JWTResource {

    @Autowired
    CustomUserdetailsService customUserdetailsService;

    @Autowired
    JWTUtilHelper jwtUtilHelper;

    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JWTRequest request) throws Exception {
        System.out.println(request);
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassWord()));
        }catch (UsernameNotFoundException exception){
            throw new Exception("Bad Credentials !!!");
        }catch (BadCredentialsException exception){
            throw new Exception("Bad Credentials !!!");
        }
        UserDetails userDetails=customUserdetailsService.loadUserByUsername(request.getUserName());
        String token=jwtUtilHelper.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(new JWTResponse(token));
    }
}
