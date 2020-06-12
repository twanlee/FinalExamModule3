package utils;

public class Constant {
        public static final String SELECT_ALL_PRODUCT = "call select_all_product();";
        public static final String SELECT_PRODUCT_ID = "call select_product_by_id(?);";
        public static final String DELETE_PRODUCT_ID = "call delete_product(?);";
        public static final String UPDATE_PRODUCT = "call update_product(?,?,?,?,?);";
        public static final String ADD_PRODUCT = "call call add_product(?,?,?,?,?);";
        public static final String FIND_PRODUCT_BY_NAME = "select * from products p join category c on p.product_cate_id=c.category_id where product_name like ?;";
}
