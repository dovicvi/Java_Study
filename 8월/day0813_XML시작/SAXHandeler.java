package day0813.com.ssafy.news;

import java.util.jar.Attributes;

public class SAXHandeler {
	StringBuilder b;
	boolean flag;
	News n;
	//시작태그를 만났을때
	public void startElement(String url,String localName,String qName,Attributes attributes) {
		//qName : 태그명을 얻을수 있다
		if(qName.equals("title")) flag=true;
	}
	//text데이터를 만났을때
	public void characters(char[] ch,int start,int length) {
		String str = new String (ch,start,length);
	    if(flag)System.out.println(str);
	}
	//끝태그를 만났을때
	public void endElement(String url, String localName,String qName) {
		if(qName.equals("title")) flag=false;
	}
}	