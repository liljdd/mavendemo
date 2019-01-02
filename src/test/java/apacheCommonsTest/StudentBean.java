package apacheCommonsTest;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lilj
 * @date 18/07/31
 */
public class StudentBean {
    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;
    private BigDecimal price;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
