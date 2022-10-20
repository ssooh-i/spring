package anno02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "myFood")      
public class MyFoodMgr {
	@Autowired
	@Qualifier(value="unfavoriteFood")
	private Food favoriteFood;  
	
	@Autowired                  
	private Food unfavoriteFood; 
	
	@Override
	public String toString() {
		return "MyFoodMgr [좋아하는 음식=" + favoriteFood + ", 싫어하는 음식=" + unfavoriteFood + "]";
	}
}
//----------------------------------------------------------------------------------
/*
//@Component  //기본값: myFoodMgr로 객체 생성(첫번째 문자만 소문자로 변환되어 bean을 만듬)
@Component(value = "myFood")     //<bean id="myFood" class="anno02.MyFoodMgr">와 동일 
public class MyFoodMgr {
	@Autowired                   //<bean id="myFood" class="anno02.MyFoodMgr" p:favoriteFood-ref="favoriteFood">    
	private Food favoriteFood;  
	
	@Autowired                   //<bean id="myFood" class="anno02.MyFoodMgr" p:unfavoriteFood-ref="unfavoriteFood">
	private Food unfavoriteFood; // @Autowired는 setter를 생략할수 있다
	
	@Override
	public String toString() {
		return "MyFoodMgr [좋아하는 음식=" + favoriteFood + ", 싫어하는 음식=" + unfavoriteFood + "]";
	}
}
*/