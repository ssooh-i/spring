package com.ssafy.main;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

//WARN을 로그 레벨로 지정을 하게 되면 그 아래 WARN, ERROR, FATAL까지 로그가 찍히게 된다.
public class Log4JTest {
	private static Logger log = Logger.getLogger(Log4JTest.class);
	   
	   public static void main(String[] args) {
	      log.setLevel(Level.WARN);    // WARN 을 로그레벨로 지정

	      log.trace("Trace Message!");
	      log.debug("Debug Message!");
	      log.info("Info Message!");
	      log.warn("Warn Message!");   // WARN 보다 높은 레벨이 로그에 찍힌다.
	      log.error("Error Message!");
	      log.fatal("Fatal Message!");
	   }
}
/*
[log4j - Logging Levels(로그 레벨)]
회사에서 업무를 하게 되면 무분별한 로그때문에 로그 확인시 어려움을 겪게된다.
불필요한 로그로 인해 비즈니스 로그를 찾기 힘들다.
로깅레벨은 ALL,OFF포함 7단계지만, 보통은 5단계를 말한다.
DEBUG
INFO
WARN
ERROR
FATAL

ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
*/