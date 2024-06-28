import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import javax.inject.Inject;

public class StudentActivity extends AppCompatActivity {
    @Inject
    BookRepository bookRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        ((MyApp) getApplication()).getAppComponent().inject(this);

        // Handle student-specific functionalities like issuing or returning books
    }

    public void issueBook(String userId, String bookId) {
        bookRepository.issueBook(userId, bookId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onBookIssued, this::handleError);
    }

    private void onBookIssued(Response response) {
        // Handle response after book is issued
    }

    private void handleError(Throwable throwable) {
        // Handle errors
    }
}
