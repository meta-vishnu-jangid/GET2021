package main;
import main.StringFunc;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("Comparing String abc with abc :" + StringFunc.compare("abc", "abc"));
		System.out.println("Comparing String abd with abc :" + StringFunc.compare("abd", "abc"));
		System.out.println("larget word of  String avd scscs scsc\\nscsss :" + StringFunc.largestWord("avd scscs scsc\nscsss"));
		System.out.println("Swap case of string AbC$ axa :" + StringFunc.swapCase("AbC$ axa"));
		System.out.println("Reverse of string abcds :" + StringFunc.reverse("abcds"));
	}

}
