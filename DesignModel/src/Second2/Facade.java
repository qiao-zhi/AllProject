package Second2;
public class Facade {
	private Music music;
	private Photo photo;
	private PhoneNum phoneNum;
	private Message message;
	public void copy(){
		music = new Music();
		photo = new Photo();
		phoneNum = new PhoneNum();
		message = new Message();
		music.copy();
		photo.copy();
		phoneNum.copy();
		message.copy();
	}
}
