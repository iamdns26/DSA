class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0] != 5) return false;
        int f5 = 0;
        int f10 = 0;
        boolean flag = true;
        for(int i = 0 ; i < bills.length ; i++){
            int b = bills[i];
            if(b==5){
                f5++;
            }
            else if(b == 10){
                if(f5==0){
                    flag = false;
                    break;
                }
                else f5--;

                f10++;
            }
            else if(b==20){
                if(f10 > 0 && f5 > 0){
                    f10--;
                    f5--;
                }
                else if(f5 > 2){
                    f5-=3;
                }
                else{
                    flag = false;
                    break;
                }

            }
        }
        System.out.println(f5+" "+f10);
        return flag;
    }
}