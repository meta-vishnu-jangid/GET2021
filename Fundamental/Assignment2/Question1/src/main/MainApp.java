package main;
import main.HexCalc;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("Hex To Decimal of '1A' :" + HexCalc.HexToDecimal("1A") );
		System.out.println("Decimal To HexaDecimal of '10' :" + HexCalc.DecimalToHex(10) );
		System.out.println("Addition of Two Hex '1A' and '12B' :" + HexCalc.add("1A","12B") );
		System.out.println("Subtraction of  Hex '1A' from '12B' :" + HexCalc.subtract("12B","1A") );
		System.out.println("Multiplication of  Hex '123' with 'AA' :" + HexCalc.multiply("123","AA") );
		System.out.println("Division of  Hex 'A' from '2' :" + HexCalc.divide("A","2") );
		System.out.println("If '1A' is equal to '1B' :" + HexCalc.equal("1A","1B") );
		System.out.println("If '1A' is equal to '1A' :" + HexCalc.equal("1A","1A") );
		System.out.println("If '1A' is less then to '1B' :" + HexCalc.lessThan("1A","1B") );
		System.out.println("If '1A' is gretaer then to '1B' :" + HexCalc.greaterThan("1A","1B") );
	}

}
