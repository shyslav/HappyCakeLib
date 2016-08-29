package sitestorages;


import sitemodels.News;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shyshkin Vladyslav on 18.08.2016.
 */
public class NewsStorage extends HashMap<Integer, News> {
    @Override
    public News put(Integer key, News value) {
        return super.put(key, value);
    }

    /**
     * Get 3 popular _News
     * @return arraylist of popular _News
     */
    public ArrayList<News> getPopular() {
        ArrayList<News> result = new ArrayList();
        List<News> listOfNews = new ArrayList(this.values());
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

    public ArrayList<News> getByTag(String teg){
        ArrayList<News> result = new ArrayList();
        for (News element: this.values()){
            if(element.getTegs().contains(teg)){
                result.add(element);
            }
        }
        return result;
    }

    /**
     *  Get map by arraylist
     * @return arrylist of _News
     */
    public ArrayList getByArray(){
        return new ArrayList(this.values());
    }

    /**
     * Get unique tags
     * @return unique tags list
     */
    public ArrayList uniqueTagArray(){
        ArrayList result = new ArrayList();
        for (News element: this.values()){
            if(!result.contains(element.getTegs())){
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Get _News by id
     * @param id id _News
     * @return arraylist of _News
     */
    public ArrayList<News> getById(int id){
        ArrayList result = new ArrayList();
        result.add(super.get(id));
        return result;
    }

}
