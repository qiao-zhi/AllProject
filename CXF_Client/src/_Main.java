import cn.it.ws.cxf.a.LanguageManager;
import cn.it.ws.cxf.a.LanguageService;

public class _Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LanguageManager lManager = new LanguageManager();
		LanguageService languageServicePort = lManager.getLanguageServicePort();
		String language = languageServicePort.getLanguage(1);
		System.out.println(language);
		
	}

}
