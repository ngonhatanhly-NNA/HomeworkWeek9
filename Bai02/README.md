Mức DEBUG: Được chọn để ghi lại các luồng thực thi chi tiết (ví dụ: quá trình phân tích file, lấy lịch sử giao dịch). Dữ liệu lưu lại: Các thông báo tiến trình, bước đang thực hiện.

Mức INFO: Được chọn để ghi nhận các giao dịch thành công (happy path), vì đây là dữ liệu kinh doanh cốt lõi cần theo dõi. Dữ liệu lưu lại: Số ID tài khoản, số tiền đã nạp/rút, số dư cuối cùng.

Mức WARN: Được chọn để bắt các trường hợp dữ liệu đầu vào không hợp lệ nhưng hệ thống vẫn tiếp tục hoạt động được (ví dụ: dòng trống trong file, sai định dạng tài khoản). Dữ liệu lưu lại: Chuỗi dữ liệu bị sai định dạng.

Mức ERROR: Được chọn để ghi vết khi hệ thống ném ra ngoại lệ (Exception) cản trở giao dịch. Dữ liệu lưu lại: Tên lỗi, chi tiết thông báo (e.getMessage()), và StackTrace để dễ dàng debug.