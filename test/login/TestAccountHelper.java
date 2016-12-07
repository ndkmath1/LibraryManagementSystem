package login;

import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import utils.AccountHelper;

public class TestAccountHelper {

    @Test
    public void testEmail() {
        System.out.println("test email");
        assertEquals(true, AccountHelper.validateEmail("aaaaaaaaaaaa@gmail.com")); 
        assertEquals(false, AccountHelper.validateEmail("a.mail.com")); // no contains @
        assertEquals(false, AccountHelper.validateEmail("abcd@abcd")); // no contains .
        assertEquals(false, AccountHelper.validateEmail("abcdefghiabcdefghiklm@gmail.com")); // len = 31
        assertEquals(true, AccountHelper.validateEmail("abcdefghiabcdefghikl@gmail.com")); //len = 30
        assertEquals(false, AccountHelper.validateEmail("c@i.e")); // len = 5
        assertEquals(true, AccountHelper.validateEmail("c@a.vi"));// len = 6
        assertEquals(true, AccountHelper.validateEmail("ca@a.vi")); // len = 7
        assertEquals(true, AccountHelper.validateEmail("222222222@mail.hust"));
        assertEquals(false, AccountHelper.validateEmail("ab-ef@mail.com"));
    }
    
    @Test
    public void testPassword() {
        System.out.println("test password");
        assertEquals(false, AccountHelper.validatePassword("12345")); // len = 5
        assertEquals(true, AccountHelper.validatePassword("123456")); // len = 6
        assertEquals(true, AccountHelper.validatePassword("1234567")); // len = 7
        assertEquals(true, AccountHelper.validatePassword("abcde678901234567890")); // len = 20
        assertEquals(true, AccountHelper.validatePassword("abcde67890123456789")); // len = 19
        assertEquals(false, AccountHelper.validatePassword("abcde6789012345678901")); // len = 21
        assertEquals(false, AccountHelper.validatePassword("abc_mnp123"));
    }
}
