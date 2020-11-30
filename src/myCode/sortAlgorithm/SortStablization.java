package myCode.sortAlgorithm;

import java.util.Arrays;

public class SortStablization {
    public static void bubbleSort1(Product[] product){
        boolean flag = false;
        for (int i=0;i < product.length-1 ; i++) {
            flag = false;
            System.out.println("当前第"+(i+1)+"轮状态"+ Arrays.toString(product));
            for (int j = product.length-1 ; j>1; j--){
                if (product[j].compareTo(product[j-1])<0) {//有等号，排序算法不稳定。相同元素会被交换
                    Product temp = product[j];
                    product[j] = product[j-1];
                    product[j-1] = temp;
                }
                System.out.println("当前第"+(i+1)+"轮状态"+ Arrays.toString(product));
            }
            //优化
            if (!flag) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        Product product1 = new Product(3, 10);
        Product product2 = new Product(2, 9);
        Product product3 = new Product(1, 9);
        Product product4 = new Product(0, 9);
        Product[] products = new Product[]{product1, product2, product3, product4};
        bubbleSort1(products);
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}

