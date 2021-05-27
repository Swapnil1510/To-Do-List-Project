import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		HashMap<String, String> itemsList = new HashMap<>();
		System.out.println("...Welcome to SRS Mall...");
		System.out.println("Items          Price");
		itemsList.put("SHIRT", "699");
		itemsList.put("BAT", "1000");
		itemsList.put("JEANS", "1200");
		itemsList.put("KURTI", "600");
		itemsList.put("SAREE", "1500");
		itemsList.put("BADMINTON", "550");
		itemsList.put("SHOES", "500");
		itemsList.put("FROCK", "400");
		itemsList.put("SCHOOL BAG", "1750");
		itemsList.put("TROLLEY BAG", "3000");

		for (Map.Entry<String, String> entry : itemsList.entrySet()) {
			System.out.println(entry.getKey() + "          " + entry.getValue());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("...Do You Want to Buy... (press 1 for Yes / 0 for No)");
		int option = Integer.parseInt(br.readLine());
		ArrayList<String> items = new ArrayList<>();

		if (option == 1) {
			String choice = "";
			do {
				System.out.println("..Which item you want to buy.. ");
				String item = br.readLine();
				String product=item.toUpperCase();
				if (itemsList.containsKey(product)) {
					items.add(product);
				} else {
					System.out.println("...This product is not available in mall...");
				}
				System.out
						.println("do you want to buy something else, if yes press 'yes' otherwiese please press 'No'");

				choice = br.readLine();

			} while (choice.equalsIgnoreCase("Yes"));

		}
		System.out.println("Items you have purchased");
		System.out.println("Items Name       Amount");
		int total = 0;
		for (String s : items) {
			System.out.println(s + "              " + itemsList.get(s));
			total = total + Integer.valueOf(itemsList.get(s));
		}
		System.out.println("Total Amount :" + total);
		System.out.println("Thank You !! Please Visit Again !! ");
	}

}
