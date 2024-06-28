import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import javax.inject.Inject;

public class LibrarianActivity extends AppCompatActivity {
    @Inject
    BookRepository bookRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarian);
        ((MyApp) getApplication()).getAppComponent().inject(this);

        // Handle librarian-specific functionalities like adding or removing books
    }

    public void addBook(Book book) {
        bookRepository.addBook(book)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onBookAdded, this::handleError);
    }

    private void onBookAdded(Response response) {
        // Handle response after book is added
    }

    private void handleError(Throwable throwable) {
        // Handle errors
    }
}
