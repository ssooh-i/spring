package anno04;
import org.springframework.stereotype.Component;
@Component
public class KoreaTire implements Tire{
	@Override
	public String getBrand() {
		return "한국타이어";
	}
}
