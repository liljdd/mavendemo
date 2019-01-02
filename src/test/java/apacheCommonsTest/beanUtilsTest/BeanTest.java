package apacheCommonsTest.beanUtilsTest;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lilj
 * @date 18/09/14
 */
public class BeanTest {
    private Integer id;
    private String name;
    private String startTime;
    private BigDecimal price;
    private Date endTime;

    public BeanTest() {
    }

    public BeanTest(Integer id, String name, String startTime, BigDecimal price, Date endTime) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.price = price;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
