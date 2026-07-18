package com.example.library_management.message;

public final class BookMessage {

    public static final String TITLE_NOT_BLANK = 
        "Tiêu đề sách không được để trống.";

    public static final String AUTHOR_NOT_BLANK = 
        "Tên tác giả không được để trống.";

    public static final String STOCK_POSITIVE = 
        "Số lượng sách tồn kho phải lớn hơn hoặc bằng 0.";

    public static final String COVER_IMAGE_EXTENSION = 
        "Tập tin ảnh bìa phải có đuôi '.jpg', '.png', '.jpeg'.";

    public static final String CREATED = 
        "Tạo sách thành công.";

    public static final String GET_PAGE = 
        "Lấy trang danh sách sách thành công.";

    public static final String NOT_FOUND =
        "Không tìm thấy sách.";
    public static final String UPDATE =
        "Cập nhật sách thành công.";
}
