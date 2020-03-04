import java.util.HashMap;
import java.util.Scanner;

public class PPP {
	public static void main(String[] args)
	{
	    System.out.println("Введите кол-во элементов");
	    Scanner in = new Scanner(System.in);
	    int elementsCount = in.nextInt();
	    int[] elements = new int[elementsCount];
	    for (int i = 0; i < elementsCount; i++)
	    {
	        System.out.println("Введите элемент массива под номером " + i);
	        elements[i] = in.nextInt();
	    }
	    for (int i = 0; i < elementsCount; i++)
	    {
	        int firstElement = elements[i];
	        for (int j = i + 1; j < elementsCount; j++)
	        {
	            int secondElement = elements[j];
	            if (firstElement == secondElement)
	            {
	                System.out.println("Все элементы должны быть разными");
	                return;
	            }
	        }
	    }
	    printArray(elements);
	    firstAlgorithm(elements);
	    secondAlgorithm(elements);
	}

	private static void firstAlgorithm(int[] data)
	{
	    int[] elements = new int[data.length];
	    System.arraycopy(data, 0, elements, 0, data.length);
	    int minIndex = 0;
	    int min = elements[minIndex];
	    int maxIndex = 0;
	    int max = elements[maxIndex];
	    for (int i = 1; i < elements.length; i++)
	    {
	        if (elements[i] < min)
	        {
	            min = elements[i];
	            minIndex = i;
	        }
	        else if (elements[i] > max)
	        {
	            max = elements[i];
	            maxIndex = i;
	        }
	    }
	    System.out.println("Первый способ:");
	    System.out.println("Максимальный элемент массива = " + max);
	    System.out.println("Минимальный элемент массива = " + min);
	    swapElements(elements, minIndex, maxIndex);
	    printArray(elements);
	}

	private static void secondAlgorithm(int[] data)
	{
	    int[] elements = new int[data.length];
	    System.arraycopy(data, 0, elements, 0, data.length);
	    int[] elementsPairs = new int[data.length];
	    System.arraycopy(data, 0, elementsPairs, 0, data.length);
	    if (data.length == 1)
	    {
	        System.out.println("Второй способ: в массиве всего один элемент");
	        return;
	    }
	    HashMap<Integer, Integer> swappedPlaceToRealPlace = new HashMap<>();
	    for (int i = 0; i < elementsPairs.length; i += 2)
	    {
	        if (i + 1 < elementsPairs.length && elementsPairs[i] > elementsPairs[i + 1])
	        {
	            swapElements(elementsPairs, i, i + 1);
	            swappedPlaceToRealPlace.put(i, i + 1);
	            swappedPlaceToRealPlace.put(i + 1, i);
	        }
	    }
	    int minIndex = 0;
	    int min = elementsPairs[minIndex];
	    int maxIndex = 1;
	    int max = elementsPairs[maxIndex];
	    for (int i = 2; i < elementsPairs.length; i += 2)
	    {
	        int firstIndex = i;
	        int secondIndex = i + 1;
	        if (secondIndex == elementsPairs.length)
	        {
	            secondIndex = i;
	        }
	        if (elementsPairs[firstIndex] < min)
	        {
	            min = elementsPairs[firstIndex];
	            minIndex = i;
	        }
	        else if (elementsPairs[secondIndex] > max)
	        {
	            max = elementsPairs[secondIndex];
	            maxIndex = secondIndex;
	        }
	    }
	    if (swappedPlaceToRealPlace.containsKey(minIndex))
	    {
	        minIndex = swappedPlaceToRealPlace.get(minIndex);
	    }
	    if (swappedPlaceToRealPlace.containsKey(maxIndex))
	    {
	        maxIndex = swappedPlaceToRealPlace.get(maxIndex);
	    }
	    System.out.println("Второй способ:");
	    System.out.println("Максимальный элемент массива = " + max);
	    System.out.println("Минимальный элемент массива = " + min);
	    swapElements(elements, minIndex, maxIndex);
	    printArray(elements);
	}

	private static void swapElements(int[] array, int i, int j)
	{
	    int swap = array[i];
	    array[i] = array[j];
	    array[j] = swap;
	}

	private static void printArray(int[] array)
	{
	    for (int i = 0; i < array.length; i++)
	    {
	        System.out.print(array[i] + " ");
	    }
	    System.out.println();
	}
}
