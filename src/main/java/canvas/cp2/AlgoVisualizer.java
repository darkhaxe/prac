package canvas.cp2;

import canvas.cp2.basicanime.Circle;

import java.awt.*;
import java.util.Arrays;

/**
 * @author haze
 * @date created at 2018/12/18 1:35 PM
 */
public class AlgoVisualizer {
    private Circle[] circles;
    private AlgoFrame frame;

    public AlgoVisualizer(int sceneHeight,
                          int sceneWidth,
                          int N) {
        circles = new Circle[N];
        int R = 50;
        for (int i = 0; i < N; i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * R)) + R;
            int y = (int) (Math.random() * (sceneWidth - 2 * R)) + R;
            //速度(-5,+5),小圆将向不同方向运动
            int vx = (int) (Math.random() * 11) - 5;
            int vy = (int) (Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, vx, vy, R);
        }

        EventQueue.invokeLater(() -> {
            //       2-1~2-5     new AlgoFrame("helloWorld", 500, 500);
            frame = new AlgoFrame("helloWorld", sceneWidth, sceneHeight);
            render(sceneHeight, sceneWidth);

        });
    }

    private void render(int sceneHeight, int sceneWidth) {


//为什么使用线程,因为如果直接while死循环放在事件派发队列中,会导致其他的ui等组件无法工作;
// 在事件派发队列中的代码应该是可以迅速结束的
        new Thread(() -> {

            while (true) {
                //绘制数据
                frame.render(circles);
                pause(20);
                //更新
                Arrays.stream(circles).forEach((Circle c) ->
                        c.move(0, 0, sceneWidth, sceneHeight));
            }
        }).start();
    }


    private static void pause(long millSec) {
        try {
            Thread.sleep(millSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
