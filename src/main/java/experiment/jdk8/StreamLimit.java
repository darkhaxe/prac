package experiment.jdk8;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.primitives.Ints.asList;

/**
 * limit操作
 *
 * @author haze
 * @date created at 2020/4/3 4:11 下午
 */
public class StreamLimit {
    /**
     * 翻页
     */
    public static void main(String[] args) {
        int pageIndex = 1;
        int pageSize = 4;

        List<Integer> list = asList(61, 62, 63, 64, 65, 66, 67, 68, 69, 70);
        while (list
                .stream()
                .skip((pageIndex - 1) * pageSize)
                .limit(pageSize).count() > 0) {
            System.out.println(
                    list
                            .stream()
                            .skip((pageIndex - 1) * pageSize)
                            .limit(pageSize)
                            .collect(Collectors.toList()));
            pageIndex++;
        }


    }
}
