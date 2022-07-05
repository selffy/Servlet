package service;

import domain.dao.UserDao;
import domain.dao.UserDaoImpl;
import web.dto.SignupReqDto;

public class UserServiecImlp implements UserService{

	private UserDao userDao;
	
	public UserServiecImlp() {
		userDao = new UserDaoImpl();
	}

	@Override
	public boolean checkUsername(String username) throws Exception {
		return userDao.findUserByUsername(username) != null;
	}
	
	@Override
	public boolean createUser(SignupReqDto signupReqDto) throws Exception {
		System.out.println("회원가입 서비스 실행");
		System.out.println(signupReqDto);
		return userDao.save(signupReqDto.toEntity()) > 0;
	}

	@Override
	public void getUser() throws Exception {

	}

	@Override
	public boolean updateUser() throws Exception {
		return false;
	}

	@Override
	public boolean deleteUser() throws Exception {
		return false;
	}

	
}
