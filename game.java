import java.util.*;

public class game{

    static boolean gg = false;
    static boolean moved = true;

    public static void display(int n[][]){
        for (int i=0; i<n.length; i++){
            for (int j=0; j<n[0].length; j++){
                if(i%2 == 0) System.out.print(n[i][j] + "   ");
                else System.out.print("  " + n[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("------");
    }

    public static int[][] doq(int[][] outry){

        gg = true;
        moved = false;

        for(int arys = 5; arys>0; arys--){
            int col = Math.max(0, arys-3);
            int row = -2*Math.min(0,arys-3);
            int nelems = 2*(3-Math.abs(arys-3));
            for (int i=0; i<nelems; i++){

                if(outry[row+i][col+i/2] == 0){
                    gg = false;
                    for(int j=i+1; j<nelems; j++){
                        if (outry[row+j][col+j/2] != 0){
                            moved = true;
                            outry[row+i][col+i/2] = outry[row+j][col+j/2];
                            outry[row+j][col+j/2] = 0;
                            break;
                        }
                    }
                }

                if(outry[row+i][col+i/2] != 0){
                    //System.out.printf("excuted\n");
                    //System.out.printf("row: %d, col: %d, i: %d\n", row, col, i);
                    for(int j=i+1; j<nelems; j++){
                        if(outry[row+j][col+j/2] == outry[row+i][col+i/2]){
                            gg = false;
                            moved = true;
                            outry[row+i][col+i/2] = outry[row+i][col+i/2]*2;
                            outry[row+j][col+j/2] = 0;
                            break;
                        }else if(outry[row+j][col+j/2] != 0){
                            break;
                        }
                    }
                }

            }

        }


        return outry;
    } 

    
    public static int[][] dos(int outry[][]){

        gg = true;
        moved = false;

        for(int arys = 5; arys>0; arys--){
            int col = Math.max(0, arys-3);
            int row = -2*Math.min(0,arys-3);
            int nelems = 2*(3-Math.abs(arys-3));

            for (int i=nelems-1; i>=0; i--){

                if(outry[row+i][col+i/2] == 0){
                    gg = false;
                    for(int j=i-1; j>=0; j--){
                        if (outry[row+j][col+j/2] != 0){
                            moved = true;
                            outry[row+i][col+i/2] = outry[row+j][col+j/2];
                            outry[row+j][col+j/2] = 0;
                            break;
                        }
                    }
                }

                if(outry[row+i][col+i/2] != 0){
                    for(int j=i-1; j>=0; j--){
                        if(outry[row+j][col+j/2] == outry[row+i][col+i/2]){
                            gg = false;
                            moved = true;
                            outry[row+i][col+i/2] = outry[row+i][col+i/2]*2;
                            outry[row+j][col+j/2] = 0;
                            break;
                        }else if(outry[row+j][col+j/2] != 0){
                            break;
                        }
                    }
                }

            }
        }

        return outry;

        
    }

    public static void addN(int[][] n){
        if(!gg){
            Random rand = new Random();
            int a = rand.nextInt(6);
            int b = rand.nextInt(3);
            
            while(n[a][b] != 0){
                a = rand.nextInt(6);
                b = rand.nextInt(3);
            }
            n[a][b] = (rand.nextInt(2)+1)*2;
        }
    }

    public static void main(String[] args){
        int[][] nums = new int[][]{ {0,0,2}, 
                                    {0,0,0},
                                    {0,0,0},
                                    {2,4,4},
                                    {0,2,4},
                                    {0,0,0}};
        Scanner sc = new Scanner(System.in);

        while(!gg){
            if (moved) addN(nums);
            display(nums);
            char input = sc.next().charAt(0);
            if(input == 'q'){
                doq(nums);
            }
            if(input == 's'){
                dos(nums);
            }  
        }
        System.out.println("\n----\nGG\n----");
        




    }
}