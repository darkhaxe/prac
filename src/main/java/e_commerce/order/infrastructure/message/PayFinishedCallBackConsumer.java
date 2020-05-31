package e_commerce.order.infrastructure.message;

import java.util.UUID;

/**
 * @author haze
 * @date created at 2019/10/21 2:33 下午
 */
public class PayFinishedCallBackConsumer {
    public static void main(String[] args) {
        System.out.println(
                UUID.randomUUID().toString().replace("-","")
        );
    }
}
