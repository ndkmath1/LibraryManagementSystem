package databasehelper;

import java.util.Locale;
import model.BookCopy;
import model.CatetoryBook;

public class BookSQLStatement {
    public final class BookTable{
        public static final String TABLE_NAME = "book";
        public static final String ID_COL = "id";
        public static final String AUTHOR_COL = "authors";
        public static final String PUBLISHER_COL = "publisher";
        public static final String IBNS_COL = "isbn";
        public static final String TITLE_COL = "title";
        public static final String CATEID_COL = "cate_id";
        public static final String BOOKID_COL = "book_id";
    }
    
    public final class CategoryBookTable{
        public static final String TABLE_NAME = "category";
        public static final String ID_COL = "id";
        public static final String CATE_CODE_COL = "cate_code";
        public static final String CATEE_NAME_COL = "cate_name";
    }
    
    public final class BookCopyTable{
        public static final String TABLE_NAME = "book_copy";
        public static final String ID_COL = "id";
        public static final String BOOKID_COL = "book_id";
        public static final String EMAIL_COL = "email";
        public static final String PASSWORD_COL = "password";
        public static final String STUDENT_ID_COL="student_id";
    }
    
    public static final String QUERY_GET_ALL_CATEGORY="SELECT * FROM "+CategoryBookTable.TABLE_NAME;
    
    public static final String QUERY_GET_NUM_OF_BOOK_WITH_CATEGORY="SELECT COUNT("+BookTable.ID_COL+") FROM "+BookTable.TABLE_NAME
            +" WHERE "+BookTable.CATEID_COL+"=?";
    
    public static final String QUERY_SAVE_NEW_BOOK="INSERT INTO "+BookTable.TABLE_NAME+" VALUES(null, ?, ?, ?, ?, ?, ?)";
    
    public static final String QUERY_CHECK_BOOK_NUMBER="SELECT "+BookTable.ID_COL+" FROM "+BookTable.TABLE_NAME+" WHERE "+BookTable.CATEID_COL+"=? AND "+BookTable.BOOKID_COL+"=?";
    
    public static final String QUERY_IS_BOOK_EXISTED="SELECT "+BookTable.ID_COL+" FROM "+BookTable.TABLE_NAME+
            " WHERE "+BookTable.TITLE_COL+"=? AND +"+BookTable.PUBLISHER_COL+"=? AND "+BookTable.AUTHOR_COL+"=?";
    
    public static final String  QUERY_SAVE_NEW_BOOK_COPY="INSERT INTO "+BookCopyTable.TABLE_NAME+" VALUES(null, ?, ?, ?, ?)";
    
    public static final String QUERY_GET_NUM_OF_COPY_BOOK="SELECT COUNT("+BookCopyTable.ID_COL+") FROM "+BookCopyTable.TABLE_NAME+" WHERE "+BookCopyTable.BOOKID_COL+"=?";

    public static final String QUERY_SEARCH_BOOK_BY_ID="SELECT * FROM "+BookTable.TABLE_NAME+", "+CategoryBookTable.TABLE_NAME
            +" WHERE "+BookTable.TABLE_NAME+"."+BookTable.CATEID_COL+"="+CategoryBookTable.TABLE_NAME+"."+CategoryBookTable.ID_COL
            +" AND concat("+CategoryBookTable.CATE_CODE_COL+","+BookTable.BOOKID_COL+") LIKE ?";
    
    public static final String QUERY_SEARCH_BOOK_BY_NAME="SELECT * FROM "+BookTable.TABLE_NAME+" WHERE "+BookTable.TITLE_COL+" LIKE ?";
    
    public static final String QUERY_SEARCH_BOOK_BY_AUTHOR="SELECT * FROM "+BookTable.TABLE_NAME+" WHERE "+BookTable.AUTHOR_COL+" LIKE ?";
    
    public static final String QUERY_SEARCH_BOOK_BY_PUBLISHER="SELECT * FROM "+BookTable.TABLE_NAME+" WHERE "+BookTable.PUBLISHER_COL+" LIKE ?";

    public static final String QUERY_GET_BOOK_COPY="SELECT * FROM "+BookCopyTable.TABLE_NAME+" WHERE "+BookCopyTable.BOOKID_COL+"=?";
}

