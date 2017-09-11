import java.io.*;
import java.util.Scanner;

public class Arduino
{ 
	private static String a = "";
	private static String b = "";
	private static String condicao ="";

	public static boolean verificar(String str)
	{
		return (str.contains("=")) ? true : false;
	}

	public static String atribuir(String str)
	{
		// String a = "", b = "";
		// String condicao = "";
		String resp = "";

		if(str != null)
		{
			//verifica se tem o caractere (=)
			if(verificar(str))
			{
				if(str.charAt(0) == 'A')
				{
					a = ""+str.charAt(2);
				}else if(str.charAt(0) == 'B'){
					b = ""+str.charAt(2);
				}
			}else{
				condicao = tabela(str);
			}
		}
		resp = a + "" + b + "" + condicao;
		return resp;
	}

	/*
	 * Tabela de uma ALU de 4 Bits que retorna um valor
	 * em hexadecimal
	 */
	public static String tabela(String str)
	{
		String resp = "";
		if(str != null)
		{
			if(str.equals("An;"))
			{
				resp = "0";
			}else if(str.equals("nAoB;")){
				resp = "1";
			}else if(str.equals("AnB;")){
				resp = "2";
			}else if(str.equals("zeroL;")){
				resp = "3";
			}else if(str.equals("nAeB;")){
				resp = "4";
			}else if(str.equals("Bn;")){
				resp = "5";
			}else if(str.equals("AxB;")){
				resp = "6";
			}else if(str.equals("ABn;")){
				resp = "7";
			}else if(str.equals("AnoB;")){
				resp = "8";
			}else if(str.equals("nAxB;")){
				resp = "9";
			}else if(str.equals("B;")){
				resp = "A";
			}else if(str.equals("AB;")){
				resp = "B";
			}else if(str.equals("umL;")){
				resp = "C";
			}else if(str.equals("AoBn;")){
				resp = "D";
			}else if(str.equals("AoB;")){
				resp = "E";
			}else if(str.equals("A;")){
				resp = "F";
			}
		}

		return resp;
	}

	/*
	 * Transformar um numero em binario
	 */
	public static String tBinario(String numero)
	{
		if(numero != null)
		{
			if(numero.equals("0"))
			{
				numero = "0000";
			}else if(numero.equals("1")){
				numero = "0001";
			}else if(numero.equals("2")){
				numero = "0010";
			}else if(numero.equals("3")){
				numero = "0011";
			}else if(numero.equals("4")){
				numero = "0100";
			}else if(numero.equals("5")){
				numero = "0101";
			}else if(numero.equals("6")){
				numero = "0110";
			}else if(numero.equals("7")){
				numero = "0111";
			}else if(numero.equals("8")){
				numero = "1000";
			}else if(numero.equals("9")){
				numero = "1001";
			}else if(numero.equals("A")){
				numero = "1010";
			}else if(numero.equals("B")){
				numero = "1011";
			}else if(numero.equals("C")){
				numero = "1100";
			}else if(numero.equals("D")){
				numero = "1101";
			}else if(numero.equals("E")){
				numero = "1110";
			}else if(numero.equals("F")){
				numero = "1111";
			}	
		}

		return numero;
	}

	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader arq;
		BufferedWriter arq2;
		String str, aux;

		try
		{
			arq  = new BufferedReader(new FileReader("74181.alu"));
			arq2 = new BufferedWriter(new FileWriter("74181.hex"));

			str = arq.readLine();
			do
			{
				// System.out.println(str);

				if(!str.equals("inicio:"))
				{
					aux = atribuir(str);
					if(!str.contains("="))
					{
						arq2.append(aux+"\n");	
					}
				}

				str = arq.readLine();

			}while(!str.equals("fim."));
			arq2.close();
			arq.close();

		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}				
	}
}
