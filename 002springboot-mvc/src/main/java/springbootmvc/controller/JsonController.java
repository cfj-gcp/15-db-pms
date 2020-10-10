package springbootmvc.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootmvc.pojo.ResponseResult;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
@RestController//返回json字符串形式，不需要视图解析器
public class JsonController {
    @RequestMapping("/doResponseToJson")
    public ResponseResult  doResponseToJson(){
        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setMessage("ok");
        return  result;
    }
    @RequestMapping("doConverMapToJson")
    public Map<String,Object> doConverMapJson(){
        Map<String, Object> map = new HashMap<>();
        map.put("username", "刘德华");
        map.put("state", true);
        return map;
    }
    @RequestMapping("do1")
    public void  do1(HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "刘德华");
        map.put("state", true);
//      将map中的数据转换成json字符串形式
        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(map);
        System.out.println("jsonstring"+s);
//将字符串响应到客户端
//        设置响应数据点编码
        response.setCharacterEncoding("utf-8");
//     //告诉客户端,要向它响应的数据类型为text/html,编码为utf-8.请以这种编码进行数据呈现
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(s);

    }
}
