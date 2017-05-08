import com.happycake.editablemodel.EditableFieldException;
import com.happycake.editablemodel.EditableParser;
import com.happycake.sitemodels.Employees;
import com.happycake.sitemodels.EmployeesList;
import com.happycake.sitemodels.News;
import com.happycake.sitemodels.NewsList;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Shyshkin Vladyslav on 08.05.17.
 */
public class EditableFieldTest {
    @Test
    public void parseNewsTest() throws ClassNotFoundException, EditableFieldException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        EditableParser parser = new EditableParser(loadNews());
        assertNotNull(parser);
        assertTrue(parser.getModelName().equalsIgnoreCase("Новости"));
        assertTrue(parser.getEntityHashMap().size() == 5);
        assertTrue(parser.getEntityHashMap().get("authorID").getSelectableMap().size() == 1);
        assertTrue(parser.getEntityHashMap().get("authorID").getFieldName().equals("Автор"));
        assertTrue(parser.getEntityHashMap().get("authorID").getValue().equals(1));
        assertTrue(parser.getEntityHashMap().get("authorID").checkWithRegExp());
    }

    private News loadNews() {
        News news = new News();
        news.setAuthorID(1);
        news.setName("name");
        news.setTegs("tags");
        news.setText("text");

        NewsList list = new NewsList();
        list.add(news);

        Employees emp = new Employees();
        emp.setId(1);
        emp.setLogin("login");
        emp.setPassword("password");
        emp.setName("test name");
        EmployeesList employees = new EmployeesList();
        employees.add(emp);

        return news;
    }
}
