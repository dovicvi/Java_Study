package day0813.com.ssafy.news;

import java.util.List;

public interface INewsDAO {
	public List<News> getNewsList(String url);
	public News seacrch(int index);
}
