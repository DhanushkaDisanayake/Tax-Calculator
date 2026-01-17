import java.util.*;
class Assingment06{
	public final static void clearConsole(){
		try{
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")){
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}else{
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch (final Exception e){
			e.printStackTrace();
		}
	}
	public static void withHoldingTax(){
		Scanner input = new Scanner(System.in);
		System.out.println("+----------------------------------------------------------------------+");
		System.out.println("|                        Withholding Tax                               |");
		System.out.println("+----------------------------------------------------------------------+\n");
		System.out.println();
		System.out.println("\t[1] Rent Tax\n");
		System.out.println("\t[2] Bank Interest Tax\n");
		System.out.println("\t[3] Dividend Tax\n");
		System.out.println("\t[4] Exit\n\n");

		System.out.print("Enter an option to continue -> ");
		int option = input.nextInt();
		clearConsole();
		
		switch(option){
			case 1 :
				rentTax();
				break;
			case 2 :
				bankInterestTax();
				break;
			case 3 :
				dividendTax();
				break;
			case 4 :
				return;
		}
	}
	public static void invalid(){
		Scanner input=new Scanner (System.in);
		System.out.print("Do you want to enter the correct value again (Y/N) : ");
		char ch = input.next().charAt(0);
		option(ch);
	}
	public static void invalidOption(){
		Scanner input=new Scanner (System.in);
		System.out.print("Do you want to try again (Y/N) : ");
		char ch = input.next().charAt(0);
		option(ch);
	}
	public static void option(char ch){
		Scanner input=new Scanner (System.in);

		if(ch=='Y'||ch=='y'){
			clearConsole();
			return;
		}else if(ch=='N'||ch=='n'){
			clearConsole();
			main(null);
		}else{
			System.out.println("\n\tInvalid choies...Please enter Y or N....\n");
			invalid();
		}

		return;
	}
	public static void option(char ch,String tax){
	Scanner input=new Scanner (System.in);

		if(ch=='Y'||ch=='y'){
			clearConsole();
			return;
		}else if(ch=='N'||ch=='n'){
			clearConsole();
			main(null);
		}else{
			System.out.println("\n\tInvalid choies...Please enter Y or N....");
			calculateAnother(tax);
		}

		return;
	}
	public static void calculateAnother(String tax){
		Scanner input = new Scanner (System.in);
		System.out.println("\n");
		System.out.print("Do you want to calculate another "+tax+" (Y/N) : ");
		char ch = input.next().charAt(0);
		option(ch,tax);
	}
	public static char calculateAnotherlease(String tax){
		Scanner input = new Scanner (System.in);
		System.out.println("\n");
		System.out.print("Do you want to calculate another "+tax+" (Y/N) : ");
		char ch = input.next().charAt(0);
		
		if(ch=='Y'||ch=='y'){
			clearConsole();
			return 'y';
		}else if(ch=='N'||ch=='n'){
			clearConsole();
			main(null);
		}else{
			System.out.println("\n\tInvalid choies...Please enter Y or N....");
			calculateAnotherlease(tax);
		}
		return 'n';
	}
	public static void rentTax(){
		while(true){
			Scanner input = new Scanner(System.in);
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println("|                            Rent Tax                                  |");
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println();
			
			System.out.print("  Enter your rent          : Rs.");
			double rent = input.nextDouble();
			System.out.println();
			
			if (rent<0){
				System.out.println("\tInvalid Input...\n\n");
				invalid();
			}else if (rent<100001){
				System.out.println("\tYou don't have to pay rent tax....");
				calculateAnother("Rent tax");
			}else{
				System.out.printf("  You have to pay rent tax : Rs.%.2f\n",rent*0.1);
				calculateAnother("Rent tax");
			}
		}
	}
	public static void bankInterestTax(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println("|                         Bank Interest Tax                            |");
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println();
			
			System.out.print("  Enter your bank interest per year          : Rs.");
			double bankIn = input.nextDouble();
			System.out.println();
			
			if (bankIn<0){
				System.out.println("\tInvalid Input...\n\n");
				invalid();
			}else{
				System.out.printf("  You have to pay Bank Interest Tax per year : Rs.%.2f\n",bankIn*0.05);
				calculateAnother("Bank Interest Tax");
			}
		}
	}
	public static void dividendTax(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println("|                            Dividend Tax                              |");
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println();
			
			System.out.print("  Enter your total dividend per year    : Rs.");
			double dividend = input.nextDouble();
			System.out.println();
			
			if(dividend<0){
				System.out.println("\tInvalid Input...\n\n");
				invalid();
			}else if(dividend<100001){
				System.out.println("\tYou don't have to pay Dividend Tax....");
				calculateAnother("Dividend Tax");
			}else{
				System.out.printf("  You have to pay Dividend Tax per year : Rs.%.2f\n",dividend*0.14);
				calculateAnother("Dividend Tax");
			}
		}	
	}
	public static void paybleTax(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println("|                             Payble Tax                               |");
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println();
			
			System.out.print("  Enter your employee payment per month   : Rs.");
			double salary = input.nextDouble();
			System.out.println();
			
			if(salary<0){
				System.out.println("\tInvalid Input...\n\n");
				invalid();
			}else if(salary<100001){
				System.out.println("\tYou don't have to pay Payble Tax....");
				calculateAnother("Payble Tax");
			}else{
				double tax;
				if (salary<=100000){
					tax=0;
				}else if (salary<=141667){
					tax=(salary-100000)*0.06;
				}else if (salary<=183333){
					tax=((salary-141667)*0.12)+2500;
				}else if (salary<=225000){
					tax=((salary-183333)*0.18)+7500;
				}else if (salary<=266667){
					tax=((salary-225000)*0.24)+15000;
				}else if (salary<=308333){
					tax=((salary-266667)*0.30)+37500;
				}else{
					tax=((salary-308333)*0.36)+52500;
				}
				System.out.printf("  You have to pay Payble Tax per year : Rs.%.2f\n",tax);
				calculateAnother("Payble Tax");
			}
		}
	}
	public static void incomeTax(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println("|                             Income Tax                               |");
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println();
			
			System.out.print("  Enter your total income per year      : Rs.");
			double income = input.nextDouble();
			System.out.println();
			double tax;
			if(income<0){
				System.out.println("\tInvalid Input...\n\n");
				invalid();
			}else if (income<=1200000){
				System.out.println("\n\tYou don't have to Income Tax....");
				calculateAnother("Income Tax");
			}else{
				if (income<=1700000){
					tax = (income-1200000)*0.06;
				}else if (income<=2200000){
					tax = ((income-1700000)*0.12)+30000;
				}else if (income<=2700000){
					tax = ((income-2200000)*0.18)+90000;
				}else if (income<=3200000){
					tax = ((income-2700000)*0.24)+180000;
				}else if (income<=3700000){
					tax = ((income-3200000)*0.30)+300000;
				}else{
					tax = ((income-3700000)*0.36)+450000;
				}
				System.out.printf("  You have to pay Income Tax per year   : Rs.%.2f\n",tax);
				calculateAnother("Income Tax");
			}
		}
	}
	public static void sscl(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println("|            Social Security Contribution Levy (SSCL) Tax              |");
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println();
			
			System.out.print("  Enter value of Good or Service     : Rs.");
			double value = input.nextDouble();
			System.out.println();
			
			if(value<0){
				System.out.println("\tInvalid Input...\n\n");
				invalid();
			}else{;
				System.out.printf("  You have to pay SSCL Tax  	     : Rs.%.2f\n",(value*0.025)+(value+(value*0.025))*0.15);
				calculateAnother("SSCL Tax");
			}
		}
	}
	public static void leasingPayment(){
		Scanner input = new Scanner (System.in);
		System.out.println("+----------------------------------------------------------------------+");
		System.out.println("|                        Leasing Payment                               |");
		System.out.println("+----------------------------------------------------------------------+\n");
		System.out.println();
		System.out.println("\t[1] Calculate Monthly Installment\n");
		System.out.println("\t[2] Search Leasing Category\n");
		System.out.println("\t[3] Find Leasing Amount\n");
		System.out.println("\t[4] Exit\n\n");

		System.out.print("Enter an option to continue -> ");
		int option = input.nextInt();
		clearConsole();
		
		switch(option){
			case 1 :
				monthlyInstallment();
				break;
			case 2 :
				leasingCategory();
				break;
			case 3 :
				leasingAmount();
				break;
			case 4 :
				return;
		}
	}
	public static void monthlyInstallment(){
		Scanner input = new Scanner(System.in);
		L2:while(true){
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println("|                     Calculate Leasing Payment                        |");
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println();
			
			System.out.print("  Enter lease amount            : Rs.");
			double lease = input.nextDouble();
			System.out.println();
			
			if (lease<0){
				System.out.println("\tInvalid Input...\n\n");
				invalid();
			}else{
				System.out.print("  Enter annual interest rate    : Rs.");
				double annual = input.nextDouble();
				L3:while(true){
					System.out.print("\n  Enter number of year          : ");
					double year = input.nextDouble();
					if (year>5){
						System.out.println("\n\tInvalid number of year....Enter the correct value again... ");
						continue L3;
					}else{
						annual/=100*12;
						double monthly = lease*annual/(1-(1/Math.pow((1+annual),(year*12))));
						System.out.printf("\n  Your monthly installment      : %.2f\n",monthly);
						if ('y'==calculateAnotherlease("SSCL Tax")){
							continue L2;
						}
					}
				}
			}
		}
	}
	public static void monthlyInstallmentL3(){
	}
	public static void leasingPlan(int month,double interest,double lease){
		interest = (interest/100)/12;
		double installment= lease*interest/(1-Math.pow((1+interest),-month));
		System.out.printf("\n  Your monthly installment for "+month/12+" year leasing amount - %.2f\n",installment);
	}
	public static void leasingCategory(){
		Scanner input = new Scanner(System.in);
		L2:while(true){
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println("|                       Search Leasing Category                        |");
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println();
			
			System.out.print("  Enter lease amount            : Rs.");
			double lease = input.nextDouble();
			System.out.println();
			
			System.out.print("  Enter annual interest rate    : ");
			double annual = input.nextDouble();
			L3:while(true){
				if(annual<0){
					System.out.println("\n\tInvalid annual interest rate....Enter the correct value again... ");
					continue L3;
				}else{
					System.out.println();
					leasingPlan(36,annual,lease);
					leasingPlan(48,annual,lease);
					leasingPlan(60,annual,lease);
					if('y'==calculateAnotherlease("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\bSearch another leasing category")){
						continue L2;
					}
				}
			}
		}
	}
	public static void leasingAmount(){
		Scanner input = new Scanner(System.in);
		L2:while(true){
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println("|                          Find Leasing Amont                          |");
			System.out.println("+----------------------------------------------------------------------+");
			System.out.println();
			
			System.out.print("  Enter the monthly lease payment amount you can afford  : Rs.");
			double payment = input.nextDouble();
			System.out.println();
			
			L3:while(true){
				System.out.print("  Enter number of year                                   : ");
				double year = input.nextDouble();
				if (year>5){
					System.out.println("\n\tInvalid number of year....Enter the correct value again... ");
					continue L3;
				}else{
					L4:while(true){
						System.out.print("\n  Enter annual interest rate                             : ");
						double annual = input.nextDouble();
						if(annual<0){
							System.out.println("\n\tInvalid annual interest rate....Enter the correct value again... ");
							continue L4;
						}else{
							annual = (annual / 100) / 12;
							double amount = payment*((1 - Math.pow(1 + annual, -(year*12)))/annual);
							System.out.printf("\n  You can get lease Amount                               : %.2f\n",amount);
							if('y'==calculateAnotherlease("monthly installment")){
								continue L2;
							}
						}
					}
				}
			}
		}
	}
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		
		while(true){
			System.out.printf("%36s%s\n",""," __  ______  ________ ________");
			System.out.printf("%36s%s\n","","|  \\/      \\|        |        \\");
			System.out.printf("%36s%s\n",""," \\$|  $$$$$$| $$$$$$$$\\$$$$$$$$");
			System.out.printf("%36s%s\n","","|  | $$   \\$| $$__      | $$");
			System.out.printf("%36s%s\n","","| $| $$     | $$  \\     | $$");
			System.out.printf("%36s%s\n","","| $| $$   __| $$$$$     | $$");
			System.out.printf("%36s%s\n","","| $| $$__/  | $$_____   | $$");
			System.out.printf("%36s%s\n","","| $$\\$$    $| $$     \\  | $$");
			System.out.printf("%36s%s\n",""," \\$$ \\$$$$$$ \\$$$$$$$$   \\$$");
			System.out.println();
		                 	
			System.out.println(" _______         __   __      _____            _       _____  _    _  _               _______   ____   _____");
			System.out.println("|__   __|  /\\    \\ \\ / /     / ____|    /\\    | |     / ____|| |  | || |         /\\  |__   __| / __ \\ |  __ \\");
			System.out.println("   | |    /  \\    \\ v /     | |        /  \\   | |    | |     | |  | || |        /  \\    | |   | |  | || |__) |");
			System.out.println("   | |   / /\\ \\    > <      | |       / /\\ \\  | |    | |     | |  | || |       / /\\ \\   | |   | |  | ||  _  /");
			System.out.println("   | |  / ____ \\  / . \\     | |____  / ____ \\ | |____| |____ | |__| || |____  / ____ \\  | |   | |__| || | \\ \\");
			System.out.println("   |_| /_/    \\_\\/_/ \\_\\     \\_____|/_/    \\_\\|______|\\_____| \\____/ |______|/_/    \\_\\ |_|    \\_____/|_|  \\_\\");
			System.out.println();
			System.out.println("=================================================================================================================");
			System.out.println();
			
			System.out.println("\t[1] Withholding Tax \n");
			System.out.println("\t[2] Payble Tax \n");
			System.out.println("\t[3] Income Tax \n");
			System.out.println("\t[4] Social Security Contribution Levy (SSCL) Tax \n");
			System.out.println("\t[5] Leasing Payment \n");
			System.out.println("\t[6] Exit \n");
			System.out.println();
			
			System.out.print("Enter an option to continue -> ");
			int option = input.nextInt();
			if(option<7){
				clearConsole();
			}
			
			switch (option){
				case 1 :
					withHoldingTax();
					break;
				case 2 :
					paybleTax();
					break;
				case 3 :
					incomeTax();
					break;
				case 4 :
					sscl();
					break;
				case 5 :
					leasingPayment();
					break;
				case 6 :
					return;
				default :
					System.out.println("\n\tInvalid option....\n\n");
					invalidOption();
				}
		}
	}
}
