public class Main {

    public static void main(String[] args) {

        //a
        System.out.println("Before they went to sleep the wolfs had: "+a(31));
        //checking with validation function;
        System.out.println(isValid(322)+"\n");


        //b
        System.out.println(isValid(160)+"\n");

        //c
        System.out.println(maxRabbits(500));



        //System.out.println(isValid(48));

    }


    //a)
    public static int a(int rabbitsMorning){
        int wolfRoutine=rabbitsMorning*3+1;
        for(int i=0;i<3;i++){
            wolfRoutine=(wolfRoutine/2)*3+1;
        }

        return wolfRoutine;
    }

    //b)
    public static boolean isValid(int number)
    {
        // so from the given number of rabbits we must check if the wolfs can eat and if in the morning there are enough rabbits to split it again
        // there are 3 wolfs in the group and in the morning we do it again so there would be 4 splits

        for(int i=0;i<4;i++){
            int temp=(number-1)%3;
            if(temp==0){
                number=((number-1)/3)*2;
            } else {
                return false;
            }
        }

        System.out.println("In the morning in each pile is: "+number/2);
        return true;
    }


    //c

    public static int maxRabbits(int rabbits_max_limit)
    {
     int rabbits_max_valid=0;

        // the idea behind the algorithm is to check the greatest number that is closest to rabbits_max_valid that can be divided by 3 then add 1
        // if it doesn't satisfy the condition of the pack we check the next number that can be divided by 3


    // finding the first number that can be divided by 3 then add 1 to it
     while(true){
         rabbits_max_limit--;
         if(rabbits_max_limit % 3==0){
             rabbits_max_valid=rabbits_max_limit+1;
             break;
         }
     }


     // now we check if the number is valid, if it is not we subtract a 3 from it and check if it is valid

     while(rabbits_max_valid-3>16){
            if(isValid(rabbits_max_valid)){
                System.out.println("Found!");
                return rabbits_max_valid;
            }else{
                //System.out.println(rabbits_max_valid);
                rabbits_max_valid-=3;
            }
        }

     System.out.println("The wolfs didn't hunt enough");
     return -1;
    }


}
