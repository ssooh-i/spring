package anno06_2;

import org.springframework.stereotype.Component;

@Component(value = "lg")
public class LgTv implements Tv {
	@Override
	public void powerOn() {
		System.out.println("LG TV - 전원을 켠다");
	}
	@Override
	public void powerOff() {
		System.out.println("LG TV - 전원을 끈다");
	}
	public void volumeUp() {
		System.out.println("LG TV - 소리를 높인다");
	}
	@Override
	public void volumeDown() {
		System.out.println("LG TV - 소리를 줄인다");
	}
}
