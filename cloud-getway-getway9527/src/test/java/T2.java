import java.time.ZonedDateTime;

public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now();  //默认时区
        System.out.println(zbj); //2022-11-19T12:41:08.862+08:00[Asia/Shanghai]
    }
}
