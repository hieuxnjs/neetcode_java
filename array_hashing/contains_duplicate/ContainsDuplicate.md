# Bài toán: Contains Duplicate

**Link NeetCode/LeetCode:** [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)
**Độ khó:** Easy
**Chủ đề:** Arrays & Hashing

## 1. Hiểu đề bài

- **Input:** Một mảng số nguyên `nums`.
- **Output:** Trả về `true` nếu có bất kỳ giá trị nào xuất hiện **ít nhất hai lần** trong mảng. Trả về `false` nếu mọi phần tử đều khác biệt (không có phần tử trùng lặp).

## 2. Các hướng giải quyết (Approaches)

### Cách 1: Brute Force (Vét cạn - 2 vòng lặp)

- **Ý tưởng:** Dùng 2 vòng lặp lồng nhau. Lấy từng phần tử so sánh với tất cả các phần tử đứng sau nó.
- **Time Complexity:** $O(N^2)$ (Quá chậm, chắc chắn bị Time Limit Exceeded)
- **Space Complexity:** $O(1)$

### Cách 2: Sắp xếp (Sorting)

- **Ý tưởng:** Đem mảng đi sắp xếp lại. Nếu có phần tử trùng, chúng chắc chắn sẽ bị ép nằm sát cạnh nhau. Chỉ cần duyệt mảng 1 lần và so sánh `nums[i]` với `nums[i+1]`.
- **Time Complexity:** $O(N \log N)$ (Tốc độ phụ thuộc vào thuật toán sắp xếp).
- **Space Complexity:** $O(1)$ hoặc $O(N)$ tùy thuộc vào thuật toán sắp xếp của ngôn ngữ.

### Cách 3: Dùng HashSet (Tối ưu nhất - Cách đã chọn)

- **Ý tưởng:** Dùng `HashSet` đóng vai trò như một "cuốn sổ tay" lưu lại các số đã duyệt qua.
- **Time Complexity:** $O(N)$ - Duyệt mảng 1 lần, các thao tác `add` và `contains` của `HashSet` tốn $O(1)$ thời gian.
- **Space Complexity:** $O(N)$ - Trong trường hợp xấu nhất (mảng không có số trùng), `HashSet` sẽ phình to ra để lưu toàn bộ $N$ phần tử của mảng.

## 3. Kiến thức học được & Lỗi sai hay mắc (Lessons Learned)

- **Tư duy cốt lõi:** Bất cứ khi nào bài toán yêu cầu _kiểm tra sự tồn tại_, hãy nghĩ ngay đến **HashSet / HashMap**. Đây là nguyên lý **Space-time tradeoff** (Đánh đổi không gian bộ nhớ để lấy tốc độ xử lý).
- **Lỗi sai 1 (Dùng mảng đánh dấu):** Ý tưởng ban đầu là dùng `int[] mark = new int[1000001]`. Tuy nhiên, cách này sẽ gây lỗi `ArrayIndexOutOfBoundsException` vì test case trên hệ thống có chứa số âm (như `-5`), mà chỉ số mảng thì không thể âm. `HashSet` tự động băm (hash) và xử lý mượt mà cả số âm lẫn số cực lớn.
- **Lỗi sai 2 (Lỗi biên dịch missing return statement):** Trong hàm trả về `boolean`, bắt buộc phải có lệnh `return false;` ở cuối cùng (bên ngoài vòng lặp) để hệ thống biết phải trả về gì nếu chạy hết mảng mà không thấy số trùng.
- **Lỗi sai 3 (Cú pháp mảng):** Để lấy độ dài của mảng `nums` trong Java, phải dùng `nums.length` (không có dấu ngoặc đơn), dùng `nums.length()` sẽ bị báo lỗi.

## 4. Code hoàn chỉnh (Java)

```java
import java.util.HashSet;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Tạo "sổ tay" HashSet lưu trữ các số đã gặp
        HashSet<Integer> seen = new HashSet<>();

        // Duyệt qua từng số trong mảng
        for (int i = 0; i < nums.length; i++) {
            // Nếu sổ tay đã chứa số này -> Phát hiện trùng lặp
            if (seen.contains(nums[i])) {
                return true;
            }
            // Nếu chưa có, ghi nhớ số này lại
            seen.add(nums[i]);
        }

        // Duyệt xong toàn bộ mảng mà không có số nào trùng
        return false;
    }
}
```
