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

    public static void displayStraight(int st[][]){
        for(int[] iary : st){
            for(int i : iary){
                System.out.print(i);
            }
            System.out.println();
        }
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

    public static void toStraight(int[][] oary, int[][] sary){
        for(int arys = 5; arys>0; arys--){
            int col = Math.max(0, arys-3);
            int row = -2*Math.min(0,arys-3);
            int nelems = 2*(3-Math.abs(arys-3));
            //System.out.printf("row: %d, col: %d, nelems: %d\n", row, col, nelems);
            for (int i=0; i<nelems; i++){
                sary[5-arys][3-nelems/2+i] = oary[row+i][col+i/2];
                //System.out.print(oary[row+i][col+i/2]);
            }
            //System.out.println();
            
        }

    }

    public static void storeTo(int[][] oary, int[][] sary){
        for(int arys = 5; arys>0; arys--){
            int col = Math.max(0, arys-3);
            int row = -2*Math.min(0,arys-3);
            int nelems = 2*(3-Math.abs(arys-3));
            //System.out.printf("row: %d, col: %d, nelems: %d\n", row, col, nelems);
            for (int i=0; i<nelems; i++){
                oary[row+i][col+i/2] = sary[5-arys][3-nelems/2+i];
                
                //System.out.print(oary[row+i][col+i/2]);
            }
            //System.out.println();
            
        }
    }
    public static void sdoq(int[][] sary){

        gg = true;
        moved = false;

        for(int arys=0; arys<5; arys++){
            int col = Math.abs(arys-2);
            int nelems = 2*(3-Math.abs(arys-2));
            for(int i=0; i<nelems; i++){

                if(sary[arys][col+i] == 0){
                    gg = false;
                    for(int j=i+1; j<nelems; j++){
                        if(sary[arys][col+j] != 0){
                            moved = true;
                            sary[arys][col+i] = sary[arys][col+j];
                            sary[arys][col+j] = 0;
                            break;
                        }
                    }
                }
                if(sary[arys][col+i] != 0){
                    for(int j=i+1; j<nelems; j++){
                        if(sary[arys][col+i] == sary[arys][col+j]){
                            gg = false;
                            moved = true;
                            sary[arys][col+i] *= 2;
                            sary[arys][col+j] = 0;
                            break;
                        }else if(sary[arys][col+j] != 0){
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void sdos(int[][] sary){

        gg = true;
        moved = false;

        for(int arys=0; arys<5; arys++){
            int col = 5-Math.abs(arys-2);
            int nelems = 2*(3-Math.abs(arys-2));
            for(int i=0; i<nelems; i++){

                if(sary[arys][col-i] == 0){
                    gg = false;
                    for(int j=i+1; j<nelems; j++){
                        if(sary[arys][col-j] != 0){
                            moved = true;
                            sary[arys][col-i] = sary[arys][col-j];
                            sary[arys][col-j] = 0;
                            break;
                        }
                    }
                }
                if(sary[arys][col-i] != 0){
                    for(int j=i+1; j<nelems; j++){
                        if(sary[arys][col-i] == sary[arys][col-j]){
                            gg = false;
                            moved = true;
                            sary[arys][col-i] *= 2;
                            sary[arys][col-j] = 0;
                            break;
                        }else if(sary[arys][col-j] != 0){
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void sdow(int[][] sary){
        
        gg = true;
        moved = false;

        for(int arys=1; arys<5; arys++){
            int row = Math.abs(arys*2-5)/2;
            int nelems = 6-Math.abs(arys*2-5);
            //System.out.println(row + " " + nelems);
            for(int i=0; i<nelems; i++){
                //System.out.printf("row: %d, i: %d, nelems: %d\n", row, i, nelems);
                if(sary[row+i][arys] == 0){
                    gg = false;
                    for(int j=i+1; j<nelems; j++){
                        if(sary[row+j][arys] != 0){
                            moved = true;
                            sary[row+i][arys] = sary[row+j][arys];
                            sary[row+j][arys] = 0;
                            break;
                        }
                    }
                }
                if(sary[row+i][arys] != 0){
                    for(int j=i+1; j<nelems; j++){
                        if(sary[row+i][arys] == sary[row+j][arys]){
                            gg = false;
                            moved = true;
                            sary[row+i][arys] *= 2;
                            sary[row+j][arys] = 0;
                            break;
                        }else if(sary[row+j][arys] != 0){
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void sdoa(int[][] sary){
        
        gg = true;
        moved = false;

        for(int arys=1; arys<5; arys++){
            int row = 4-Math.abs(arys*2-5)/2;
            int nelems = 6-Math.abs(arys*2-5); 
            //System.out.println(row + " " + nelems);
            for(int i=0; i<nelems; i++){
                //System.out.printf("row: %d, i: %d, nelems: %d\n", row, i, nelems);
                if(sary[row-i][arys] == 0){
                    gg = false;
                    for(int j=i+1; j<nelems; j++){
                        if(sary[row-j][arys] != 0){
                            moved = true;
                            sary[row-i][arys] = sary[row-j][arys];
                            sary[row-j][arys] = 0;
                            break;
                        }
                    }
                }
                if(sary[row-i][arys] != 0){
                    for(int j=i+1; j<nelems; j++){
                        if(sary[row-i][arys] == sary[row-j][arys]){
                            gg = false;
                            moved = true;
                            sary[row-i][arys] *= 2;
                            sary[row-j][arys] = 0;
                            break;
                        }else if(sary[row-j][arys] != 0){
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void addN(int[][] n){
        if(!gg){
            Random rand = new Random();
            int a = rand.nextInt(5);
            int b = rand.nextInt(6);
            
            while(n[a][b] != 0 && n[a][b] != 9){
                a = rand.nextInt(5);
                b = rand.nextInt(6);
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
        int[][] str = new int[5][6];
        for(int[] iary : str){
            Arrays.fill(iary, 9);
        }
        toStraight(nums, str);
        displayStraight(str);

        Scanner sc = new Scanner(System.in);

        while(!gg){
            if (moved) addN(str);
            storeTo(nums, str);
            display(nums);


            char input = sc.next().charAt(0);
            if(input == 'q'){
                sdoq(str);
            }
            if(input == 's'){
                sdos(str);
            }
            if(input == 'w'){
                sdow(str);
            }
            if(input == 'a'){
                sdoa(str);
            }  
        }
        System.out.println("\n----\nGG\n----");


    }
}