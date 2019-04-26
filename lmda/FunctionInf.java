package alg.lmda;

import java.util.*;
public class FunctionInf {
	public static byte[] transformArray(short[] array, ShortToByteFunction function) {
		byte[] transformedArray = new byte[array.length];
		for(int i = 0; i < array.length; i++) {
			transformedArray[i] = function.applyAsByte(array[i]);
		}
		return transformedArray;
	}

	public static void main(String args[]) {
		short[] arr = {(short)1, (short)2, (short)3};
		byte[] transformedArray = transformArray(arr, s -> (byte)(s*2));
		for(byte b: transformedArray) {
			System.out.print(b + " " );
		}
		System.out.println();
	}
}

@FunctionalInterface
interface ShortToByteFunction {
	byte applyAsByte(short s);
}
