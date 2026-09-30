package array_hashing.contains_duplicate;
import java.util.HashSet;
import java.util.Scanner;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> mark = new HashSet<>();

        for (int num : nums) {
            if (mark.contains(num)) {
                return true;
            }

            mark.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Nhap cac phan tu:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        boolean result = containsDuplicate(nums);

        System.out.println(result);

        sc.close();
    }
}
//Sử dụng hashSet nhanh hơn và hiệu quả hơn