package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bll.UserService;
import com.example.config.JwtTokenUtil;
import com.example.model.Users;
import com.example.req.UserSignInReq;
import com.example.req.UserSignUpReq;
import com.example.rsp.SingleRsp;

@RestController
@RequestMapping("/user")
public class UserController {
	// region -- Fields --

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	// end

	// region -- Methods --
	@PostMapping("/sign-in")
	public ResponseEntity<?> signIn(@RequestBody UserSignInReq req) {
		SingleRsp res = new SingleRsp();

		try {
			// Get data
			String userName = req.getUserName();
			String password = req.getPassword();

			// Handle
			Users m = userService.getBy(userName);
			if (m == null) {
				res.setError("User name doesn't exist!");
			} else {
				UsernamePasswordAuthenticationToken x;
				x = new UsernamePasswordAuthenticationToken(userName, password);
				Authentication y = authenticationManager.authenticate(x);
				SecurityContextHolder.getContext().setAuthentication(y);
				int userId = m.getId();

				// Set data
				List<SimpleGrantedAuthority> z = userService.getRole(userId);
				String t3 = jwtTokenUtil.doGenerateToken(m, z);

				res.setResult(t3);
			}
		} catch (AuthenticationException e) {
			res.setError("Invalid user name or password!");
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@RequestBody UserSignUpReq req) {
		SingleRsp res = new SingleRsp();

		try {
			// Get data
			String userName = req.getUserName();
			String firstName = req.getFirstName();
			String lastName = req.getLastName();
			String phoneNo = req.getPhoneNo();
			String address = req.getAddress();
			String remarks = req.getRemarks();

			String password = req.getPassword();
			password = bCryptPasswordEncoder.encode(password);

			// Convert data
			Users m = new Users();
			m.setUserName(userName);
			m.setFirstName(firstName);
			m.setLastName(lastName);
			m.setPhoneNo(phoneNo);
			m.setAddress(address);
			m.setRemarks(remarks);
			m.setPasswordHash(password);

			// Handle
			String tmp = userService.save(m);

			if (tmp.isEmpty()) {
				List<SimpleGrantedAuthority> z = userService.getRole(m.getId());
				String token = jwtTokenUtil.doGenerateToken(m, z);

				// Set Data
				res.setResult(token);
			} else {
				res.setError("User name has already been registed!");
			}
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// end
}