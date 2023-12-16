Rclass Solution {
    int mod=1000000007;
    // public long power(long n , long p){
    //     if(p==0) return 1;
    //     long res=1;

    //     while(p!=0){
    //         if(p%2==0){
    //             p=p/2;
    //             n =(n*n)%mod;
    //         }
    //         else {
    //             res = (res*n)%mod;
    //             p=p-1;
    //         }
    //     }
    //     return res;
    // }

    //using recursion
    public long power(long n , long p){
        if(p==0) return 1;

        if(p%2!=0) return (n*power(n , p-1))%mod;
        else return power((n*n)%mod , p/2);  
    }
    public int countGoodNumbers(long n) {
        long evenPos = (n+1)/(long)2;
        long oddPos = n-evenPos;

        evenPos = power((long)5 , evenPos);
        oddPos = power((long)4 ,oddPos);

        System.out.println(evenPos+" : "+oddPos);
        return (int) (evenPos*oddPos%mod);
        
    }
}
