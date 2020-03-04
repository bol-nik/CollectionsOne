
import java.util.*;
import java.util.Map.Entry;

public class Nik {
	public static Map<String, String> change(Map<String, String> a) {

		if (a.containsKey("ice cream")) {
			a.put("ice cream", "cherry");
		}
		a.put("bread", "butter");

		return (HashMap<String, String>) a;
	}
	
	public static <T,P> void Show(Map<T, P> topping1)  {
		for (Entry<T, P> item : topping1.entrySet()) {

			System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
		}
	}
	
	public static String[] allSwap(final String[] strings) {
	    // map of first characters, and the index where they were last seen
	    final Map<Character, Integer> potentialSwap = new HashMap<>();

	    for (int thisIndex = 0; thisIndex < strings.length; thisIndex++) {
	        if (strings[thisIndex].isEmpty()) {
	            continue; // skip empty strings
	        }

	        final Character firstChar = strings[thisIndex].charAt(0); // box charAt(0)
	        // remove firstChar from the map. If it's not found, returns null
	        final Integer potentialIndex = potentialSwap.remove(firstChar);

	        if (potentialIndex != null) {
	            final int thatIndex = potentialIndex; // unbox potentialIndex
	            // swap values at thisIndex and thatIndex
	            final String temp = strings[thatIndex];
	            strings[thatIndex] = strings[thisIndex];
	            strings[thisIndex] = temp;
	        } else {
	            // save the index for possible swapping later
	            potentialSwap.put(firstChar, thisIndex); // box thisIndex
	        }
	    }

	    return strings;
	}

	public static void main(String[] args) {
//		Измените и верните данную карту следующим образом: если у ключа «a» есть значение, 
		//припишите это значение ключу «b» и установите ключ «a» в пустое значение – «». 
		//По сути, «b» - это хулиган, который забирает значение и заменяет его пустой строкой.
//		mapBully({"a": "candy", "b": "dirt"}) → {"a": "", "b": "candy"}
//		mapBully({"a": "candy"}) → {"a": "", "b": "candy"}
//		mapBully({"a": "candy", "b":"carrot","c": "meh"}) → {"a":"","b":"candy", "c": "meh"}

		Scanner in = new Scanner(System.in);
		String a;
		Map<Character, String> mapBully = new HashMap<Character, String>();

		String choice;
		for (int i = 97; i < 123; i++) {
			System.out.println("Введите строку");
			a = in.nextLine();
			mapBully.put((char) i, a);
			if (i == 97) {
				i++;
				mapBully.put((char) i, mapBully.get((char) 97));
				mapBully.replace((char) 97, "");
			}
			System.out.println("Ввести еще строку?(Y/N)");
			do {
				choice = in.next();

			} while (!choice.equals("N") && !choice.equals("n") && !choice.equals("Y") && !choice.equals("y"));
			in.nextLine();
			if (choice.equals("N") || choice.equals("n")) {
				break;
			}

		}
		Show(mapBully);
		in.close();
		// -----------------------------------------------------------------------------
//		При заданной карте ключей продуктов питания и основных значений измените и 
		//верните карту следующим образом: если ключ «мороженое» присутствует, 
		//установите его значение «вишня». Во всех случаях установите ключ «хлеб», чтобы иметь значение «масло».
//		topping1({"ice cream": "peanuts"}) → {"bread": "butter", "ice cream": "cherry"}
//		topping1({}) → {"bread": "butter"}
//		topping1({"pancake": "syrup"}) → {"bread": "butter", "pancake": "syrup"}

		System.out.println("---------------------------------------------------------------");
		Map<String, String> topping1 = new HashMap<String, String>();
		topping1.put("ice cream", "peanuts");
		System.out.println("До изменения:");
		Show(topping1);
		topping1=change(topping1);
		System.out.println("После изменения");
		Show(topping1);
		System.out.println();System.out.println();
		
		System.out.println("До изменения:");
		System.out.println("Пустой Map");
		topping1.clear();
		Show(topping1);
		topping1=change(topping1);
		System.out.println("После изменения");
		Show(topping1);
		System.out.println();System.out.println();

		System.out.println("До изменения:");
		topping1.replace("bread", "cream");
		Show(topping1);
		topping1=change(topping1);
		System.out.println("После изменения");
		Show(topping1);
		//--------------------------------------------------
		
//		Скажем, что 2 строки «совпадают», если они не пустые, а их первые символы одинаковы. 
		//Выполните зацикливание и затем верните заданный массив непустых строк следующим образом: 
		//если строка соответствует более ранней строке в массиве, поменяйте местами 2 строки в 
		//массиве. Когда позиция в массиве поменялась местами, она больше не соответствует ничему. 
		//Используя карту, это можно решить, сделав всего один проход по массиву. 
//		allSwap(["ab", "ac"]) → ["ac", "ab"]
//		allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
//		allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]

		System.out.println("---------------------------------------------------------------");
		String[] allSwap= {"ax", "bx", "ay", "by", "ai", "aj", "bx", "by"};
		
		System.out.println("До замены");
		for(String a1:allSwap) {
			System.out.print(a1+" ");
		}
		//long stamp = System.currentTimeMillis();
		allSwap(allSwap);
		System.out.println();
		System.out.println("После замены");
		for(String a1:allSwap) {
			System.out.print(a1+" ");
		}
		System.out.println();
		//System.out.println( (System.currentTimeMillis() - stamp)); //для себя добавил
	}

}
