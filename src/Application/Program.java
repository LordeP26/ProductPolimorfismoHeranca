package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		List<Product> list = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			System.out.println("Product #" + (i+1) + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, customsFee);
				list.add(product);
			}else if (ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				Product product = new UsedProduct(name, price, date);
				list.add(product);
			}else {
				Product product = new Product(name, price);
				list.add(product);
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS");
		for(Product product : list) {
			System.out.println(product.priceTag());
		}
		
		
		sc.close();
	}

}
