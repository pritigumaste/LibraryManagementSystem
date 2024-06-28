public class BookRepository {
    private APIService apiService;

    public BookRepository(APIService apiService) {
        this.apiService = apiService;
    }

    public Observable<Response> addBook(Book book) {
        return Observable.fromCallable(() -> apiService.addBook(book).execute().body())
            .subscribeOn(Schedulers.io());
    }

    public Observable<Response> issueBook(String userId, String bookId) {
        return Observable.fromCallable(() -> apiService.issueBook(userId, bookId).execute().body())
            .subscribeOn(Schedulers.io());
    }
}
