package canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author haze
 * @date created at 2018/9/24 下午1:16
 */
public class AlgoFrame extends JFrame {
    private int canvasWidth;

    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();

//        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
//        setSize(canvasWidth, canvasHeight);
        //设置内容面板为自定义的AlgoCanvas
        setContentPane(canvas);
        //对加载进窗口的内容进行调整布局,不调用则Panel长宽变成(0,0)
        pack();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //2-3
    private class AlgoCanvas extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //个性化绘制代码 2-3
//            g.drawOval(100, 100, 300, 300);

            //2-4 使用Graphics2D绘制
            Graphics2D g2D = (Graphics2D) g;

            //设置画笔粗细
            AlgoVisHelper.setStrokeLine(g2D, 5);
            //先画实心圆,再画空心
            g2D.setColor(Color.GRAY);
            AlgoVisHelper.drawCircle(125, 125, 250,
                    (Ellipse2D.Float ellipse) -> g2D.fill(ellipse)
            );
            g2D.setColor(Color.PINK);
            AlgoVisHelper.drawCircle(125, 125, 250,
                    (Ellipse2D.Float ellipse) -> g2D.draw(ellipse)
            );
        }


        /**
         * 设置画布大小,无需在构造器设置
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }


    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }


}
