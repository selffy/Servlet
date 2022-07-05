package service;

import web.dto.SignupReqDto;

public interface UserService {
	public boolean checkUsername(String username) throws Exception;
	public boolean createUser(SignupReqDto signupReqDto) throws Exception;
	public void getUser() throws Exception; //로그인할때 user정보 가지고 옴
	public boolean updateUser() throws Exception;
	public boolean deleteUser() throws Exception;
	
}
