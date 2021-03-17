package com.haeyo.biz.user.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeyo.biz.user.UserService;
import com.haeyo.biz.user.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAOMybatis userDAO;

	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("유저서비스");
		return userDAO.getUser(vo);
	}
}
