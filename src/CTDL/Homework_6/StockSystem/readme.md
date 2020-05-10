# StockSystem
    Thực ra là 1 người không chơi hay biết gì về 
    chứng khoán nên mình đặt tên biến kiểu vô vọng :(
    Mình có tìm hiểu nhưng cái món này nó khoai quá :( 
    
    Với bài này mình khá phân vân là liệu nó có phải 1 hệ thống đa luồng 
    hay không?

    Nhưng thực sự mình không biết mình làm gì :)) 
    
    Mình đang làm với việc tạo 1 class là user,
    có các quyền năng vô hạn như mua cổ phiếu,
    bán cổ phiếu mà mình có, hay là xóa lệnh bán cổ phiếu
    quyền năng vô hạn hiện tại mình mới chỉ biết có vậy
    
    + Với mua cổ phiếu sẽ đi tìm trong sellordersystem để xem có ông nào  
    bán cổ phiếu giá rẻ không, có thì mua không thì cho vào buy order
    + Với bán cổ phiếu thì sẽ kiểm tra mình có đủ số lượng muốn bán không
    đủ mới cho bán không thì còn khuya. Và mình sẽ chỉ đc bán value = 1 số
    chia hết cho 100 nhé, tại mình có nghĩ trường hợp khác 100 xong thì mình
    lại thấy vô vọng trong việc hiểu cái mua và bán này
    + xóa order thì chỉ là search trong Buysystem rồi xóa cái order mình có thôi
    
    Bài này mình mô phỏng lại hệ thống chứng khoán
    Có sự trao đổi giữa người dùng và hệ thống
    Mình không nghĩ được cách nào hợp lý và tối ưu cho 
    việc nếu các order đang được để lâu,
    Kiểu nó sẽ phải được cập nhật liên tục ý, để luôn check rằng cái 
    top của sellorder sẽ phải luôn lớn hơn top của buyorder và trong lúc đấy 
    thì người dùng vẫn có thể thực hiện các lệnh, mình chưa có nhiều kiến thức
    về xây dựng hệ thống như vậy nên bài này mình làm có thể nói là khá sơ sài
    