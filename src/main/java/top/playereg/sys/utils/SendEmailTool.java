package top.playereg.sys.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class SendEmailTool {
    //    test
    public static void main(String[] args) {
        sendEmail(
                "TestBot",
                "test@email.playereg.top",
                "enderg@qq.com",
                "测试邮件",
                "<html><body><h1>这是测试邮件</h1></body></html>"
        );
    }

    public static boolean sendEmail(
            String sendName,
            String from,
            String to,
            String title,
            String text
    ) {
        try {
            // 使用 Gson 读取 JSON 文件
            Gson gson = new Gson();
            FileReader reader = new FileReader("src/main/java/top/playereg/ApiKeys.json");
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            String apiKey = jsonObject.get("sendApiKey").getAsString();

            Resend resend = new Resend(apiKey);

            CreateEmailOptions params = CreateEmailOptions.builder()
                    .from(sendName + " <" + from + ">")
                    .to(to)
                    .subject(title)
                    .html(text)
                    .build();

            CreateEmailResponse data = resend.emails().send(params);
            System.out.println("邮件ID：" + data.getId());
            return true;
        } catch (ResendException e) {
            e.printStackTrace();
            return false;
        } catch (FileNotFoundException e) { // 处理文件不存在的异常
            throw new RuntimeException(e);
        }
    }
}
