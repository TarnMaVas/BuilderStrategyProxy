package bsp.second_task;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;

public class MailSender {
    private static final String API_KEY = 
                                    "25d1010b2968f4bcfaea758a35f1a136";

    private static final String API_SECRET = 
                                    "2d9d0c376a12929119cfb606ad1a28e0";

    public void sendMail(MailInfo mailInfo) {
        ClientOptions options = ClientOptions.builder()
            .apiKey(API_KEY)
            .apiSecretKey(API_SECRET)
            .build();

        MailjetClient client = new MailjetClient(options);

        MailjetRequest request = new MailjetRequest(Emailv31.resource)
            .property(Emailv31.MESSAGES, new JSONArray()
                .put(new JSONObject()
                    .put(Emailv31.Message.FROM, new JSONObject()
                        .put("Email", "tarnmavas@gmail.com")
                        .put("Name", "NonSuspiciousMails"))
                    .put(Emailv31.Message.TO, new JSONArray()
                        .put(new JSONObject()
                            .put("Email", mailInfo.getClient().getEmail())
                            .put("Name", mailInfo.getClient().getName())))
                    .put(Emailv31.Message.SUBJECT, "Greetings.")
                    .put(Emailv31.Message.TEXTPART, mailInfo.generate())
                    .put(Emailv31.Message.CUSTOMID, "AppTest")));

        try {
            MailjetResponse response = client.post(request);
            System.out.println(
            "Email sent successfully. Status Code: " + response.getStatus());
        } catch (com.mailjet.client.errors.MailjetException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}