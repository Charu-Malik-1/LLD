package book.my.show.Booking.services;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    private final Counter dbSaveSuccess;
    private final Counter dbSaveFailure;

    private final Counter apiSuccess;
    private final Counter apiFailure;

    private final Counter paymentSuccess;
    private final Counter paymentFailure;

    public MetricsService(MeterRegistry meterRegistry) {

        // DB metrics
        dbSaveSuccess = Counter.builder("application_db_operations_total")
                .description("Total successful database operations")
                .tag("operation", "save")
                .tag("status", "success")
                .register(meterRegistry);

        dbSaveFailure = Counter.builder("application_db_operations_total")
                .description("Total failed database operations")
                .tag("operation", "save")
                .tag("status", "failure")
                .register(meterRegistry);


        // API metrics
        apiSuccess = Counter.builder("application_api_requests_total")
                .description("Total successful API requests")
                .tag("status", "success")
                .register(meterRegistry);

        apiFailure = Counter.builder("application_api_requests_total")
                .description("Total failed API requests")
                .tag("status", "failure")
                .register(meterRegistry);


        // Payment metrics
        paymentSuccess = Counter.builder("application_payment_total")
                .description("Total successful payments")
                .tag("status", "success")
                .register(meterRegistry);

        paymentFailure = Counter.builder("application_payment_total")
                .description("Total failed payments")
                .tag("status", "failure")
                .register(meterRegistry);
    }


    // =========================
    // DB Metrics
    // =========================

    public void incrementDbSaveSuccess() {
        dbSaveSuccess.increment();
    }

    public void incrementDbSaveFailure() {
        dbSaveFailure.increment();
    }


    // =========================
    // API Metrics
    // =========================

    public void incrementApiSuccess() {
        apiSuccess.increment();
    }

    public void incrementApiFailure() {
        apiFailure.increment();
    }


    // =========================
    // Payment Metrics
    // =========================

    public void incrementPaymentSuccess() {
        paymentSuccess.increment();
    }

    public void incrementPaymentFailure() {
        paymentFailure.increment();
    }
}