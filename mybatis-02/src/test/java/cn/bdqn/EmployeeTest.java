package cn.bdqn;

import cn.bdqn.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class EmployeeTest {

    @Test
    public void testQueryByName() throws Exception{

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = ssf.openSession();

        // namespsace+id
        String empName = "%王%";
        List<Employee> employees = session.selectList("cn.bdqn.mapper.EmployeeMapper.queryByName",empName);

        if(employees != null && employees.size() > 0){
            for (Employee employee:employees) {
                System.out.println(employee);
            }
        }

        is.close();
        session.close();
    }

    // 改造版
    @Test
    public void testQueryByName_2() throws Exception{

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = ssf.openSession();

        // namespsace+id
        String empName = "王";
        List<Employee> employees = session.selectList("cn.bdqn.mapper.EmployeeMapper.queryByName_2",empName);

        if(employees != null && employees.size() > 0){
            for (Employee employee:employees) {
                System.out.println(employee);
            }
        }

        is.close();
        session.close();
    }

    // 改造版2，最完美的
    @Test
    public void testQueryByName_3() throws Exception{

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = ssf.openSession();

        // namespsace+id
        String empName = "王";
        List<Employee> employees = session.selectList("cn.bdqn.mapper.EmployeeMapper.queryByName_3",empName);

        if(employees != null && employees.size() > 0){
            for (Employee employee:employees) {
                System.out.println(employee);
            }
        }

        is.close();
        session.close();
    }

    @Test
    public void testInsert() throws Exception{

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = ssf.openSession();

        // namespsace+id
        Employee employee = new Employee();
        employee.setBirthday(new Date());
        employee.setEmail("chongchong@163.com");
        employee.setSex("女");
        employee.setEmpName("史周冲的小姨子");
        employee.setAddress("洛阳寡妇村");

        session.insert("cn.bdqn.mapper.EmployeeMapper.insert",employee);

        System.out.println("返回自增主键的id:");
        System.out.println(employee.getId());

        session.commit();

        is.close();
        session.close();
    }

    @Test
    public void testInsert_2() throws Exception{

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = ssf.openSession();

        // namespsace+id
        Employee employee = new Employee();
        employee.setBirthday(new Date());
        employee.setEmail("chongchong@163.com");
        employee.setSex("女");
        employee.setEmpName("史周冲的小姨妈");
        employee.setAddress("洛阳寡妇村");

        session.insert("cn.bdqn.mapper.EmployeeMapper.insert_2",employee);

        System.out.println("返回自增主键的id:");
        System.out.println(employee.getId());

        session.commit();

        is.close();
        session.close();
    }
}
