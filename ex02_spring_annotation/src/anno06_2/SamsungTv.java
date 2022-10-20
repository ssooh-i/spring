package anno06_2;

import org.springframework.stereotype.Component;

@Component(value = "samsung")
public class SamsungTv implements Tv{
	@Override
	public void powerOn() {
		System.out.println("SAMSUNG TV - 전원을 켠다");
	}
	@Override
	public void powerOff() {
		System.out.println("SAMSUNG TV - 전원을 끈다");
	}
	@Override
	public void volumeUp() {
		System.out.println("SAMSUNG TV - 소리를 높인다");
	}
	@Override
	public void volumeDown() {
		System.out.println("SAMSUNG TV - 소리를 줄인다");
	}
}
