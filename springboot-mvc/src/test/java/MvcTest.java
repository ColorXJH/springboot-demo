import com.master.controller.MyController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/9 13:49
 */
@SpringBootTest
public class MvcTest {

    private MockMvc mockMvc;
    @Before
    public void  setUp(){
        mockMvc= MockMvcBuilders.standaloneSetup(new MyController()).build();
    }
    @Test
    public void getUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/getUser")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())

        ;
    }
    @Test
    public void getUser1() throws Exception{
        String content=mockMvc.perform(MockMvcRequestBuilders
                .get("/getUserByName")
                .param("name","MasterXJH")//增加参数
                .param("password","123456")
                .param("age","22")
        )
                .andReturn().getResponse().getContentAsString();//获取response返回值
        System.out.println(content);
    }

    @Test
    public void testGetMyName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getName/ColorXJH")
                                              .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andDo(print());
    }
}
