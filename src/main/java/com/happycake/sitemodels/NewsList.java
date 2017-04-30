package com.happycake.sitemodels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Shyshkin Vladyslav
 */
public class NewsList extends ArrayList<News> {
    private HashMap<Integer, News> map = new HashMap<>();

    @Override
    public boolean add(News news) {
        map.put(news.getId(), news);
        return super.add(news);
    }

    /**
     * Get News by id
     *
     * @param id category id
     * @return category by id
     */
    public News getByID(int id) {
        return map.get(id);
    }

    /**
     * Get 3 popular _News
     *
     * @return arraylist of popular _News
     */
    public ArrayList<News> getPopular() {
        NewsList result = new NewsList();
        List<News> listOfNews = new ArrayList(this);
        listOfNews.sort((e1, e2) -> e2.getView() - e1.getView());
        int end = 3;
        if (end > listOfNews.size()) {
            end = listOfNews.size();
        }
        for (int i = 0; i < end; i++) {
            result.add(listOfNews.get(i));
        }
        return result;
    }

    /**
     * Get by tag
     *
     * @param tag tag name
     * @return tag
     */
    public ArrayList<News> getByTag(String tag) {
        ArrayList<News> result = new ArrayList<>();
        for (News element : this) {
            if (element.getTags().contains(tag)) {
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Get unique tags
     *
     * @return unique tags list
     */
    public ArrayList uniqueTagArray() {
        ArrayList result = new ArrayList();
        for (News element : this) {
            if (!result.contains(element.getTags())) {
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Get news list by ids array
     *
     * @param ids ids
     * @return news list by ids
     */
    public NewsList getByIDS(int[] ids) {
        NewsList list = new NewsList();
        for (int id : ids) {
            News news = map.get(id);
            if (news != null) {
                list.add(news);
            }
        }
        return list;
    }
}
