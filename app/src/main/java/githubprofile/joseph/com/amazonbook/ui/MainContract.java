package githubprofile.joseph.com.amazonbook.ui;

import java.util.List;

import githubprofile.joseph.com.amazonbook.model.Book;

/**
 * Created by Admin on 2/9/2018.
 */

public interface MainContract {
    /**
     * pesenter to view
     */
    interface  View {
        public void success(List<Book> response);
        public void failed(String message);
    }

    /**
     * view  to presenter
     */
    interface  Listener {

    }


}
