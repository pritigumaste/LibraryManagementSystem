import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;

public class BookRepository {
    private APIService apiService;

    public BookRepository(Retrofit retrofit) {
        apiService = retrofit.create(APIService.class);
    }

    public Observable<List<Book>> getBooks() {
        return Observable.fromCallable(() -> apiService.getAllBooks().execute().body());
    }

    public Observable<Response> issueBook(String userId, String bookId) {
        return Observable.fromCallable(() -> apiService.issueBook(userId, bookId).execute().body());
    }

    public Observable<Response> returnBook(String bookId) {
        return Observable.fromCallable(() -> apiService.returnBook(bookId).execute().body());
    }
}


// public class BookRepository {
//     private APIService apiService;

//     public BookRepository(APIService apiService) {
//         this.apiService = apiService;
//     }

//     public Observable<Response> addBook(Book book) {
//         return Observable.fromCallable(() -> apiService.addBook(book).execute().body())
//             .subscribeOn(Schedulers.io());
//     }

//     public Observable<Response> issueBook(String userId, String bookId) {
//         return Observable.fromCallable(() -> apiService.issueBook(userId, bookId).execute().body())
//             .subscribeOn(Schedulers.io());
//     }
// }
