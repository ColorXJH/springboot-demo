import com.master.MyController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/9 10:55
 */
@SpringBootTest //系统会自动加载 springboot 容器
public class WebTest {

    private MockMvc mockMvc;
    @Before
    public void  setUp(){
        mockMvc= MockMvcBuilders.standaloneSetup(new MyController()).build();
    }
    @Test
    public void getHello() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/getName")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                /*.andDo(print())*/ //--打印输出请求和返回体
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("xjh")))
                //MockMvcResultMatchers.content():获取web请求执行后的结果，
                //Matchers.containsString("xjh")：判断返回的结果是否包含“xjh”
        ;
    }
}
