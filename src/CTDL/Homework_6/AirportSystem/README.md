# AirportSystem
   
    Đây là bài tập mô phỏng hệ thống sân bay
    Các bạn có thể test trong file Main.java
    Mình đã code với 1 cái AirplaneSystem 
    Với mục đích cơ bản là để thêm các máy bay các loại
    Mình để là HeapPriorityQueue luôn vì mình muốn nó tối ưu time luôn
    Các bạn và thầy cô hoàn toàn có thể chuyển về các file của bài 1, 
    Thay mỗi phần khai báo là có thể sử dụng được
    Chỉ khác nhau mình để removeMin và removeTop
    (Nếu các bạn chuyển phải rất cẩn thận đừng quên removeTop hay Min, rất dễ bị lặp  vô hạn nha <3), 
    vì ở Heap mình k muốn trùng tên lắm, điều này có thể sửa được
    Nó cũng  chỉ là tên khai báo thôi :v 
    
    AirplaneSystem có 2 tham số là Date và Airplane đại diện cho
    Thời gian máy bay sắp cất cánh
        - Airplane thì có full thông tin về chuyến bay của hãng đó
        - Date là timeStart của máy bay, key của system
    
    Như các bạn có thể thấy mình để 3 loại máy bay là:
        +) VietNamAirline
        +) Vietjet
        +) Bamboo
    
    Mình có 2 kiểu add là add 1 loạt  các máy bay vào System
        -) Sử dụng phương thức removeTop để lấy máy bay có nhãn time nhỏ nhất
        -) Sử dụng phương thức insert để thêm máy bay mới vào System

    Ở file  initialization mình có để 2 loại là:
        create All máy bay các hãng    
        create All máy bay của từng hãng
    
    Hoặc các bạn thích có thể thêm 1 máy bay riêng, ở Main mình cũng vdu khá rõ rồi 
    
## Contact

    https://www.facebook.com/parkouryb