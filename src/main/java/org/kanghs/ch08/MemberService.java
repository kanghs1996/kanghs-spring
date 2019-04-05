package org.kanghs.ch08;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kanghs.ch03.Member;

/**
 * p.204 [리스트 8.13]를 Main과 Service로 분리한 Service 부분
 * 
 * @author kanghs
 */
public class MemberService {

	Logger logger = LogManager.getLogger();

	MemberDao memberDao = null;

	/**
	 * memberDao setter for injection
	 */
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void selectAll() {
		List<Member> members = memberDao.selectAll(0, 100);
		logger.debug(members);
	}

	public void updateMember() {
		Member member = memberDao.selectByEmail("kanghs@naver.com");
		member.setPassword("654321");
		memberDao.update(member);
		logger.debug("Update complete.");
	}

	public void insertMember() {
		Member member = new Member();
		member.setEmail("momo7346@naver.com");
		member.setPassword("123456");
		member.setName("강현수");
		memberDao.insert(member);
		logger.debug("Insert complete.");
	}	
}
