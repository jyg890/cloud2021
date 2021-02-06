import java.time.ZonedDateTime;

/**
 * @author JYG
 * @description
 * @create 2021−02-06 2:38 下午
 */
public class T1 {
    public static void main(String[] args)
    {
        //打印时区
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);

        //2020-02-21T15:51:37.485+08:00[Asia/Shanghai]
    }
}
