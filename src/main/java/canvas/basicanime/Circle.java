package canvas.basicanime;

/**
 * @author haze
 * @date created at 2018/11/25 3:25 PM
 */
public class Circle {
    public int x, y;
    public int vx, vy;
    public int r;

    public Circle(int x, int y, int vx, int vy, int r) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.r = r;
    }

    public void move(int minX, int minY, int maxX, int maxY) {
        x += vx;
        y += vy;
        collapseCheck(minX, minY, maxX, maxY);
    }

    /*
      检测碰撞
     */
    private void collapseCheck(int minX, int minY, int maxX, int maxY) {
        //到了左边缘,则停止在距离左边缘r的坐标r
        if (x - r < minX) {
            x = r;
            vx = -vx;
        }
        if (y - r < minY) {
            y = r;
            vy = -vy;
        }
        //到了右边缘,则停止在距离右边缘r的坐标maxX-r
        if (x + r > maxX) {
            x = maxX - r;
            vx = -vx;
        }
        if (y + r > maxY) {
            y = maxY - r;
            vy = -vy;
        }
    }


}
