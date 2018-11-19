package canvas;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.function.Consumer;

/**
 * @author haze
 * @date created at 2018/11/18 8:52 PM
 */
public class AlgoVisHelper {
    private AlgoVisHelper() {
    }

    /*
    设置画笔粗细
     */
    public static void setStrokeLine(Graphics2D g2D, int strokeWidth) {
        //p1:- p2:线条末端 p3:线条拐点
        g2D.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    /**
     * 绘制空心圆
     *
     * @param x 圆心x
     * @param y 圆心y
     * @param r 半径
     */
    public static void drawCircle(int x, int y, int r,
                                  Consumer<Ellipse2D.Float> drawFunc) {
        //绘制椭圆/圆,需要定义一个长方形/正方形 外边框 x,y代表外边框的起点,w:宽 h:高
        drawFunc.accept(new Ellipse2D.Float(x - r / 2, y - r / 2, r * 2, r * 2));
    }

    public static void setColor(Color color,Graphics2D g2D){
        g2D.setColor(color);
    }


}
