// Submit metrics returns "Payload accepted" response
import com.datadog.api.client.ApiClient;
import com.datadog.api.client.ApiException;
import com.datadog.api.client.v2.api.MetricsApi;
import com.datadog.api.client.v2.model.IntakePayloadAccepted;
import com.datadog.api.client.v2.model.MetricIntakeType;
import com.datadog.api.client.v2.model.MetricPayload;
import com.datadog.api.client.v2.model.MetricPoint;
import com.datadog.api.client.v2.model.MetricResource;
import com.datadog.api.client.v2.model.MetricSeries;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) {
        ApiClient defaultClient = ApiClient.getDefaultApiClient();
        MetricsApi apiInstance = new MetricsApi(defaultClient);

        String api_key = "7276e037fed5a44a1968672dae7577fd";
        String app_key = "79c2e03d7220f018c2b880657f476a11121295fe";

        HashMap<String,String> secret = new HashMap<>();

        secret.put("apiKeyAuth",api_key);
        secret.put("appKeyAuth",app_key);

        defaultClient.setBasePath("https://us5.datadoghq.com/");
        defaultClient.configureApiKeys(secret);


        MetricPayload body =
                new MetricPayload()
                        .series(
                                Collections.singletonList(
                                        new MetricSeries()
                                                .metric("sada.SYS.hits1")
                                                .type(MetricIntakeType.COUNT)
                                                .points(
                                                        Collections.singletonList(
                                                                new MetricPoint()
                                                                        .timestamp(OffsetDateTime.now().toInstant().getEpochSecond())
                                                                        .value(ThreadLocalRandom.current().nextDouble(0.5, 1.0))))
                                                .resources(
                                                        Collections.singletonList(
                                                                new MetricResource().name("SadanandMachine").type("host")))));

        try {
            int i = 0 ;
            while(i<=100) {
                IntakePayloadAccepted result = apiInstance.submitMetrics(body);
                System.out.println(result);
                i++;
            }
        } catch (ApiException e) {
            System.err.println("Exception when calling MetricsApi#submitMetrics");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
