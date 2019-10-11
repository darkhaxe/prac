package unittest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author haze
 * @date created at 2019/9/23 11:01 上午
 */
@Component
public class ApiService {
    @Autowired
    private TestApiService testApiService;

    public String test() {
        String connect = testApiService.connect();
        connect += "test";//test自己的业务
        return connect;
    }
}
