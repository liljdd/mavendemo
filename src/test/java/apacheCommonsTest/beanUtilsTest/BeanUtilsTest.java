package apacheCommonsTest.beanUtilsTest;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @author lilj
 * @date 18/09/14
 */
public class BeanUtilsTest {
    /**
     * bean--->bean
     */
    @Test
    public void test01() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        BeanTest b1 = new BeanTest(1, "jim", "2019-09-14", new BigDecimal("19.11"), new Date());
        System.out.println(b1);
        String s1 = JSONObject.toJSONString(b1);
        System.out.println("s=" + s1);
        BeanTest b2 = new BeanTest();
        BeanTest b3 = new BeanTest();
        BeanUtils.copyProperties(b2, b1);
        PropertyUtils.copyProperties(b3, b1);
        System.out.println(b2);
        System.out.println("b2=" + JSONObject.toJSONString(b2));
        System.out.println("b3=" + JSONObject.toJSONString(b3));
    }

    @Test
    public void test02() {
        BeanTest b1 = new BeanTest(null, "jim", "2019-09-14", new BigDecimal("19.11"), null);
        JSONObject j1 = (JSONObject) JSONObject.toJSON(b1);
        BeanTest b2 = JSONObject.toJavaObject(j1, BeanTest.class);
        System.out.println("b2=" + b2);
        System.out.println("j2=" + JSONObject.toJSONString(b2));
    }

    /**
     * 复制
     */
    @Test
    public void test03() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BeanTest b1 = new BeanTest(1, "jim", "2019-09-14", new BigDecimal("19.11"), new Date());
        System.out.println(b1);
        BeanTest b2 = (BeanTest)BeanUtils.cloneBean(b1);
        System.out.println(b2);
    }

    /**
     * bean-->map
     * map-->bean
     */
    @Test
    public void test04() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        BeanTest b1 = new BeanTest(1, "jim", "2019-09-14", new BigDecimal("19.11"), new Date());
        Map map = BeanUtils.describe(b1);
        for (Object key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }
        BeanTest b2 = new BeanTest();
        //map.remove("class");
        map.remove("endTime");
        BeanUtils.populate(b2,map);
        System.out.println(b1);
        System.out.println(b2);

    }

}

