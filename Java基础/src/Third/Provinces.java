package Third;

import javax.swing.JComboBox;

public class Provinces {

    private static JComboBox prvc = new JComboBox();;

    public static JComboBox getPrvcList(String country){

		if(country.equals("Canada")){
		   prvc.addItem("New Brunswick");
		   prvc.addItem("Nova Scotia");
		   prvc.addItem("Ontario");
		   prvc.addItem("Qu��bec");
		   prvc.addItem("Manitoba");
		   prvc.addItem("British Columbia");
		   prvc.addItem("Prince Edward Island");
		   prvc.addItem("Alberta");
		   prvc.addItem("Saskatchewan");
		   prvc.addItem("Newfoundland-Labrador");
		   prvc.addItem("Northwest Territories");
		   prvc.addItem("Yukon Territory");
		   prvc.addItem("Nunavut Territory");

		}
		else if (country.equals("USA")) {
		   prvc.addItem("Alabama");
		   prvc.addItem("Alaska ");
		   prvc.addItem("Arizona");
		   prvc.addItem("Arkansas");
		   prvc.addItem("California");
		   prvc.addItem("Colorado");
		   prvc.addItem("Connecticut");
		   prvc.addItem("Delaware");
		   prvc.addItem("District of Columbia");
		   prvc.addItem("Florida");
		   prvc.addItem("Georgia");
		   prvc.addItem("Hawaii");
		   prvc.addItem("Idaho");
		   prvc.addItem("Illinois");
		   prvc.addItem("Indiana");
		   prvc.addItem("Iowa");
		   prvc.addItem("Kansas");
		   prvc.addItem("Kentucky");
		   prvc.addItem("Louisiana");
		   prvc.addItem("Maine");
		   prvc.addItem("Maryland");
		   prvc.addItem("Massachusetts");
		   prvc.addItem("Michigan");
		   prvc.addItem("Minnesota");
		   prvc.addItem("Mississippi");
		   prvc.addItem("Missouri");
		   prvc.addItem("Montana");
		   prvc.addItem("Nebraska");
		   prvc.addItem("Nevada");
		   prvc.addItem("New Hampshire");
		   prvc.addItem("New Jersey");
		   prvc.addItem("New Mexico");
		   prvc.addItem("New York");
		   prvc.addItem("North Carolina");
		   prvc.addItem("North Dakota");
		   prvc.addItem("Ohio");
		   prvc.addItem("Oklahoma");
		   prvc.addItem("Oregon");
		   prvc.addItem("Pennsylvania");
		   prvc.addItem("Rhode Island");
		   prvc.addItem("South Carolina");
		   prvc.addItem("South Dakota");
		   prvc.addItem("Texas");
		   prvc.addItem("Utah");
		   prvc.addItem("Vermont");
		   prvc.addItem("Virginia");
		   prvc.addItem("Virgin Islands");
		   prvc.addItem("Washington");
		   prvc.addItem("West Virginia");
		   prvc.addItem("Wisconsin");
		   prvc.addItem("Wyoming");
		}

		else if (country.equals("China")){
           prvc.addItem("�ӱ�");
		   prvc.addItem("����");
		   prvc.addItem("���");
		   prvc.addItem("ɽ��");
		   prvc.addItem("ɽ��");
		   prvc.addItem("����");
		   prvc.addItem("����");
		   prvc.addItem("������");
		   prvc.addItem("����");
		   prvc.addItem("����");
		   prvc.addItem("����");
		   prvc.addItem("�㶫");
		   prvc.addItem("����");
		   prvc.addItem("̨��");
		   prvc.addItem("�Ĵ�");
		   prvc.addItem("����");
		   prvc.addItem("����");
		   prvc.addItem("����");
		   prvc.addItem("����");
		   prvc.addItem("����");
		   prvc.addItem("�㽭");
		   prvc.addItem("�ຣ");
		   prvc.addItem("�½�ά�����������");
		   prvc.addItem("���ɹ�������");
		   prvc.addItem("���Ļ���������");
		   prvc.addItem("����������");
		   prvc.addItem("����׳��������");
		   prvc.addItem("������");
		   prvc.addItem("�����");
		   prvc.addItem("������");
		   prvc.addItem("�Ϻ���");
		   prvc.addItem("���� ");
		   prvc.addItem("���");
		   prvc.addItem("̨��");
		}
	   return prvc;
	}
}
