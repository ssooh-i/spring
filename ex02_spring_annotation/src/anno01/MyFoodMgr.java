package anno01;

//setter, toString 추가
public class MyFoodMgr {
	private Food favoriteFood;
	private Food unfavoriteFood;
	
	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}
	
	public void setUnfavoriteFood(Food unfavoriteFood) {
		this.unfavoriteFood = unfavoriteFood;
	}
	
	@Override
	public String toString() {
		return "MyFoodMgr [좋아하는 음식=" + favoriteFood + ", 싫어하는 음식=" + unfavoriteFood + "]";
	}
}
