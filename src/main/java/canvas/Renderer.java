package canvas;

import java.awt.*;

/**
 * @author haze
 * @date created at 2018/9/24 下午1:15
 */
public class Renderer {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
                new AlgoFrame("helloWorld",500,500);
        });
    }
}
