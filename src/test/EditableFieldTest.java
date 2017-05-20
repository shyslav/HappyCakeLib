import com.happycake.editablemodel.EditableFieldException;
import com.happycake.editablemodel.EditableParser;
import com.happycake.sitemodels.Employees;
import com.happycake.sitemodels.EmployeesList;
import com.happycake.sitemodels.News;
import com.happycake.sitemodels.NewsList;
import com.shyslav.utils.LazyDate;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
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

    /**
     * test pattern for phone
     */
    @Test
    public void patternTestPhone() {
        Pattern p = Pattern.compile("^((\\+380|0)([0-9]{9}))?$");
        Matcher m = p.matcher("0913030595");
        assertTrue(m.matches());
    }

    /**
     * test pattern for email
     */
    @Test
    public void patternTestTextEmail() {
        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher("marinas0595@gmail.com");
        assertTrue(m.matches());

        m = p.matcher("shyslav@gmail.com");
        assertTrue(m.matches());

        m = p.matcher("shyshin.vladyslav@gmail.com");
        assertTrue(m.matches());

        m = p.matcher("agmail.com");
        assertFalse(m.matches());
    }

    /**
     * test pattern for textfield
     */
    @Test
    public void patternTestText() {
        Pattern p = Pattern.compile("[\\d\\w\\t\\n\\r\\f\\v\\W*.]{3,50}");
        Matcher m = p.matcher("some text любой текст+-.,/;:_");
        assertTrue(m.matches());

        m = p.matcher("123 213 214 test тест 321");
        assertTrue(m.matches());
    }

    /**
     * test pattern for textarea
     */
    @Test
    public void patternTestTextArea() {
        Pattern p = Pattern.compile("[\\d\\w\\t\\n\\r\\f\\v\\W*.]{3,16777215}");
        Matcher m = p.matcher("some text любой текст+-.,/;:_");
        assertTrue(m.matches());
    }

    /**
     * test pattern for numbers
     */
    @Test
    public void patternTestNumber() {
        Pattern p = Pattern.compile("[\\d]{1,11}");
        Matcher m = p.matcher("1000000");
        assertTrue(m.matches());
    }

    /**
     * test pattern for double numbers
     */
    @Test
    public void patternTestNumberDouble() {
        Pattern p = Pattern.compile("^\\d*\\.?\\d*$");
        Matcher m = p.matcher("1000000.0");
        assertTrue(m.matches());

        m = p.matcher("5.0");
        assertTrue(m.matches());

        m = p.matcher("3.932");
        assertTrue(m.matches());
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
