public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] primes = new boolean[n]; // creates a new array type boolean with length of n
        for (int i = 0; i < n; i++) {
            primes[i] = true; // initializes all elements in the array to true
        }
        primes[0] = false; //
        primes[1] = false; // 0 and 1 are not prime
        int counter = 0; 
        int div = 2; // initial
        while (div < Math.sqrt(n)) {
            while (counter < n) {
                if ( primes[counter] == true) {
                    if ( counter%div == 0 ) {
                        if (counter != div) {
                            primes[counter] = false;
                            }
                        
                    }
                }
            counter++;
            }
        counter = 0;
        div++;
        }
        double counter2 = 0;
        for (int i2 = 0; i2 < n; i2++) {
            if ( primes[i2] == true) {
                System.out.println(i2);
                counter2++;
            }
        }
        int x = (int)((counter2/n) * 100);

        System.out.println("There are " + counter2 + " primes between 2 and " + n + ". ("+ x +"% are primes)");
        /* for (int i3 = 0; i3 < n; i3++) {
            System.out.println(primes[i3]);
        } This prints out the values of the arrey inorder to trubleshoot if needed */
    }
}