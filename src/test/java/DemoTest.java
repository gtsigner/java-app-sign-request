import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.demo.Base64;
import com.demo.UnifiedInterceptor;
import org.junit.Test;

public class DemoTest {

    //    X-Udid: c64a11a9c335422790085bf5b3efba0f
//    X-Client-Time: 1561078679000
//    X-Sign: b0246f8e447c646a39008da4a4f676a8
//    X-AccessToken: nh7tEZwOfjFBw15ZXyROHA_JXverPP9KVRbF09iXBU8enX6l0i655EIny-mUOQ0Gyt09wYyskUZb-b_HK-0G0Ft57APMSaHYH7WfBslW2eJApTe6BY3-3O1B4fRkz_O1G-M65ZMBApdQKkkK3uBYfzEqxIlOBqpKOgIrL3xKli8
//    X-NetWork:
//    X-User-Agent: mapi/1.0 (windows 10;pc.yupaopao.bixin 6.0.1.1;windows;qt-fusion)
//    X-Authentication: 08be1712cde9e6a50c49267a501aabb4
//    Content-Type: application/json; charset=utf-8
//    Content-Length: 112
//    Connection: Keep-Alive
//    Accept-Encoding: gzip, deflate
//    Accept-Language: zh-CN,en,*
//    User-Agent: Mozilla/5.0
    @Test
    public void testDemo() {

        JSONObject object = new JSONObject();
        object.put("X-Udid", "c64a11a9c335422790085bf5b3efba0f");
        object.put("X-Client-Time", "1561078679001");
        object.put("X-Sign", "7a710cd43560c5f873de22b4537c27ae");
        object.put("X-AccessToken", "");
        object.put("X-NetWork", "");
        object.put("X-User-Agent", "mapi/1.0 (windows 10;pc.yupaopao.bixin 6.0.1.1;windows;qt-fusion)");
        String udid = "c64a11a9c335422790085bf5b3efba0f";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"");
        stringBuilder.append("X-Udid");
        stringBuilder.append("\":\"");
        stringBuilder.append("c64a11a9c335422790085bf5b3efba0f");
        stringBuilder.append("\",\"");
        stringBuilder.append("X-Client-Time");
        stringBuilder.append("\":\"");
        stringBuilder.append("1561121147000");
        stringBuilder.append("\",\"");
        stringBuilder.append("X-Sign");
        stringBuilder.append("\":\"");
        stringBuilder.append("146c4b76a751ea2c1d6c1d2a8a807d4d");
        stringBuilder.append("\",\"");
        stringBuilder.append("X-AccessToken");
        stringBuilder.append("\":\"");
        stringBuilder.append("OAX4K1H7cRNUA1aQ04KmQ0aEvhqYQ8izYcl73C8ZjGUenX6l0i655EIny-mUOQ0Gyt09wYyskUZb-b_HK-0G0Ft57APMSaHYH7WfBslW2eJApTe6BY3-3O1B4fRkz_O1G-M65ZMBApdQKkkK3uBYfzEqxIlOBqpKOgIrL3xKli8");
        stringBuilder.append("\",\"");
        stringBuilder.append("X-NetWork");
        stringBuilder.append("\":\"");
        stringBuilder.append("");
        stringBuilder.append("\",\"");
        stringBuilder.append("X-User-Agent");
        stringBuilder.append("\":\"");
        stringBuilder.append("mapi/1.0 (windows 10;pc.yupaopao.bixin 6.0.1.1;windows;qt-fusion)");
        stringBuilder.append("\"}");
        String str = UnifiedInterceptor.sign(stringBuilder.toString());
        System.out.println(UnifiedInterceptor.sign("123"));
        System.out.println(str);
    }
}
