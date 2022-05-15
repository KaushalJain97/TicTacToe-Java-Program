import java.util.*;

public class TicTacToe{

static void print(int[][] a){
	for(int i=0;i<3;i++){
		System.out.println("-------------");
		for(int j=0;j<3;j++ ){
			System.out.print(a[i][j]+" ");
		}
		System.out.println();
		}
	System.out.println();
		System.out.println();
}

static boolean check_won(int[][] a){
	//check with respect to row
	
	for(int i=0;i<3;i++){
		int f_0=0;
		int f_1=0;
		for(int j=0;j<3;j++){
			if(a[i][j]==0)
				f_0++;
			else if(a[i][j]==1)
				f_1++;
		}
		
		if(f_0==3 || f_1==3)
			return true;
		
			
	}
	
	//check with respect to column
	for(int j=0;j<3;j++){
		int f_0=0;
		int f_1=0;
		for(int i=0;i<3;i++){
			if(a[i][j]==0)
				f_0++;
			else if(a[i][j]==1)
				f_1++;
		}
		
		if(f_0==3 || f_1==3)
			return true;
		}
	//check with first diagonal
	int i=0;
	int j=0;
	int f_0=0;
	int f_1=0;
	
	
	while(i<3 && j<3){
		if(a[i][j]==0)
				f_0++;
			else if(a[i][j]==1)
				f_1++;
		i++;
		j++;
	}
	if(f_0==3 || f_1==3)
			return true;
	//check with second diagonal
	i=0;
	j=2;
	f_0=0;
	f_1=0;
	while(i<3 && j>=0){
		if(a[i][j]==0)
				f_0++;
			else if(a[i][j]==1)
				f_1++;
		i++;
		j--;
	}
	if(f_0==3 || f_1==3)
			return true;
	return false;
	}


public static void main(String[] args){


Scanner sc=new Scanner(System.in);
int[][] a=new int[3][3];

for(int i=0;i<3;i++){
		
		for(int j=0;j<3;j++ ){
			a[i][j]=-1;
		}
		
	}


System.out.println("Player A is assigned --> 1");
System.out.println("Player B is assigned--> 0");

int flag=0;

	print(a);
	for(int i=0;i<9 && flag==0;i++){
		if(i%2==0){
			System.out.println("Turn of Player A");
			System.out.println("Input Row Number");
			
			int p1=sc.nextInt();
			System.out.println("Input Column number");
			int p2=sc.nextInt();
			if(p1>3 || p2>3){
				System.out.println("Invalid position stopping the game");
				break;
			}
			
			a[p1-1][p2-1]=1;
			print(a);
			if(check_won(a))
			{
				System.out.println("** Congratulations!! Player A won **");
				flag++;

				
			}
			
		}
		else
		{
			System.out.println("Turn of Player B");
			System.out.println("Input Row Number");
			
			int p1=sc.nextInt();
			System.out.println("Input Column number");
			int p2=sc.nextInt();
			
			a[p1-1][p2-1]=0;
			if(p1>3 || p2>3){
				flag++;
				System.out.println("Invalid position stopping the game");
				break;
			}
			print(a);
			if(check_won(a))
			{
				System.out.println("** Congratulations!! Player B won **");
				flag++;
			}
		}
	}
	
  if(flag==0)
	System.out.println("Draw!!");
}
}
