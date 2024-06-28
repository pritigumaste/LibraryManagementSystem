import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    @GET("books")
    Call<List<Book>> getAllBooks();

    @POST("books/issue")
    Call<Response> issueBook(@Query("userId") String userId, @Query("bookId") String bookId);
    
    @POST("books/return")
    Call<Response> returnBook(@Query("bookId") String bookId);
}
