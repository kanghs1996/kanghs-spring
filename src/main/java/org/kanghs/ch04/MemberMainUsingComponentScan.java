package org.kanghs.ch04;

import org.kanghs.ch03.RegisterRequest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMainUsingComponentScan {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("chap04.xml");
		MemberRegisterService regService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
		
		//registerRequest 초기화
		RegisterRequest req = new RegisterRequest();
		req.setEmail("kanghs@exmaple.com");
		req.setPassword("0000");
		req.setName("kanghs");
		
		//회원 등록 
		regService.regist(req);
		ctx.close();
		
	}
}
