import com.master.controller.UserController;
import com.master.model.UserBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/11 16:34
 */
@SpringBootTest
public class TestController {
    @Resource
    private UserBean properties;

    @Value("${colorxjh.name}")
    private String name;

    private MockMvc mockMvc;
    @Before
    public void setUp(){
        mockMvc= MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
    @Test
    public void testUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/saveUser")
        .param("name","ColorXJH")
        .param("age","110"));
    }
    @Test
    public void testFilter1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/my/name"));
    }
    //在测试类包中无法读取他们的数据，但是在java包中他们的数据是正确的
    @Test
    public void testYml(){
        System.out.println(name);
        System.out.println(properties);
    }
}
