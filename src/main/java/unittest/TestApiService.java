package unittest;

import org.springframework.stereotype.Component;

/**
 * @author haze
 * @date created at 2019/9/23 11:01 上午
 */
@Component
public class TestApiService {
    public String connect() {
        return "error";
    }

    public String findFromDb() {
        return "db_data";
    }
}
