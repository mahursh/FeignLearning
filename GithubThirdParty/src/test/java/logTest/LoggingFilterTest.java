//package test;
//
//import com.ada.githubthirdparty.filter.LoggingFilter;
//import lombok.Setter;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.lang.reflect.Field;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class LoggingFilterTest {
//
//    @Setter
//    private LoggingFilter loggingFilter;
//
//    @Test
//    public void givenFilter_whenAutowired_thenDependencyInjected() throws Exception{
//        Assert.assertNotNull(loggingFilter);
//        Assert.assertNotNull(getField(loggingFilter , "loggingService" ));
//    }
//
//    private Object getField(Object target, String fieldName) throws NoSuchFieldException ,IllegalAccessException {
//
//        Field field = target.getClass().getDeclaredField(fieldName);
//        field.setAccessible(true);
//        return field.get(target);
//    }
//}
